package api;

import dao.UsuarioDao;
import dto.CreditCardDto;
import dto.StatusDto;
import model.Usuario;
import serializer.UserSerializer;
import serializer.StatusSerializer;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Collectors;

public class UpdateCreditCardServlet  extends HttpServlet {

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String body = req.getReader().lines().collect(Collectors.joining());
        CreditCardDto dto = new UserSerializer().fromJsonString(body);

        Usuario user = (Usuario) req.getAttribute("user");
        boolean success = new UsuarioDao().updateCreditCard(
                user.getId(),
                dto.getNumeroCartao(),
                dto.getCodigoSeguranca(),
                dto.getDataValidade());

        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();
        if(success) {
            out.append(new StatusSerializer().toJsonString(new StatusDto("ok")));
        } else {
            out.append(new StatusSerializer().toJsonString(new StatusDto("Valores inválidos")));
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
        out.close();
    }
}
