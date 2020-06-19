package com.qsd.bookstore.po;

import java.io.Serializable;

/**
 * @Description 商品评论表
 * @Author Esion
 * @Data 2020年6月18日
 */

public class Comment implements Serializable {

	private static final long serialVersionUID = 4666827094944775297L;
	//评论表的表名
	private String commentName;
	//ID
	private Integer id;
	//评论的用户名
	private String username;
	//评论的内容
	private String content;
	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Comment(String username, String content) {
		super();
		this.username = username;
		this.content = content;
	}
	public String getCommentName() {
		return commentName;
	}
	public void setCommentName(String commentName) {
		this.commentName = commentName;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
}
