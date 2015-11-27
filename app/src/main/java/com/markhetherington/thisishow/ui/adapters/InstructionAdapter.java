package com.markhetherington.thisishow.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.markhetherington.thisishow.R;
import com.markhetherington.thisishow.models.Instruction;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class InstructionAdapter extends RecyclerView.Adapter<InstructionAdapter.InstructionViewHolder> {

    List<Instruction> mInstructions;

    public InstructionAdapter(List<Instruction> instructions) {
        mInstructions = instructions;
    }

    @Override
    public InstructionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.instruction_item, parent, false);
        return new InstructionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(InstructionViewHolder holder, int position) {
        Instruction instruction = mInstructions.get(position);
        holder.titleView.setText(instruction.getTitle());
        holder.descriptionView.setText(Html.fromHtml(instruction.getDescriptionHtmlText()));
        Picasso.with(holder.imageView.getContext()).load(instruction.getImageUrl()).fit().centerCrop().into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return mInstructions.size();
    }

    public class InstructionViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.title)
        TextView titleView;
        @Bind(R.id.description)
        TextView descriptionView;
        @Bind(R.id.image)
        ImageView imageView;

        public InstructionViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
