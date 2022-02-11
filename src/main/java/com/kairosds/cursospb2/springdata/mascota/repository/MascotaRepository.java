package com.kairosds.cursospb2.springdata.mascota.repository;

import com.kairosds.cursospb2.springdata.mascota.Mascota;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MascotaRepository extends CrudRepository<Mascota, Long> {

    List<Mascota> findByNombre(String nombre);

    @Query("select m from Mascota m where m.animal = 'perro'")
    public List<Mascota> findAllPerros();

    @Query(value = "select * from mascota m where m.raza = :raza", nativeQuery = true)
    List<Mascota> findAllByRaza(@Param("raza") String raza);

}