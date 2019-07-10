package dto;

public class CreditCardDto {

    protected Integer codigoSeguranca;
    protected String dataValidade;
    protected String numeroCartao;
    protected Integer userId;

    public CreditCardDto() {
    }

    public Integer getCodigoSeguranca() {
        return codigoSeguranca;
    }

    public void setCodigoSeguranca(Integer codigoSeguranca) {
        this.codigoSeguranca = codigoSeguranca;
    }

    public String getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(String dataValidade) {
        this.dataValidade = dataValidade;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "CreditCardDto{" +
                "codigoSeguranca=" + codigoSeguranca +
                ", dataValidade='" + dataValidade + '\'' +
                ", numeroCartao='" + numeroCartao + '\'' +
                ", userId=" + userId +
                '}';
    }
}
