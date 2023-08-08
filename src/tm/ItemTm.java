package tm;

import javafx.scene.control.Button;

public class ItemTm {
    private String code;
    private String Description;
    private double unitePrice;
    private int qtyOnHand;
    private Button btn;

    public ItemTm(String code, String description, double unitePrice, int qtyOnHand, Button btn) {
        this.code = code;
        Description = description;
        this.unitePrice = unitePrice;
        this.qtyOnHand = qtyOnHand;
        this.btn = btn;
    }

    public ItemTm() {
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

    public Button getBtn() {
        return btn;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }
}

