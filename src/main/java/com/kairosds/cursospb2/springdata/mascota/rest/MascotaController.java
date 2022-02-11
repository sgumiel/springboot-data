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

}