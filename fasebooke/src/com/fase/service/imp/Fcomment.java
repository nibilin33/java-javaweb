package com.fase.service.imp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fase.iservice.Icommentservice;
import com.fase.mapper.TCommentMapper;
import com.fase.po.DynamicInfo;
import com.fase.po.TComment;
@Service
@Transactional
public class Fcomment implements Icommentservice {
	@Resource
	TCommentMapper tdao;

	@Override
	public List<TComment> findParentCommentByItemId(Map<String, Object> param) {
		// TODO 自动生成的方法存根
	     tdao.selectparentbyid(param);
		List<TComment> info=(List<TComment>) param.get("result");
		return info;
	}

	@Override
	public List<TComment> findReplyCommentByCommentId(Map<String, Object> param) {
		// TODO 自动生成的方法存根
		tdao.selectreplybyid(param);
		List<TComment> info=(List<TComment>) param.get("result");
		return info;
	}

	@Override
	public Integer InsertComment(TComment t) {
		// TODO 自动生成的方法存根
		return tdao.insertcomment(t);
	}




}
