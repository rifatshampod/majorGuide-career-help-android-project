package fsktm.um.edu.mymajor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SearchResultRecViewAdapter extends RecyclerView.Adapter<SearchResultRecViewAdapter.ViewHolder> {

    private ArrayList<MajorSubcategoryModel> searchResults = new ArrayList<>();
    private OnClickListener mOnClickListener;

    public SearchResultRecViewAdapter(ArrayList<MajorSubcategoryModel> searchResults, OnClickListener onClickListener) {
        this.searchResults = searchResults;
        this.mOnClickListener = onClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_result_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view, mOnClickListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String title = searchResults.get(position).getTitle();
        String description = searchResults.get(position).getDescription();

        if(title.length() > 25){
            title = title.substring(0, 25);
        }

        if(description.length() > 50){
            description = description.substring(0, 50);
        }

        holder.txtSearchResultTitle.setText(title);
        holder.txtSearchResultDescription.setText(description);
    }

    @Override
    public int getItemCount() {
        return searchResults.size();
    }

    public void setSearchResults(ArrayList<MajorSubcategoryModel> searchResults) {
        this.searchResults = searchResults;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView txtSearchResultTitle;
        public TextView txtSearchResultDescription;
        OnClickListener onClickListener;

        public ViewHolder(@NonNull View itemView, OnClickListener onClickListener) {
            super(itemView);
            txtSearchResultTitle = itemView.findViewById(R.id.txtSearchResultTitle);
            txtSearchResultDescription = itemView.findViewById(R.id.txtSearchResultDescription);
            this.onClickListener = onClickListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onClickListener.onClick(getAdapterPosition());
        }
    }

    public interface OnClickListener{
        void onClick(int position);
    }
}
