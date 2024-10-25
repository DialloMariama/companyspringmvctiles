package com.groupeisi.companyspringmvctiles.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/*")
public class PrivateFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession();
        // on récupère le nom de la session
        String username = (String) session.getAttribute("username");
        // on récupère le chemin demandé par l’utilisateur
        String chemin = req.getServletPath();
        // on récupère la méthode HTTP utilis´ee (GET ou POST)
        String method = req.getMethod();
        if (username != null || chemin.equals("/") || chemin.equals("/login") || chemin.equals("/sigup")
                || chemin.equals("/client")
                || chemin.equals("/logout") || chemin.equals("/index.jsp")
                || chemin.equals("/login") && method.equalsIgnoreCase("POST")
                || chemin.equals("/singup") && method.equalsIgnoreCase("POST") || chemin.startsWith("/public/") || chemin.startsWith("/resources/"))
            chain.doFilter(request, response);
        else
            res.sendRedirect(req.getContextPath());
    }

    @Override
    public void destroy() {

    }

}
