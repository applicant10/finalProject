package kr.spring.member.domain;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.sun.istack.internal.NotNull;

public class MemberCommand {
	@Email
	@NotEmpty
	private String m_id;
	@NotEmpty
	private String m_pw;
	@NotNull
	private int m_grade;
	@NotEmpty
	private String m_nick;
	private String md_name;
	private String md_phone;
	private int m_access;

	public int getM_access() {
		return m_access;
	}

	public void setM_access(int m_access) {
		this.m_access = m_access;
	}

	public boolean isCheckedPasswd(String userPasswd) {
		if(m_grade>0 && m_pw.equals(userPasswd)) {
			return true;
		}
		return false;
	}
	
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public String getM_pw() {
		return m_pw;
	}
	public void setM_pw(String m_pw) {
		this.m_pw = m_pw;
	}
	public int getM_grade() {
		return m_grade;
	}
	public void setM_grade(int m_grade) {
		this.m_grade = m_grade;
	}
	public String getM_nick() {
		return m_nick;
	}
	public void setM_nick(String m_nick) {
		this.m_nick = m_nick;
	}
	public String getMd_name() {
		return md_name;
	}
	public void setMd_name(String md_name) {
		this.md_name = md_name;
	}
	public String getMd_phone() {
		return md_phone;
	}
	public void setMd_phone(String md_phone) {
		this.md_phone = md_phone;
	}

	@Override
	public String toString() {
		return "MemberCommand [m_id=" + m_id + ", m_pw=" + m_pw + ", m_grade=" + m_grade + ", m_nick=" + m_nick
				+ ", md_name=" + md_name + ", md_phone=" + md_phone + ", m_access=" + m_access + "]";
	}
	
	
	
	
}
