package com.simbirsoft.igorverbkin.timeactivity;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskViewHolder> {

    private List<String> data = new ArrayList<>();
    private OnTaskClickListener listener;

    public TaskAdapter(OnTaskClickListener listener) {
        this.listener = listener;
    }

    interface OnTaskClickListener {
        void onTaskClick();
    }

    public void updateList(List<String> data) {
        this.data.clear();
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    public void add(String item) {
        data.add(item);
        notifyItemInserted(getItemCount());
    }

    public void removeItem(int pos) {
        data.remove(pos);
        notifyItemRemoved(pos);
    }

    @Override
    public TaskViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new TaskViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_task, parent, false), listener);
    }

    @Override
    public void onBindViewHolder(TaskViewHolder holder, int position) {
        holder.bindView(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
