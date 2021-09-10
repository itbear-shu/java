package cn.jd.service;

import cn.jd.pojo.Item;

import java.util.List;
/*
 * 固定模式，不用更改
 * */
public interface ItemService {
    //保存商品
    void save(Item item);

    //根据条件查询商品
    List<Item> findAll(Item item);
}
