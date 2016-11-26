package com.fase.mapper;

import com.fase.po.Comments;

public interface CommentsMapper {
    int deleteByPrimaryKey(String cid);

    int insert(Comments record);

    int insertSelective(Comments record);

    Comments selectByPrimaryKey(String cid);

    int updateByPrimaryKeySelective(Comments record);

    int updateByPrimaryKey(Comments record);
}