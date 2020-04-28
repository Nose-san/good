package com.example.good.domain.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.good.domain.model.Goods;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Mapper
public interface GoodsRepository {

    List<Goods> findPageByCategoryId(int categoryId);

    Optional<Goods> findById(String id);
}
