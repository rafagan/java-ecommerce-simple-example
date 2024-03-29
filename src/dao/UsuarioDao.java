package dao;

import model.Usuario;
import utils.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioDao {
    public boolean updateCreditCard(Integer id, String numeroCartao, Integer codigoSeguranca, String dataValidade) {
        try {
            PreparedStatement stmt;
            Connection c = ConnectionFactory.factory();
            stmt = c.prepareStatement(
                    "Update usuario set numeroCartao = ? , codigoSeguranca = ? , dataValidade = ? where id = ?");
            stmt.setString(1, numeroCartao);
            stmt.setInt(2, codigoSeguranca);
            stmt.setString(3, dataValidade);
            stmt.setInt(4, id);

            int result = stmt.executeUpdate();
            return (result > 0);
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
        } catch(Exception e) {
            e.printStackTrace();
        }
        return password;
    }

    public Usuario getUser(String login) {
        String query = "select * from usuario as u where u.login = ?";

        Usuario user = new Usuario();
        try {
            Connection c = ConnectionFactory.factory();
            PreparedStatement stmt = c.prepareStatement(query);
            stmt.setString(1, login);
            ResultSet res = stmt.executeQuery();

            // Só terá 1
            while(res.next()) {
                user.setSenha(res.getString("senha"));
                user.setCodigoSeguranca(res.getInt("codigoSeguranca"));
                user.setDataValidade(res.getString("dataValidade"));
                user.setId(res.getInt("id"));
                user.setNumeroCartao(res.getString("numeroCartao"));
                user.setLogin(res.getString("login"));
            }

            c.close();
        } catch(Exception e){
            e.printStackTrace();
        }
        return user;
    }
}
