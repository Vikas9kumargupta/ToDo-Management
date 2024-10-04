package com.vikasLearning.todo.repository;

import com.vikasLearning.todo.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
}
