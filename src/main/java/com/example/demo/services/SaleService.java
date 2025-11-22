package com.example.demo.services;

import com.example.demo.entities.Product;
import com.example.demo.entities.Sale;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.repositories.SaleRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class SaleService {

    private final SaleRepository saleRepository;
    private final ProductRepository productRepository;

    public SaleService(SaleRepository saleRepository, ProductRepository productRepository) {
        this.saleRepository = saleRepository;
        this.productRepository = productRepository;
    }

    public List<Sale> findAll() {
        return saleRepository.findAll();
    }

    public Sale findById(Long id) {
        return saleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sale not found: " + id));
    }

    public Sale create(Sale sale) {

        Product product = productRepository.findById(sale.getProduct().getId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        BigDecimal price = product.getPrice();
        BigDecimal quantity = BigDecimal.valueOf(sale.getQuantity());
        BigDecimal total = price.multiply(quantity);

        if (sale.getDiscount() != null) {
            total = total.subtract(sale.getDiscount());
        }

        sale.setTotalAmount(total);

        if (sale.getSaleDate() == null) {
            sale.setSaleDate(LocalDateTime.now());
        }

        return saleRepository.save(sale);
    }

    public Sale update(Long id, Sale sale) {
        Sale existing = findById(id);

        existing.setProduct(sale.getProduct());
        existing.setQuantity(sale.getQuantity());
        existing.setDiscount(sale.getDiscount());
        existing.setStatus(sale.getStatus());
        existing.setSaleDate(sale.getSaleDate());

        return create(existing); // recalcula total
    }

    public void delete(Long id) {
        saleRepository.deleteById(id);
    }
}