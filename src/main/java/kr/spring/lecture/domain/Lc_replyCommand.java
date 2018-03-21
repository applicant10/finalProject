package kr.spring.lecture.domain;

import java.sql.Date;

public class Lc_replyCommand {
	private int lcr_num;
	private String m_id;
	private int lc_num;
	private String lcr_content;
	private Date lcr_date;
	private String lcr_ip;
	
	public int getLcr_num() {
		return lcr_num;
	}
	public void setLcr_num(int lcr_num) {
		this.lcr_num = lcr_num;
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public int getLc_num() {
		return lc_num;
	}
	public void setLc_num(int lc_num) {
		this.lc_num = lc_num;
	}
	public String getLcr_content() {
		return lcr_content;
	}
	public void setLcr_content(String lcr_content) {
		this.lcr_content = lcr_content;
	}
	public Date getLcr_date() {
		return lcr_date;
	}
	public void setLcr_date(Date lcr_date) {
		this.lcr_date = lcr_date;
	}
	public String getLcr_ip() {
		return lcr_ip;
	}
	public void setLcr_ip(String lcr_ip) {
		this.lcr_ip = lcr_ip;
	}
	@Override
	public String toString() {
		return "Lc_replyCommand [lcr_num=" + lcr_num + ", m_id=" + m_id + ", lc_num=" + lc_num + ", lcr_content="
				+ lcr_content + ", lcr_date=" + lcr_date + ", lcr_ip=" + lcr_ip + "]";
	}
}