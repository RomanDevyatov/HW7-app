package com.netcracker.service;

import com.netcracker.entity.Shop;
import com.netcracker.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShopService {

    @Autowired
    private ShopRepository shopRepository;

    public List<Shop> findAll(){
        return shopRepository.findAll();
    }

    public Shop findById(long id){
        Optional<Shop> optional = shopRepository.findById(id);
        return optional.orElse(new Shop());
    }

    public List<Shop> findByName(String name){
        return shopRepository.findByName(name);
    }
    public List<Shop> findByArea(String area){ return shopRepository.findByArea(area);   }
    public List<Shop> findByCommission(int commission){ return shopRepository.findByCommission(commission);   }

    public Shop save(Shop shop){
        shopRepository.save(shop);
        return shop;
    }

    public void deleteAll() {
        shopRepository.deleteAll();
    }

    public List<String> retrieveNameWhereAreaOr(String ar1, String ar2){
        return shopRepository.retrieveNameWhereAreaOr(ar1, ar2);
    }
}
