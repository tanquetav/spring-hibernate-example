package com.george.example.repository;

import com.george.example.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;


@RepositoryRestResource(collectionResourceRel = "product", path = "product")
public interface ProductRepository  extends PagingAndSortingRepository<Product, Integer> {
    Page<Product> findByNameContaining(@Param("name") String name, Pageable pageable);
}
