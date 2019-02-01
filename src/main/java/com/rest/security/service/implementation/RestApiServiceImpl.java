package com.rest.security.service.implementation;

import com.rest.security.domain.Quote;
import com.rest.security.service.RestApiService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@PropertySource("classpath:application.properties")
public class RestApiServiceImpl implements RestApiService {

    @Value("${randomUrl.path}")
    private String randomUrl;

    @Override
    public Quote randomClient() {
        return new RestTemplate().getForObject(randomUrl, Quote.class);
    }


}
