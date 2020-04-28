package com.example.good.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

import com.example.good.domain.model.Goods;
import com.example.good.domain.repository.GoodsRepository;

@Service
public class GoodsService {

    @Autowired
    GoodsRepository goodsRepository;

    public List<Goods> findByCategoryId(Integer categoryId) {

        //Todo pagination

        List<Goods> goodsList = Collections.emptyList();
        goodsList = goodsRepository.findPageByCategoryId(categoryId);

        return goodsList;
    }

    public Goods findOne(String goodsId) {
        return goodsRepository.findById(goodsId).orElse(null);
    }

}
