package com.example.Agritechproductssearchbox.service;

import com.example.Agritechproductssearchbox.model.Product;
import com.example.Agritechproductssearchbox.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IProductService {



    public List<String> searchProducts(String query);

    public List<Product> getAllProducts();

    Product addProduct(Product product);

    List<Product> search(String q);
}

