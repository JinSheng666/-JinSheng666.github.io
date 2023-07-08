package com.jinsheng.service;
import com.jinsheng.domain.Brand;
import com.jinsheng.domain.PageBean;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface BrandService {
    List<Brand> selectAll();

    boolean add(Brand brand);

    boolean deleteByIds(List<Integer> ids);

    boolean deleteById(int id);

    int selectTotalCount();

    PageBean<Brand> selectByPage(int currentPage, int PageSize);


    PageBean<Brand> selectByPageAndCondition(int currentPage, int PageSize, Brand brand);

    int selectTotalCountByCondition(Brand brand);

    boolean update(Brand brand);

    Brand selectById(Integer id);
}
