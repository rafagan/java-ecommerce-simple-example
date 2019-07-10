package dao;

import model.ItemPedido;
import model.PedidoCompra;
import utils.ConnectionFactory;

import java.sql.*;

public class ItemPedidoDao {
    public ItemPedido createOrderItem(ItemPedido orderItem) {
        PreparedStatement stmt;
        try {
            Connection c = ConnectionFactory.factory();
            stmt = c.prepareStatement(
                    "Insert into itempedido (quantidade, pedidoCompraId, itemID) values (?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, orderItem.getQuantidade());
            stmt.setInt(2, orderItem.getPedidoCompraId());
            stmt.setInt(3, orderItem.getItemId());

            int result = stmt.executeUpdate();
            if(result <= 0) { return null; }

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    orderItem.setId(generatedKeys.getInt(1));
                }
                else {
                    return null;
                }
            }

            return orderItem;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
