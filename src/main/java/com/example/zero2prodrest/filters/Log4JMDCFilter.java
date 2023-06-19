package com.example.zero2prodrest.filters;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

@Component
public class Log4JMDCFilter extends OncePerRequestFilter {

    public static final String REQUEST_ID = "request-id";
    public static final String REQUEST_ID_LOG_TEMPLATE = "RID:%s";

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

            String requestId = Optional.ofNullable(request.getHeader(REQUEST_ID))
                    .orElse(UUID.randomUUID().toString());
            MDC.put(REQUEST_ID, String.format(REQUEST_ID_LOG_TEMPLATE, requestId));
            response.addHeader(REQUEST_ID, requestId);
            filterChain.doFilter(request, response);
            MDC.remove(REQUEST_ID);
    }
}
