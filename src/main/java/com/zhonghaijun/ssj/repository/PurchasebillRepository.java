package com.zhonghaijun.ssj.repository;

import com.zhonghaijun.ssj.common.UserContext;
import com.zhonghaijun.ssj.domain.Position;
import com.zhonghaijun.ssj.domain.Purchasebill;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PurchasebillRepository extends BaseRepository<Purchasebill,Long> {

    @Query("select o from Purchasebill o where o.inputUser.position.parent=?1 and o.status=0")
    List<Purchasebill> findAllByPosition(Position position);

}