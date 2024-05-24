/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.Autogest.controller;


import com.app.Autogest.entity.Clase_Orden_Ingreso;
import com.app.Autogest.services.IClaseOrdenIngresoService;
import jakarta.validation.Valid;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author CLAUDIO CRUZADO
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/Autogest")

public class ClaseOrdenIngresoController {

    @Autowired
    private IClaseOrdenIngresoService ordenService;

    @GetMapping("/MostrarOrdenIngreso")
    private List<Clase_Orden_Ingreso> index() {
        return ordenService.findAll();
    }

    @PostMapping("/InsertarOrdenIngreso")
    private ResponseEntity<Map<String, String>> insert(@Valid @RequestBody Clase_Orden_Ingreso ordeningreso, BindingResult bindingResult) {
        Map<String, String> response = new HashMap();

        try {
            if (bindingResult.hasErrors()) {
                List<FieldError> errors = bindingResult.getFieldErrors();
                for (FieldError error : errors) {
                    response.put(error.getField(), error.getDefaultMessage());
                }
                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            } else {
                ordeningreso.setFecha_Entrada(new Date());
                Clase_Orden_Ingreso insertarTipoDoc = ordenService.insert(ordeningreso);
                if (insertarTipoDoc != null) {
                    response.put("message", "Orden de Ingreso insertado correctamente");
                    return new ResponseEntity<>(response, HttpStatus.CREATED);
                } else {
                    response.put("message", "Error al insertar Orden de Ingreso");
                    return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } catch (Exception e) {
            response.put("error", "Error al insertar Orden de Ingreso: " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
