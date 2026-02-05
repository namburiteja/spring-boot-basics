package org.example.springbootbasics.repository;

import org.example.springbootbasics.entity.FlamesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlamesRepository extends JpaRepository<FlamesEntity, Long> {

}
