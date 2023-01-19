package com.crudlover.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crudlover.api.dto.CarDTO;
import com.crudlover.api.model.Car;
import com.crudlover.api.repository.CarRepository;

import jakarta.validation.Valid;


@RequestMapping("/car")
@RestController
public class CarController {
    
    @Autowired
    private CarRepository carRepository;


    @PostMapping("/create")
    public void createCar(@RequestBody @Valid CarDTO req){
        carRepository.save(new Car(req));
    }

    @GetMapping("/listall")
    public List<Car> listAll(){
        return carRepository.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id ){
        carRepository.deleteById(id);
    }

    @PutMapping("/update/{id}")
    public void update(@PathVariable Long id, @RequestBody @Valid CarDTO req){
        carRepository.findById(id).map(car -> {
            car.setAnoModelo(req.anoModelo());
            car.setDataFabricacao(req.dataFabricacao());
            car.setFabricante(req.fabricante());
            car.setModelo(req.modelo());
            car.setValor(req.valor());
            return carRepository.save(car);
        });
    }
}
