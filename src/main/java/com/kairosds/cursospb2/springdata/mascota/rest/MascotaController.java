package com.kairosds.cursospb2.springdata.mascota.rest;

import com.kairosds.cursospb2.springdata.mascota.Mascota;
import com.kairosds.cursospb2.springdata.mascota.repository.MascotaRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/mascota")
public class MascotaController {

    private final MascotaRepository mascotaRepository;

    @GetMapping
    public List<Mascota> findAll(){
        return (List<Mascota>) this.mascotaRepository.findAll();
    }

    @PostMapping
    public Mascota createMascota(@RequestBody Mascota mascota) {
        final var mascotaSaved = this.mascotaRepository.save(mascota);
        return mascotaSaved;
    }

    @GetMapping(value = "/search", params = "nombre")
    public List<Mascota> findByName(@RequestParam("nombre") String name) {
        return this.mascotaRepository.findByNombre(name);
    }

    @GetMapping("/perro")
    public List<Mascota> findAllPerro(){
        return this.mascotaRepository.findAllPerros();
    }

    @GetMapping(value = "/search", params = "raza")
    public List<Mascota> findAllByRaza(@RequestParam(value = "raza") String raza) {
        return this.mascotaRepository.findAllByRaza(raza);
    }



}