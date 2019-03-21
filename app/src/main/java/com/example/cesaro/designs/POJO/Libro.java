package com.example.cesaro.designs.POJO;


/* el objeto productos representa  all lo que se puede
* ver en pantalla dentro de los recyclerView*/

import java.util.Objects;

public class Libro {
    private long id;
    private String tituloLibro;
    private String Autor;
    private String genero;
    private String editorial;
    private int paginas;
    private String sinpsisLibro;
    private float precioLibro;
    private int descuentoLibro;
    private int valoracion;
    private String urlPortada;
    private boolean popular;
    private boolean nuevo;


    public Libro(long id, String tituloLibro, String autor, String genero, String editorial,
                 int paginas, String sinpsisLibro, float precioLibro, int descuentoLibro,
                 int valoracion, String urlPortada, boolean popular, boolean nuevo) {
        this.id = id;
        this.tituloLibro = tituloLibro;
        Autor = autor;
        this.genero = genero;
        this.editorial = editorial;
        this.paginas = paginas;
        this.sinpsisLibro = sinpsisLibro;
        this.precioLibro = precioLibro;
        this.descuentoLibro = descuentoLibro;
        this.valoracion = valoracion;
        this.urlPortada = urlPortada;
        this.popular = popular;
        this.nuevo = nuevo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTituloLibro() {
        return tituloLibro;
    }

    public void setTituloLibro(String tituloLibro) {
        this.tituloLibro = tituloLibro;
    }

    public String getAutor() {
        return Autor;
    }

    public void setAutor(String autor) {
        Autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public String getSinpsisLibro() {
        return sinpsisLibro;
    }

    public void setSinpsisLibro(String sinpsisLibro) {
        this.sinpsisLibro = sinpsisLibro;
    }

    public float getPrecioLibro() {
        return precioLibro;
    }

    public void setPrecioLibro(float precioLibro) {
        this.precioLibro = precioLibro;
    }

    public int getDescuentoLibro() {
        return descuentoLibro;
    }

    public void setDescuentoLibro(int descuentoLibro) {
        this.descuentoLibro = descuentoLibro;
    }

    public int getValoracion() {
        return valoracion;
    }

    public void setValoracion(int valoracion) {
        this.valoracion = valoracion;
    }

    public String getUrlPortada() {
        return urlPortada;
    }

    public void setUrlPortada(String urlPortada) {
        this.urlPortada = urlPortada;
    }

    public boolean isPopular() {
        return popular;
    }

    public void setPopular(boolean popular) {
        this.popular = popular;
    }

    public boolean isNuevo() {
        return nuevo;
    }

    public void setNuevo(boolean nuevo) {
        this.nuevo = nuevo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Libro libro = (Libro) o;
        return id == libro.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
