package serializer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.PedidoCompra;

import java.util.List;

public class OrderSerializer {
    public String toJsonString(List<PedidoCompra> items){
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        String json = gson.toJson(items);
        return json;
    }
}
