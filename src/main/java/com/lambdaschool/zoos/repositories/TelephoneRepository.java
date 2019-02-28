package com.lambdaschool.zoos.repositories;

import com.lambdaschool.zoos.models.Telephone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelephoneRepository extends JpaRepository<Telephone, Long> {
}
