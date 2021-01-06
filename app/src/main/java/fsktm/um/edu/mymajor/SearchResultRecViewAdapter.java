package fsktm.um.edu.mymajor;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SearchResultRecViewAdapter extends RecyclerView.Adapter<SearchResultRecViewAdapter.ViewHolder> {

    private ArrayList<SearchResultModel> searchResults = new ArrayList<>();
    private OnClickListener mOnClickListener;

    public SearchResultRecViewAdapter(ArrayList<SearchResultModel> searchResults, OnClickListener onClickListener) {
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
        holder.txtSearchResultTitle.setText(searchResults.get(position).getTitle());
        holder.txtSearchResultDescription.setText(searchResults.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return searchResults.size();
    }

    public void setSearchResults(ArrayList<SearchResultModel> searchResults) {
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

            itemView.setOnClickListener(this) ;
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
