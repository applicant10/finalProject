package kr.spring.record.domain;

import java.sql.Date;

public class RecordCommand {
	private int g_num;
	private String m_nick;
	private String record;
	private Date r_date;
	private String g_name;
	private String r_content;
	
	public int getG_num() {
		return g_num;
	}
	public void setG_num(int g_num) {
		this.g_num = g_num;
	}
	public String getG_name() {
		return g_name;
	}
	public String getR_content() {
		return r_content;
	}
	public void setR_content(String r_content) {
		this.r_content = r_content;
	}
	public void setG_name(String g_name) {
		this.g_name = g_name;
	}
	public String getM_nick() {
		return m_nick;
	}
	public void setM_nick(String m_nick) {
		this.m_nick = m_nick;
	}
	public String getRecord() {
		return record;
	}
	public void setRecord(String record) {
		this.record = record;
	}
	public Date getR_date() {
		return r_date;
	}
	public void setR_date(Date r_date) {
		this.r_date = r_date;
	}
	@Override
	public String toString() {
		return "RecordCommand [m_nick=" + m_nick + ", record=" + record + ", r_date=" + r_date + ", g_name=" + g_name
				+ ", r_content=" + r_content + "]";
	}
	
	
}
