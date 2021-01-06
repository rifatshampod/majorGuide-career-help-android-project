package fsktm.um.edu.mymajor;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class SearchResult extends Fragment implements SearchResultRecViewAdapter.OnClickListener  {

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SearchResult() {
        // Required empty public constructor
    }

    public static SearchResult newInstance(String param1, String param2) {
        SearchResult fragment = new SearchResult();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();
    private TextView textSearchTitle;
    private ArrayList<SearchResultModel> list;
    private RecyclerView searchResultsView;

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
        View v= inflater.inflate(R.layout.activity_search_results, container, false);

        String type = getArguments().getString("type");
        final String search = getArguments().getString("search");

        searchResultsView = v.findViewById(R.id.searchResultsView);
        textSearchTitle = v.findViewById(R.id.textSearchTitle);

        textSearchTitle.setText(("Search Results: ").concat(search));

        list = new ArrayList<>();

        final SearchResultRecViewAdapter adapter = new SearchResultRecViewAdapter(list, this);
        searchResultsView.setAdapter(adapter);
        searchResultsView.setLayoutManager(new LinearLayoutManager(v.getContext()));
        searchResultsView.setItemAnimator(new DefaultItemAnimator());

        if(type.equals("major")){
            myRef.child("majors").child("categories").addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren()){
                        for (DataSnapshot dataSnapshot2: dataSnapshot1.child("subcategories").getChildren()){
                            if(dataSnapshot2.child("title").toString().toLowerCase().contains(search.toLowerCase())){
                                list.add(dataSnapshot2.getValue(SearchResultModel.class));
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
        }


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
