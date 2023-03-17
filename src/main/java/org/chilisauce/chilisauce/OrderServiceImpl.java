package org.chilisauce.chilisauce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    SauceRepository sauceRepository;

    @Override
    public void processOrder(SauceOrder sauceOrder) {
        for (Sauce sauceInOrder : sauceOrder.sauceList) {
            Optional<Sauce> byId = sauceRepository.findById(sauceInOrder.id);
            if (byId.isPresent()) {
                Sauce sauceInDb = byId.get();
                sauceInDb.quantity -= sauceInOrder.quantity;
                sauceRepository.save(sauceInDb);
            }
        }
        //sauceOrder.sauceList.stream()
        //        .map(sauceInOrder -> sauceRepository.findById(sauceInOrder.id))
        //        .filter(Optional::isPresent)
        //        .map(Optional::get)
        //        .forEach(sauceInDb -> {
        //            sauceInDb.quantity -= sauceOrder.sauceList.stream()
        //                    .filter(sauceInOrder -> sauceInOrder.id == sauceInDb.id)
        //                    .mapToInt(sauceInOrder -> sauceInOrder.quantity)
        //                    .sum();
        //            sauceRepository.save(sauceInDb);
        //        });

    }
}
