package com.simbirsoft.igorverbkin.timeactivity;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryViewHolder> {

    private List<String> data = new ArrayList<>();
    private OnCategoryClickListener listener;

    public CategoryAdapter(OnCategoryClickListener listener) {
        this.listener = listener;
    }

    interface OnCategoryClickListener {
        void onCategoryClick();
    }

    public void updateList(List<String> data) {
        this.data.clear();
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CategoryViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_category, parent, false), listener);
    }

    @Override
    public void onBindViewHolder(CategoryViewHolder holder, int position) {
        holder.bindView(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
