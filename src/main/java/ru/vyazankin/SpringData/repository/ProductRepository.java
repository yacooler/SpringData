package ru.vyazankin.SpringData.repository;

import org.springframework.data.repository.CrudRepository;
import ru.vyazankin.SpringData.entity.Product;

import java.math.BigDecimal;

public interface ProductRepository extends CrudRepository<Product, Long> {

    Iterable<Product> getAllByPriceBetween(BigDecimal min, BigDecimal max);
    Iterable<Product> getAllByPriceIsGreaterThanEqual(BigDecimal min);
    Iterable<Product> getAllByPriceIsLessThanEqual(BigDecimal max);
}
