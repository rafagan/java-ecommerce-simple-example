package dao;

import model.Item;
import model.ItemPedido;
import model.PedidoCompra;
import utils.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PedidoCompraDao {
    public static void main(String[] args) {
        new PedidoCompraDao().cancelOrder(1);
    }


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
            int retorno = stmt.executeUpdate();
            return (retorno > 0);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
