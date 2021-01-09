package fsktm.um.edu.mymajor;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class CvFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    Button createCv, viewCV;

    DatabaseReference myDatabase;
    FirebaseAuth mFirebaseAuth;

    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();


    private String mParam1;
    private String mParam2;

    private RecyclerView recyclerView;
    private List<CategoryModel> list;

    public CvFragment() {

    }


    public static CvFragment newInstance(String param1, String param2) {
        CvFragment fragment = new CvFragment();
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
        View v= inflater.inflate(R.layout.fragment_cv, container, false);

        recyclerView = v.findViewById(R.id.cvList);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(RecyclerView.VERTICAL);

        recyclerView.setLayoutManager(layoutManager);

        list = new ArrayList<>();

        createCv = v.findViewById(R.id.cv_create_btn);
        viewCV = v.findViewById(R.id.cv_view_btn);

        createCv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment newFragment = new CvBuildFragment();
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

        final String userId = user.getUid();

        myDatabase = FirebaseDatabase.getInstance().getReference().child("resume").child(userId).child("1");
        myDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if(dataSnapshot.exists()){
                    viewCV.setVisibility(View.VISIBLE);

                    final String name = dataSnapshot.child("name").getValue().toString();
                    final String email = dataSnapshot.child("email").getValue().toString();
                    final String phone = dataSnapshot.child("phone").getValue().toString();
                    final String address = dataSnapshot.child("address").getValue().toString();
                    final String dob = dataSnapshot.child("dob").getValue().toString();
                    final String studyLevel = dataSnapshot.child("studylevel").getValue().toString();
                    final String studyYear = dataSnapshot.child("studyYear").getValue().toString();
                    final String studyResult = dataSnapshot.child("studyResult").getValue().toString();

                    final String skill1 = dataSnapshot.child("skill1").getValue().toString();
                    final String level1 = dataSnapshot.child("level1").getValue().toString();
                    final String skill2 = dataSnapshot.child("skill2").getValue().toString();
                    final String level2 = dataSnapshot.child("level2").getValue().toString();

                    viewCV.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            AlertDialog alertDialog = new AlertDialog.Builder(getContext()).create(); //Read Update
                            alertDialog.setTitle("CV");
                            alertDialog.setMessage("Name: "+name+"\n Email: "+email
                                    +"\n Phone Number: "+phone
                                    +"\n Address: "+address
                                    +"\n Date of Birth: "+dob+"\n \n"
                                    +"\n Level of Study: "+studyLevel
                                    +"\n Result : "+studyResult+ "    Passing Year: "+studyYear+"\n \n"
                                    +"Skill :"+skill1+"    Level: "+level1+"\n"
                                    +"Skill :"+skill2+"    Level: "+level2+"\n"
                            );

                            alertDialog.setButton("close", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    // here you can add functions
                                }
                            });

                            alertDialog.show();
                        }
                    });


                } else {
                    viewCV.setVisibility(View.INVISIBLE);
                }
//                String name = dataSnapshot.child("name").getValue().toString();
//                String email = dataSnapshot.child("email").getValue().toString();
//                String phone = dataSnapshot.child("phone").getValue().toString();
//                String address = dataSnapshot.child("address").getValue().toString();



            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        return v;
    }
}