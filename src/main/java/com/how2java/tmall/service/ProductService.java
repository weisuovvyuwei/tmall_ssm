package com.how2java.tmall.service;

import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.pojo.Product;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProductService {
    void add(Product product);

    void delete(int id);

    void update(Product product);

    List<Product> list(int cid);

    Product get(int id);

    void setFirstProductImage(Product product);

    void fill(List<Category> categories);

    void fill(Category category);

    void fillByRow(List<Category> categories);

    void setSaleAndReviewNumber(Product p);

    void setSaleAndReviewNumber(List<Product> ps);

    List<Product> search(String keyword);
}
