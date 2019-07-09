package serializer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.Item;
import model.PedidoCompra;

import java.util.List;

public class ItemSerializer {

    public String toJsonString(List<Item> items){
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        String json = gson.toJson(items);
        return json;
    }


}


