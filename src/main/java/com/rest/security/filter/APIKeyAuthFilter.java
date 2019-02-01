package com.rest.security.filter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;

import javax.servlet.http.HttpServletRequest;

@PropertySource("classpath:application.properties")
public class APIKeyAuthFilter extends AbstractPreAuthenticatedProcessingFilter {

    @Value("${http.auth.apikey.header}")
    private String apiKeyHeader;

    public APIKeyAuthFilter(String apiKeyHeader) {
        this.apiKeyHeader = apiKeyHeader;
    }

    @Override
    protected Object getPreAuthenticatedPrincipal(HttpServletRequest httpServletRequest) {
        return httpServletRequest.getHeader(apiKeyHeader);
    }

    @Override
    protected Object getPreAuthenticatedCredentials(HttpServletRequest httpServletRequest) {
        return "N/A";
    }
}
