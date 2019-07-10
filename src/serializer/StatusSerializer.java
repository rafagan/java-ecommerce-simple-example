package serializer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.StatusDto;

public class StatusSerializer {

    public String toJsonString(StatusDto dto) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        String json = gson.toJson(dto);
        return json;
    }
}
