package tm;

public class ItemDetailsTm {
    private String itemCode;
    private double unitePrice;
    private int qty;
    private double total;

    public ItemDetailsTm() {
    }

    public ItemDetailsTm(String itemCode, double unitePrice, int qty, double total) {
        this.itemCode = itemCode;
        this.unitePrice = unitePrice;
        this.qty = qty;
        this.total = total;
    }



    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public double getUnitePrice() {
        return unitePrice;
    }

    public void setUnitePrice(double unitePrice) {
        this.unitePrice = unitePrice;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}



