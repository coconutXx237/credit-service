package com.klimkin.msdeal.repository;

import com.klimkin.msdeal.entity.Application;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ApplicationRepository extends CrudRepository<Application, Long> {

    Optional<Application> findByApplicationId(Long applicationId);
}
