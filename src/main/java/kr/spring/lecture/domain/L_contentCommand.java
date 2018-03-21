package kr.spring.lecture.domain;

import java.sql.Date;

import org.hibernate.validator.constraints.NotEmpty;

import com.sun.istack.internal.NotNull;

public class L_contentCommand {
	private int lc_num;
	@NotEmpty
	private String lc_title;
	@NotEmpty
	private String lc_content;
	private Date lc_date;
	private Date lc_redate;
	private int lc_hit;
	@NotNull
	private int lc_sequence;
	@NotNull
	private int l_num;
	//출력&join용 변수
	//lc_m_num 기본키
	private int lc_m_num;
	//강의 수강 완료 컬럼
	private Date comdate;
	//강의_회원(수강) 테이블 기본키
	private int l_m_num;
	
	public int getLc_num() {
		return lc_num;
	}
	public void setLc_num(int lc_num) {
		this.lc_num = lc_num;
	}
	public String getLc_title() {
		return lc_title;
	}
	public void setLc_title(String lc_title) {
		this.lc_title = lc_title;
	}
	public String getLc_content() {
		return lc_content;
	}
	public void setLc_content(String lc_content) {
		this.lc_content = lc_content;
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
	public int getLc_hit() {
		return lc_hit;
	}
	public void setLc_hit(int lc_hit) {
		this.lc_hit = lc_hit;
	}
	public int getL_num() {
		return l_num;
	}
	public void setL_num(int l_num) {
		this.l_num = l_num;
	}
	public int getLc_m_num() {
		return lc_m_num;
	}
	public void setLc_m_num(int lc_m_num) {
		this.lc_m_num = lc_m_num;
	}
	public Date getComdate() {
		return comdate;
	}
	public void setComdate(Date comdate) {
		this.comdate = comdate;
	}
	public int getL_m_num() {
		return l_m_num;
	}
	public void setL_m_num(int l_m_num) {
		this.l_m_num = l_m_num;
	}
	public int getLc_sequence() {
		return lc_sequence;
	}
	public void setLc_sequence(int lc_sequence) {
		this.lc_sequence = lc_sequence;
	}
	@Override
	public String toString() {
		return "L_contentCommand [lc_num=" + lc_num + ", lc_title=" + lc_title + ", lc_date=" + lc_date + ", lc_redate="
				+ lc_redate + ", lc_hit=" + lc_hit + ", lc_sequence=" + lc_sequence + ", l_num=" + l_num + ", lc_m_num="
				+ lc_m_num + ", comdate=" + comdate + ", l_m_num=" + l_m_num + "]";
	}
	
}
