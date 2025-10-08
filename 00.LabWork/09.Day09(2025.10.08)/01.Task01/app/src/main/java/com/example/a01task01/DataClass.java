package com.example.a01task01;

public class DataClass {
    private String name;

    private int imgID;

    private  int buttonID;

    public DataClass(String name, int imgID, int buttonID) {
        this.name = name;
        this.imgID = imgID;
        this.buttonID = buttonID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImgID() {
        return imgID;
    }

    public void setImgID(int imgID) {
        this.imgID = imgID;
    }

    public int getButtonID() {
        return buttonID;
    }

    public void setButtonID(int buttonID) {
        this.buttonID = buttonID;
    }
}
