package kr.spring.lecture.domain;

import java.sql.Date;

import org.hibernate.validator.constraints.NotEmpty;

public class Lc_memCommand {
	@NotEmpty
	private int lc_m_num;
	@NotEmpty
	private int lc_num;
	@NotEmpty
	private int l_m_num;
	private Date comdate;
	//Ãâ·Â¿ë
	private Date lc_date;
	private Date lc_redate;
	private String lc_title;
	
	public int getLc_m_num() {
		return lc_m_num;
	}
	public void setLc_m_num(int lc_m_num) {
		this.lc_m_num = lc_m_num;
	}
	public int getLc_num() {
		return lc_num;
	}
	public void setLc_num(int lc_num) {
		this.lc_num = lc_num;
	}
	public int getL_m_num() {
		return l_m_num;
	}
	public void setL_m_num(int l_m_num) {
		this.l_m_num = l_m_num;
	}
	public Date getComdate() {
		return comdate;
	}
	public void setComdate(Date comdate) {
		this.comdate = comdate;
	}
	public Date getLc_date() {
		return lc_date;
	}
	public void setLc_date(Date lc_date) {
		this.lc_date = lc_date;
	}
	public Date getLc_redate() {
		return lc_redate;
	}
	public void setLc_redate(Date lc_redate) {
		this.lc_redate = lc_redate;
	}
	public String getLc_title() {
		return lc_title;
	}
	public void setLc_title(String lc_title) {
		this.lc_title = lc_title;
	}
	
}
