package org.springframeworkguru.msscbreweryclient.client;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframeworkguru.msscbreweryclient.model.CustomerDto;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerClientTest {

    @Autowired
    CustomerClient customerClient ;

    @Test
    void getCustomerById() {

        CustomerDto customerDto = customerClient.getCustomerById(UUID.randomUUID());

        assertNotNull(customerDto);

    }

    @Test
    void saveCustomer(){

        CustomerDto customerDto = CustomerDto.builder().name("Sohini").build();
        customerClient.saveCustomer(customerDto);
    }


    @Test
    void deleteCustomer(){

        customerClient.deleteCustomer(UUID.randomUUID());
    }
}