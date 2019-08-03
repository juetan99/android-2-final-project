package com.ucsdextandroid2.android2final;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ParkDetailActivity extends AppCompatActivity {
    private ImageView imageView;
    private TextView tvTitle;
    private TextView tvDescription;
    private TextView tvWeather;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_park_details);

        imageView = findViewById(R.id.park_detail_image);
        tvTitle = findViewById(R.id.park_detail_title);
        tvDescription = findViewById(R.id.tv_detail_description);
        tvWeather = findViewById(R.id.tv_detail_weather);

        Park park = getIntent().getParcelableExtra("park");

        if (park != null){
            tvTitle.setText(park.getName());
            tvDescription.setText(park.getDescription());
            tvDescription.setVisibility(View.GONE);
            tvWeather.setText(park.getWeather());
            tvWeather.setVisibility(View.GONE);
            List<ParkEntity> parkEntityList= AppDatabase.getAppDatabase(this).parkDao().getParkById(park.getId());

            Picasso.get().load(parkEntityList.get(0).imageUrl).into(imageView);
        }


    }

    public void toggle_content(View v){
        tvDescription.setVisibility(tvDescription.isShown()? View.GONE : View.VISIBLE);
    }
    public void toggle_content_weather(View v){
        tvWeather.setVisibility(tvWeather.isShown()? View.GONE : View.VISIBLE);
    }
}
