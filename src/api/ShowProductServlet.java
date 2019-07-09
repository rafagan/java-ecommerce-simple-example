package api;

import dao.ItemDao;
import dao.PedidoCompraDao;
import model.Item;
import model.PedidoCompra;
import serializer.ItemSerializer;
import serializer.OrderSerializer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ShowProductServlet  extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String descricao = req.getParameter("descricao");
        resp.setContentType("application/json");

        PrintWriter out = resp.getWriter();
        List<Item> items = new ItemDao().getMostSoldItems(descricao);
        String json = new ItemSerializer().toJsonString(items);
        out.append(json);
        out.close();
    }

}
