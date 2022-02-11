package com.kairosds.cursospb2.springdata.customrepo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

@NoRepositoryBean
public interface CustomRepository<ENTITY, ID>  extends CrudRepository<ENTITY, ID> {
    Optional<ENTITY> findByCodigo(Long codigo);
}
