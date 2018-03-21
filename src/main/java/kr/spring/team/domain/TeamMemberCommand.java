package kr.spring.team.domain;

import java.sql.Date;

public class TeamMemberCommand {
	private String m_nick;
	private int g_num;
	private String g_name;
	private String g_type;
	private String g_greet;
	private Date g_date;
	
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
	public String getG_name() {
		return g_name;
	}
	public void setG_name(String g_name) {
		this.g_name = g_name;
	}
	public String getG_type() {
		return g_type;
	}
	public void setG_type(String g_type) {
		this.g_type = g_type;
	}
	public String getG_greet() {
		return g_greet;
	}
	public void setG_greet(String g_greet) {
		this.g_greet = g_greet;
	}
	public Date getG_date() {
		return g_date;
	}
	public void setG_date(Date g_date) {
		this.g_date = g_date;
	}
	
	@Override
	public String toString() {
		return "TeamMemberCommand [m_nick=" + m_nick + ", g_num=" + g_num + ", g_name=" + g_name + ", g_type=" + g_type
				+ ", g_greet=" + g_greet + ", g_date=" + g_date + "]";
	}
	
	
	
}
