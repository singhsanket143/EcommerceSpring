package org.example.ecommercespring.configuration;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ClientConfig {

    @Value("${HTTP_METHOD}")
    String ClientMethod;

    @Getter
    @Value("${BASE_URL}")
    String BaseUrl;

    public Boolean getclientMethod(){
        return ClientMethod.equals("OkHttp");
    }

}
