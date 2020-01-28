package com.sujit.gitrepodemo.ui;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import static androidx.recyclerview.widget.RecyclerView.SCROLL_STATE_IDLE;

public abstract class RecyclerViewScrollListener extends RecyclerView.OnScrollListener {

    private Integer threshold = 3;
    private boolean endWithAuto = false;

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    public RecyclerViewScrollListener(RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
        init();
    }

    private void init() {
        recyclerView.addOnScrollListener(this);
        this.layoutManager = recyclerView.getLayoutManager();
//        loadFirstData();
    }

    @Override
    public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
        super.onScrollStateChanged(recyclerView, newState);
        if(newState == SCROLL_STATE_IDLE) {
            int visibleItemCount = layoutManager.getChildCount();
            int totalItemCount = layoutManager.getItemCount();

            int firstVisibleItemPosition = 0;
            if(layoutManager instanceof LinearLayoutManager) {
                firstVisibleItemPosition = ((LinearLayoutManager)layoutManager).findLastVisibleItemPosition();

            } else if(layoutManager instanceof GridLayoutManager) {
                firstVisibleItemPosition = ((GridLayoutManager)layoutManager).findLastVisibleItemPosition();
            }

            if(isLastPage()) return;

            if ((visibleItemCount + firstVisibleItemPosition + threshold) >= totalItemCount) {
                if(!endWithAuto) {
                    endWithAuto = true;
                    loadMore();
                }
            } else {
                endWithAuto = false;
            }
        }
    }

    @Override
    public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);
    }

    public abstract boolean isLastPage();
    public abstract void loadMore();
//    public abstract void loadFirstData();
}
