/**
 * 
 */
package com.hailooo.entity;

/**
 * 会议主题
 * @author yuhongliang
 *
 */
public class Theme extends BaseEntity {
	private String title;
	private String content;
	private int meetId;
	private int speakerId;
	private Speaker speaker;
	
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
	public int getSpeakerId() {
		return speakerId;
	}
	public void setSpeakerId(int speakerId) {
		this.speakerId = speakerId;
	}
	public Speaker getSpeaker() {
		return speaker;
	}
	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}
}
