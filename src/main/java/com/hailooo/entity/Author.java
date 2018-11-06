/**
 * 
 */
package com.hailooo.entity;

/**
 * @author yuhongliang
 * 嘉宾实体
 */
public class Author extends BaseEntity {
	
	private String name;
	private String summary;
	private String avatarImgUrl;
	private String positionalTitle;
	private String profession;
	private String company;
	private String blogSiteUrl;
	private String githubSiteUrl;
	private String telephone;
	private String email;
	private String interest; // 兴趣爱好
	private int praise;	// 点赞数
	private int collection;	// 关注数
	
	public Author() {
		
	}
	
	public Author(int id) {
		this.id = id;
	}
	
	public Author(int id, String name, String summary) {
		this.id = id;
		this.name = name;
		this.summary = summary;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getAvatarImgUrl() {
		return avatarImgUrl;
	}
	public void setAvatarImgUrl(String avatarImgUrl) {
		this.avatarImgUrl = avatarImgUrl;
	}
	public String getPositionalTitle() {
		return positionalTitle;
	}
	public void setPositionalTitle(String positionalTitle) {
		this.positionalTitle = positionalTitle;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getBlogSiteUrl() {
		return blogSiteUrl;
	}
	public void setBlogSiteUrl(String blogSiteUrl) {
		this.blogSiteUrl = blogSiteUrl;
	}
	public String getGithubSiteUrl() {
		return githubSiteUrl;
	}
	public void setGithubSiteUrl(String githubSiteUrl) {
		this.githubSiteUrl = githubSiteUrl;
	}
	public String getInterest() {
		return interest;
	}
	public void setInterest(String interest) {
		this.interest = interest;
	}
	public int getPraise() {
		return praise;
	}
	public void setPraise(int praise) {
		this.praise = praise;
	}
	public int getCollection() {
		return collection;
	}
	public void setCollection(int collection) {
		this.collection = collection;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
}
