package dto;


public class ShoppingCartDto {

    private Integer itemId;
    private Integer amount;

    public ShoppingCartDto() {
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "ShoppingCartDto{" +
                "itemId=" + itemId +
                ", amount=" + amount +
                '}';
    }
}
