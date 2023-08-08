package model;

public class Item {
    private String code;
    private String Description;
    private double unitePrice;
    private int qtyOnHand;

    public Item(String code, String description, double unitePrice, int qtyOnHand) {
        this.code = code;
        Description = description;
        this.unitePrice = unitePrice;
        this.qtyOnHand = qtyOnHand;
    }

    public Item() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public double getUnitePrice() {
        return unitePrice;
    }

    public void setUnitePrice(double unitePrice) {
        this.unitePrice = unitePrice;
    }

    public int getQtyOnHand() {
        return qtyOnHand;
    }

    public void setQtyOnHand(int qtyOnHand) {
        this.qtyOnHand = qtyOnHand;
    }
}

