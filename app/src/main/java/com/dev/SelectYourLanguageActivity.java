package com.dev;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.helpers.AppBaseActivityHelper;

public class SelectYourLanguageActivity extends AppBaseActivityHelper {

    RecyclerView recycler_view;
    LanguageAdapter languageAdapter;
    Button next_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_your_language);

        recycler_view = findViewById(R.id.recycler_view);
        next_btn = findViewById(R.id.next_btn);

        next_btn.setOnClickListener(this);
        setRecyclerView();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.next_btn:
                goToSelectYourGenderActivity(null);
                break;
        }
    }

    private void setRecyclerView(){
        recycler_view.setHasFixedSize(true);
        recycler_view.setLayoutManager(new GridLayoutManager(this,2));
        languageAdapter = new LanguageAdapter(this);
        recycler_view.setAdapter(languageAdapter);
    }

    private class LanguageAdapter extends RecyclerView.Adapter<LanguageAdapter.ViewHolder>{

        Context context;

        public LanguageAdapter(Context context) {
            this.context = context;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.rv_language_layout,parent,false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 9;
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            public ViewHolder(@NonNull View itemView) {
                super(itemView);
            }
        }
    }
}
