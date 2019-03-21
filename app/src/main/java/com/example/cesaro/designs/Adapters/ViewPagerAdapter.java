package com.example.cesaro.designs.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.cesaro.designs.R;

public class ViewPagerAdapter extends PagerAdapter {


    /* positionSlider es la variable que indica el numero de pagina de slider que esta presente
    tambien la imagen que se mostrara segun el String[] urlImages

    Iniciaremos positionSlider en 0 para que presente la imagen en la posicion 0 del
    String[]*/

    int positionSlider = 0;

    /*Context se crea para obtener la activididad donde mostraremos nuestro slider
    * urlImage es donde agregaremos los URL de las imagenes que necesitaremos
    * titles[] seran los titulos que necesitaremos para cada imagen.*/
    private Context context;
    private String[] urlImages;
    private String[] titles;

    public ViewPagerAdapter(Context context, String[] urlImages, String[] titles){
        this.context = context;
        this.urlImages = urlImages;
        this.titles = titles;
    }
    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {

        // obtenemos el layout que utilizaremos para el slider
        View v = LayoutInflater.from(container.getContext())
                .inflate(R.layout.my_slider_custom_layout, container, false);


        // Enlazamos los Widgets que utilizaremos con las clases java
        ImageView imageViewSlider = v.findViewById(R.id.imageViewBanner);
        final TextView titleSlider = v.findViewById(R.id.textViewTitleBanner);
        RelativeLayout rLayoutSlider = v.findViewById(R.id.containerSlider);


        /* agregamos los textos y
        * glide para poder colocar las imagenes que necesitamos presentar*/

        titleSlider.setText(titles[positionSlider]);

        RequestOptions options = new RequestOptions();
        options.diskCacheStrategy(DiskCacheStrategy.ALL);
        options.centerCrop();

        Glide.with(context)
                .load(urlImages[positionSlider])
                .apply(options)
                .into(imageViewSlider);

        //enlazamos el contanerdor con un ViewPager para poder modificar sus estados
        ViewPager viewPagerSlider = (ViewPager) container;

        //Agregamos un listener al Layout para las funciones que necesitemos

        rLayoutSlider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, String.valueOf(titleSlider.getText()), Toast.LENGTH_SHORT).show();
            }
        });

        /*condicionpara poder hacer el slider infinito
        * donde si exedemos el tamaño del String[] urlimages
        * positionSlider regresara a valer 0 y en caso contrario aumentara 1
        * para asi agregar las imagenes restantes dentro del String[] urlImages*/

        if (positionSlider>=urlImages.length-1){
            positionSlider = 0;
        }else {
            ++positionSlider;
        }

        //Agregamos la vista al slider

        viewPagerSlider.addView(v);


        return v;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        //destruccion de elementos dentro del ViewPagerSlider
        ViewPager viewPager = (ViewPager) container;

        View v = (View)object;

        viewPager.removeView(v);
    }

}
