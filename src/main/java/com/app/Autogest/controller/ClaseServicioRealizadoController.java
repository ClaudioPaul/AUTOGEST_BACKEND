/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.Autogest.controller;

import com.app.Autogest.entity.Clase_Servicio_Realizado;
import com.app.Autogest.services.IClaseServicioRealizadoService;
import jakarta.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
@PreAuthorize("denyAll()")
public class ClaseServicioRealizadoController {

    @Autowired
    private IClaseServicioRealizadoService serviciorealizadoService;

    @GetMapping("/MostrarServicioRealizado")
    @PreAuthorize("hasAnyAuthority('INTERMEDIO')")
    private List<Clase_Servicio_Realizado> index() {
        return serviciorealizadoService.findAll();
    }

    @PostMapping("/InsertarServicioRealizado")
    @PreAuthorize("hasAnyAuthority('INTERMEDIO')")
    private ResponseEntity<Map<String, String>> insert(@Valid @RequestBody Clase_Servicio_Realizado serviciorealizado, BindingResult bindingResult) {
        Map<String, String> response = new HashMap();

        try {
            if (bindingResult.hasErrors()) {
                List<FieldError> errors = bindingResult.getFieldErrors();
                for (FieldError error : errors) {
                    response.put(error.getField(), error.getDefaultMessage());
                }
                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            } else {

                Clase_Servicio_Realizado insertarServicioRealizado = serviciorealizadoService.insert(serviciorealizado);
                if (insertarServicioRealizado != null) {
                    response.put("message", "Servicio Realizado  insertado correctamente");
                    return new ResponseEntity<>(response, HttpStatus.CREATED);
                } else {
                    response.put("message", "Error al insertar Servicio Realizado");
                    return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } catch (Exception e) {
            response.put("error", "Error al insertar Servicio Realizado: " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
