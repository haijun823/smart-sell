package com.zhonghaijun.ssj.service.impl;

import com.zhonghaijun.ssj.domain.Depot;
import com.zhonghaijun.ssj.domain.Employee;
import com.zhonghaijun.ssj.domain.Stockincomebill;
import com.zhonghaijun.ssj.repository.StockincomebillRepository;
import com.zhonghaijun.ssj.service.StockincomebillService;
import com.zhonghaijun.ssj.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class StockincomebillServiceImpl extends BaseServiceImpl<Stockincomebill,Long> implements StockincomebillService {
    @Autowired
    private StockincomebillRepository stockincomebillRepository;




   //审核订单
    public void auding(Long id, Employee employee){
        Stockincomebill bill = stockincomebillRepository.findById(id);
        if (bill == null) {
            throw new RuntimeException("没有此订单");
        }
        if (bill.getStatus() == 1){
            throw new RuntimeException("此订单已经被审核了");
        }
        if (bill.getStatus() == -1) {
            throw new RuntimeException("此入库单已经作废");
        }
        //设置状态，审核人，审核时间
        bill.setAuditor(employee);
        bill.setAuditortime(new Date());
        bill.setStatus(1);
        //审核完就保存
        merge(bill);

        //获得仓库，将货物存入
        Depot depot = bill.getDepot();
        //设置当前容量
        depot.setCurrentCapacity(depot.getCurrentCapacity().add(bill.getTotalnum()));
        //设置总金额
        depot.setTotalAmount(depot.getTotalAmount().add(bill.getTotalamount()));

    }
}