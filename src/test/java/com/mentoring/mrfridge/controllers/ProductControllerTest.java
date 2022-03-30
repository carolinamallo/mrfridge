package com.mentoring.mrfridge.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JSR310Module;
import com.mentoring.mrfridge.model.PackagingDetails;
import com.mentoring.mrfridge.model.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.LIST;

public class ProductControllerTest {

    @Test
    void serializationTest() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JSR310Module());
//        Product product = new Product(1, "pera", LocalDate.);
        //Deserializar
        Product product = mapper.readValue("{ \"qty\" : 1, \"name\" : \"pera\", \"expiryDate\": \"22/02/2022\" }", Product.class);
        assertThat(product.getQuantity()).isEqualTo(1);
        assertThat(product.getName()).isEqualTo("pera");
        assertThat(product.getExpiryDate()).isEqualTo(LocalDate.of(2022, 2, 22));

        //Serializar
        Product productoParaGatos = new Product("comida de gato");
        productoParaGatos.setPackagingDetails(Collections.singletonList(new PackagingDetails(2,3,7)));
        String comida_de_gato = mapper.writeValueAsString(productoParaGatos);

        Person anyThing = mapper.readValue("{ \"id\" : 1, \"lastName\" : \"Mallo\", \"address\": {\"mainStreet\": \"Serrano\", " +
                "\"apartments\": [{\"number\":1, \"door\": \"D\"}]}}", Person.class);

        assertThat(anyThing.getId()).isEqualTo(1);
    }
}

@Getter
@AllArgsConstructor
class Person {
    Long id;
    String lastName;
    Address address;
    public Person() {
    }
}

@Getter
@AllArgsConstructor
class Address {
    String mainStreet;
    List<Apartments> apartments;
    public Address() {
    }
}

@Getter
@AllArgsConstructor
class Apartments {
    Integer number;
    String door;
    public Apartments() {
    }
}
