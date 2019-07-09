package serializer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.CreditCardDto;

public class CreditCardSerializer {

    public String toJsonString(CreditCardDto item){
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        String json = gson.toJson(item);
        return json;
    }

    public CreditCardDto fromJsonString(String json) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        CreditCardDto dto = gson.fromJson(json, CreditCardDto.class);
        return dto;
    }

}
