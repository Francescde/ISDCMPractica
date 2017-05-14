/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Video;

/**
 *
 * @author francescdepuigguixe
 */
class VideoModelResource {
    private int id;
    private String titulo;
    private String autor;
    private String fechaCreacion;
    private String duracion;
    private int reproducciones;
    private String descripcion;
    private String formato;
    private String url;

    public VideoModelResource(VideoModel model) {
        this.id = model.getId();
        this.titulo = model.getTitulo();
        this.autor = model.getAutor();
        this.fechaCreacion = model.getFechaCreacion().toString();
        this.duracion = model.getDuracion().toString();
        this.reproducciones = model.getReproducciones();
        this.descripcion = model.getDescripcion();
        this.formato = model.getFormato();
        this.url = model.getUrl();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
   
    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public int getReproducciones() {
        return reproducciones;
    }

    public void setReproducciones(int reproducciones) {
        this.reproducciones = reproducciones;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
