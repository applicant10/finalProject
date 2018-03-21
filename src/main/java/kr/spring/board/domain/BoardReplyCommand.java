package kr.spring.board.domain;

import java.sql.Date;

public class BoardReplyCommand {
	private int br_num;
	private String br_content;
	private Date br_date;
	private String br_ip;
	private String b_num;
	private String m_id;
	
	public int getBr_num() {
		return br_num;
	}
	public void setBr_num(int br_num) {
		this.br_num = br_num;
	}
	public String getBr_content() {
		return br_content;
	}
	public void setBr_content(String br_content) {
		this.br_content = br_content;
	}
	public Date getBr_date() {
		return br_date;
	}
	public void setBr_date(Date br_date) {
		this.br_date = br_date;
	}
	public String getBr_ip() {
		return br_ip;
	}
	public void setBr_ip(String br_ip) {
		this.br_ip = br_ip;
	}
	public String getB_num() {
		return b_num;
	}
	public void setB_num(String b_num) {
		this.b_num = b_num;
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	@Override
	public String toString() {
		return "QboardReplyCommand [br_num=" + br_num + ", br_content=" + br_content + ", br_date=" + br_date
				+ ", br_ip=" + br_ip + ", b_num=" + b_num + ", m_id=" + m_id + "]";
	}
	
	
}
