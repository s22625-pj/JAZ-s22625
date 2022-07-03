package com.example.jazs22625.repository;

import com.example.jazs22625.model.Database;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NBPRepo extends JpaRepository<Database,Long> {
}
