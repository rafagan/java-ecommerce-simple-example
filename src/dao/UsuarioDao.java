package dao;

import utils.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioDao {
    public boolean updateCreditCard(Integer id, String numeroCartao, String codigoSeguranca, String dataValidade) {
        try {
            PreparedStatement stmt;
            Connection c = ConnectionFactory.factory();
            stmt = c.prepareStatement(
                    "Update usuario set numeroCartao = ? , codigoSeguranca = ? , dataValidade = ? where id = ?");
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

    public String getUserPassword(String login) {
        String query = "select senha from usuario as u where u.login = ?";

        String password = "";
        try {
            Connection c = ConnectionFactory.factory();
            PreparedStatement stmt = c.prepareStatement(query);
            stmt.setString(1, login);
            ResultSet res = stmt.executeQuery();

            // Só terá 1
            while(res.next()){
                password = res.getString("senha");
            }

            c.close();
        } catch(Exception e){
            e.printStackTrace();
        }
        return password;
    }
}
