package org.chilisauce.chilisauce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController()
@RequestMapping("/api")
public class SauceController {

    @Autowired
    OrderService orderService;

    @Autowired
    SauceService sauceService;

    @PostMapping("/postSauce")
    public List<Sauce> postSauceList(@RequestBody List<Sauce> sauces) {
        sauceService.updateSauceList(sauces);
        return sauces;
    }

    @GetMapping("/getStock")
    public List<Sauce> getStock(@RequestParam(required = false) String scoville,
                                @RequestParam(required = false) String origin,
                                @RequestParam(required = false) String name) {

        return sauceService.getStock(scoville, origin, name);
    }

    @PostMapping("/placeOrder")
    public SauceOrder placeOrder(@RequestBody SauceOrder sauceOrder) {
        SauceOrder savedSauceOrder = orderService.placeOrder(sauceOrder);
        orderService.processOrder(sauceOrder);
        return savedSauceOrder;
    }
}
