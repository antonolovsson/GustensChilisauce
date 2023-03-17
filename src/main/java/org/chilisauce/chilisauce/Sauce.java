package org.chilisauce.chilisauce;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Sauce {

    @Id
    private int id;
    private String name;

    //TODO Set to private.
    int quantity;
    private String origin;
    private int scoville;
    private double price;

    @ManyToOne
    @JoinColumn(referencedColumnName = "orderId")
    @JsonIgnore
    private SauceOrder sauceOrder;
}
