package com.zhonghaijun.ssj.repository;

import com.zhonghaijun.ssj.domain.Systemdictionarydetail;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SystemdictionarydetailRepository extends BaseRepository<Systemdictionarydetail,Long> {

    @Query("select d from Systemdictionarydetail d join d.types ty where ty.sn=?1")
    List<Systemdictionarydetail> findDetailsBySn(String sn);

}