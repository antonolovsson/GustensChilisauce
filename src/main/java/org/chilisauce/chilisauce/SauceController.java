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
    SauceRepository sauceRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderService orderService;

    @Autowired
    SauceService sauceService;

    @GetMapping("/stock")
    public List<Sauce> getFullStock() {
        return sauceRepository.findAll();
    }

    @PostMapping("/postsauce")
    public List<Sauce> postSauceList(@RequestBody List<Sauce> sauces) {
        sauceService.updateSauceList(sauces);
        return sauces;
    }


    @GetMapping("/filter")
    public List<Sauce> getFiltered(@RequestParam(required = false) String scoville,
                                   @RequestParam(required = false) String origin,
                                   @RequestParam(required = false) String name) {

        return sauceRepository.getSauceByScovilleAndOriginAndName(scoville, origin, name);
    }

    @GetMapping("/filters")
    public List<Sauce> getFiltereds(@RequestParam(required = false) String scoville,
                                    @RequestParam(required = false) String origin,
                                    @RequestParam(required = false) String name) {

        return sauceRepository.getFilteredList(scoville, origin, name);
    }


    //TODO Display the values from the DB (not the null values)
    @PostMapping("/placeorder")
    public SauceOrder placeOrder(@RequestBody SauceOrder sauceOrder) {
        SauceOrder savedSauceOrder = orderRepository.save(sauceOrder);
        orderService.processOrder(sauceOrder);
        return savedSauceOrder;
    }
}
