package com.tecsup.app.micro.product.client;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
@Slf4j
public class UserClient {

    private final RestTemplate restTemplate;

    @Value("${user.service.url}")
    private String userServiceUrl;

    public User getUserById(Long createdBy){

        String Url=userServiceUrl+"/api/users/"+createdBy;

        try{
            User user =restTemplate.getForObject(Url,User.class);
            log.info("User retrived successfully from userdb:{}",user);
            return user;
        }catch (Exception e){
            log.info("Error Calling  User Service :{ }", e.getMessage());
            throw new RuntimeException("Error Calling  User Service"+e.getMessage());
        }




//        return  User.builder()
//                .name("Jhon Deep")
//                .build();
    }

}
