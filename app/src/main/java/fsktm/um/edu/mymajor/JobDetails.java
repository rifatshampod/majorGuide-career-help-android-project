package fsktm.um.edu.mymajor;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link JobDetails#newInstance} factory method to
 * create an instance of this fragment.
 */
public class JobDetails extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public JobDetails() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment JobDetails.
     */
    // TODO: Rename and change types and number of parameters
    public static JobDetails newInstance(String param1, String param2) {
        JobDetails fragment = new JobDetails();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    private TextView txtJobTitle;
    private TextView txtJobDescription;
    private TextView txtJobCompanyName;
    private TextView txtJobLocation;
    private TextView txtJobType;
    private TextView txtJobSalary;
    private TextView txtJobEmail;
    private ArrayList<JobModel> list = new ArrayList<>();

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
        View view = inflater.inflate(R.layout.fragment_job_details, container, false);

        txtJobTitle = view.findViewById(R.id.txtJobTitle);
        txtJobDescription = view.findViewById(R.id.txtJobDescription);
        txtJobCompanyName = view.findViewById(R.id.txtJobCompanyName);
        txtJobLocation = view.findViewById(R.id.txtJobLocation);
        txtJobType = view.findViewById(R.id.txtJobType);
        txtJobSalary = view.findViewById(R.id.txtJobSalary);
        txtJobEmail = view.findViewById(R.id.txtJobEmail);

        list = (ArrayList<JobModel>) getArguments().getSerializable("jobs");
        int index = getArguments().getInt("index");

        JobModel jobModel = list.get(index);

        txtJobTitle.setText(jobModel.getTitle());
        txtJobDescription.setText(jobModel.getDescription());
        txtJobCompanyName.setText(jobModel.getCompanyName());
        txtJobLocation.setText(jobModel.getLocation());
        txtJobType.setText(jobModel.getJob_type());
        txtJobSalary.setText(jobModel.getSalary());
        txtJobEmail.setText(jobModel.getEmail());

        return view;
    }
}