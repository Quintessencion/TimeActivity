package com.simbirsoft.igorverbkin.timeactivity;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

class CategoryViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.header) TextView header;

    private CategoryAdapter.OnCategoryClickListener listener;

    public CategoryViewHolder(View itemView, CategoryAdapter.OnCategoryClickListener listener) {
        super(itemView);
        this.listener = listener;
        ButterKnife.bind(this, itemView);
    }

    public void bindView(String nameHeader) {
        header.setText(nameHeader);
        itemView.setOnClickListener(v -> listener.onCategoryClick());
    }
}
