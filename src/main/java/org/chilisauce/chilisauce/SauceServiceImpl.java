package org.chilisauce.chilisauce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SauceServiceImpl implements SauceService{

    @Autowired
    SauceRepository sauceRepository;
    @Override
    public List<Sauce> updateSauceList(List<Sauce> sauceList) {
        sauceList.forEach(sauce -> sauceRepository.save(sauce));
        return sauceList;
    }

    @Override
    public List<Sauce> getFilteredSauceList(int scoville, String origin, String name) {
//TODO
        return null;
    }
}
