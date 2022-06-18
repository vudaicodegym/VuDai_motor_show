package com.example.vudai_motor_show.controller;

import com.example.vudai_motor_show.dto.response.ResponseMessage;
import com.example.vudai_motor_show.model.Color;
import com.example.vudai_motor_show.service.impl.ColorServiceIMPL;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/color")
public class ColorController {
    ColorServiceIMPL colorService;

    @GetMapping
    public ResponseEntity<List<Color>> getAllColor(){
        return new ResponseEntity<>(colorService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Color> getColorByID(@PathVariable("id") Long id){
        return new ResponseEntity<>(colorService.getColorByID(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createColor(@RequestBody Color color){
        if (colorService.existByColor(color.getColor())){
            return new ResponseEntity<>(new ResponseMessage("color name existed"), HttpStatus.OK);
        }else {
            colorService.save(color);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @PutMapping
    public ResponseEntity<?> editColor(@RequestBody Color color){
        if (colorService.existByColor(color.getColor())){
            return new ResponseEntity<>(new ResponseMessage("color name existed"), HttpStatus.OK);
        }else {
            colorService.save(color);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

}
