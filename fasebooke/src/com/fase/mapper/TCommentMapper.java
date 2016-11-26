package com.fase.mapper;

import java.util.List;
import java.util.Map;

import com.fase.po.TComment;

public interface TCommentMapper {
 public void selectparentbyid(Map<String, Object> param);
 public void selectreplybyid(Map<String, Object> param);
 public void selectemotionbyid(Map<String,Object>param);
 public Integer insertcomment(TComment cooment);
 
}
