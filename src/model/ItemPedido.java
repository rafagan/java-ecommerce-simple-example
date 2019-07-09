package model;

import java.util.Objects;

public class ItemPedido {

    private Integer id;
    private Integer quantidade;
    private Integer pedidoCompraId;
    private Integer itemId;

    public ItemPedido() {
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemPedido that = (ItemPedido) o;
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

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Integer getPedidoCompraId() {
        return pedidoCompraId;
    }

    public void setPedidoCompraId(Integer pedidoCompraId) {
        this.pedidoCompraId = pedidoCompraId;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    @Override
    public String toString() {
        return "PedidoCompraDao{" +
                "id=" + id +
                ", quantidade=" + quantidade +
                ", pedidoCompraId=" + pedidoCompraId +
                ", itemId=" + itemId +
                '}';
    }
}
