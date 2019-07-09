package serializer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.StatusOkDto;

public class StatusOkSerializer {

    public String toJsonString(StatusOkDto dto) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        String json = gson.toJson(dto);
        return json;
    }
}
