package api;

import dao.UsuarioDao;
import dto.LoginDto;
import dto.StatusDto;
import serializer.LoginSerializer;
import serializer.StatusSerializer;
import utils.HashFactory;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Collectors;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();

        String body = req.getReader().lines().collect(Collectors.joining());
        LoginDto dto = new LoginSerializer().fromJsonString(body);

        String hash = HashFactory.generatePasswordHash(dto.getPassword());
        if(!hash.equals(new UsuarioDao().getUserPassword(dto.getLogin()))) {
            out.append(new StatusSerializer().toJsonString(new StatusDto("Invalid login or password")));
            resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        } else {
            String token = HashFactory.generateTokenHash(dto.getLogin());
            out.append(new StatusSerializer().toJsonString(new StatusDto(token)));
        }

        out.close();
    }
}
