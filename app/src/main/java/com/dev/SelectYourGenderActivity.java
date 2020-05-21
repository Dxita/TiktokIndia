package com.dev;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.helpers.AppBaseActivityHelper;

import java.util.ArrayList;

public class SelectYourGenderActivity extends AppBaseActivityHelper {

    RecyclerView recycler_view;
    Button next_btn;
    ArrayList<String> gender_list;
    GenderAdapter gender_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_your_gender);

        recycler_view = findViewById(R.id.recycler_view);
        next_btn = findViewById(R.id.next_btn);

        gender_list = new ArrayList<>();

        next_btn.setOnClickListener(this);
        setRecyclerView();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.next_btn:
                goToDashboardActivity(null);
                break;
        }
    }

    private void setRecyclerView(){
        recycler_view.setHasFixedSize(true);
        recycler_view.setLayoutManager(new LinearLayoutManager(this));
        gender_adapter = new GenderAdapter(this,getGenderList());
        recycler_view.setAdapter(gender_adapter);
    }

    private ArrayList<String> getGenderList(){
        gender_list.add(getResources().getString(R.string.text_female));
        gender_list.add(getResources().getString(R.string.text_male));
        gender_list.add(getResources().getString(R.string.text_non_binary));
        gender_list.add(getResources().getString(R.string.text_prefer_not_to_say));
        return gender_list;
    }

    private class GenderAdapter extends RecyclerView.Adapter<GenderAdapter.ViewHolder>{

        Context context;
        ArrayList<String> gender_list;

        public GenderAdapter(Context context, ArrayList<String> gender_list) {
            this.context = context;
            this.gender_list = gender_list;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.rv_language_layout,parent,false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            holder.setData(position);
        }

        @Override
        public int getItemCount() {
            return gender_list.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            TextView text_view;
            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                text_view = itemView.findViewById(R.id.text_view);
            }

            public void setData(int position){
                text_view.setText(gender_list.get(position));
            }
        }
    }
}
