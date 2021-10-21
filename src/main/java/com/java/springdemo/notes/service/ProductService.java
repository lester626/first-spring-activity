package com.java.springdemo.notes.service;

import com.java.springdemo.notes.model.Product;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private static Map<Integer, Product> productMap = new HashMap();
    private SecureRandom secureRandom = new SecureRandom();

    // create a product map
    static {
        Product coffee = new Product();
        coffee.setId(1);
        coffee.setName("coffee");
        coffee.setPrice(150);
        productMap.put(coffee.getId(), coffee);

        Product tea = new Product();
        tea.setId(2);
        tea.setName("tea");
        tea.setPrice(180);
        productMap.put(tea.getId(), tea);
    }

    // get all products
    public List<Product> retrieveAllProducts() {
        return productMap.values().stream().collect(Collectors.toList());
    }

    // get product by Id
    public Product retrieveProductById(int id) {
        return productMap.get(id);
    }

    // add product
    public Product addNewProduct(Product newProduct) {
        Product product = new Product();
        product.setId(Math.abs(secureRandom.nextInt()));
        product.setName(newProduct.getName());
        product.setPrice(newProduct.getPrice());
        productMap.put(product.getId(), product);
        return product;
    }

    // update product by Id
    public Product updateProductPrice(int id, Product updatedProduct) {
        Product product = null;
        if(productMap.containsKey(id)) {
            product = productMap.get(id);
            product.setPrice(updatedProduct.getPrice());
        }
        return product;
    }

    //delete product by Id
    public void deleteProductById(int id) {
        if(productMap.containsKey(id)) {
            productMap.remove(id);
        }
    }

}
