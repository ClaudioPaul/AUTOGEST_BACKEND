/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.app.Autogest.dao;

import com.app.Autogest.entity.Clase_Citas;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 *
 * @author CLAUDIO CRUZADO
 */
public interface IClaseCitasDao extends JpaRepository<Clase_Citas, Long> {

}
