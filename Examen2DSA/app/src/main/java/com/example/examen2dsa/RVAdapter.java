package com.example.examen2dsa;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.examen2dsa.models.Element;
import com.squareup.picasso.Picasso;

import java.util.List;


public class RVAdapter extends RecyclerView.Adapter<RVAdapter.RVViewHolder> {

    private List<Element> museumelements; //DATA
    private Context context; //In order to open a Picasso image
    private static RecyclerViewClickListener itemListener;
    public RVAdapter(List<Element> elements) {

        this.museumelements = elements;

    }

    public void setContext(Context context) {
        this.context = context;
    }

    public void setItemListener(RecyclerViewClickListener itemListener) {
        RVAdapter.itemListener = itemListener;
    }

    @NonNull
    @Override
    public RVViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item, parent, false);
        return new RVViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RVViewHolder holder, int position) {
        holder.museumText.setText(museumelements.get(position).getAdrecaNom());
        //Museum image (in URL format) is loaded by means of Picasso
        Picasso.with(context).load(museumelements.get(position).getImatge().get(0)).into(holder.museumImage);


    }

    @Override
    public int getItemCount() {
        return museumelements.size();
    }

    public class RVViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        //Views of each RecyclerView item
        ImageView museumImage;
        TextView museumText;

        public RVViewHolder(@NonNull View itemView) {
            super(itemView);

            museumImage = itemView.findViewById(R.id.museumImageView);
            museumText = itemView.findViewById(R.id.museumTextView);

                itemView.setOnClickListener(this);
            }
        @Override
        public void onClick(View v) { //no hace nada porque no he conseguido que funcione
            itemListener.recyclerViewListClicked(v, this.getLayoutPosition());
        }
    }
}
