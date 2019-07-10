package model;

import java.sql.Date;
import java.util.Objects;

public class PedidoCompra {

    private Integer id;
    private Date data;
    private Integer usuarioId;

    public PedidoCompra() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PedidoCompra that = (PedidoCompra) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    @Override
    public String toString() {
        return "PedidoCompra{" +
                "id=" + id +
                ", data=" + data +
                ", usuarioId=" + usuarioId +
                '}';
    }
}
