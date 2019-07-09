package serializer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import dto.ShoppingCartDto;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCartSerializer {

    public String toJsonString(List<ShoppingCartDto> items){
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        String json = gson.toJson(items);
        return json;
    }

    public List<ShoppingCartDto> fromJsonString(String json) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();

        Type listType = new TypeToken<ArrayList<ShoppingCartDto>>(){}.getType();
        List<ShoppingCartDto> dto = gson.fromJson(json, listType);
        return dto;
    }
}
