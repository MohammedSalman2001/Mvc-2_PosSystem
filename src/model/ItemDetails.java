package model;

public class ItemDetails {
    private String orderId;
    private String code;
    private double unitePrice;
    private int qty;

    public ItemDetails() {
    }

    public ItemDetails(String orderId, String code, double unitePrice, int qty) {
        this.setOrderId(orderId);
        this.code = code;
        this.unitePrice = unitePrice;
        this.qty = qty;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
