package com.mentoring.mrfridge.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.util.List;

//@Entity
//@Table(name="products")
public class Product {
    //@Id
    private Long id;
    @JsonProperty("qty")
    private int quantity;
    private String name;
    private List<PackagingDetails> packagingDetails;

    public List<PackagingDetails> getPackagingDetails() {
        return packagingDetails;
    }

    public void setPackagingDetails(List<PackagingDetails> packagingDetails) {
        this.packagingDetails = packagingDetails;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate expiryDate;

    public Product() {

    }

    public Product(int quantity, String name, LocalDate expiryDate) {
        this.quantity = quantity;
        this.name = name;
        this.expiryDate = expiryDate;
    }

    public Product(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

}