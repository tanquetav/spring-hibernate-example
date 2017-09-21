package com.george.example.service;

import com.george.example.model.Part;
import com.george.example.model.Product;
import com.george.example.repository.PartRepository;
import com.george.example.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by george on 9/10/17.
 */
@Service
public class PartService {
    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    PartRepository partRepository;

    @Autowired
    ProductRepository productRepository;

    public Object sample2() {
        Set<String> out = new HashSet<String>();
        Iterable<Part> lstPart = partRepository.findAll();
        for (Part part : lstPart) {
            out.add(part.getProduct().getName());
        }
        return out;
    }
    public Object sample3() {
        Query query = entityManager.createQuery(" select product.name from Part  part join part.product product");

        return query.getResultList();
    }

    @Transactional
    public Object sample4() {
        Product p = new Product();
        p.setName("cccc");
        p.setDescription("cccc");
        productRepository.save(p);
        Part pa = new Part();
        pa.setName("cccc");
        pa.setProduct(p);
        partRepository.save(pa);
        entityManager.flush();
        if (true ) throw new RuntimeException("erro");
        return "lo";
    }
}
