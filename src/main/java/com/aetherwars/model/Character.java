package com.aetherwars.model;

public class Character {
  private String name;
  private String description;
  private Type type;

  public Character() {
    this.name = "";
    this.description = "";
    this.type = Type.OVERWORLD;
  }

  public Character(String name, String description, Type element) {
    this.name = name;
    this.description = description;
    this.type = element;
  }

  @Override
  public String toString() {
    return "Name: " + this.name + "\nDescription: " + this.description + "\nType: " + this.type;
  }
}
