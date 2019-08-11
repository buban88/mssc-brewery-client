package org.springframeworkguru.msscbreweryclient.client;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframeworkguru.msscbreweryclient.model.CustomerDto;

import javax.swing.text.DefaultEditorKit;
import java.net.URI;
import java.util.UUID;

@Component
@ConfigurationProperties(value = "sfg.customer",ignoreUnknownFields = false)
public class CustomerClient {

    private final String  CUSTOMER_URI_ENDPOINT = "/api/v1/customer/";

    private String apiHost ;

    private RestTemplate restTemplate ;

    public CustomerClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }


    public CustomerDto getCustomerById(UUID uuid){

        return restTemplate.getForObject(apiHost+CUSTOMER_URI_ENDPOINT+uuid.toString(),CustomerDto.class);



    }

    public void setApiHost(String apiHost) {
        this.apiHost = apiHost;
    }

    public URI saveCustomer(CustomerDto customerDto){

        return restTemplate.postForLocation(apiHost+CUSTOMER_URI_ENDPOINT, customerDto);

    }

    public void deleteCustomer(UUID uuid){
        restTemplate.delete(apiHost+CUSTOMER_URI_ENDPOINT+uuid.randomUUID());
    }
}
