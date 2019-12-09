package com.zhonghaijun.ssj.web.controller.info;

import com.zhonghaijun.ssj.common.PageDate;
import com.zhonghaijun.ssj.domain.Job;
import com.zhonghaijun.ssj.query.JobQuery;
import com.zhonghaijun.ssj.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;


@Controller
@RequestMapping("job")
public class JobController {
    
    @Autowired
    private JobService service;

    //lostinfo这是给查询出来的对象命名，解决数据丢失，在所有方法执行前会执行的方法
    @ModelAttribute("lostinfo")
    public Job lostInfo(Job job,String cmd){
        if (job.getId() != null&&"upd".equals(cmd)){
            job = service.findOne(job.getId());
            //修改的时候会导致数据丢失，比如头像没有上传或者密码没有修改时
            return job;
        }
        return job;
    }
    @RequestMapping("/index")
    public String  index(){
        return "info/Job";
    }

    //获得所有数据
    @RequestMapping("/findAll")
    @ResponseBody
    public PageDate<Job> getall(JobQuery query){
        return new PageDate<Job>(service.findPageByQuery(query));
    }
    //修改
    @RequestMapping("/upd")
    @ResponseBody
    //这是让e对象来引用上面查询出来的对象，并且在底层就对其赋值，可以让没有赋值的值有值
    public String upd(@ModelAttribute("lostinfo") Job e){
        service.merge(e);
        return "修改成功";
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
    public String add(Job job){
        service.merge(job);
        return "添加成功!!";
    }
    //根据id查找
    @RequestMapping("/getone")
    @ResponseBody
    public Job getone(Long id){
        return service.findOne(id);
    }
}