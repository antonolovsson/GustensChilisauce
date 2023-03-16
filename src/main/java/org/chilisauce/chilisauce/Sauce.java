package org.chilisauce.chilisauce;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
    int stock;
    String origin;
    int scoville;
    int price;

}
