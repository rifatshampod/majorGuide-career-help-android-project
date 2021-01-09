package fsktm.um.edu.mymajor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AgentListRecViewAdapter extends RecyclerView.Adapter<AgentListRecViewAdapter.ViewHolder> {

    private ArrayList<AgentModel> list = new ArrayList<>();
    private OnClickListener onClickListener;

    public AgentListRecViewAdapter() {

    }

    public AgentListRecViewAdapter(ArrayList<AgentModel> list, OnClickListener onClickListener) {
        this.list = list;
        this.onClickListener = onClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.agent_list_item, parent, false);
        ViewHolder holder = new ViewHolder(view, onClickListener);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtAgentListItemTitle.setText(list.get(position).getName());
        holder.txtAgentListItemDescription.setText(list.get(position).getPhoneNumber());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setList(ArrayList<AgentModel> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView txtAgentListItemTitle;
        private TextView txtAgentListItemDescription;
        private OnClickListener onClickListener;

        public ViewHolder(@NonNull View itemView, OnClickListener onClickListener) {
            super(itemView);

            txtAgentListItemTitle = itemView.findViewById(R.id.txtAgentListItemTitle);
            txtAgentListItemDescription = itemView.findViewById(R.id.txtAgentListItemDescription);

            itemView.setOnClickListener(this);
            this.onClickListener = onClickListener;
        }

        @Override
        public void onClick(View v) {
            onClickListener.OnClick(getAdapterPosition());
        }
    }

    public interface OnClickListener{
        void OnClick(int position);
    }
}
