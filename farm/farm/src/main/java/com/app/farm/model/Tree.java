package com.app.farm.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;


@Entity
@Table(name="tree")
public class Tree {


    public Tree(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Tree() {

    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Getter
    @Setter
    @Id
    private String id;

    public String getName() {
        return name;
    }

    @Setter
    private String name;

    public String getYield() {
        return yield;
    }

    public void setYield(String yield) {
        this.yield = yield;
    }

    private String yield;

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    private int area;

}
