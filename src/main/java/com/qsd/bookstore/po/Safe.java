package com.qsd.bookstore.po;

/**
 * @Description 
 * @Author Esion
 * @Data 2020年6月6日
 */

public class Safe {
	
	private String token;
	private String question1;
	private String answer1;
	private String question2;
	private String answer2;
	private String question3;
	private String answer3;
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getQuestion1() {
		return question1;
	}
	public void setQuestion1(String question1) {
		this.question1 = question1;
	}
	public String getAnswer1() {
		return answer1;
	}
	public void setAnswer1(String answer1) {
		this.answer1 = answer1;
	}
	public String getQuestion2() {
		return question2;
	}
	public void setQuestion2(String question2) {
		this.question2 = question2;
	}
	public String getAnswer2() {
		return answer2;
	}
	public void setAnswer2(String answer2) {
		this.answer2 = answer2;
	}
	public String getQuestion3() {
		return question3;
	}
	public void setQuestion3(String question3) {
		this.question3 = question3;
	}
	public String getAnswer3() {
		return answer3;
	}
	public void setAnswer3(String answer3) {
		this.answer3 = answer3;
	}
	@Override
	public String toString() {
		return "Safe [token=" + token + ", question1=" + question1 + ", answer1=" + answer1 + ", question2=" + question2
				+ ", answer2=" + answer2 + ", question3=" + question3 + ", answer3=" + answer3 + "]";
	}

}
