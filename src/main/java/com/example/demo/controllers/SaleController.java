package com.example.demo.controllers;

import com.example.demo.entities.Sale;
import com.example.demo.services.SaleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/sales")
public class SaleController {

    private final SaleService service;

    public SaleController(SaleService service) {
        this.service = service;
    }

    @GetMapping
    public List<Sale> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Sale findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public ResponseEntity<Sale> create(@Valid @RequestBody Sale sale) {
        Sale created = service.create(sale);
        return ResponseEntity.ok(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sale> update(@PathVariable Long id, @Valid @RequestBody Sale sale) {
        Sale updated = service.update(id, sale);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}