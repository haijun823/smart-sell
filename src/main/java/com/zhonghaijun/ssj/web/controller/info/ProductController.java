package com.zhonghaijun.ssj.web.controller.info;

import com.zhonghaijun.ssj.common.PageDate;
import com.zhonghaijun.ssj.domain.Product;
import com.zhonghaijun.ssj.query.ProductQuery;
import com.zhonghaijun.ssj.service.ProductService;
import net.coobird.thumbnailator.Thumbnails;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;


@Controller
@RequestMapping("product")
public class ProductController {
    
    @Autowired
    private ProductService service;

    @RequestMapping("/index")
    public String  index(){
        return "info/product";
    }

    //lostinfo这是给查询出来的对象命名，解决数据丢失，在所有方法执行前会执行的方法
    @ModelAttribute("lostinfo")
    public Product lostInfo(Product product,String cmd){
        if (product.getId() != null&&"upd".equals(cmd)){
            product = service.findOne(product.getId());
            //修改的时候会导致数据丢失，比如头像没有上传或者密码没有修改时
            System.out.println(product);
            product.setTypesId(null);
            product.setUnitId(null);
            product.setBrandId(null);
        }
        return product;
    }
    //获得所有数据
    @RequestMapping("/getall")
    @ResponseBody
    public PageDate<Product> getall(ProductQuery query, String search){
        return new PageDate<Product>(service.findPageByQuery(query));
    }
    //修改
    @RequestMapping("/upd")
    @ResponseBody
    //这是让e对象来引用上面查询出来的对象，并且在底层就对其赋值，可以让没有赋值的值有值
    public String updoradd(@ModelAttribute("lostinfo") Product product,MultipartFile fileImage,HttpServletRequest request){
        //boolean isMulitpart = ServletFileUpload.isMultipartContent(request);
        uploadImage(product, fileImage, request);
        service.merge(product);
        return "成功";
    }

    //上传图片
    public void uploadImage(Product product,MultipartFile fileImage,HttpServletRequest request){
        if (fileImage!=null){
            //删除掉旧的图片
            if (product.getId()!=null&& StringUtils.isNotBlank(product.getPic())){
                //大图和缩略图,删除掉
                String maxPic = product.getPic();
                String smallpic = product.getSmallpic();
                String maxRealPath = request.getServletContext().getRealPath(maxPic);
                String smallRealPath = request.getServletContext().getRealPath(smallpic);
                File file = new File(maxRealPath);
                File file1 = new File(smallRealPath);
                if (file.exists()&&file1.exists()){
                    file.delete();
                    file1.delete();
                }
            }
            try {
                //大图的路径,新名称
                String maxPath = "/images/"+ UUID.randomUUID().toString().substring(0,4)+fileImage.getOriginalFilename();
                String smallPath = "/images/"+ UUID.randomUUID().toString().substring(0,4)+fileImage.getOriginalFilename();
                //获得物理路径
                String realPath = request.getServletContext().getRealPath("/");
                File small = new File(realPath,smallPath);
                File max = new File(realPath,maxPath);

                //将图片保存在web上的路径
                FileCopyUtils.copy(fileImage.getInputStream(), new FileOutputStream(max));
                //处理缩略图,将图片转换成缩略图
                Thumbnails.of(fileImage.getInputStream()).scale(0.1F).toFile(small);
                //保存到数据库
                product.setPic(maxPath);
                product.setSmallpic(smallPath);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    //删除
    @RequestMapping("/del")
    @ResponseBody
    public String del(String id){
        try {
            service.del(Long.parseLong(id));
        } catch (Exception e) {
            return "删除失败";
        }
        return "删除成功!!";
    }
    //添加
    @RequestMapping("/add")
    @ResponseBody
    public String add(Product product,MultipartFile fileImage){
        service.merge(product);
        return "添加成功!!";
    }
    //根据id查找
    @RequestMapping("/findOne")
    @ResponseBody
    public Product findOne(Long id){
        return service.findOne(id);
    }
}