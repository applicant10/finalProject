package kr.spring.study.domain;

import java.sql.Date;

public class StudyReplyCommand {
	private String m_nick;
	private int t_num;
	private int re_tnum;
	private String re_tcontent;
	private Date re_tdate;
	
	public String getM_nick() {
		return m_nick;
	}
	public void setM_nick(String m_nick) {
		this.m_nick = m_nick;
	}
	public int getT_num() {
		return t_num;
	}
	public void setT_num(int t_num) {
		this.t_num = t_num;
	}
	public int getRe_tnum() {
		return re_tnum;
	}
	public void setRe_tnum(int re_tnum) {
		this.re_tnum = re_tnum;
	}
	public String getRe_tcontent() {
		return re_tcontent;
	}
	public void setRe_tcontent(String re_tcontent) {
		this.re_tcontent = re_tcontent;
	}
	public Date getRe_tdate() {
		return re_tdate;
	}
	public void setRe_tdate(Date re_tdate) {
		this.re_tdate = re_tdate;
	}
	@Override
	public String toString() {
		return "StudyReplyCommand [m_nick=" + m_nick + ", t_num=" + t_num + ", re_tnum=" + re_tnum + ", re_tcontent="
				+ re_tcontent + ", re_tdate=" + re_tdate + "]";
	}
	
	
}
