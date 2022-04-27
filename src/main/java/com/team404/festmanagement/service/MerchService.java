package com.team404.festmanagement.service;

import com.team404.festmanagement.model.Merch;
import com.team404.festmanagement.repository.MerchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class MerchService {
    @Autowired
    MerchRepository merchRepository;
    public List<Merch> getAllMerch(){ return merchRepository.findAll();}
    public void addMerch(Merch merch){
        merchRepository.save(merch);
    }

    public void removeMerchByID(long id){
        merchRepository.deleteById(id);
    }

    public Optional<Merch> getMerchByID(long id){
        return merchRepository.findById(id);
    }


    public List<Merch> getAllMerchByCategoryID(int id){
        return merchRepository.findAllByCategory_Id(id);
    }

}
