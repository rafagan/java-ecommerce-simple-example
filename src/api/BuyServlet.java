package api;

import dto.ShoppingCartDto;
import dto.StatusDto;
import serializer.ShoppingCartSerializer;
import serializer.StatusOkSerializer;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;

public class BuyServlet  extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String body = req.getReader().lines().collect(Collectors.joining());
        List<ShoppingCartDto> dto  = new ShoppingCartSerializer().fromJsonString(body);

        //TODO: SALVAR TODOS OS PEDIDOS

        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();
        out.append(new StatusOkSerializer().toJsonString(new StatusDto()));
        out.close();
    }
}

