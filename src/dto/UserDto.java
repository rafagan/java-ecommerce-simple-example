package dto;

public class UserDto extends CreditCardDto {
    private String login;
    private Integer id;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "login='" + login + '\'' +
                ", id=" + id +
                ", codigoSeguranca=" + codigoSeguranca +
                ", dataValidade='" + dataValidade + '\'' +
                ", numeroCartao='" + numeroCartao + '\'' +
                '}';
    }
}
