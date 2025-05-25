package repository;

/*
Category.java
Category Repository
Author: Abethu Ngxitho 221297820
Date: 24 May 2025
*/

import domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category , String> {

    List<Category> findbyName(String name);

    List<Category> findDescription(String description);


}
