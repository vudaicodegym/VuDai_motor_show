package com.example.vudai_motor_show.controller;

import com.example.vudai_motor_show.dto.response.ResponseMessage;
import com.example.vudai_motor_show.model.Category;
import com.example.vudai_motor_show.service.ICategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/category")
public class CategoryController {
    ICategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> findAll(){
        return new ResponseEntity<>(categoryService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Long id){
        try {
            return new ResponseEntity<>(categoryService.findById(id), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new ResponseMessage("can not find this category"), HttpStatus.OK);
        }
    }
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Category category){
        if (categoryService.exitsByName(category.getCategoryName()) || category.getId() != null){
            return new ResponseEntity<>(new ResponseMessage("category exist"), HttpStatus.OK);
        }else{
            categoryService.save(category);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @PutMapping
    public ResponseEntity<?> edit(@RequestBody Category category){
        if (categoryService.exitsByName(category.getCategoryName())){
            return new ResponseEntity<>(new ResponseMessage("category exist"), HttpStatus.OK);
        }else{
            categoryService.save(category);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}
