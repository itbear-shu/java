package Second.service;


import Second.dao.NovelDao;
import Second.pojo.Novel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/*
 * 固定模式，不用更改
 * */
@Service
public class NovelServiceImpl implements NovelService {

    @Autowired
    private NovelDao novelDao;

    @Override
    @Transactional
    public void save(Novel novel) {
        this.novelDao.save(novel);
    }

    @Override
    public List<Novel> findAll(Novel novel) {
        /* 声明查询条件 */
        Example<Novel> example = Example.of(novel);
        //根据查询条件进行数据查询
        List<Novel> list = this.novelDao.findAll(example);
        return list;
    }
}
