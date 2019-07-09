package api;

import dao.PedidoCompraDao;
import model.PedidoCompra;
import serializer.OrderSerializer;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ShowOrderServlet  extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer userId = Integer.parseInt( req.getParameter("userId"));

        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();
        List<PedidoCompra> pedidos = new PedidoCompraDao().getUserOrders(userId);
        String json = new OrderSerializer().toJsonString(pedidos);
        out.append(json);
        out.close();
    }
}


