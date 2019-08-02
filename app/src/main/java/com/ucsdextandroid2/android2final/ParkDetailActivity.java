package com.ucsdextandroid2.android2final;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.squareup.picasso.Picasso;

public class ParkDetailActivity extends AppCompatActivity {
    private ImageView imageView;
    private TextView tvTitle;
    private TextView tvDescription;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_park_details);

        imageView = findViewById(R.id.park_detail_image);
        tvTitle = findViewById(R.id.park_detail_title);
        tvDescription = findViewById(R.id.park_detail_description);

        Park park = getIntent().getParcelableExtra("park");

        if (park != null){
            tvTitle.setText(park.getName());
            tvDescription.setText(park.getDescription());
            Log.d("test", "onCreate: " + park.getImageUrl());
            Picasso.get().load(park.getImageUrl()).into(imageView);
        }
    }
}
