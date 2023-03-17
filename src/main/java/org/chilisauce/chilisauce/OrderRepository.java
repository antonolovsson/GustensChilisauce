package org.chilisauce.chilisauce;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<SauceOrder, Integer> {
}
