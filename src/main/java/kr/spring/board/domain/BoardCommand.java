package kr.spring.board.domain;

import java.sql.Date;

import org.hibernate.validator.constraints.NotEmpty;

public class BoardCommand {
	private int b_num;
	@NotEmpty
	private String b_title;
	@NotEmpty
	private String b_content;
	private Date b_date;
	private int b_hit;
	private String b_ip;
	private String b_nick;
	@NotEmpty
	private String m_id;
	
	public int getB_num() {
		return b_num;
	}
	public void setB_num(int b_num) {
		this.b_num = b_num;
	}
	public String getB_title() {
		return b_title;
	}
	public void setB_title(String b_title) {
		this.b_title = b_title;
	}
	
	public String getB_content() {
		return b_content;
	}
	public void setB_content(String b_content) {
		this.b_content = b_content;
	}
	public Date getB_date() {
		return b_date;
	}
	public void setB_date(Date b_date) {
		this.b_date = b_date;
	}
	public int getB_hit() {
		return b_hit;
	}
	public void setB_hit(int b_hit) {
		this.b_hit = b_hit;
	}
	public String getB_ip() {
		return b_ip;
	}
	public void setB_ip(String b_ip) {
		this.b_ip = b_ip;
	}
	public String getB_nick() {
		return b_nick;
	}
	public void setB_nick(String b_nick) {
		this.b_nick = b_nick;
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	@Override
	public String toString() {
		return "boardCommand [b_num=" + b_num + ", b_title=" + b_title + ", b_cotent=" + b_content + ", b_date="
				+ b_date + ", b_hit=" + b_hit + ", b_ip=" + b_ip + ", b_nick=" + b_nick + ", m_id=" + m_id + "]";
	}
	
	
}
