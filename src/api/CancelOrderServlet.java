package api;

import dao.PedidoCompraDao;
import dto.StatusDto;
import serializer.StatusSerializer;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CancelOrderServlet extends HttpServlet {

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();

        try {
            Integer orderId = Integer.parseInt(req.getParameter("orderId"));
            new PedidoCompraDao().cancelOrder(orderId);
            out.append(new StatusSerializer().toJsonString(new StatusDto("ok")));
        } catch (Exception e) {
            out.append(new StatusSerializer().toJsonString(new StatusDto("Invalid orderId")));
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }

        out.close();
    }
}
