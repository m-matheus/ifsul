package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Product;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class ProductController {

    @PostMapping("api/demand/predict")
    public ResponseEntity<Map<String, Object>> evaluateEmployee(@RequestBody Product p) {
        
        if(p.getProductId() == null || p.getSalesData() == null) {
            return ResponseEntity.badRequest().build();
        } else if (p.getSalesData().length < 2) {
            return ResponseEntity.badRequest().build();
        }

        Float sum = 0f;

        for(int value : p.getSalesData()) {
            sum += value;
        }

        float average = sum / p.getSalesData().length;

        Map<String, Object> response = new HashMap<>();

        response.put("productId", p.getProductId());
        response.put("average", average);

        return ResponseEntity.ok(response);
    }
    
}
