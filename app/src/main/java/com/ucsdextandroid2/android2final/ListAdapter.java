package com.ucsdextandroid2.android2final;

import android.util.Log;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListViewHolder> {

    private List<Park> items = new ArrayList<>();

    private OnItemClickListener<Park> clickListener;

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ListViewHolder listViewHolder = ListViewHolder.inflate(parent);
        listViewHolder.setClickListener(item ->{
            if (clickListener != null)
                clickListener.onItemClicked(item);
        });
        return listViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        holder.bind(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setList(List<Park> list){
        Log.d("test", "Park count: " + list.size());
        this.items = list;
        notifyDataSetChanged();
    }

    public void setClickListener(OnItemClickListener<Park> clickListener) {
        this.clickListener = clickListener;
    }
}
