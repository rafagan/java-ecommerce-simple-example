package utils;

import dao.UsuarioDao;
import dto.StatusDto;
import serializer.StatusSerializer;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class SecurityFilter implements Filter {
    @Override
    public void doFilter(
            ServletRequest req,
            ServletResponse resp,
            FilterChain chain) throws IOException, ServletException
    {
        HttpServletRequest r = (HttpServletRequest) req;
        String[] freePaths = new String[]{"api/v1/login", "api/v1/products"};
        String url = r.getRequestURL().toString();

        for(String path: freePaths) {
            if(url.contains(path)) {
                chain.doFilter(req, resp);
                return;
            }
        }

        String token = r.getHeader("Authorization");
        if(token == null && !url.contains("api/")) {
            chain.doFilter(req, resp);
            return;
        }

        try {
            String[] metaData = token.split(":");
            if (metaData.length != 2 || !HashFactory.generateTokenHash(metaData[0]).equals(token)) {
                confInvalidToken(resp);
                return;
            }

            r.setAttribute("user", new UsuarioDao().getUser(metaData[0]));
            chain.doFilter(req, resp);
        } catch (Exception e) {
            confInvalidToken(resp);
        }
    }

    private void confInvalidToken(ServletResponse resp) throws IOException {
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();
        out.append(new StatusSerializer().toJsonString(new StatusDto("Invalid token")));
        ((HttpServletResponse) resp).setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        out.close();
    }
}
