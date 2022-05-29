/**
 * @author : ALE_IS_TER
 * Project Name: Layered_Architecture
 * Date        : 5/29/2022
 * Time        : 6:04 AM
 * @Since : 0.1.0
 */

package lk.ijse.pos.entity;

import java.math.BigDecimal;

public class Item {
    private String code;
    private String description;
    private int qtyOnHand;
    private BigDecimal unitPrice;

    public Item() {
    }

    public Item(String code, String description, int qtyOnHand, BigDecimal unitPrice) {
        this.setCode(code);
        this.setDescription(description);
        this.setQtyOnHand(qtyOnHand);
        this.setUnitPrice(unitPrice);
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQtyOnHand() {
        return qtyOnHand;
    }

    public void setQtyOnHand(int qtyOnHand) {
        this.qtyOnHand = qtyOnHand;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "Item{" +
                "code='" + code + '\'' +
                ", description='" + description + '\'' +
                ", qtyOnHand=" + qtyOnHand +
                ", unitPrice=" + unitPrice +
                '}';
    }
}
