package com.example.Agritechproductssearchbox.service;

import com.example.Agritechproductssearchbox.model.Product;
import com.example.Agritechproductssearchbox.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImp implements IProductService {
    private final ProductRepository productRepository;

    public ProductServiceImp(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public List<String> searchProducts(String query) {
        List<Product> byNameStartingWithIgnoreCase = productRepository.findByNameStartingWithIgnoreCase(query);

        List<String> collect = byNameStartingWithIgnoreCase.stream()
                .map(p -> p.getName())
                .collect(Collectors.toList());

        return collect;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product addProduct(Product product) {
        return null;
    }

    @Override
    public List<Product> search(String q) {
        return productRepository.findByNameStartingWithIgnoreCase(q);
    }
}
