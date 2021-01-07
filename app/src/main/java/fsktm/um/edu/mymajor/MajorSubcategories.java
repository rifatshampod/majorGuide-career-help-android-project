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
 * Use the {@link MajorSubcategories#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MajorSubcategories extends Fragment implements SearchResultRecViewAdapter.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MajorSubcategories() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MajorSubcategories.
     */
    // TODO: Rename and change types and number of parameters
    public static MajorSubcategories newInstance(String param1, String param2) {
        MajorSubcategories fragment = new MajorSubcategories();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();
    private ArrayList<MajorSubcategoryModel> list;
    private RecyclerView majorSubcategoriesView;
    private TextView txtMajorSubcategoryTitle;

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
        View v = inflater.inflate(R.layout.fragment_major_subcategories, container, false);

        txtMajorSubcategoryTitle = v.findViewById(R.id.txtMajorSubcategoryTitle);
        majorSubcategoriesView = v.findViewById(R.id.majorSubcategoriesView);

        list = new ArrayList<>();

        final String categoryTitle = getArguments().getString("major_title");
        txtMajorSubcategoryTitle.setText(categoryTitle.concat(" Subcategories"));

        final SearchResultRecViewAdapter adapter = new SearchResultRecViewAdapter(list, this);
        majorSubcategoriesView.setAdapter(adapter);
        majorSubcategoriesView.setLayoutManager(new LinearLayoutManager(v.getContext()));
        majorSubcategoriesView.setItemAnimator(new DefaultItemAnimator());

        myRef.child("majors").child("categories").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren()){
                    if(dataSnapshot1.child("title").getValue().toString().equals(categoryTitle)){
                        for (DataSnapshot dataSnapshot2: dataSnapshot1.child("subcategories").getChildren()){
                            list.add(dataSnapshot2.getValue(MajorSubcategoryModel.class));
                        }
                    }
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getActivity(), "Database error!", Toast.LENGTH_SHORT).show();
            }
        });

        return v;
    }

    @Override
    public void onClick(int position) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("majors", list);
        bundle.putInt("index", position);

        MajorDetails majorDetails = new MajorDetails();
        majorDetails.setArguments(bundle);
        getFragmentManager().beginTransaction().replace(R.id.frameContainer, majorDetails).commit();
    }
}