/**
 * 
 */
package com.hailooo.entity;

import java.util.List;
import java.util.Map;

/**
 * @author yuhongliang
 * 会议实体
 */
public class Meet  extends BaseEntity{
	
	// 基本属性
	private String title;
	private String imgUrl;
	private String publisher;
	private String time;
	private String addr;
	private String ticketPrice;
	private String summary;
	private List<Theme> themes;
	private List<Map<String, Integer>> ids;
	private int categoryId;
	private int comment;
	private int collection;
	private String sponsor;
	private String coSponsor;
	private int publish;
	
	public Meet() {
		
	}
	public Meet(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getTicketPrice() {
		return ticketPrice;
	}
	public void setTicketPrice(String ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public int getComment() {
		return comment;
	}
	public void setComment(int comment) {
		this.comment = comment;
	}
	public int getCollection() {
		return collection;
	}
	public void setCollection(int collection) {
		this.collection = collection;
	}
	public String getSponsor() {
		return sponsor;
	}
	public void setSponsor(String sponsor) {
		this.sponsor = sponsor;
	}
	public String getCoSponsor() {
		return coSponsor;
	}
	public void setCoSponsor(String coSponsor) {
		this.coSponsor = coSponsor;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public List<Theme> getThemes() {
		return themes;
	}
	public void setThemes(List<Theme> themes) {
		this.themes = themes;
	}
	public int getPublish() {
		return publish;
	}
	public void setPublish(int publish) {
		this.publish = publish;
	}
	public List<Map<String, Integer>> getIds() {
		return ids;
	}
	public void setIds(List<Map<String, Integer>> ids) {
		this.ids = ids;
	}
}
