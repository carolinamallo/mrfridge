package com.mentoring.mrfridge.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.time.LocalDate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductsControllerIT {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void shouldAddANewProduct() {
        // crear un objeto de product
        Product product = new Product(5, "Tomates", LocalDate.of(2022,5,15));
        // llamar al endpoint
        InsertProductRequest request = new InsertProductRequest(product);
        restTemplate.postForObject("/products", request, InsertProductResponse.class);
        // verificar que se ha insertado
    }

    // GET /products
    // POST /products -> body
    // Serialización: Objeto Java -> JSON // Jackson / Gson / Jersey
    // Deserializacion: JSON -> Objeto Java //
    // PUT /products/:id -> body
    // DELETE /products/:id
    // GET /products?type=vegetariano

    //        E2E
    //        BDD     -> lenguaje natural
    //    Integration -> /products -> returns 200 -> JSON -> TDD
    //       Unit     -> productsController.getAll -> TDD

}

class Product {

    private int quantity;
    private String name;
    private LocalDate expiryDate;

    public Product(int quantity, String name, LocalDate expiryDate) {
        this.quantity = quantity;
        this.name = name;
        this.expiryDate = expiryDate;
    }
}

class InsertProductRequest {

    private Product product;

    public InsertProductRequest(Product product) {
        this.product = product;
    }
}

class InsertProductResponse {

}