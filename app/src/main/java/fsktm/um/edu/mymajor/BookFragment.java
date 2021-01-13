package fsktm.um.edu.mymajor;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
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
 * Use the {@link BookFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BookFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();
    EditText bookTitle;
    Button searchBtn, viewBtn;
    TextView bookNumber1;
    TextView bookNumber2;
    TextView bookNumber3;
    ImageView bookImage1;
    ImageView bookImage2;
    ImageView bookImage3;


    ArrayList<BookModel> list = new ArrayList<>();

    private String mParam1;
    private String mParam2;

    public BookFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static BookFragment newInstance(String param1, String param2) {
        BookFragment fragment = new BookFragment();
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
        View v =  inflater.inflate(R.layout.fragment_book, container, false);

        searchBtn = v.findViewById(R.id.search_btn_books);
        viewBtn = v.findViewById(R.id.view_btn_books);
        bookTitle = v.findViewById(R.id.title_input_books);

        bookNumber1 = v.findViewById(R.id.bookNumber1);
        bookNumber2 = v.findViewById(R.id.bookNumber2);
        bookNumber3 = v.findViewById(R.id.bookNumber3);

        bookImage1 = v.findViewById(R.id.bookImage1);
        bookImage2 = v.findViewById(R.id.bookImage2);
        bookImage3 = v.findViewById(R.id.bookImage3);

        myRef.child("books").child("0").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String title = dataSnapshot.child("title").getValue().toString();
                if(title.length() > 15){
                    title = title.substring(0, 15);
                }
                bookNumber1.setText(title);
                list.add(dataSnapshot.getValue(BookModel.class));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getActivity(), "Database error!", Toast.LENGTH_SHORT).show();
            }
        });

        myRef.child("books").child("3").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String title = dataSnapshot.child("title").getValue().toString();
                if(title.length() > 15){
                    title = title.substring(0, 15);
                }
                bookNumber2.setText(title);
                list.add(dataSnapshot.getValue(BookModel.class));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getActivity(), "Database error!", Toast.LENGTH_SHORT).show();
            }
        });

        myRef.child("books").child("4").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String title = dataSnapshot.child("title").getValue().toString();
                if(title.length() > 15){
                    title = title.substring(0, 15);
                }

                bookNumber3.setText(title);
                list.add(dataSnapshot.getValue(BookModel.class));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getActivity(), "Database error!", Toast.LENGTH_SHORT).show();
            }
        });

        bookImage1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("books", list);
                bundle.putInt("index", 0);

                BookDetails bookDetails = new BookDetails();
                bookDetails.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.frameContainer, bookDetails).commit();
            }
        });

        bookImage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("books", list);
                bundle.putInt("index", 1);

                BookDetails bookDetails = new BookDetails();
                bookDetails.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.frameContainer, bookDetails).commit();
            }
        });

        bookImage3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("books", list);
                bundle.putInt("index", 2);

                BookDetails bookDetails = new BookDetails();
                bookDetails.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.frameContainer, bookDetails).commit();
            }
        });


        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bookTitle.getText().toString().isEmpty()){
                    Toast.makeText(getActivity(), "Please enter a search keyword", Toast.LENGTH_SHORT).show();
                } else {
                    Bundle bundle = new Bundle();
                    bundle.putString("query", bookTitle.getText().toString());

                    BookSearchResult bookSearchResult = new BookSearchResult();
                    bookSearchResult.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.frameContainer, bookSearchResult).commit();
                }
            }
        });

        viewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BookList bookList = new BookList();
                getFragmentManager().beginTransaction().replace(R.id.frameContainer, bookList).commit();
            }
        });



        return v;
    }
}