package org.chilisauce.chilisauce;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Sauce {

    @Id
    int id;
    String name;
    int quantity;
    String origin;
    int scoville;
    int price;


    //TODO Fix this issue with mapping.
    @ManyToOne
    @JoinColumn(referencedColumnName = "orderId")
    SauceOrder sauceOrder;
}
