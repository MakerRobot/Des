package com.example.cesaro.designs.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.cesaro.designs.Interfaces.OnClickBookListener;
import com.example.cesaro.designs.POJO.Libro;
import com.example.cesaro.designs.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


public class LibroAdapter extends RecyclerView.Adapter<LibroAdapter.ViewHolder> {

    //se agregan las variables necesarias para agregar los datos en el recyclerView
    ArrayList<Libro> libroArrayList;
    OnClickBookListener listener;
    Context context;


    public LibroAdapter(ArrayList<Libro> libroArrayList, OnClickBookListener listener) {
        this.libroArrayList = libroArrayList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        //se enlaza el layout a inflar
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_destacados, viewGroup, false);

        //se optiene el contexto de donde se muestren las vistas
        context = viewGroup.getContext();

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {

        //se agregan los contenidos para cada objeto segun la posicion que se ocupe
        final Libro libro = libroArrayList.get(position);

        viewHolder.setListener(libro,listener);

        if (libro.getUrlPortada()!=null&& libro.getTituloLibro()!=null){

            /*si el url de la imagen esta presente se agrega
            * utilizando una escala CenterCrop, guardando las imagnes en memoria y
            * teniendo como placeHolder el icono de la app*/
            RequestOptions options = new RequestOptions();
            options.diskCacheStrategy(DiskCacheStrategy.ALL);
            options.placeholder(R.mipmap.ic_launcher);
            options.centerCrop();


            Glide.with(context)
                    .load(libro.getUrlPortada())
                    .apply(options)
                    .into(viewHolder.Imageproducto);

            viewHolder.textViewNombreLibro.setText(libro.getTituloLibro());
            viewHolder.textViewLibroPrecio.setText("$"+String.valueOf(libro.getPrecioLibro()));

        }else{
            viewHolder.Imageproducto.setImageDrawable(ContextCompat
                    .getDrawable(context,R.mipmap.ic_launcher_round));
        }
//
        if (libro.isNuevo()){
            viewHolder.cardCaracteristica.setVisibility(View.VISIBLE);
        }else{
            viewHolder.cardCaracteristica.setVisibility(View.GONE);
        }



    }

    public void addView(Libro libro){

        if(!libroArrayList.contains(libro)){
            libroArrayList.add(libro);
            notifyDataSetChanged();
        }
    }

    @Override
    public int getItemCount() {
        return libroArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        /* Vistas enlazadas con la libreria ButterKnife
         * descargar en : http://jakewharton.github.io/butterknife/ ---*/
        @BindView(R.id.Imageproducto)
        ImageView Imageproducto;
        @BindView(R.id.textViewCaracteristica)
        TextView textViewCaracteristica;
        @BindView(R.id.cardCaracteristica)
        CardView cardCaracteristica;
        @BindView(R.id.cardImageProducto)
        CardView cardImageProducto;
        @BindView(R.id.textViewNombreLibro)
        TextView textViewNombreLibro;
        @BindView(R.id.textViewLibroPrecio)
        TextView textViewLibroPrecio;
        @BindView(R.id.containerBook)
        ConstraintLayout containerBook;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        void setListener (final Libro libro, final OnClickBookListener listener ){
            containerBook.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClickBookListener(libro);
                }
            });
        }

    }
}
