package com.markhetherington.thisishow.ui.activites;

import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.graphics.ColorUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.markhetherington.thisishow.R;
import com.markhetherington.thisishow.models.Project;
import com.markhetherington.thisishow.ui.adapters.InstructionAdapter;
import com.markhetherington.thisishow.ui.adapters.MaterialAdapter;
import com.markhetherington.thisishow.ui.controllers.ProjectController;
import com.markhetherington.thisishow.ui.utils.HeaderTransform;
import com.markhetherington.thisishow.ui.widgets.BigStartTextView;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;


public class ProjectActivity extends AppCompatActivity implements ProjectController.ProjectControllerListener {

    @Bind(R.id.toolbar_layout)
    CollapsingToolbarLayout mCollapsingToolbarLayout;
    @Bind(R.id.project_description)
    BigStartTextView mDescription;
    @Bind(R.id.header_image)
    ImageView mToolbarBackground;
    @Bind(R.id.material_recycler_view)
    RecyclerView mMaterialRecyclerView;
    @Bind(R.id.instruction_recycler_view)
    RecyclerView mInstructionRecyclerView;

    ProjectController mProjectController = new ProjectController();

    @Override
    public void onProjectChanged(Project project) {
        updateView(project);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);

        mInstructionRecyclerView.setLayoutManager(new org.solovyev.android.views.llm.LinearLayoutManager(this));
        mInstructionRecyclerView.setNestedScrollingEnabled(false);
        mMaterialRecyclerView.setLayoutManager(new org.solovyev.android.views.llm.LinearLayoutManager(this));
        mMaterialRecyclerView.setNestedScrollingEnabled(false);

        mProjectController.subscribe(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mProjectController.unsubscribe(this);
    }

    private void updateView(Project project) {
        mCollapsingToolbarLayout.setTitle(project.getTitle());
        mDescription.setText(project.getDescription());

        HeaderTransform transformation = new HeaderTransform(this);
        Picasso.with(this).load(project.getImageUrl())
                .fit().centerCrop().transform(transformation)
                .into(mToolbarBackground, new Callback() {
                    @Override
                    public void onSuccess() {
                        setToolbarColor(transformation.getPalette().getDarkVibrantColor(Color.BLACK));
                    }

                    @Override
                    public void onError() {
                    }
                });

        InstructionAdapter instructionAdapter = new InstructionAdapter(project.getInstructions());
        mInstructionRecyclerView.setAdapter(instructionAdapter);
        MaterialAdapter materialAdapter = new MaterialAdapter(project.getMaterials());
        mMaterialRecyclerView.setAdapter(materialAdapter);

    }

    private void setToolbarColor(int color) {
        int alphaComponent = ColorUtils.setAlphaComponent(Color.BLACK, 77);
        int statusBarColor = ColorUtils.compositeColors(alphaComponent, color);

        mCollapsingToolbarLayout.setContentScrimColor(color);
        mCollapsingToolbarLayout.setStatusBarScrimColor(statusBarColor);
        mDescription.setStartColor(color);
    }


}
