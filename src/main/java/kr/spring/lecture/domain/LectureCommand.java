package kr.spring.lecture.domain;

import java.sql.Date;

import org.hibernate.validator.constraints.NotEmpty;

import com.sun.istack.internal.NotNull;

public class LectureCommand {
	@NotNull
	private int l_num;
	@NotEmpty
	private String l_title;
	@NotEmpty
	private String l_shortcon;
	@NotEmpty
	private String l_content;
	private Date l_date;
	private Date l_redate;
	private int l_hit;
	private float l_point;
	@NotNull
	private String l_open;
	private int l_pay;
	private String l_adv;
	private String l_donation;
	@NotNull
	private String m_id;
	@NotNull
	private int s_num;
	//join le_num
	private int l_m_num;
	private Date sDate;
	private Date eDate;
	
	//counting result
	//°­ÀÇ °¹¼ö
	private int lconCount;
	//¿Ï·á °­ÀÇ °¹¼ö
	private int lconComdateCount;
	
	public int getL_num() {
		return l_num;
	}
	public void setL_num(int l_num) {
		this.l_num = l_num;
	}
	public String getL_title() {
		return l_title;
	}
	public void setL_title(String l_title) {
		this.l_title = l_title;
	}
	public String getL_shortcon() {
		return l_shortcon;
	}
	public void setL_shortcon(String l_shorcon) {
		this.l_shortcon = l_shorcon;
	}
	public String getL_content() {
		return l_content;
	}
	public void setL_content(String l_content) {
		this.l_content = l_content;
	}
	public Date getL_date() {
		return l_date;
	}
	public void setL_date(Date l_date) {
		this.l_date = l_date;
	}
	public Date getL_redate() {
		return l_redate;
	}
	public void setL_redate(Date l_redate) {
		this.l_redate = l_redate;
	}
	public int getL_hit() {
		return l_hit;
	}
	public void setL_hit(int l_hit) {
		this.l_hit = l_hit;
	}
	public float getL_point() {
		return l_point;
	}
	public void setL_point(float l_point) {
		this.l_point = l_point;
	}
	public String getL_open() {
		return l_open;
	}
	public void setL_open(String l_open) {
		this.l_open = l_open;
	}
	public int getL_pay() {
		return l_pay;
	}
	public void setL_pay(int l_pay) {
		this.l_pay = l_pay;
	}
	public String getL_adv() {
		return l_adv;
	}
	public void setL_adv(String l_adv) {
		this.l_adv = l_adv;
	}
	public String getL_donation() {
		return l_donation;
	}
	public void setL_donation(String l_donation) {
		this.l_donation = l_donation;
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public int getS_num() {
		return s_num;
	}
	public void setS_num(int s_num) {
		this.s_num = s_num;
	}
	public int getL_m_num() {
		return l_m_num;
	}
	public void setL_m_num(int l_m_num) {
		this.l_m_num = l_m_num;
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
	public int getLconCount() {
		return lconCount;
	}
	public void setLconCount(int lconCount) {
		this.lconCount = lconCount;
	}
	public int getLconComdateCount() {
		return lconComdateCount;
	}
	public void setLconComdateCount(int lconComdateCount) {
		this.lconComdateCount = lconComdateCount;
	}
	
	@Override
	public String toString() {
		return "LectureCommand [l_num=" + l_num + ", l_title=" + l_title + ", l_date=" + l_date + ", l_redate="
				+ l_redate + ", l_hit=" + l_hit + ", l_point=" + l_point + ", l_open=" + l_open + ", l_pay=" + l_pay
				+ ", l_adv=" + l_adv + ", l_donation=" + l_donation + ", m_id=" + m_id + ", s_num=" + s_num
				+ ", l_m_num=" + l_m_num + ", sDate=" + sDate + ", eDate=" + eDate + ", lconCount=" + lconCount
				+ ", lconComdateCount=" + lconComdateCount + "]";
	}
}
