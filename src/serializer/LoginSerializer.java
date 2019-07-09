package serializer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.LoginDto;

public class LoginSerializer {
    public LoginDto fromJsonString(String json) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        LoginDto dto = gson.fromJson(json, LoginDto.class);
        return dto;
    }
}
