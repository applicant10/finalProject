package kr.spring.lecture.domain;

import java.sql.Date;

import org.hibernate.validator.constraints.NotEmpty;

public class Le_numCommand {
	@NotEmpty
	private int l_m_num;
	@NotEmpty
	private int l_num;
	@NotEmpty
	private String m_id;
	@NotEmpty
	private Date sDate;
	private Date eDate;
	//Ãâ·Â¿ë
	private String l_title;
	
	public int getL_m_num() {
		return l_m_num;
	}
	public void setL_m_num(int l_m_num) {
		this.l_m_num = l_m_num;
	}
	public int getL_num() {
		return l_num;
	}
	public void setL_num(int l_num) {
		this.l_num = l_num;
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public Date getsDate() {
		return sDate;
	}
	public void setsDate(Date sDate) {
		this.sDate = sDate;
	}
	public Date geteDate() {
		return eDate;
	}
	public void seteDate(Date eDate) {
		this.eDate = eDate;
	}
	public String getL_title() {
		return l_title;
	}
	public void setL_title(String l_title) {
		this.l_title = l_title;
	}
}
