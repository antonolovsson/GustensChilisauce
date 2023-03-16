package org.chilisauce.chilisauce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RestController()
@RequestMapping("/api")
public class SauceController {
    @Autowired
    SauceRepository sauceRepository;

    @GetMapping("/getstock")
    public List<Sauce> getFullStock(){
        return sauceRepository.findAll();
    }

    @PostMapping("/postsauce")
    public Sauce postSauce(@RequestBody Sauce sauce){
        Sauce savedSauce = sauceRepository.saveAndFlush(sauce);
        return savedSauce;
    }

    @PutMapping("/buysauce")
    public Optional<Sauce> buySauce(@RequestParam int id, @RequestParam int units){
        Optional<Sauce> sauceInDb = sauceRepository.findById(id);
        if(sauceInDb.isPresent()){
            sauceInDb.get().stock = sauceInDb.get().stock - units;
            sauceRepository.save(sauceInDb.get());
        }
        return sauceRepository.findById(id);
    }


}
