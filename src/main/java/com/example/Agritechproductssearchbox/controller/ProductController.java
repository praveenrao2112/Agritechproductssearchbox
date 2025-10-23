package com.example.Agritechproductssearchbox.controller;



import com.example.Agritechproductssearchbox.model.Product;
import com.example.Agritechproductssearchbox.service.IProductService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping("/sample")
    public String sampleApi()
    {
        return "This is Sample Api";
    }

    @PostMapping("/add")
    @Operation(summary = "Add new product", description = "Add a product to test search functionality")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        return ResponseEntity.ok(productService.addProduct(product));
    }

    @GetMapping("/search")
    public List<String> searchProducts(@RequestParam String q)
    {
        System.out.println("Input-> "+ q);
        System.out.println("Search Called");
        List<Product> search = productService.search(q);

        List<String> listOfNames = new ArrayList<>();

        for(Product s: search)
        {
            listOfNames.add(s.getName());
        }
        return listOfNames;
    }
}
