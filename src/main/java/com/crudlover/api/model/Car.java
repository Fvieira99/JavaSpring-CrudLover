package com.crudlover.api.model;


import java.util.Date;

import com.crudlover.api.dto.CarDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Car {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String modelo;
    
    @Column(nullable = false)
    private String fabricante;

    @Column(nullable = false)
    private Date dataFabricacao;
    
    @Column(nullable = false)
    private double valor;
    
    @Column(nullable = false)
    private int anoModelo;

    public Car(CarDTO car){
        this.modelo = car.modelo();
        this.fabricante = car.fabricante();
        this.dataFabricacao = car.dataFabricacao();
        this.valor = car.valor();
        this.anoModelo = car.anoModelo();
    }

}

