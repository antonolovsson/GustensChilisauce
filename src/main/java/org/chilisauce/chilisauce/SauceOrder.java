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

    @OneToMany(mappedBy = "id")
    List<Sauce> sauceList;

    int totalPrice;

    public void calculateTotalPrice() {
        totalPrice = sauceList.stream().map(sauce -> sauce.getQuantity() * sauce.getPrice()).mapToInt(Integer::intValue).sum();
    }
}
