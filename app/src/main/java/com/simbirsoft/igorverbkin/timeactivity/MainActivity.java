package com.simbirsoft.igorverbkin.timeactivity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements TaskAdapter.OnTaskClickListener, CategoryAdapter.OnCategoryClickListener {

    @BindView(R.id.fab_add_task) FloatingActionButton addTask;

    private CategoryAdapter categoryAdapter;
    private TaskAdapter taskAdapter;
    private RecyclerView taskRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        RecyclerView categoryRecycler = findViewById(R.id.category_recycler);
        categoryRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        categoryAdapter = new CategoryAdapter(this);

        List<String> data = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            data.add(String.valueOf(i));
        }

        categoryAdapter.updateList(data);
        categoryRecycler.setAdapter(categoryAdapter);


        taskRecycler = findViewById(R.id.tasks_recycler);
        taskRecycler.setLayoutManager(new LinearLayoutManager(this));
        taskAdapter = new TaskAdapter(this);

        List<String> data2 = new ArrayList<>();
        for (int i = 1; i < 15; i++) {
            data2.add("Some long name of task " + i);
        }

        taskAdapter.updateList(data2);
        taskRecycler.setAdapter(taskAdapter);

        prepareSwipeHelper();
    }

    private void prepareSwipeHelper() {
        SwipeHelper swipeHelper = new SwipeHelper(this, taskRecycler) {
            @Override
            public void instantiateUnderlayButton(RecyclerView.ViewHolder viewHolder, List<UnderlayButton> underlayButtons) {
                underlayButtons.add(new SwipeHelper.UnderlayButton(
                        getResources(),
                        R.drawable.ic_del,
                        R.color.blue,
                        pos -> taskAdapter.removeItem(pos)
                ));

                underlayButtons.add(new SwipeHelper.UnderlayButton(
                        getResources(),
                        R.drawable.ic_share,
                        R.color.gray_100,
                        new SwipeHelper.UnderlayButtonClickListener() {
                            @Override
                            public void onClick(int pos) {
                                // TODO: OnEdit
                            }
                        }
                ));
            }
        };

        swipeHelper.attachSwipe();
    }

    @Override
    public void onCategoryClick() {

    }

    @Override
    public void onTaskClick() {

    }

    @OnClick(R.id.fab_add_task)
    public void onClickFab() {
        taskAdapter.add("Some long name of task " + (int) (Math.random() * 100));
    }
}
