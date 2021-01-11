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
 * Use the {@link BookSearchResult#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BookSearchResult extends Fragment implements BookSearchRecViewAdapter.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();
    private ArrayList<BookModel> list = new ArrayList<>();
    private TextView txtBookSearchTitle;
    private RecyclerView txtBookListView;

    public BookSearchResult() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BookSearchResult.
     */
    // TODO: Rename and change types and number of parameters
    public static BookSearchResult newInstance(String param1, String param2) {
        BookSearchResult fragment = new BookSearchResult();
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
        View view = inflater.inflate(R.layout.fragment_book_search_result, container, false);

        txtBookSearchTitle = view.findViewById(R.id.txtBookSearchTitle);
        txtBookListView = view.findViewById(R.id.txtBookListView);

        final BookSearchRecViewAdapter adapter = new BookSearchRecViewAdapter(list, this);

        txtBookListView.setAdapter(adapter);
        txtBookListView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        txtBookListView.setItemAnimator(new DefaultItemAnimator());

        final String query = getArguments().getString("query");
        myRef.child("books").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren()){
                    if (dataSnapshot1.child("title").getValue().toString().toLowerCase().contains(query.toLowerCase())){
                        list.add(dataSnapshot1.getValue(BookModel.class));
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
        bundle.putSerializable("books", list);
        bundle.putInt("index", position);

        BookDetails bookDetails = new BookDetails();
        bookDetails.setArguments(bundle);
        getFragmentManager().beginTransaction().replace(R.id.frameContainer, bookDetails).commit();
    }
}