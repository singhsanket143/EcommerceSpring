package org.example.ecommercespring.configuration;

import io.github.cdimascio.dotenv.Dotenv;
import org.example.ecommercespring.gateway.api.FakeStoreCategoryApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Configuration
public class RetrofitConfig {

    @Value("${fake-store.apiurl}")
    private String fakestoreapiUrl;

    @Bean
    public Retrofit retrofit() {
        //Dotenv dotenv = Dotenv.load();
        //String baseUrl = dotenv.get("FAKESTOREAPIURL");
        return new Retrofit.Builder()
                .baseUrl(fakestoreapiUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Bean
    public FakeStoreCategoryApi fakeStoreCategoryApi(Retrofit retrofit) {
        return retrofit.create(FakeStoreCategoryApi.class);
    }

}
