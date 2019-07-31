package com.ucsdextandroid2.android2final;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListActivity extends AppCompatActivity {
    private ListAdapter adapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycleview_list);

        adapter = new ListAdapter();

        RecyclerView recyclerView =findViewById(R.id.rv_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        DataSources.getInstance().getParks(new DataSources.Callback<List<Park>>() {
            @Override
            public void onDataFetched(List<Park> data) {
                Log.d("ListActivity", "API returns Park: "+ data.size());
                adapter.setList(data);
            }
        });

    }
}
