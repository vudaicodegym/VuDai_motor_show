package com.example.vudai_motor_show.controller;

import com.example.vudai_motor_show.dto.response.ResponseMessage;
import com.example.vudai_motor_show.model.Brand;
import com.example.vudai_motor_show.service.IBrandService;
import com.example.vudai_motor_show.service.impl.BrandServiceIMPL;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/brand")
public class BrandController {
    IBrandService brandService;
    @GetMapping
    public ResponseEntity<List<Brand>> findAll() {
        return new ResponseEntity<>(brandService.findALl(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Long id){
        try {
            return new ResponseEntity<>(brandService.findBrandById(id), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new ResponseMessage("can not find this brand"), HttpStatus.OK);
        }

    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Brand brand){
        if (brandService.existsByBrandName(brand.getBrandName())){
            return new ResponseEntity<>(new ResponseMessage("brand name existed"), HttpStatus.OK);
        }else {
            brandService.save(brand);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @PutMapping
    public ResponseEntity<?> editBrand(@RequestBody Brand brand){
        if (brandService.existsByBrandName(brand.getBrandName())){
            return new ResponseEntity<>(new ResponseMessage("brand name existed"), HttpStatus.OK);
        }else {
            brandService.save(brand);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}
