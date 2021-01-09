package fsktm.um.edu.mymajor;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CvBuildFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CvBuildFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    Button saveResume;
    EditText name, email, phone, address, dob, studylevel, studyYear, studyResult, skill1, skill2;
    SeekBar level1,level2;

    String nameVal, emailVal, phoneVal, addressVal, dobVal, studylevelVal, studyYearVal, studyResultVal, skill1Val, skill2Val;

    int level1Val,level2Val, cvNo=1;

    DatabaseReference myDatabase;
    FirebaseAuth mFirebaseAuth;

    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

    public CvBuildFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CvBuildFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CvBuildFragment newInstance(String param1, String param2) {
        CvBuildFragment fragment = new CvBuildFragment();
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
        View v= inflater.inflate(R.layout.fragment_cv_build, container, false);

        myDatabase = FirebaseDatabase.getInstance().getReference("resume");
        mFirebaseAuth = FirebaseAuth.getInstance();

        saveResume=v.findViewById(R.id.save_resume_btn);

        name = v.findViewById(R.id.name);
        email = v.findViewById(R.id.email);
        phone = v.findViewById(R.id.contact);
        address = v.findViewById(R.id.address);
        dob = v.findViewById(R.id.dob);
        studylevel = v.findViewById(R.id.study_level);
        studyYear = v.findViewById(R.id.study_year);
        studyResult = v.findViewById(R.id.study_result);
        skill1 = v.findViewById(R.id.skill1);
        level1 = v.findViewById(R.id.level1);
        skill2 = v.findViewById(R.id.skill2);
        level2 = v.findViewById(R.id.level2);


        saveResume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Data value --------------------------------------------------

                nameVal = name.getText().toString();
                emailVal = email.getText().toString();
                phoneVal = phone.getText().toString();
                addressVal = address.getText().toString();
                dobVal = dob.getText().toString();
                studylevelVal = studylevel.getText().toString();
                studyYearVal = studyYear.getText().toString();
                studyResultVal = studyResult.getText().toString();
                skill1Val = skill1.getText().toString();
                skill2Val = skill2.getText().toString();

                level1Val = level1.getProgress();
                level2Val = level2.getProgress();
                Toast.makeText(getActivity(),"Data have been saved.",Toast.LENGTH_LONG).show();

                String id = user.getUid();

                Members members = new Members(String.valueOf(mFirebaseAuth.getCurrentUser()), nameVal, emailVal, phoneVal, addressVal, dobVal, studylevelVal, studyYearVal, studyResultVal, skill1Val, skill2Val,level1Val,level2Val);

                myDatabase.child(id).child(Integer.toString(cvNo)).setValue(members);

                Fragment newFragment = new CvFragment();
                // consider using Java coding conventions (upper first char class names!!!)
                FragmentTransaction transaction = getFragmentManager().beginTransaction();

                // Replace whatever is in the fragment_container view with this fragment,
                // and add the transaction to the back stack
                transaction.replace(R.id.frameContainer, newFragment);
                transaction.addToBackStack(null);

                // Commit the transaction
                transaction.commit();
            }
        });

        return v;
    }
}