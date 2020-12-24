package ru.vyazankin.SpringData.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.vyazankin.SpringData.entity.Product;
import ru.vyazankin.SpringData.repository.ProductRepository;

import java.math.BigDecimal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {
    private final ProductRepository productRepository;

    @GetMapping
    public Iterable<Product> products(@RequestParam(name = "minprice", required = false) BigDecimal minprice,
                                      @RequestParam(name = "maxprice", required = false) BigDecimal maxprice){

        //Эта логика должна жить в сервисе
        if (maxprice != null && minprice != null){
            return productRepository.getAllByPriceBetween(minprice, maxprice);
        } else if (maxprice != null){
            return productRepository.getAllByPriceIsLessThanEqual(maxprice);
        } else if (minprice != null) {
            return productRepository.getAllByPriceIsGreaterThanEqual(minprice);
        }
        return productRepository.findAll();
    }

    @GetMapping("/{id}")
    public Product getProductByID(@PathVariable Long id){
        var product = productRepository.findById(id);
        //Тут пока мы не умеем возвращать клиенту ошибки
        return product.orElse(null);
    }

    @PostMapping
    public Product addProduct(@RequestBody Product product){
        if (product.getTitle() == null || product.getTitle().isBlank() || product.getPrice() == null){
            //Тут мы пока не умеем возвращать клиенту ошибки
            return null;
        }
        return productRepository.save(product);
    }

    @GetMapping("/delete/{id}")
    public void deleteProductByID(@PathVariable Long id){
        if (productRepository.existsById(id)){
            productRepository.deleteById(id);
        } else {
            //Тут мы пока не умеем возвращать клиенту ошибки
        }
    }

}
