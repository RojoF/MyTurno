package com.example.mycolas;

class Posts {

    private int userId;
    private int id;
    private String title;
    private String body;


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

    //public String getTitle() {
    // return title;
    //}

    //public String getBody() {
    // return body;
    //}
}
