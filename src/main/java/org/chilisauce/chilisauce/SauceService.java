package org.chilisauce.chilisauce;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SauceService {

    List<Sauce> updateSauceList(List<Sauce> sauceList);

    List<Sauce> getStock(String scoville, String origin, String name);

}
