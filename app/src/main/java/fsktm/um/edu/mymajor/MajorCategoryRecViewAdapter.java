package fsktm.um.edu.mymajor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MajorCategoryRecViewAdapter extends RecyclerView.Adapter<MajorCategoryRecViewAdapter.ViewHolder>{


    private ArrayList<MajorCategoryModel> list = new ArrayList<>();
    private OnClickListener onClickListener;

    public MajorCategoryRecViewAdapter() {

    }

    public MajorCategoryRecViewAdapter(ArrayList<MajorCategoryModel> list, OnClickListener onClickListener) {
        this.list = list;
        this.onClickListener = onClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.major_category_list_item, parent, false);
        ViewHolder holder = new ViewHolder(view, onClickListener);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String title = list.get(position).getTitle();
        String description = list.get(position).getDescription();

        if(title.length() > 25){
            title = title.substring(0, 25);
        }

        if(description.length() > 50){
            description = description.substring(0, 50);
        }

        holder.txtMajorCategoryListItemTitle.setText(title);
        holder.txtMajorCategoryListItemDescription.setText(description);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setList(ArrayList<MajorCategoryModel> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView txtMajorCategoryListItemTitle;
        private TextView txtMajorCategoryListItemDescription;
        OnClickListener onClickListener;
        public ViewHolder(@NonNull View itemView, OnClickListener onClickListener) {
            super(itemView);
            txtMajorCategoryListItemTitle = itemView.findViewById(R.id.txtMajorCategoryListItemTitle);
            txtMajorCategoryListItemDescription = itemView.findViewById(R.id.txtMajorCategoryListItemDescription);
            this.onClickListener = onClickListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onClickListener.onClick(getAdapterPosition());
        }
    }

    public interface OnClickListener{
        void onClick(int position);
    }

}
