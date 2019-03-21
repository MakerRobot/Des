package com.example.cesaro.designs;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.cesaro.designs.Adapters.LibroAdapter;
import com.example.cesaro.designs.Adapters.ViewPagerAdapter;
import com.example.cesaro.designs.Interfaces.OnClickBookListener;
import com.example.cesaro.designs.POJO.Libro;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnClickBookListener {


    /*String[] para mandar los datos de las imagnes y textos a la clase
    * ViewPagerAdapter y podamos utilizarla tambien se crea un Handler para poder
    * hacer que el slider sea automatico*/

    private Handler handlerSlider = new Handler();

    String[] urlImages = new String[]  {
            "https://cdn.pixabay.com/photo/2018/07/11/16/53/book-3531412_960_720.jpg",
            "https://cdn.pixabay.com/photo/2015/03/17/14/05/sparkler-677774_960_720.jpg",
            "https://cdn.pixabay.com/photo/2012/03/01/01/42/connect-20333_960_720.jpg",
            "https://cdn.pixabay.com/photo/2016/12/09/11/33/smartphone-1894723_960_720.jpg"
    };

    String[] titlesSlider = new String []{
            "Books",
            "Telefonos",
            "Ventas",
            "Cosas",
    };

    //vistas con calses java
    RecyclerView recyclerViewDestacados;

    //adapters
    LibroAdapter libroAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //InView metodo donde enlazamos las vistas con las clases java
        inView();

    }
    private void inView() {


        //Enlace de vistas
        final ViewPager viewPagerSlider = findViewById(R.id.myViewPagerSlider);
        recyclerViewDestacados = findViewById(R.id.recycerViewDestacados);



       /**Creacion del Slider**/

       //Adaptador
        ViewPagerAdapter adapterSlider =
                new ViewPagerAdapter(this,urlImages,titlesSlider);



        //"Conexion" con el adaptador
        viewPagerSlider.setOffscreenPageLimit(1);
        viewPagerSlider.setAdapter(adapterSlider);


       /*Handler para hacer automatico el slider
       * donde cada 9000 milisegundos cambiara la pantalla*/
       handlerSlider.postDelayed(new Runnable() {
           @Override
           public void run() {
               //Avanzamos 1
               viewPagerSlider.setCurrentItem(viewPagerSlider.getCurrentItem()+1);
               handlerSlider.postDelayed(this,9000);
           }
       },9000);


        //se configura el adaptador de destacados

        confyAdapter();
        confyRecycler();
        addLibro();
    }

    private void addLibro() {

        String[] names = {
                "El caballero de...",
                "Portada para...",
                "The girl of INK ",
                "Fifty Shades of...",
                "The cat in the had"
        };
        String[] autores = {
                "Autor1",
                "Autor2",
                "Autor3",
                "Autor4",
                "Autor5",
        };
        String[] generos = {
                "Love",
                "Ficcion",
                "Miedo",
                "Ciencia",
                "Aventura"
        };
        String[] editoriales = {
                "Editorial1",
                "Editorial2",
                "Editorial3",
                "Editorial4",
                "Editorial5"
        };
        int [] paginas = {
                20,
                20,
                20,
                20,
                20
        };
        String [] sinpsisLibro = {
                "Sinopsis1",
                "Sinopsis2",
                "Sinopsis3",
                "Sinopsis4",
                "Sinopsis5"
        };
        float [] precioLibro = {
                20,
                20.5f,
                19.99f,
                32.4f,
                70.30f
        };
        int [] descuentoLibro = {
                20,
                20,
                20,
                20,
                20
        };
        int [] valoracion = {
                10,
                10,
                10,
                10,
                10
        };
        String [] urlPortada = {
                "https://cdn.gandhi.com.mx/media/catalog/product/i/m/image_1165_1_90091.jpg",
                "https://a.wattpad.com/cover/104041861-352-k31221.jpg",
                "https://www.socialunderground.co/wp-content/uploads/2017/04/portada-libro-disen%CC%83ada-por-Helen-Crawford-White.jpg",
                "https://i.emezeta.com/weblog/portadas-libros/fifty-shades-alice-wonderland.jpg",
                "https://img.culturacolectiva.com/content/2013/08/portada3-1.jpg"
        };
        boolean [] popular = {
                false,
                false,
                false,
                false,
                false
        };
        boolean [] nuevo = {
                false,
                true,
                false,
                false,
                false
        };

        for(int i =0; i<5; i++){
            Libro libro = new Libro(i+1,names[i],autores[i],generos[i],
                    editoriales[i],paginas[i],sinpsisLibro[i],precioLibro[i],
                    descuentoLibro[i],valoracion[i],urlPortada[i],popular[i],nuevo[i]);
            libroAdapter.addView(libro);
        }
    }

    private void confyAdapter() {
        libroAdapter = new LibroAdapter(new ArrayList<Libro>(),this);
    }

    private void confyRecycler(){
        recyclerViewDestacados.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        recyclerViewDestacados.setAdapter(libroAdapter);
    }

    @Override
    public void onClickBookListener(Libro libro) {

    }
}
