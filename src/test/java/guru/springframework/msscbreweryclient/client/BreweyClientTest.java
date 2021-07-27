package guru.springframework.msscbreweryclient.client;

import guru.springframework.msscbreweryclient.model.BeerDto;
import guru.springframework.msscbreweryclient.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class BreweyClientTest {

    @Autowired
    BreweyClient client;

    @Test
    void getBeerById() {
        BeerDto dto=client.getBeerById(UUID.randomUUID());
        assertNotNull(dto);
    }

    @Test
    void saveNewBeer()
    {
        //given
        BeerDto beerDto= BeerDto.builder().beerName("New Beer").build();
        URI uri=client.saveBeerNew(beerDto);
        assertNotNull(uri);
        System.out.println(uri.toString());

    }

    @Test
    void updateNewBeer()
    {
        //given
        BeerDto beerDto= BeerDto.builder().beerName("New Beer").build();
        client.updateBeer(UUID.randomUUID(),beerDto);
    }

    @Test
    void deleteBeer() {
        client.deleteBeer(UUID.randomUUID());
    }

    @Test
    void getCustomerById() {
        CustomerDto dto=client.getCustomerById(UUID.randomUUID());
        assertNotNull(dto);
    }

    @Test
    void saveNewCustomer()
    {
        //given
        CustomerDto customerDto= CustomerDto.builder().customerName("New Customer").build();
        URI uri=client.saveCustomerNew(customerDto);
        assertNotNull(uri);
        System.out.println(uri.toString());

    }

    @Test
    void updateNewCustomer()
    {
        //given
        CustomerDto customerDto= CustomerDto.builder().customerName("New Customer").build();
        client.updateCustomer(UUID.randomUUID(),customerDto);
    }

    @Test
    void deleteCustomer() {
        client.deleteCustomer(UUID.randomUUID());
    }
}