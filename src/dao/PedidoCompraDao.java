package dao;

import model.PedidoCompra;
import utils.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PedidoCompraDao {
    public List<PedidoCompra> getUserOrders(Integer userId) {
        String query =
                "select * from pedidocompra as pc where pc.usuarioId = ? order by pc.data desc";

        List<PedidoCompra> compras = new ArrayList<>();

        try {

            Connection c = ConnectionFactory.factory();
            PreparedStatement stmt = c.prepareStatement(query);
            stmt.setInt(1,userId);
            ResultSet res = stmt.executeQuery();

            while(res.next()){
                PedidoCompra  pc = new PedidoCompra();
                pc.setData(res.getDate("data"));
                pc.setUsuarioId(res.getInt("usuarioId"));
                pc.setId(res.getInt(("id")));

                compras.add(pc);
            }

            c.close();
        } catch(Exception e){
            e.printStackTrace();
        }
        return compras;
    }


    public boolean cancelOrder(Integer orderId) {
        PreparedStatement stmt;
        try {
            Connection c = ConnectionFactory.factory();
            stmt = c.prepareStatement("Delete from pedidocompra where id = ?");
            stmt.setInt(1, orderId);
            int result = stmt.executeUpdate();
            return (result > 0);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public PedidoCompra createOrder(PedidoCompra order) {
        PreparedStatement stmt;
        try {
            Connection c = ConnectionFactory.factory();
            stmt = c.prepareStatement(
                    "Insert into pedidocompra (data, usuarioId) values (?, ?)",
                    Statement.RETURN_GENERATED_KEYS);
            stmt.setDate(1, order.getData());
            stmt.setInt(2, order.getUsuarioId());

            int result = stmt.executeUpdate();
            if(result <= 0) { return null; }

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    order.setId(generatedKeys.getInt(1));
                }
                else {
                     return null;
                }
            }

            return order;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
