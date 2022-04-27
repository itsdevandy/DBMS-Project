package com.team404.festmanagement.repository;

import com.team404.festmanagement.dto.MerchDTO;
import com.team404.festmanagement.model.Merch;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MerchRepository extends JpaRepository<Merch, Long> {

    List<Merch> findAllByCategory_Id(int id);


}
