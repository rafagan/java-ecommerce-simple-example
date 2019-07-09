package dao;

import model.Item;
import utils.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ItemDao {


    public List<Item> getMostSoldItems(String descricao) {
        if(descricao == null) descricao = "";
        String query =
                "select i.id, i.descricao, i.nome, i.detalhes, sum(ip.quantidade) as qtde " +
                "from item_ as i left join itempedido ip on i.id = ip.itemID " +
                (descricao.length() > 0 ? ("where i.descricao like ?") : "") +
                "group by i.id order by qtde desc";

        List<Item> items = new ArrayList<>();

        try {

            Connection c = ConnectionFactory.factory();
            PreparedStatement stmt = c.prepareStatement(query);
            if(descricao.length() > 0) stmt.setString(1, '%' + descricao + '%');
            ResultSet res = stmt.executeQuery();


            while(res.next()){
                Item i = new Item();
                i.setDescricao(res.getString("descricao"));
                i.setNome(res.getString("nome"));
                i.setDestalhes(res.getString("detalhes"));
                i.setId(res.getInt(("id")));

                items.add(i);
            }

            c.close();
        } catch(Exception e){
            e.printStackTrace();
        }
        return items;
    }

}
