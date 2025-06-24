package org.example.ecommercespring.configuration;

import io.github.cdimascio.dotenv.Dotenv;
import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Configuration
public class OkHttpConfig {
    @Bean
    public OkHttpClient okHttpClient() {
        return new OkHttpClient();
    }
}
