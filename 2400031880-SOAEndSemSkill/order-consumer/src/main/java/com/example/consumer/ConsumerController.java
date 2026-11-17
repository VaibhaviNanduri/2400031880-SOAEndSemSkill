package com.example.consumer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClient;

@RestController
@RequestMapping("/orders")
public class ConsumerController {

    private final RestClient restClient;

    public ConsumerController(@Value("${provider.base-url}") String providerBaseUrl) {
        this.restClient = RestClient.builder()
                .baseUrl(providerBaseUrl)
                .build();
    }

    @GetMapping("/product/{id}")
    public Product getProductForOrder(@PathVariable Long id) {
        return restClient.get()
                .uri("/products/{id}", id)
                .retrieve()
                .body(Product.class);
    }
}
