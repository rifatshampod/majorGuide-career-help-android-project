package fsktm.um.edu.mymajor;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BookFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BookFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    EditText bookTitle;
    Button searchBtn, viewBtn;

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