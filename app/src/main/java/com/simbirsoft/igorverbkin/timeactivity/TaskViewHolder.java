package com.simbirsoft.igorverbkin.timeactivity;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

class TaskViewHolder extends RecyclerView.ViewHolder implements TextMoveAble {

    @BindView(R.id.task_card_view) CardView cardView;
    @BindView(R.id.card) View card;
    @BindView(R.id.task_image) ImageView taskImage;
    @BindView(R.id.task_name) TextView taskName;
    @BindView(R.id.elapsed_time) TextView elapsedTime;

    private TaskAdapter.OnTaskClickListener listener;

    public TaskViewHolder(View itemView, TaskAdapter.OnTaskClickListener listener) {
        super(itemView);
        this.listener = listener;
        ButterKnife.bind(this, itemView);
    }

    public void bindView(String data) {
        taskName.setText(data);
        elapsedTime.setText(data.split(" ")[5]);
        itemView.setOnClickListener(v -> listener.onTaskClick());
    }

    public void increaseMargin() {
        card.setBackgroundColor(itemView.getResources().getColor(android.R.color.white));
        ViewGroup.LayoutParams lp = taskImage.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) lp).leftMargin = (int) itemView.getResources().getDimension(R.dimen.increase_margin);
        taskImage.setLayoutParams(lp);
        elapsedTime.setVisibility(View.INVISIBLE);
    }

    public void reduceMargin() {
        card.setBackgroundColor(itemView.getResources().getColor(R.color.gray));
        ViewGroup.LayoutParams lp = taskImage.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) lp).leftMargin = (int) itemView.getResources().getDimension(R.dimen.reduce_margin);
        taskImage.setLayoutParams(lp);
        elapsedTime.setVisibility(View.VISIBLE);
    }

    @Override
    public void setElevation(float dimension) {
        card.setElevation(dimension);
    }
}
