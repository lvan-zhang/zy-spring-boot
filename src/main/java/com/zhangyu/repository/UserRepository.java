package com.zhangyu.repository;

import com.zhangyu.model.UserForJpa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserForJpa, Long> {
}
