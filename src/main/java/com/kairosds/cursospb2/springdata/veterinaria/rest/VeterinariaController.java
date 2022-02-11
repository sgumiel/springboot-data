package com.kairosds.cursospb2.springdata.veterinaria.rest;

import java.util.List;

import com.kairosds.cursospb2.springdata.veterinaria.Veterinaria;
import com.kairosds.cursospb2.springdata.veterinaria.repository.VeterinariaRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/veterinaria")
public class VeterinariaController {

    private final VeterinariaRepository veterinariaRepository;

    @GetMapping
    public List<Veterinaria> findAll(){
        return (List)this.veterinariaRepository.findAll();
    }

    @GetMapping("/search")
    public ResponseEntity<Veterinaria> findByCodigo(@RequestParam Long codigo) {
        return this.veterinariaRepository.findByCodigo(codigo)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}