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
    int orderId;
    String clientName;
    int clientId;

    //TODO Fix this issue with the mappings.
    @OneToMany(mappedBy = "id")
    List<Sauce> sauceList;
}
