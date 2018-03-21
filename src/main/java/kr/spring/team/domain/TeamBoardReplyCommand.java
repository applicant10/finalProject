package kr.spring.team.domain;

import java.sql.Date;

public class TeamBoardReplyCommand {
	private String m_nick;
	private int tb_num;
	private int re_gnum;
	private String re_gcontent;
	private Date re_gdate;
	
	public String getM_nick() {
		return m_nick;
	}
	public void setM_nick(String m_nick) {
		this.m_nick = m_nick;
	}
	public int getTb_num() {
		return tb_num;
	}
	public void setTb_num(int tb_num) {
		this.tb_num = tb_num;
	}
	public int getRe_gnum() {
		return re_gnum;
	}
	public void setRe_gnum(int re_gnum) {
		this.re_gnum = re_gnum;
	}
	public String getRe_gcontent() {
		return re_gcontent;
	}
	public void setRe_gcontent(String re_gcontent) {
		this.re_gcontent = re_gcontent;
	}
	public Date getRe_gdate() {
		return re_gdate;
	}
	public void setRe_gdate(Date re_gdate) {
		this.re_gdate = re_gdate;
	}
	@Override
	public String toString() {
		return "TeamBoardReplyCommand [m_nick=" + m_nick + ", tb_num=" + tb_num + ", re_gnum=" + re_gnum
				+ ", re_gcontent=" + re_gcontent + ", re_gdate=" + re_gdate + "]";
	}
	
	
	
}
