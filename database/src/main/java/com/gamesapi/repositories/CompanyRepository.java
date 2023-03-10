package com.gamesapi.repositories;

import com.gamesapi.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Integer> {
    Optional<Company> findBySourceId(int id);

}
