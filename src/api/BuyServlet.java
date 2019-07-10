package api;

import dao.ItemPedidoDao;
import dao.PedidoCompraDao;
import dto.ShoppingCartDto;
import dto.StatusDto;
import model.ItemPedido;
import model.PedidoCompra;
import model.Usuario;
import serializer.ShoppingCartSerializer;
import serializer.StatusSerializer;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

public class BuyServlet  extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Usuario user = (Usuario) req.getAttribute("user");
        String body = req.getReader().lines().collect(Collectors.joining());
        List<ShoppingCartDto> dtos  = new ShoppingCartSerializer().fromJsonString(body);

        PedidoCompra order = new PedidoCompra();
        order.setData(new Date(new java.util.Date().getTime()));
        order.setUsuarioId(user.getId());
        order = new PedidoCompraDao().createOrder(order);

        for(ShoppingCartDto dto: dtos) {
            ItemPedido orderItem = new ItemPedido();
            orderItem.setItemId(dto.getItemId());
            orderItem.setQuantidade(dto.getAmount());
            orderItem.setPedidoCompraId(order.getId());
            new ItemPedidoDao().createOrderItem(orderItem);
        }

        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();
        out.append(new StatusSerializer().toJsonString(new StatusDto("ok")));
        out.close();
    }
}

