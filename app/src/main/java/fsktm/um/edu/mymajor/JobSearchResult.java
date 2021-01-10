package fsktm.um.edu.mymajor;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link JobSearchResult#newInstance} factory method to
 * create an instance of this fragment.
 */
public class JobSearchResult extends Fragment implements JobResultRecViewAdapter.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public JobSearchResult() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment JobSearchResult.
     */
    // TODO: Rename and change types and number of parameters
    public static JobSearchResult newInstance(String param1, String param2) {
        JobSearchResult fragment = new JobSearchResult();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();
    private ArrayList<JobModel> list = new ArrayList<>();
    private TextView txtJobSearchResultTitle;
    private RecyclerView jobSearchResultView;

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
        View view = inflater.inflate(R.layout.fragment_job_search_result, container, false);

        txtJobSearchResultTitle = view.findViewById(R.id.txtJobSearchResultTitle);
        jobSearchResultView = view.findViewById(R.id.jobSearchResultView);

        final JobResultRecViewAdapter adapter = new JobResultRecViewAdapter(list, this);
        jobSearchResultView.setAdapter(adapter);
        jobSearchResultView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        jobSearchResultView.setItemAnimator(new DefaultItemAnimator());

        final String jobTitle = getArguments().getString("job_title");
        final String jobLocation = getArguments().getString("job_location");

        txtJobSearchResultTitle.setText("Results for ".concat(jobTitle));

        myRef.child("jobs").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren()){
                    if(dataSnapshot1.child("title").getValue().toString().toLowerCase().contains(jobTitle.toLowerCase()) &&
                            dataSnapshot1.child("location").getValue().toString().toLowerCase().contains(jobLocation.toLowerCase())){
                        list.add(dataSnapshot1.getValue(JobModel.class));
                    }

                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getActivity(), "Database error!", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    @Override
    public void onClick(int position) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("jobs", list);
        bundle.putInt("index", position);


        JobDetails jobDetails = new JobDetails();
        jobDetails.setArguments(bundle);
        getFragmentManager().beginTransaction().replace(R.id.frameContainer, jobDetails).commit();
    }
}