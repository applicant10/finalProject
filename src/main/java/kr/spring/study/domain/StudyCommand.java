package kr.spring.study.domain;

import java.sql.Date;


import org.hibernate.validator.constraints.NotEmpty;

public class StudyCommand {
	private String m_nick;
	private int g_num;
	private String g_type;
	private int t_num;
	@NotEmpty
	private String t_area;
	@NotEmpty
	private String t_sub;
	@NotEmpty
	private String t_title;
	@NotEmpty
	private String t_content;
	private Date t_date;
	
	public String getM_nick() {
		return m_nick;
	}
	public void setM_nick(String m_nick) {
		this.m_nick = m_nick;
	}
	public int getG_num() {
		return g_num;
	}
	public void setG_num(int g_num) {
		this.g_num = g_num;
	}
	public String getG_type() {
		return g_type;
	}
	public void setG_type(String g_type) {
		this.g_type = g_type;
	}
	public int getT_num() {
		return t_num;
	}
	public void setT_num(int t_num) {
		this.t_num = t_num;
	}
	public String getT_area() {
		return t_area;
	}
	public void setT_area(String t_area) {
		this.t_area = t_area;
	}
	public String getT_sub() {
		return t_sub;
	}
	public void setT_sub(String t_sub) {
		this.t_sub = t_sub;
	}
	public String getT_title() {
		return t_title;
	}
	public void setT_title(String t_title) {
		this.t_title = t_title;
	}
	public String getT_content() {
		return t_content;
	}
	public void setT_content(String t_content) {
		this.t_content = t_content;
	}
	public Date getT_date() {
		return t_date;
	}
	public void setT_date(Date t_date) {
		this.t_date = t_date;
	}
	@Override
	public String toString() {
		return "StudyCommand [m_nick=" + m_nick + ", g_num=" + g_num + ", g_type=" + g_type + ", t_num=" + t_num
				+ ", t_area=" + t_area + ", t_sub=" + t_sub + ", t_title=" + t_title + ", t_content=" + t_content
				+ ", t_date=" + t_date + "]";
	}
		
	
}

