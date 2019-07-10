package api;

import dao.UsuarioDao;
import dto.CreditCardDto;
import dto.StatusDto;
import serializer.CreditCardSerializer;
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
        CreditCardDto dto = new CreditCardSerializer().fromJsonString(body);

        new UsuarioDao().updateCreditCard(
                dto.getUserId(),
                dto.getNumeroCartao(),
                dto.getCodigoSeguranca(),
                dto.getDataValidade());

        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();
        out.append(new StatusSerializer().toJsonString(new StatusDto("ok")));
        out.close();
    }
}
