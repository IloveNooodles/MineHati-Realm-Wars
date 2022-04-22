package com.aetherwars.models.carddata;

import com.aetherwars.models.activecard.ActiveCard;

public abstract class CardData {
    protected String name;
    protected String description;
    protected int manaCost;
    protected String image;

    public CardData() {
        this.name = "";
        this.description = "An Empty Card";
        this.manaCost = 0;
        this.image = "";
    }

    public CardData(String name, String description, int manaCost, String image) {
        this.name = name;
        this.description = description;
        this.manaCost = manaCost;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getManaCost() {
        return manaCost;
    }

    public String getImage() {
        return image;
    }

}
