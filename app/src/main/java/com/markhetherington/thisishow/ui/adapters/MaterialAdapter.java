package com.markhetherington.thisishow.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.markhetherington.thisishow.R;
import com.markhetherington.thisishow.models.Material;
import com.markhetherington.thisishow.models.MaterialQuantityItem;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MaterialAdapter extends RecyclerView.Adapter<MaterialAdapter.InstructionViewHolder> {

    List<MaterialQuantityItem> mMaterials;

    public MaterialAdapter(List<MaterialQuantityItem> materials) {
        mMaterials = materials;
    }

    @Override
    public InstructionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.material_item, parent, false);
        return new InstructionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(InstructionViewHolder holder, int position) {
        MaterialQuantityItem instruction = mMaterials.get(position);
        holder.mTextView.setText(instruction.getMaterial().getName());
        holder.mQuantityTextView.setText(String.valueOf(instruction.getCount()));
    }

    @Override
    public int getItemCount() {
        return mMaterials.size();
    }

    public class InstructionViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.text)
        TextView mTextView;
        @Bind(R.id.quantity)
        TextView mQuantityTextView;

        public InstructionViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
