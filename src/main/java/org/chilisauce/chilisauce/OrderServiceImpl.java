package org.chilisauce.chilisauce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private static final int DISCOUNT_AMOUNT = 5;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    SauceRepository sauceRepository;

    @Override
    public void processOrder(SauceOrder sauceOrder) {
        for (Sauce sauceInOrder : sauceOrder.sauceList) {
            Optional<Sauce> byId = sauceRepository.findById(sauceInOrder.getId());
            if (byId.isPresent()) {
                Sauce sauceInDb = byId.get();
                sauceInDb.quantity -= sauceInOrder.quantity;
                sauceRepository.save(sauceInDb);
            }
        }
        sauceOrder.calculateTotalPrice();
    }

    @Override
    public SauceOrder placeOrder(SauceOrder sauceOrder) {
        List<Sauce> updatedWithInfoOrder = sauceOrder.getSauceList().stream().map(
                sauce -> Sauce.builder()
                        .id(sauce.getId())
                        .quantity(sauce.getQuantity())
                        .price(sauceRepository.getPriceById(sauce.getId()))
                        .name(sauceRepository.getNameById(sauce.getId()))
                        .origin(sauceRepository.getOriginById(sauce.getId()))
                        .scoville(sauceRepository.getScovilleById(sauce.getId()))
                        .build()).toList();
        sauceOrder.setSauceList(updatedWithInfoOrder);
        sauceOrder.calculateTotalPrice();
        calculateDiscount(sauceOrder);
        return orderRepository.save(sauceOrder);
    }


    //TODO FIX THIS SHIT LOGIC
    private void calculateDiscount(SauceOrder sauceOrder){
        double newTotalPrice = 0;
        for (Sauce sauce : sauceOrder.getSauceList()) {
            int quantity = sauce.getQuantity();
            double discountQuantity = Math.floor(quantity / DISCOUNT_AMOUNT);
            double price = sauce.getPrice();
            newTotalPrice = sauceOrder.getTotalPrice() - (price * discountQuantity);

        }
        sauceOrder.setTotalPrice(newTotalPrice);
    }
}
