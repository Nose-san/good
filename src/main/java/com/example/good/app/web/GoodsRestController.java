package com.example.good.app.web;

import com.example.good.app.model.GoodsResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.example.good.domain.model.Goods;
import com.example.good.domain.service.GoodsService;

import java.util.ArrayList;
import java.util.List;

import com.github.dozermapper.core.Mapper;

@RestController
@RequestMapping("goods")
public class GoodsRestController {

    @Autowired
    GoodsService goodsService;

    @Autowired
    Mapper beanMapper;

    @GetMapping(params = "categoryId")
    public List<GoodsResource> getGoodsByCategoryId(@RequestParam("categoryId") Integer categoryId) {
        List<Goods> goodsList = goodsService.findByCategoryId(categoryId);
        List<GoodsResource> goodsResourcesList = new ArrayList<>();
        for (Goods goods : goodsList) {
            goodsResourcesList.add(beanMapper.map(goods, GoodsResource.class));
        }
        return goodsResourcesList;
    }

    @GetMapping("/{goodsId}")
    public GoodsResource getGoodsDetail(@PathVariable String goodsId) {

        Goods goods = goodsService.findOne(goodsId);
        return beanMapper.map(goods, GoodsResource.class);
    }

}
