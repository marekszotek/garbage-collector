package com.codecool.garbagecollector.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Status {

    public Status() {
        stock = new ArrayList<>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @OneToMany(mappedBy = "status")
    private transient List<Garbage> stock;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Garbage> getStock() {
        return stock;
    }

    public void setStock(List<Garbage> stock) {
        this.stock = stock;
    }

    public void addGarbage(Garbage garbage) {
        garbage.setStatus(this);
        stock.add(garbage);
    }
}