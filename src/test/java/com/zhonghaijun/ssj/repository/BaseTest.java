package com.zhonghaijun.ssj.repository;

import com.zhonghaijun.ssj.domain.Menu;
import com.zhonghaijun.ssj.domain.Product;
import com.zhonghaijun.ssj.domain.Producttype;
import com.zhonghaijun.ssj.query.ProducttypeQuery;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class BaseTest {
    @Autowired
    private MenuRepository repository;

    @Test
    @Transactional
    public void test(){
        List<Menu> list = repository.findMenusByEmployee(1L);
        ArrayList<Menu> parentList = new ArrayList<>();
        for (Menu menu : list) {
            Menu parent = menu.getParent();
            if (!parentList.contains(parent)){
                parentList.add(parent);
                parent.getChildren().add(menu);
            }else {
                int i = parentList.indexOf(parent);
                Menu m = parentList.get(i);
                m.getChildren().add(menu);
            }
        }
        for (Menu menu : parentList) {
            System.out.println(menu.getName());
            menu.getChildren().forEach(e -> System.out.println(e));
        }
    }

    @Autowired
    private ProductRepository productRepository;
    @Test
    @Transactional
    public void test2(){
        List<Product> list = productRepository.findProductsAll();
        for (Product product : list) {
//            System.out.println(product.getBrandid());
        }
    }
    @Autowired
    private  ProducttypeRepository producttypeRepository;
    @Test
    public void test3(){
        ProducttypeQuery query = new ProducttypeQuery();

        List<Producttype> list = producttypeRepository.findAllByQuery(query);
        for (Producttype p : list) {
            System.out.println(p);
        }
    }

}
