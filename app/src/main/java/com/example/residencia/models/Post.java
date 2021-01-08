package com.example.residencia.models;

public class Post {
    private String id;
    private String title;
    private String description;
    private String precio;
    private String horario;
    private String image1;
    private String image2;
    private String idUser;
    private String nivel;
    private long timestamp;

    public Post() {

    }

    public Post(String id, String title, String description, String precio, String horario, String image1, String image2, String idUser, String nivel,long timestamp) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.precio = precio;
        this.horario = horario;
        this.image1 = image1;
        this.image2 = image2;
        this.idUser = idUser;
        this.nivel = nivel;
        this.timestamp = timestamp;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }
}