package com.fase.iservice;

import java.util.List;
import java.util.Map;

import com.fase.po.TComment;

public interface Icommentservice {
	List<TComment> findParentCommentByItemId(Map<String, Object> param);
	List<TComment> findReplyCommentByCommentId(Map<String, Object> param);
	Integer InsertComment(TComment t);
}
