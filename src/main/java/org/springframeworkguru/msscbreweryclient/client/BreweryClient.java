package org.springframeworkguru.msscbreweryclient.client;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframeworkguru.msscbreweryclient.model.BeerDto;

import java.net.URI;
import java.util.UUID;

@Component
@ConfigurationProperties(value = "sfg.brewery",ignoreUnknownFields = false)
public class BreweryClient {

    private String apiHost;
    private final String BEER_PATH_V1 = "/api/v1/beer/" ;

    private final RestTemplate restTemplate ;

    public BreweryClient(RestTemplateBuilder restTemplateBuilder){
        this.restTemplate = restTemplateBuilder.build();
    }

    public void setApiHost(String apiHost){
        this.apiHost = apiHost;
    }

    public BeerDto getBeerById(UUID uuid){

        return restTemplate.getForObject(apiHost+BEER_PATH_V1+uuid.toString(), BeerDto.class);

    }

    public URI saveBeerDto(BeerDto beerDto){
        return restTemplate.postForLocation(apiHost+BEER_PATH_V1 , beerDto);
    }

    public void updateBeer(UUID uuid, BeerDto beerDto){
        restTemplate.put(apiHost+BEER_PATH_V1+uuid.toString(),beerDto);
    }

    public void deleteBeer(UUID uuid){
        restTemplate.delete(apiHost+BEER_PATH_V1+uuid.toString());
    }
}
