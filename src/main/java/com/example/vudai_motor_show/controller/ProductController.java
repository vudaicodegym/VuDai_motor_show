package com.example.vudai_motor_show.controller;

import com.example.vudai_motor_show.dto.response.ResponseMessage;
import com.example.vudai_motor_show.model.Product;
import com.example.vudai_motor_show.service.IProductService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/product")
public class ProductController {
    IProductService productService;

    @GetMapping
    public ResponseEntity<Page<Product>> findAll(@PageableDefault Pageable pageable){
        return new ResponseEntity<>(productService.findAll(pageable), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Long id){
        try {
            return new ResponseEntity<>(productService.findById(id),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new ResponseMessage("can not find this product"), HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<?> createProduct(@RequestBody Product product){
        if (productService.existsByModelName(product.getModel().getName()) || product.getId() != null){
            return new ResponseEntity<>(new ResponseMessage("This model is in another product"), HttpStatus.OK);
        }else {
            productService.Save(product);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @PutMapping
    public ResponseEntity<?> editProduct(@RequestBody Product product){
        if (productService.existsByModelName(product.getModel().getName())){
            return new ResponseEntity<>(new ResponseMessage("This model is in another product"), HttpStatus.OK);
        }else {
            productService.Save(product);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}
