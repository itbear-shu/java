package Second.service;

import Second.pojo.Novel;

import java.util.List;

/*
 * 固定模式，不用更改
 * */
public interface NovelService {
    //保存商品
    void save(Novel novel);

    //根据条件查询商品
    List<Novel> findAll(Novel novel);
}
