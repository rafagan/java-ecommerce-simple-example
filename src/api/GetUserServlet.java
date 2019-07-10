package api;

import dto.StatusDto;
import dto.UserDto;
import model.Usuario;
import serializer.StatusSerializer;
import serializer.UserSerializer;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class GetUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();
        UserSerializer userSerializer = new UserSerializer();

        try {
            Usuario user = (Usuario) req.getAttribute("user");
            UserDto dto = userSerializer.toDto(user);
            String json = userSerializer.toJsonString(dto);
            out.append(json);
        } catch (Exception e) {
            out.append(new StatusSerializer().toJsonString(new StatusDto("Invalid user")));
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }

        out.close();
    }
}
