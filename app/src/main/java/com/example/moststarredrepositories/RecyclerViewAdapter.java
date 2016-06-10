package com.example.moststarredrepositories;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Provide views to RecyclerView
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private static final String LOG_TAG = RecyclerViewAdapter.class.getSimpleName();

    private Repository[] mDataSet;
    private Context mContext;

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param dataSet Repository[] containing the data to populate views to be used by RecyclerView.
     */
    public RecyclerViewAdapter(Repository[] dataSet, Context context) {
        mDataSet = dataSet;
        mContext = context;
    }

    /**
     * Provide a reference to the type of views that you are using (custom ViewHolder)
     */
    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView repoName;

        public ViewHolder(View itemView) {
            super(itemView);
            // Define click listener for the ViewHolder's View.
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Show Detail View/Activity
                }
            });
            repoName = (TextView) itemView.findViewById(R.id.repo_name_text_view);
        }

        public TextView getRepoName() {
            return repoName;
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Create a new view
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_base, parent, false);

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    // Get element from the dataset at this position and replace the contents of the view
    // with that element
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.getRepoName().setText(mDataSet[position].getName());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataSet.length;
    }
}
