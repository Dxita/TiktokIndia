package com.dev;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.appbasehelpers.AppBaseActivityHelper;

public class SearchActivity extends AppBaseActivityHelper {

    RecyclerView recycler_view;
    SearchAdapter searchAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        recycler_view = findViewById(R.id.recycler_view);

        setSearchRecyclerView();
    }

    private void setSearchRecyclerView(){
        recycler_view.setHasFixedSize(true);
        recycler_view.setLayoutManager(new LinearLayoutManager(this));
        searchAdapter = new SearchAdapter(this);
        recycler_view.setAdapter(searchAdapter);
    }

    //----------------------------------  SearchRecyclerView -------------------------------------------

    private class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder>{

        Context context;

        public SearchAdapter(Context context) {
            this.context = context;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.include_searched_item_layout,parent,false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            holder.setData(position);
        }

        @Override
        public int getItemCount() {
            return 3;
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            RecyclerView inner_recycler_view;
            InnerRecyclerAdapter innerRecyclerAdapter;
            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                inner_recycler_view = itemView.findViewById(R.id.inner_recycler_view);

                setInnerRecyclerView();
            }

            public void setData(int position){

            }

            private void setInnerRecyclerView(){
                inner_recycler_view.setHasFixedSize(true);
                inner_recycler_view.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
                innerRecyclerAdapter = new InnerRecyclerAdapter(context);
                inner_recycler_view.setAdapter(innerRecyclerAdapter);
            }

            //----------------------------------  SearchInnerHorizontalRecyclerView -------------------------------------------

            private class InnerRecyclerAdapter extends RecyclerView.Adapter<InnerRecyclerAdapter.InnerViewHolder>{
                Context context;

                public InnerRecyclerAdapter(Context context) {
                    this.context = context;
                }

                @NonNull
                @Override
                public InnerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                    View view = LayoutInflater.from(context).inflate(R.layout.include_rv_search_inner_layout,parent,false);
                    return new InnerViewHolder(view);
                }

                @Override
                public void onBindViewHolder(@NonNull InnerViewHolder holder, int position) {
                    holder.setData(position);
                }

                @Override
                public int getItemCount() {
                    return 10;
                }

                public class InnerViewHolder extends RecyclerView.ViewHolder {
                    ImageView image_view;
                    public InnerViewHolder(@NonNull View itemView) {
                        super(itemView);
                        image_view = itemView.findViewById(R.id.image_view);
                    }

                    public void setData(int position){

                    }
                }
            }
        }
    }
}
