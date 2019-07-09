package dao;

import utils.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UsuarioDao {
    public static void main(String[] args) {
        new UsuarioDao().updateCreditCard(1,"4","5","5");

    }

    public boolean updateCreditCard(Integer id, String numeroCartao, String codigoSeguranca, String dataValidade) {
        try {
            PreparedStatement stmt;
            Connection c = ConnectionFactory.factory();
            stmt = c.prepareStatement(
                    "Update usuario set numeroCartao = ? , codigoSeguranca = ? , dataValidade = ? where id =?");
            stmt.setString(1, numeroCartao);
            stmt.setString(2, dataValidade);
            stmt.setString(3, codigoSeguranca);
            stmt.setInt(4, id);

            int retorno = stmt.executeUpdate();
            return (retorno > 0);
        } catch (Exception e) {
            return false;
        }
    }
}
