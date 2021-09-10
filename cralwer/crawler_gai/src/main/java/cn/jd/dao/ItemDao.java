package cn.jd.dao;

import cn.jd.pojo.Item;
import org.springframework.data.jpa.repository.JpaRepository;
/*
* 固定模式，不用更改
* */
public interface ItemDao extends JpaRepository<Item, Long> {

}
