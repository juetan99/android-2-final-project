package com.ucsdextandroid2.android2final;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;

public class ListViewHolder extends RecyclerView.ViewHolder{
    private ImageView imageView;
    private TextView tvTitle;
    private TextView tvSubtitle;
    private Park currentPark;

    private OnItemClickListener<Park> clickListener;

    public static ListViewHolder inflate(@NonNull ViewGroup parent){
        return new ListViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.viewholder_list_item, parent, false));
    }

    private ListViewHolder(@NonNull View itemView){
        super(itemView);

        imageView = itemView.findViewById(R.id.vhli_image);
        tvTitle = itemView.findViewById(R.id.vhli_title);
        tvSubtitle = itemView.findViewById(R.id.vhli_subtitle);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clickListener != null && currentPark != null){
                    clickListener.onItemClicked(currentPark);
                }
            }
        });

    }

    public void bind(Park park){
        this.currentPark = park;

        Picasso.get().load(park.getImages().get(0).getUrl()).into(imageView);
        tvTitle.setText(park.getName());
        tvSubtitle.setText(park.getStates());
    }

    public void setClickListener(OnItemClickListener<Park> clickListener) {
        this.clickListener = clickListener;
    }

}
