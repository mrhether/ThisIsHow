package com.markhetherington.thisishow.ui.controllers;

import com.markhetherington.thisishow.models.Project;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by markhetherington on 2015-11-26.
 */
public class FeedController extends BaseViewController<FeedController.FeedControllerListener> {

    @Override
    protected void onListenerAdded() {
        List<Project> projects = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            projects.add(ProjectController.createStubProject());
        }
        inform(listener -> listener.onProjectsUpdated(projects));
    }

    public interface FeedControllerListener {
        void onProjectsUpdated(List<Project> projects);
    }

}
