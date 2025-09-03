package com.sunat.sunatresttemplate.controller;

import com.sunat.sunatresttemplate.model.SunatResponse;
import com.sunat.sunatresttemplate.service.SunatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SunatController {

    @Autowired
    private SunatService sunatService;

    @GetMapping("/sunat/ruc")
    public ResponseEntity<SunatResponse> consultarRuc(@RequestParam("numero") String numero) {
        try {
            return ResponseEntity.ok(sunatService.consultarRuc(numero));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @GetMapping("/sunat/ruc/full")
    public ResponseEntity<SunatResponse> consultarRucFull(@RequestParam("numero") String numero) {
        try {
            return ResponseEntity.ok(sunatService.consultarRucFull(numero));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
}