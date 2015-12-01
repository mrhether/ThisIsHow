package com.markhetherington.thisishow.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.markhetherington.thisishow.R;
import com.markhetherington.thisishow.models.Project;
import com.markhetherington.thisishow.ui.adapters.ProjectAdapter;
import com.markhetherington.thisishow.ui.controllers.FeedController;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;


public class ProjectFeedFragment extends Fragment implements FeedController.FeedControllerListener {

    private static final String ARG_COLUMN_COUNT = "column-count";

    private int mColumnCount = 1;
    private OnListFragmentInteractionListener mListener;
    private ProjectAdapter mAdapter;

    @Bind(R.id.list)
    RecyclerView mRecyclerView;

    FeedController mFeedController = new FeedController();

    public ProjectFeedFragment() {
    }

    public static ProjectFeedFragment newInstance(int columnCount) {
        ProjectFeedFragment fragment = new ProjectFeedFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_project_list, container, false);
        ButterKnife.bind(this, view);
        Context context = view.getContext();

        if (mColumnCount <= 1) {
            mRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        } else {
            mRecyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
        }
        mFeedController.subscribe(this);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mFeedController.unsubscribe(this);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onProjectsUpdated(List<Project> projects) {
        mAdapter = new ProjectAdapter(projects, mListener);
        mRecyclerView.setAdapter(mAdapter);
    }

    public interface OnListFragmentInteractionListener {
        void onListFragmentInteraction(Project project);
    }
}
