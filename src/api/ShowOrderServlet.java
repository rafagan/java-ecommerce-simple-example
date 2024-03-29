package api;

import dao.PedidoCompraDao;
import dto.StatusDto;
import model.PedidoCompra;
import model.Usuario;
import serializer.OrderSerializer;
import serializer.StatusSerializer;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ShowOrderServlet  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();

        try {
            Usuario user = (Usuario) req.getAttribute("user");
            List<PedidoCompra> orders = new PedidoCompraDao().getUserOrders(user.getId());
            String json = new OrderSerializer().toJsonString(orders);
            out.append(json);
        } catch (Exception e) {
            out.append(new StatusSerializer().toJsonString(new StatusDto("Invalid user")));
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }

        out.close();
    }
}


