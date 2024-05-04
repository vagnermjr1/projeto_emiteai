package com.emiteai.cadastro.config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class RequestInterceptor implements HandlerInterceptor {



    private static final Logger LOG = LoggerFactory.getLogger(RequestInterceptor.class);

    @Override
    public boolean preHandle(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response, Object handler) throws Exception {
        LOG.info("Requisição recebida - URL: {}, Método: {}, Endereço IP: {}",
                request.getRequestURL(), request.getMethod(), request.getRemoteAddr());
        return true;
    }


    @Override
    public void afterCompletion(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response, Object handler, Exception ex) throws Exception {

        if (ex != null) {
            LOG.info("Erro ao processar requisição - URL: {}, Método: {}, Endereço IP: {}, Erro: {}",
                    request.getRequestURL(), request.getMethod(), request.getRemoteAddr(), ex.getMessage());
        }

    }



}

