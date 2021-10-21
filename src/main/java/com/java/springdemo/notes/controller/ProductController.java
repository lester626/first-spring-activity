package com.java.springdemo.notes.controller;

import com.java.springdemo.notes.exception.ItemNotFoundException;
import com.java.springdemo.notes.model.Product;
import com.java.springdemo.notes.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
//@RequestMapping("products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("products/all")
    public List<Product> getAllProducts() {
        return productService.retrieveAllProducts();
    }

    @GetMapping("products/{id}")
    public Product getProductById(@PathVariable int id) {
        return productService.retrieveProductById(id);
    }

    @PostMapping(value = "/products", produces = "application/json")
    public Product addProduct(@RequestBody Product newProduct) {
        return productService.addNewProduct(newProduct);
    }

    @PutMapping("/products")
    public ResponseEntity<Product> updateProductById(@RequestBody Product updatedProduct) {
        if(productService.retrieveProductById(updatedProduct.getId()) == null) {
            throw new ItemNotFoundException();
        }
//        else {
//            productService.updateProductPrice(updatedProduct.getId(), updatedProduct);
//        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Product> deleteProductById(@PathVariable int id){
        if(productService.retrieveProductById(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            productService.deleteProductById(id);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
