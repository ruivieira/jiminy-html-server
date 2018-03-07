package io.radanalytics.jiminy.service;

import io.radanalytics.jiminy.model.ProductDAO;

import java.util.List;

/**
 * ProductService<br>
 * 
 * Simple interface for what operations would be required of this service.
 * 
 * @author Rui Vieira <rcardoso@redhat.com>
 */
public interface ProductService {
 
    ProductDAO findById(long id);

    List<ProductDAO> findAllById(List<Long> ids);

}
