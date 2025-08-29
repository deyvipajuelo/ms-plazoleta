package com.pragma.powerup.domain.model;

public class Dish {
    private String nombrePlato;
    private Integer precio;
    private String descripcion;
    private String urlImagen;
    private String categoria;
    private boolean isActive;
    private Long restauranteId;

    public Dish(String nombrePlato, Integer precio, String descripcion, String urlImagen, String categoria, boolean isActive, Long restauranteId) {
        this.nombrePlato = nombrePlato;
        this.precio = precio;
        this.descripcion = descripcion;
        this.urlImagen = urlImagen;
        this.categoria = categoria;
        this.isActive = isActive;
        this.restauranteId = restauranteId;
    }

    public String getNombrePlato() {
        return nombrePlato;
    }

    public void setNombrePlato(String nombrePlato) {
        this.nombrePlato = nombrePlato;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Long getRestauranteId() {
        return restauranteId;
    }

    public void setRestauranteId(Long restaurantId) {
        this.restauranteId = restaurantId;
    }
}
