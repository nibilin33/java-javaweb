package com.fase.po;

import java.math.BigDecimal;
import java.util.List;

public class TComment {
	private String id;// id  
	private String customerId;// 用户id  
	private String parentCommentId;// 父评论id  
	private String contentId;// 内容id  
	private String content;// 评论内容  
	private String commetDate;// 评论日期  
	private String commetTime;// 评论时间  
	private BigDecimal state;// 评论的状态  
	private BigDecimal type;// 评论类型  
	private List<TComment> replyComment; // 评论回复信息  
	private Fuser customer;// 评论者信息  
	private Fuser replyCustomer; // 回复评论的人 
	  
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getParentCommentId() {
		return parentCommentId;
	}
	public void setParentCommentId(String parentCommentId) {
		this.parentCommentId = parentCommentId;
	}
	public String getContentId() {
		return contentId;
	}
	public void setContentId(String contentId) {
		this.contentId = contentId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCommetDate() {
		return commetDate;
	}
	public void setCommetDate(String commetDate) {
		this.commetDate = commetDate;
	}
	public String getCommetTime() {
		return commetTime;
	}
	public void setCommetTime(String commetTime) {
		this.commetTime = commetTime;
	}
	public BigDecimal getState() {
		return state;
	}
	public void setState(BigDecimal state) {
		this.state = state;
	}
	public BigDecimal getType() {
		return type;
	}
	public void setType(BigDecimal type) {
		this.type = type;
	}
	public List<TComment> getReplyComment() {
		return replyComment;
	}
	public void setReplyComment(List<TComment> replyComment) {
		this.replyComment = replyComment;
	}
	public Fuser getCustomer() {
		return customer;
	}
	public void setCustomer(Fuser customer) {
		this.customer = customer;
	}
	public Fuser getReplyCustomer() {
		return replyCustomer;
	}
	public void setReplyCustomer(Fuser replyCustomer) {
		this.replyCustomer = replyCustomer;
	}
}
