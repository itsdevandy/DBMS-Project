package com.team404.festmanagement.repository;

import com.team404.festmanagement.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
