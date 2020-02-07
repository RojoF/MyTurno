package com.example.mycolas;

class Posts {

    //Declaramos los setters and getters  de las variables que queremos cojer del webService

    private int userId;
    private int id;

    // Anotacion @SupressWarnigs para evitar el warning private-package
    @SuppressWarnings("WeakerAccess")
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }

    @SuppressWarnings("WeakerAccess")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
