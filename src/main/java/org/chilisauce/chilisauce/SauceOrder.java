package org.chilisauce.chilisauce;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class SauceOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;
    private String clientName;
    private int clientId;
    private double priceBeforeDiscount;
    private double discount;
    private double totalPrice;

    @OneToMany(mappedBy = "id")
    private List<Sauce> sauceList;
    public void calculateTotalPrice() {
        totalPrice = sauceList.stream().map(sauce -> sauce.getQuantity() * sauce.getPrice()).mapToDouble(Double::doubleValue).sum();
    }
    public void calculateDiscount(int discountAmount){
        double newDiscountPriceAmount = 0;
        this.priceBeforeDiscount=totalPrice;
        for (Sauce sauce : getSauceList()) {
            int quantity = sauce.getQuantity();
            double discountQuantity = Math.floor(quantity / discountAmount);
            double price = sauce.getPrice();
            newDiscountPriceAmount = newDiscountPriceAmount - (price * discountQuantity);
        }
        setDiscount(newDiscountPriceAmount);
        setTotalPrice(getPriceBeforeDiscount() + newDiscountPriceAmount);
    }
}
