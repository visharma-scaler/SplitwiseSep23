package com.scaler.splitwisesep23.repositpries;

import com.scaler.splitwisesep23.models.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {
}
