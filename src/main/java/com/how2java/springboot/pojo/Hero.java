package com.how2java.springboot.pojo;

public class Hero  {
 

    private int id;

    private String name;
    private float hp;
     
    public float getHp() {
        return hp;
    }
    public void setHp(float hp) {
        this.hp = hp;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "Hero [id=" + id + ", name=" + name + ", hp=" + hp + "]";
    }
 
}