package guru.springframework.msscbreweryclient.client;

import guru.springframework.msscbreweryclient.model.BeerDto;
import guru.springframework.msscbreweryclient.model.CustomerDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@Component
@ConfigurationProperties(value = "sfg.brewery",ignoreUnknownFields = false)
public class BreweyClient {
    public final String BEER_PATH_V1 = "/api/v1/beer/";
    public final String CUSTOMER_PATH_V1 = "/api/v1/customer/";
    private String apiHost;
    private final RestTemplate restTemplate;

    public BreweyClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public BeerDto getBeerById(UUID uuid)
    {
        return restTemplate.getForObject(apiHost+BEER_PATH_V1+uuid.toString(),BeerDto.class);
    }
    public URI saveBeerNew(BeerDto beerDto)
    {
        return restTemplate.postForLocation(apiHost+BEER_PATH_V1,beerDto);
    }
    public void updateBeer(UUID id,BeerDto beerDto)
    {
        restTemplate.put(apiHost+BEER_PATH_V1+id.toString(),beerDto);
    }
    public void deleteBeer(UUID id)
    {
        restTemplate.delete(apiHost+BEER_PATH_V1+id);
    }
    public CustomerDto getCustomerById(UUID uuid)
    {
        return restTemplate.getForObject(apiHost+CUSTOMER_PATH_V1+uuid.toString(),CustomerDto.class);
    }
    public URI saveCustomerNew(CustomerDto customerDto)
    {
        return restTemplate.postForLocation(apiHost+CUSTOMER_PATH_V1,customerDto);
    }
    public void updateCustomer(UUID id,CustomerDto customerDto)
    {
        restTemplate.put(apiHost+CUSTOMER_PATH_V1+id.toString(),customerDto);
    }
    public void deleteCustomer(UUID id)
    {
        restTemplate.delete(apiHost+CUSTOMER_PATH_V1+id);
    }
    public void setApiHost(String apiHost) {
        this.apiHost = apiHost;
    }
}
