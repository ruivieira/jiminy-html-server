package io.radanalytics.jiminy.service;

import io.radanalytics.jiminy.ProductRepository;
import io.radanalytics.jiminy.model.Product;
import io.radanalytics.jiminy.model.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * PostgresProductService<br>
 * 
 * Provides the interface between the controller and the data access layer.
 * 
 * @author Rui Vieira <rcardoso@redhat.com>
 */
@Service
public class PostgresProductService implements ProductService {

    @Autowired
    ProductRepository repository;

    @Override
    public ProductDAO findById(long id){
        Product product= repository.findOne(id);
        return new ProductDAO(product);
    }

    @Override
    public List<ProductDAO> findAllById(List<Long> ids) {
        List<Product> products = repository.findAll(ids);
        List<ProductDAO> productDAOS = new ArrayList<>();
        for (Product product : products) {
            productDAOS.add(convertToDAO(product));
        }

        return productDAOS;
    }

    private ProductDAO convertToDAO(Product product){
        return new ProductDAO(product);
    }


}