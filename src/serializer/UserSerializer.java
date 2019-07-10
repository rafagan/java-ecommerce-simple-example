package serializer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.CreditCardDto;
import dto.UserDto;
import model.Usuario;

public class UserSerializer {

    public String toJsonString(CreditCardDto item) {
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

    public String toJsonString(UserDto item) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        String json = gson.toJson(item);
        return json;
    }

    public UserDto toDto(Usuario user) {
        UserDto userDto = new UserDto();
        userDto.setLogin(user.getLogin());
        userDto.setCodigoSeguranca(user.getCodigoSeguranca());
        userDto.setDataValidade(user.getDataValidade());
        userDto.setNumeroCartao(user.getNumeroCartao());
        userDto.setId(user.getId());
        return userDto;
    }
}
