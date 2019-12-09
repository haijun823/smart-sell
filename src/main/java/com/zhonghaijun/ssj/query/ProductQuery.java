package com.zhonghaijun.ssj.query;

import com.zhonghaijun.ssj.domain.Product;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import com.github.wenhao.jpa.Specifications;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

public class ProductQuery extends BaseQuery {

                                            
                                        
                                        
                                        
                                        
                                        
                                        
                                        
                                        
                

        private String name;
        private String color;
        private String pic;
        private String smallpic;
        private Double costprice;
        private Double saleprice;
        private Long typesId;
        private Long unitId;
        private Long brandId;

    @Override
    //高级查询
    public Specification getSpec() {
        Specification<Product> specification = Specifications.<Product>and()
        .like(StringUtils.isNotBlank(name),"name","%"+name+"%").build();          
        return specification;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }
    
    public String getSmallpic() {
        return smallpic;
    }

    public void setSmallpic(String smallpic) {
        this.smallpic = smallpic;
    }
    
    public Double getCostprice() {
        return costprice;
    }

    public void setCostprice(Double costprice) {
        this.costprice = costprice;
    }
    
    public Double getSaleprice() {
        return saleprice;
    }

    public void setSaleprice(Double saleprice) {
        this.saleprice = saleprice;
    }
    
    public Long getTypesId() {
        return typesId;
    }

    public void setTypesId(Long typesId) {
        this.typesId = typesId;
    }
    
    public Long getUnitId() {
        return unitId;
    }

    public void setUnitId(Long unitId) {
        this.unitId = unitId;
    }
    
    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }
}