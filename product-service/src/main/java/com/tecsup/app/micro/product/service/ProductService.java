package com.tecsup.app.micro.product.service;


import com.tecsup.app.micro.product.client.User;
import com.tecsup.app.micro.product.client.UserClient;
import com.tecsup.app.micro.product.dto.Product;
import com.tecsup.app.micro.product.entity.ProductEntity;
import com.tecsup.app.micro.product.mapper.ProductMapper;
import com.tecsup.app.micro.product.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper mapper;
    private final UserClient userClient;


    public Product getProductById(Long id){

        ProductEntity entity= productRepository.findById(id).orElse(null);
        // Get client by id
        log.info("User Id: {}",entity.getCreatedBy());

        User user = userClient.getUserById(entity.getCreatedBy());


        log.info("User Name: {}",user.getName());

        return mapper.toDomainWithUser(entity,user);
    }





}
