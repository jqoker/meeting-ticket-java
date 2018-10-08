/**
 * 
 */
package com.brickjs.entity;

/**
 * 会议主题
 * @author yuhongliang
 *
 */
public class Theme extends BaseEntity {
	private String title;
	private String content;
	private int meetId;
	private int authorId;
	private Author author;
	
	public Theme() {
		
	}
	public Theme(int id) {
		this.id = id;
	}
	public int getMeetId() {
		return meetId;
	}
	public void setMeetId(int meetId) {
		this.meetId = meetId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getAuthorId() {
		return authorId;
	}
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
}
