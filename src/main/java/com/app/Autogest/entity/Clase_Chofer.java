/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.Autogest.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 *
 * @author CLAUDIO CRUZADO
 */
@Entity
@Table(name = "Chofer")
public class Clase_Chofer {

    private static final long serialVersionUID = 1L;

    @Column(name = "Id_Chofer")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id_Chofer;

    @Column(name = "Nombres", length = 60)
    private String nombres;

    @Column(name = "Apellidos", length = 60)
    private String apellidos;
    
    @ManyToOne
    @JoinColumn(name = "Id_Tipo_Documento_Fk")
    private Clase_Tipo_Documento Id_Tipo_Documento_Fk;

    @Column(name = "Numero_Documento")
    private String numero_Documento;

    @Column(name = "Telefono", length = 20)
    private String telefono;

    public Clase_Chofer() {
    }

    public Clase_Chofer(Long Id_Chofer, String nombres, String apellidos, Clase_Tipo_Documento Id_Tipo_Documento_Fk, String numero_Documento, String telefono) {
        this.Id_Chofer = Id_Chofer;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.Id_Tipo_Documento_Fk = Id_Tipo_Documento_Fk;
        this.numero_Documento = numero_Documento;
        this.telefono = telefono;
    }

    public Long getId_Chofer() {
        return Id_Chofer;
    }

    public void setId_Chofer(Long Id_Chofer) {
        this.Id_Chofer = Id_Chofer;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres.toUpperCase();
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos.toUpperCase();
    }

    public Clase_Tipo_Documento getId_Tipo_Documento_Fk() {
        return Id_Tipo_Documento_Fk;
    }

    public void setId_Tipo_Documento_Fk(Clase_Tipo_Documento Id_Tipo_Documento_Fk) {
        this.Id_Tipo_Documento_Fk = Id_Tipo_Documento_Fk;
    }

    public String getNumero_Documento() {
        return numero_Documento;
    }

    public void setNumero_Documento(String numero_Documento) {
        this.numero_Documento = numero_Documento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
}
