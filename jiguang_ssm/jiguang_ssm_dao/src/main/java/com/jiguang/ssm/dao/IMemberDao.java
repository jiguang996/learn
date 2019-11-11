package com.jiguang.ssm.dao;

import com.jiguang.ssm.domain.Member;
import org.apache.ibatis.annotations.Select;

public interface IMemberDao {
    @Select("select * from member  where id=#{memberId}")
    Member findByOrdersId(String memberId);
}
