package org.chilisauce.chilisauce;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SauceService {

    List<Sauce> updateSauceList(List<Sauce> sauceList);

    List<Sauce> getFilteredSauceList(int scoville, String origin, String name);

}
