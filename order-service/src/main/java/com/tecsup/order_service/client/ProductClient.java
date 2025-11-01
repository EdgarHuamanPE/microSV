package com.tecsup.order_service.client;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
@Slf4j
public class ProductClient {

    private final RestTemplate restTemplate;

    @Value("${product.service.url}")
    private String productServiceUrl;

    public Product getProductById(Long idProduct) {
        String Url = productServiceUrl + "/api/products/" + idProduct;
        try {
            Product product = restTemplate.getForObject(Url, Product.class);

            log.info("Product retrived successfully from userdb:{}", product);
            return product;
        } catch (Exception e) {
            log.info("Error Calling  Product Service :{ }", e.getMessage());
            throw new RuntimeException("Error Calling  Product Service" + e.getMessage());
        }
    }
}
