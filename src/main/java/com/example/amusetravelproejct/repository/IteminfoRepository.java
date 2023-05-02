package com.example.amusetravelproejct.repository;

import com.example.amusetravelproejct.domain.ItemEstimation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IteminfoRepository extends JpaRepository<Iteminfo, Long> {
    Iteminfo findByItemCode(String itemCode);

}
