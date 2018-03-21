package kr.spring.team.domain;

import java.sql.Date;

public class TeamAppliCommand {
	private String m_nick;
	private int g_num;
	private String a_content;
	private Date a_date;
	private int a_num;
	
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
	public String getA_content() {
		return a_content;
	}
	public void setA_content(String a_content) {
		this.a_content = a_content;
	}
	public Date getA_date() {
		return a_date;
	}
	public void setA_date(Date a_date) {
		this.a_date = a_date;
	}
	public int getA_num() {
		return a_num;
	}
	public void setA_num(int a_num) {
		this.a_num = a_num;
	}
	@Override
	public String toString() {
		return "TeamAppliCommand [m_nick=" + m_nick + ", g_num=" + g_num + ", a_content="
				+ a_content + ", a_date=" + a_date + ", a_num=" + a_num + "]";
	}
	
	
	
}
