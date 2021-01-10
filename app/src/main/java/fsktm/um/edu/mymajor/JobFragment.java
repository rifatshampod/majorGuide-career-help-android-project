package fsktm.um.edu.mymajor;

import android.icu.util.ULocale;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class JobFragment extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;

    EditText jobInput, locationInput;
    Button searchBtn;

    public JobFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment JobFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static JobFragment newInstance(String param1, String param2) {
        JobFragment fragment = new JobFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_job, container, false);

        jobInput = v.findViewById(R.id.title_input);
        locationInput = v.findViewById(R.id.location_input);
        searchBtn = v.findViewById(R.id.search_btn_job);

        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(jobInput.getText().toString().isEmpty()){
                    Toast.makeText(getActivity(), "Please enter the job title", Toast.LENGTH_SHORT).show();
                } else if(locationInput.getText().toString().isEmpty()){
                    Toast.makeText(getActivity(), "Please enter a location", Toast.LENGTH_SHORT).show();
                } else {
                    Bundle bundle = new Bundle();
                    bundle.putString("job_title", jobInput.getText().toString());
                    bundle.putString("job_location", locationInput.getText().toString());

                    JobSearchResult jobSearchResult = new JobSearchResult();
                    jobSearchResult.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.frameContainer, jobSearchResult).commit();
                }
            }
        });

        return v;
    }
}