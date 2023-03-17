package org.chilisauce.chilisauce;

import org.springframework.stereotype.Service;

@Service
public interface OrderService {

    void processOrder(SauceOrder sauceOrder);

    SauceOrder placeOrder(SauceOrder sauceOrder);

}
