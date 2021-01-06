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
 * Use the {@link MajorDetails#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MajorDetails extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private TextView txtMajorTitle;
    private TextView txtMajorDescription;
    private TextView txtMajorSkills;
    private ArrayList<SearchResultModel> list;
    public MajorDetails() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MajorDetails.
     */
    // TODO: Rename and change types and number of parameters
    public static MajorDetails newInstance(String param1, String param2) {
        MajorDetails fragment = new MajorDetails();
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
        View v= inflater.inflate(R.layout.fragment_major_details, container, false);

        txtMajorTitle = v.findViewById(R.id.txtMajorTitle);
        txtMajorDescription = v.findViewById(R.id.txtMajorDescription);
        txtMajorSkills = v.findViewById(R.id.txtMajorSkills);

        list = (ArrayList<SearchResultModel>) getArguments().getSerializable("majors");
        int index = getArguments().getInt("index");

        SearchResultModel searchResultModel = list.get(index);
        txtMajorTitle.setText(searchResultModel.getTitle());
        txtMajorDescription.setText(searchResultModel.getDescription());

        return v;

    }
}