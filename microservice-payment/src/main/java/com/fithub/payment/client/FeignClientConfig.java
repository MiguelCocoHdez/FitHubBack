package com.fithub.payment.client;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.context.SecurityContextHolder;

import feign.RequestInterceptor;
import feign.RequestTemplate;

@Configuration
public class FeignClientConfig implements RequestInterceptor {	//Esta clase sirve para pasar el token en el header mediante feign client para acceder a datos de otros endpoints protegidos

	@Override
    public void apply(RequestTemplate template) {
        String token = SecurityContextHolder.getContext().getAuthentication().getCredentials().toString();
        template.header("Authorization", "Bearer " + token);
    }
}
