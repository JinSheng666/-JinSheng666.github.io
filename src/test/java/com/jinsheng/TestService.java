package com.jinsheng;

import com.jinsheng.config.springConfig;
import com.jinsheng.domain.Brand;
import com.jinsheng.service.BrandService;
import com.jinsheng.service.impl.BrandServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = springConfig.class)
public class TestService {

    @Autowired
    BrandService brandService;

    @Test
    public void testPage(){
        Brand brand = new Brand();

        brand.setBrandName("华为");
        brand.setCompanyName("华为技术有限公司");
        brand.setStatus(1);

        brandService.selectByPageAndCondition(1,20,brand);
    }

    @Test
    public void testCount(){
        Brand brand = new Brand();

        brand.setBrandName("华为");
        brand.setCompanyName("华为技术有限公司");
        brand.setStatus(1);

        brandService.selectTotalCountByCondition(brand);
    }
}
