package com.example.apppaisajes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    List<Paisaje> paisajeList;
    Context context;
    ClickListener clickListener;

    public RecyclerAdapter(List<Paisaje> paisajeList, Context context, ClickListener clickListener){
        this.paisajeList = paisajeList;
        this.context = context;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.vista_elementos_lista,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ViewHolder holder, int position) {

        Paisaje item = paisajeList.get(position);
        holder.imageViewPaisajesLista.setImageResource(item.getImagen());

    }

    @Override
    public int getItemCount() {
        return paisajeList.size();
    }
    // CLASE VIEWHOLDER
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView imageViewPaisajesLista;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageViewPaisajesLista = itemView.findViewById(R.id.imageViewPaisajesLista);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            clickListener.onItemClick(getAdapterPosition());
        }
    }
}
