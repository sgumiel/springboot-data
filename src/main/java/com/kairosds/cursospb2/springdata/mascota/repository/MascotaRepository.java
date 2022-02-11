package com.kairosds.cursospb2.springdata.mascota.repository;

import com.kairosds.cursospb2.springdata.mascota.Mascota;
import org.springframework.data.repository.CrudRepository;

public interface MascotaRepository extends CrudRepository<Mascota, Long> {
}