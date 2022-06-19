package com.example.vudai_motor_show.controller;

import com.example.vudai_motor_show.dto.response.ResponseMessage;
import com.example.vudai_motor_show.model.Model;
import com.example.vudai_motor_show.service.IModelService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/model")
public class ModelController {
    IModelService modelService;

    @GetMapping
    public ResponseEntity<Page<Model>> findAll(@PageableDefault Pageable pageable){
        Page<Model> modelPage = modelService.findAll(pageable);
        return new ResponseEntity<>(modelPage, HttpStatus.OK);
    }

    @GetMapping ("/{id}")
    public ResponseEntity<?> findModelById(@PathVariable("id")Long id){
        try {
            return new ResponseEntity<>(modelService.findById(id), HttpStatus.OK);
        }catch (Exception e){
            System.err.println(e);
            return new ResponseEntity<>(new ResponseMessage("can not find this model"), HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<?> createModel(@RequestBody Model model){
        if (modelService.existByName(model.getName()) || model.getId() != null){
            return new ResponseEntity<>(new ResponseMessage("model existed"), HttpStatus.OK);
        }else {
            modelService.save(model);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @PutMapping
    public ResponseEntity<?> editModel(@RequestBody Model model){
        if (modelService.existByName(model.getName())){
            return new ResponseEntity<>(new ResponseMessage("model name existed"), HttpStatus.OK);
        }else {
            modelService.save(model);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}
