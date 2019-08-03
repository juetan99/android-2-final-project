package com.ucsdextandroid2.android2final;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListActivity extends AppCompatActivity {
    private ListAdapter listAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycleview_list);

        listAdapter = new ListAdapter();

        RecyclerView recyclerView =findViewById(R.id.rv_list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(listAdapter);

        getAPIdata();

        listAdapter.setClickListener(new OnItemClickListener<Park>() {
            @Override
            public void onItemClicked(Park item) {
                Intent intent = new Intent(ListActivity.this, ParkDetailActivity.class);
                intent.putExtra("park", item);

                startActivity(intent);

                ParkEntity parkEntity = new ParkEntity();
                parkEntity.id = item.getId();
                parkEntity.name = item.getName();
                parkEntity.imageUrl = item.getImages().get(0).getUrl();

                // add to database
                addParktoDB(parkEntity);
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull String name, @NonNull Context context, @NonNull AttributeSet attrs) {
        return super.onCreateView(name, context, attrs);
    }



    private void getAPIdata(){
        DataSources.getInstance().getParks(new DataSources.Callback<List<Park>>() {
            @Override
            public void onDataFetched(List<Park> data) {
                Log.d("ListActivity", "API returns Park: "+ data.size());
                listAdapter.setList(data);
            }
        });

    }


    private void addParktoDB(ParkEntity parkEntity){
            AppDatabase.getAppDatabase(this).parkDao().insert(parkEntity);
    }
}
