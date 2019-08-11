package org.springframeworkguru.msscbreweryclient.client;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframeworkguru.msscbreweryclient.model.BeerDto;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BreweryClientTest {

    @Autowired
    BreweryClient breweryClient;

    @Test
    void getBeerById() {
        BeerDto beerDto = breweryClient.getBeerById(UUID.randomUUID());

        assertNotNull(beerDto);

    }

    @Test
    void saveBeerDto(){

        BeerDto beerDto = BeerDto.builder().beerName("New Beer").id(UUID.randomUUID()).build();

        URI uri = breweryClient.saveBeerDto(beerDto);

        assertNotNull(uri);
        System.out.println(uri);

    }


    @Test
    void updateBeer(){
        breweryClient.updateBeer(UUID.randomUUID(),BeerDto.builder().beerName("Neew Beer").build());
    }


    @Test
    void deleteBeer(){
        breweryClient.deleteBeer(UUID.randomUUID());
    }

}