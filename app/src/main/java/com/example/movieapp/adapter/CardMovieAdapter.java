package com.example.movieapp.adapter;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movieapp.R;

public class CardMovieAdapter extends RecyclerView.Adapter<CardMovieAdapter.ViewHolder> {

    private String[] caption;
    private int[] imageId;
    public Listener listener;

    public CardMovieAdapter(String[] caption, int[] imageId) {
        this.caption = caption;
        this.imageId = imageId;
    }

    public interface Listener {
        void onClick(int position);
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public CardMovieAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardView cv = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.card_movie_adapter, parent, false);
        return new ViewHolder(cv);
    }

    @Override
    public void onBindViewHolder(@NonNull CardMovieAdapter.ViewHolder holder, final int position) {
        CardView cardView = holder.cardView;
        ImageView imageView = cardView.findViewById(R.id.info_image);
        Drawable drawable = ContextCompat.getDrawable(cardView.getContext(), imageId[position]);
        imageView.setImageDrawable(drawable);
        imageView.setContentDescription(caption[position]);
        TextView textView = cardView.findViewById(R.id.info_text);
        textView.setText(caption[position]);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return caption.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private CardView cardView;

        public ViewHolder(@NonNull CardView itemView) {
            super(itemView);
            cardView = itemView;
        }
    }
}
