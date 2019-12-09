package com.zhonghaijun.ssj.repository;

import com.zhonghaijun.ssj.domain.Stockincomebill;

public interface StockincomebillRepository extends BaseRepository<Stockincomebill,Long> {

    Stockincomebill findById(Long id);
}