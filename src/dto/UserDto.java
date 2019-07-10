package dto;

public class UserDto extends CreditCardDto {
    private String login;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "login='" + login + '\'' +
                ", codigoSeguranca='" + codigoSeguranca + '\'' +
                ", dataValidade='" + dataValidade + '\'' +
                ", numeroCartao='" + numeroCartao + '\'' +
                ", userId=" + userId +
                '}';
    }
}
