package Second.dao;

import Second.pojo.Novel;
import org.springframework.data.jpa.repository.JpaRepository;

/*
* 固定模式，不用更改
* */
public interface NovelDao extends JpaRepository<Novel, Long> {

}
