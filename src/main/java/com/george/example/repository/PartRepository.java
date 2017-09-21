package com.george.example.repository;

import com.george.example.model.Part;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(collectionResourceRel = "part", path = "part")
public interface PartRepository extends PagingAndSortingRepository<Part, Integer> {
}
