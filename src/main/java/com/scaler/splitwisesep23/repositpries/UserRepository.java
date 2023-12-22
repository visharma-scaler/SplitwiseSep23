package com.scaler.splitwisesep23.repositpries;

import com.scaler.splitwisesep23.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
