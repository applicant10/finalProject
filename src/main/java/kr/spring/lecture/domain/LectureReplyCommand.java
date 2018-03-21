package kr.spring.lecture.domain;

import java.sql.Date;

public class LectureReplyCommand {
	private int lr_num;
	private String m_id;
	private int l_num;
	private String lr_content;
	private Date lr_date;
	private String lr_ip;
	private int lr_point;
	
	public int getLr_num() {
		return lr_num;
	}
	public void setLr_num(int lr_num) {
		this.lr_num = lr_num;
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public int getL_num() {
		return l_num;
	}
	public void setL_num(int l_num) {
		this.l_num = l_num;
	}
	public String getLr_content() {
		return lr_content;
	}
	public void setLr_content(String lr_content) {
		this.lr_content = lr_content;
	}
	public Date getLr_date() {
		return lr_date;
	}
	public void setLr_date(Date lr_date) {
		this.lr_date = lr_date;
	}
	public String getLr_ip() {
		return lr_ip;
	}
	public void setLr_ip(String lr_ip) {
		this.lr_ip = lr_ip;
	}
	public int getLr_point() {
		return lr_point;
	}
	public void setLr_point(int lr_point) {
		this.lr_point = lr_point;
	}
	@Override
	public String toString() {
		return "LectureReplyCommand [lr_num=" + lr_num + ", m_id=" + m_id + ", l_num=" + l_num + ", lr_date=" + lr_date
				+ ", lr_ip=" + lr_ip + ", lr_point=" + lr_point + "]";
	}
}