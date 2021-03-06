package com.qsd.bookstore.po;

import java.io.Serializable;

/**
 * @Description 商品详情
 * @Author Esion
 * @Data 2020年6月2日
 */

public class Commodity implements Serializable {

	private static final long serialVersionUID = -6512576262267258754L;
	private Integer id;
    private String name;
    private String imageName;
    private String fileName;
    //销售量
    private Integer number;
    private Double price;
    private String category;
    //浏览量
    private Integer view;
    private String content;
    private String author;
    //上架状态
    private Boolean status;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Integer getView() {
		return view;
	}
	public void setView(Integer view) {
		this.view = view;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Commodity [id=" + id + ", name=" + name + ", imageName=" + imageName + ", fileName=" + fileName
				+ ", number=" + number + ", price=" + price + ", category=" + category + ", view=" + view + ", content="
				+ content + ", author=" + author + ", status=" + status + "]";
	}

	
}
