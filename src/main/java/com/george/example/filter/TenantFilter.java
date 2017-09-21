package com.george.example.filter;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by george on 9/11/17.
 */
@Component
@WebFilter("/*")

public class TenantFilter  extends OncePerRequestFilter implements Filter {
    public static final ThreadLocal<String> threadLocal = new ThreadLocal<String>();


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            threadLocal.set("");
            String tenant = request.getHeader("X-Tenant");
            if ( tenant !=null) {
                threadLocal.set(tenant );
            }
            System.out.println(threadLocal.get());
            filterChain.doFilter(request,response);
        } finally {
            threadLocal.remove();

        }
    }
}
