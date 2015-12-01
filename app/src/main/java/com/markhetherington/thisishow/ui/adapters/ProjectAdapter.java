package com.markhetherington.thisishow.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.markhetherington.thisishow.R;
import com.markhetherington.thisishow.models.Project;
import com.markhetherington.thisishow.ui.fragments.ProjectFeedFragment;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ProjectAdapter extends RecyclerView.Adapter<ProjectAdapter.ViewHolder> {

    private final List<Project> mProjects;
    private final ProjectFeedFragment.OnListFragmentInteractionListener mListener;

    public ProjectAdapter(List<Project> projects, ProjectFeedFragment.OnListFragmentInteractionListener listener) {
        mProjects = projects;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.project_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mProjects.get(position);
        holder.mIdView.setText(holder.mItem.getTitle());
        holder.mContentView.setText(mProjects.get(position).getDescription());

        holder.mView.setOnClickListener(v -> {
            if (null != mListener) {
                mListener.onListFragmentInteraction(holder.mItem);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mProjects.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public Project mItem;

        public final View mView;
        @Bind(R.id.id)
        public TextView mIdView;
        @Bind(R.id.content)
        public TextView mContentView;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            ButterKnife.bind(this, view);
        }
    }
}
