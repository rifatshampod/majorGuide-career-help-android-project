package fsktm.um.edu.mymajor;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MajorFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MajorFragment extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;

    EditText majorSearch;
    Button searchMajorBtn, viewMajorBtn;

    public MajorFragment() {
        // Required empty public constructor
    }

    public static MajorFragment newInstance(String param1, String param2) {
        MajorFragment fragment = new MajorFragment();
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
        View v= inflater.inflate(R.layout.fragment_major, container, false);

        majorSearch = v.findViewById(R.id.major_input);
        searchMajorBtn = v.findViewById(R.id.search_btn_major);
        viewMajorBtn = v.findViewById(R.id.view_all_btn_major);

        return v;
    }
}