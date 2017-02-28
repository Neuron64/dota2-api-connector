package com.kingofneurons.esport.dota2.dto.game_items;


public class Item {

     private int id;
    private String name;
    private int cost;
    private int secret_shop;
    private int side_shop;
    private int recipe;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    public int getSecret_shop() {
        return secret_shop;
    }

    public int getSide_shop() {
        return side_shop;
    }

    public int getRecipe() {
        return recipe;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setSecret_shop(int secret_shop) {
        this.secret_shop = secret_shop;
    }

    public void setSide_shop(int side_shop) {
        this.side_shop = side_shop;
    }

    public void setRecipe(int recipe) {
        this.recipe = recipe;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", secret_shop=" + secret_shop +
                ", side_shop=" + side_shop +
                ", recipe=" + recipe +
                '}';
    }
}
