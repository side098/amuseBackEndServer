package com.example.amusetravelproejct.repository;

import com.example.amusetravelproejct.domain.DisplayCategory;
import com.example.amusetravelproejct.domain.HashTag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DisplayCategoryRepository extends JpaRepository<DisplayCategory, Long> {

    Optional<DisplayCategory> findByHashTag(HashTag hashTag);
}
