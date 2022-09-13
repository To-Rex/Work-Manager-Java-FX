package com.yrvoration.workmanagerjava;

public class Users{
    private int id;
    private String ism;
    private String familya;

    public Users(int id, String ism, String familya) {
        this.id = id;
        this.ism = ism;
        this.familya = familya;
    }
    public void setId(int id) {
        this.id = id;
    }

    public void setIsm(String ism) {
        this.ism = ism;
    }

    public void setFamilya(String familya) {
        this.familya = familya;
    }

    public int getId() {
        return id;
    }

    public String getIsm() {
        return ism;
    }

    public String getFamilya() {
        return familya;
    }


}
