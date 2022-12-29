package com.sdmcdemo.sdmc.repository;

import com.sdmcdemo.sdmc.model.user;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userRepository extends JpaRepository<user, Long> {
}
