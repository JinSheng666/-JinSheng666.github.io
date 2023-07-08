package com.jinsheng.service.impl;

import com.jinsheng.dao.BrandDao;
import com.jinsheng.domain.Brand;
import com.jinsheng.domain.PageBean;
import com.jinsheng.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    BrandDao brandDao;

    @Override
    public List<Brand> selectAll() {
        return brandDao.selectAll();
    }

    @Override
    public boolean add(Brand brand) {
        brandDao.add(brand);
        return true;
    }

    @Override
    public boolean deleteByIds(List<Integer> ids) {
        brandDao.deleteByIds(ids);
        return true;
    }

    @Override
    public boolean deleteById(int id) {
        brandDao.deleteById(id);
        return true;
    }

    @Override
    public int selectTotalCount() {
        return brandDao.selectTotalCount();
    }

    /**
     * 分页查询
     * */
    @Override
    public PageBean<Brand> selectByPage(int currentPage, int PageSize) {

        //计算开始索引
        int begin = (currentPage - 1) * PageSize;
        //计算查询条目数
        int size = PageSize;

        //查询当前页数据
        List<Brand> selectByPage = brandDao.selectByPage(begin, size);

        //查询总记录数
        int count = this.selectTotalCount();

        //封装pageBean对象
        PageBean<Brand> pageBean = new PageBean<>();
        pageBean.setRows(selectByPage);
        pageBean.setTotalCount(count);

        return pageBean;
    }

    /**
     * 分页和条件查询
     * */
    @Override
    public PageBean<Brand> selectByPageAndCondition(int currentPage, int PageSize, Brand brand) {
        //计算开始索引
        int begin = (currentPage - 1) * PageSize;
        //计算查询条目数
        int size = PageSize;

        //实现模糊查询，添加%%号
        String brandName = brand.getBrandName();
        if (brandName != null && brandName.length() > 0){
            brand.setBrandName("%"+brandName+"%");
        }

        String companyName = brand.getCompanyName();
        if (companyName != null && companyName.length() > 0){
            brand.setCompanyName("%"+companyName+"%");
        }

        //查询当前页数据
        List<Brand> selectByPageAndCondition = brandDao.selectByPageAndCondition(begin,size,brand);

        //查询总记录数
        int count = this.selectTotalCountByCondition(brand);

        System.out.println("总记录数："+count);

        //封装pageBean对象
        PageBean<Brand> pageBean = new PageBean<>();
        pageBean.setRows(selectByPageAndCondition);
        pageBean.setTotalCount(count);

        return pageBean;
    }

    /*
     * 根据条件查询计数
     * */
    @Override
    public int selectTotalCountByCondition(Brand brand) {
        return brandDao.selectTotalCountByCondition(brand);
    }

    @Override
    public boolean update(Brand brand) {
        brandDao.update(brand);
        return true;
    }

    @Override
    public Brand selectById(Integer id) {
        return brandDao.selectById(id);
    }

}
