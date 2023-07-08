package com.jinsheng.controller;

import com.jinsheng.domain.Brand;
import com.jinsheng.domain.PageBean;
import com.jinsheng.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;

@RestController
@RequestMapping("/brands")
public class BrandController {

    @Autowired
    private BrandService brandService;

    /**
     * 回显数据，id查询
     * */
    @GetMapping("/{id}")
    public Result selectById(@PathVariable Integer id){
        //数据
        Brand brand = brandService.selectById(id);
        //编码
        Integer code = brand != null ? Code.SELECT_OK : Code.SELECT_ERR;
        //信息
        String msg = brand != null ? "success" : "数据查询失败！";
        return new Result(code,brand,msg);
    }

    /**
     * 查询所有
     * */
    @GetMapping
    public Result selectAll(){

        List<Brand> brand = brandService.selectAll();
        //编码
        Integer code = brand != null ? Code.SELECT_ALL_OK : Code.SELECT_ALL_REE;
        //信息
        String msg = brand != null ? "success" : "所有数据查询失败！";

        System.out.println(msg);

        return new Result(code,brand,msg);
    }

    /**
     * 添加数据
     *
     * */
    @PostMapping
    public Result add(@RequestBody Brand brand){
        boolean add =  brandService.add(brand);

        Integer code = add ? Code.INSERT_OK : Code.INSERT_ERR;

        String msg = add ? "success" : "数据添加错误";

        System.out.println(msg);
        return new Result(code,add,msg);
    }

    /**
     * 根据id删除
     * */
    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable Integer id){
        boolean delete = brandService.deleteById(id);

        Integer code = delete ? Code.DELETE_OK : Code.DELETE_ERR;

        return new Result(code,delete);
    }

    /**
     * 根据id删除多个
     * */
    @DeleteMapping
    public Result deleteByIds(@RequestBody List<Integer> ids){
        boolean delById = brandService.deleteByIds(ids);

        Integer code = delById ? Code.DELETE_ALL_OK : Code.DELETE_ALL_ERR;

        String msg = delById ? "success" : "批量删除失败";

        return new Result(code,delById,msg);
    }

    /**
     * 修改数据
     * */
    @PutMapping
    public Result update(@RequestBody Brand brand){

        boolean update = brandService.update(brand);

        Integer code = update ? Code.UPDATE_OK : Code.UPDATE_ERR;

        return new Result(code,update);
    }

    /**
     * 分页查询
     * */
    @PostMapping(params = {"currentPage","pageSize"})
    public Result selectByPage(@RequestParam("currentPage") int currentPage,@RequestParam("pageSize") int pageSize){

        PageBean<Brand> selectByPage= brandService.selectByPage(currentPage, pageSize);

        Integer code = selectByPage !=null ? Code.BRAND_PAGE_OK : Code.BRAND_PAGE_REE;

        String msg = selectByPage !=null ? "success" : "分页数据查询错误";

        System.out.println(msg);
        return new Result(code,selectByPage,msg);

    }

    /**
     * 分页条件查询
     * */
    @PostMapping("/{currentPage}/{PageSize}")
    public Result selectByPageAndCondition(@PathVariable int currentPage,@PathVariable int PageSize,@RequestBody Brand brand){

        PageBean<Brand> brandPageBean = brandService.selectByPageAndCondition(currentPage, PageSize, brand);

        Integer code = brandPageBean !=null ? Code.PAGE_CONDITION_OK : Code.PAGE_CONDITION_REE;

        String msg = brandPageBean !=null ? "success" : "分页条件查询错误";

        return new Result(code,brandPageBean,msg);
    }
}
