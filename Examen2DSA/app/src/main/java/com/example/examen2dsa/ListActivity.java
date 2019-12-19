package com.example.examen2dsa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.examen2dsa.models.Museums;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListActivity extends AppCompatActivity implements RecyclerViewClickListener{

    private ProgressBar listProgress;
    private RecyclerView museumslistRV;

    private MuseumsAPI APIinterface; //Interface of the API methods
public RVAdapter  adapter;
    public void loadMuseums(){
        //Method getMuseums() of the API interface
showProgress(true);
        Call<Museums> call = APIinterface.getMuseums();
        call.enqueue(new Callback<Museums>() {
            @Override
            public void onResponse(Call<Museums> call, Response<Museums> response) {
                if(response.isSuccessful()){
                    Museums museums = response.body();
                adapter  = new RVAdapter(museums.getElements());
                    museumslistRV.setAdapter(adapter);
                    adapter.setContext(museumslistRV.getContext());
                    adapter.setItemListener(ListActivity.this);
                }
                else
                    Toast.makeText(getApplicationContext(), "Error Code: " + response.code(), Toast.LENGTH_LONG).show();
                showProgress(false);
            }
            @Override
            public void onFailure(Call<Museums> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Error Code: " + t.getMessage(), Toast.LENGTH_LONG).show();
                showProgress(false);
            }
        });
    }

    public void showProgress (boolean visible){
        //Sets the visibility/invisibility of the ProgressBar
        if(visible)
            this.listProgress.setVisibility(View.VISIBLE);
        else
            this.listProgress.setVisibility(View.GONE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        listProgress = findViewById(R.id.listProgressBar);
        museumslistRV = findViewById(R.id.museumslistRecyclerView);

        //Retrofit Builder
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://do.diba.cat/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIinterface = retrofit.create(MuseumsAPI.class);

        museumslistRV.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        loadMuseums();
    }
//    public void Details(final View view) {
//
//        Intent intent = new Intent(view.getContext(), MuseumDetail.class);
//        startActivity(intent);
//    }
@Override
public void recyclerViewListClicked(View v, int position){
    Intent intent = new Intent(v.getContext(), MuseumDetail.class);
    intent.putExtra("posicion",position);
   startActivity(intent);



}

//set up adapter and pass clicked listener this

}
