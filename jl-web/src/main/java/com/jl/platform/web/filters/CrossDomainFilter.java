package com.jl.platform.web.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CrossDomainFilter implements Filter {
    public static String ACAO = "Access-Control-Allow-Origin";
    public static String ACAH = "Access-Control-Allow-Headers";
    public static String ACAM = "Access-Control-Allow-Methods";
    public static String ACMG = "Access-Control-Max-Age";
    public static String CC = "Cache-Control";
    public static String ACAC = "Access-Control-Allow-Credentials";

    @Override
    public void destroy() {
        // TODO Auto-generated method stub

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) req;
        HttpServletResponse httpResponse = (HttpServletResponse) resp;
        setCros(httpRequest, httpResponse);
        if (httpRequest.getMethod().equalsIgnoreCase("OPTION")) {
            return;
        }

        chain.doFilter(req, resp);

    }

    private void setCros(HttpServletRequest httpRequest, HttpServletResponse httpResponse) {
        httpResponse.setHeader(ACAO, httpRequest.getHeader("Origin"));
        httpResponse.setHeader(ACAM, "POST, GET, DELETE, UPDATE");
        httpResponse.setHeader(ACAH, "x-requested-with,content-type");
        httpResponse.setHeader(ACMG, "0");
        httpResponse.setHeader(CC, "no-cache");
        httpResponse.setHeader(ACAC, "true");
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
        // TODO Auto-generated method stub

    }

}
