package fsktm.um.edu.mymajor;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
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
 * Use the {@link MajorCategories#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MajorCategories extends Fragment implements MajorCategoryRecViewAdapter.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MajorCategories() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MajorCategories.
     */
    // TODO: Rename and change types and number of parameters
    public static MajorCategories newInstance(String param1, String param2) {
        MajorCategories fragment = new MajorCategories();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();
    private ArrayList<MajorCategoryModel> list;
    private RecyclerView majorCategoriesView;
    private TextView txtMajorCategoryTitle;

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

        View v = inflater.inflate(R.layout.fragment_major_categories, container, false);

        majorCategoriesView = v.findViewById(R.id.majorCategoriesView);
        txtMajorCategoryTitle = v.findViewById(R.id.txtMajorCategoryTitle);

        list = new ArrayList<>();

        final MajorCategoryRecViewAdapter adapter = new MajorCategoryRecViewAdapter(list, this);
        majorCategoriesView.setAdapter(adapter);
        majorCategoriesView.setLayoutManager(new LinearLayoutManager(v.getContext()));
        majorCategoriesView.setItemAnimator(new DefaultItemAnimator());


        myRef.child("majors").child("categories").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren()){

                    MajorCategoryModel majorCategoryModel = new MajorCategoryModel();
                    majorCategoryModel.setTitle(dataSnapshot1.child("title").getValue().toString());
                    majorCategoryModel.setDescription(dataSnapshot1.child("description").getValue().toString());
                    ArrayList<MajorSubcategoryModel> tempList = new ArrayList<>();
                    for (DataSnapshot dataSnapshot2 : dataSnapshot1.child("subcategories").getChildren()){
                        tempList.add(dataSnapshot2.getValue(MajorSubcategoryModel.class));
                    }
                    majorCategoryModel.setSubcategories(tempList);
                    list.add(majorCategoryModel);
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
        bundle.putString("major_title", list.get(position).getTitle());

        MajorSubcategories majorSubcategories = new MajorSubcategories();
        majorSubcategories.setArguments(bundle);
        getFragmentManager().beginTransaction().replace(R.id.frameContainer, majorSubcategories).commit();
    }
}