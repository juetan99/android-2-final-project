package com.ucsdextandroid2.android2final;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListFragment extends Fragment {
    private ListAdapter listAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        listAdapter = new ListAdapter();
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView =view.findViewById(R.id.rv_list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(requireContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(listAdapter);

        getAPIdata();

        listAdapter.setClickListener(new OnItemClickListener<Park>() {
            @Override
            public void onItemClicked(Park item) {
                Intent intent = new Intent(getActivity(), ParkDetailActivity.class);
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
        AppDatabase.getAppDatabase(requireContext()).parkDao().insert(parkEntity);
    }

}

