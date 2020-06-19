package com.qsd.bookstore.vo;

import com.qsd.bookstore.po.Safe;

/**
 * @Description 
 * @Author Esion
 * @Data 2020年6月6日
 */

public class SafeVo extends BaseVo {

	private SafeQuestion question;
	
	public SafeVo() {
	}

	public SafeVo(Integer code, String message) {
		super(code, message);
	}

	public SafeVo(Integer code, String message, Safe safe) {
		super(code, message);
		this.question = new SafeQuestion();
		this.question.setQuestion1(safe.getQuestion1());
		this.question.setQuestion2(safe.getQuestion2());
		this.question.setQuestion3(safe.getQuestion3());
	}

	public SafeQuestion getQuestion() {
		return question;
	}

	public void setQuestion(SafeQuestion question) {
		this.question = question;
	}

	class SafeQuestion{
		private String question1;
		private String question2;
		private String question3;
		public String getQuestion1() {
			return question1;
		}
		public void setQuestion1(String question1) {
			this.question1 = question1;
		}
		public String getQuestion2() {
			return question2;
		}
		public void setQuestion2(String question2) {
			this.question2 = question2;
		}
		public String getQuestion3() {
			return question3;
		}
		public void setQuestion3(String question3) {
			this.question3 = question3;
		}
	}
	
}
