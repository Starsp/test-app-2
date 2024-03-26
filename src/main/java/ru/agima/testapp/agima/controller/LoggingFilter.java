package ru.agima.testapp.agima.controller;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;

@Slf4j
@Component
@WebFilter(urlPatterns = "/*")
public class LoggingFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        ContentCachingRequestWrapper contentCachingRequestWrapper = new ContentCachingRequestWrapper(request);
        StringBuilder logData = new StringBuilder("---[HTTP request - ");
        logData.append(IOUtils.toString(contentCachingRequestWrapper.getInputStream(), StandardCharsets.UTF_8));
        Iterator<String> iterator = request.getHeaderNames().asIterator();
        while (iterator.hasNext()) {
            String headerName = iterator.next();
            logData.append(headerName).append(":").append(request.getHeader(headerName)).append("\n");
        }
        logData.append("]---").append("\n");
        int status = response.getStatus();
        logData.append("\n");
        logData.append("---[HTTP response - ")
                .append(status).append("-")
                .append(HttpStatus.valueOf(status).getReasonPhrase()).append("-")
                .append(request.getMethod()).append("-")
                .append(request.getRequestURL()).append("\n");
        response.getHeaderNames()
                .forEach(headerName -> logData.append(headerName).append(":").append(response.getHeader(headerName)));
        logData.append("]---").append("\n");
        log.info(logData.toString());
        filterChain.doFilter(contentCachingRequestWrapper, response);
    }
}
