package kr.spring.enterprise.domain;

import java.sql.Date;
import java.util.ArrayList;

public class EnterpriseUserCommand {
	private String enterprise_num;
	private String enterprise_name;
	private String m_nick;
	private String enterprise_ceo;
	private String enterprise_address;
	private String enterprise_address_detail;
	private String enterprise_phone_num;
	private String enterprise_pax_num;
	private String enterprise_type;
	private String enterprise_info;
	private String m_id;
	private int m_grade;
	private String enterprise_password;
	private String enterprise_password_confirm;
	private String enterprise_charge;
	private String enterprise_charge_phone;
	private String enterprise_email;
	private Date enterprise_regDate;
	private Date enterLikeDate;
	private String enterprise_postCode;
	private int enterprise_pay;
	private int enterprise_pay_percent;
	private int m_access;
	
	
	
	public int getM_access() {
		return m_access;
	}
	public void setM_access(int m_access) {
		this.m_access = m_access;
	}

	private String enterNames;
	
	public int getEnterprise_pay() {
		return enterprise_pay;
	}
	public void setEnterprise_pay(int enterprise_pay) {
		this.enterprise_pay = enterprise_pay;
	}
	public int getEnterprise_pay_percent() {
		return enterprise_pay_percent;
	}
	public void setEnterprise_pay_percent(int enterprise_pay_percent) {
		this.enterprise_pay_percent = enterprise_pay_percent;
	}
	public String getEnterprise_postCode() {
		return enterprise_postCode;
	}
	public void setEnterprise_postCode(String enterprise_postCode) {
		this.enterprise_postCode = enterprise_postCode;
	}
	public Date getEnterLikeDate() {
		return enterLikeDate;
	}
	public void setEnterLikeDate(Date enterLikeDate) {
		this.enterLikeDate = enterLikeDate;
	}

	public String getEnterNames() {
		return enterNames;
	}
	public void setEnterNames(String enterNames) {
		this.enterNames = enterNames;
	}

	private int checkAlert;
	public int getCheckAlert() {
		return checkAlert;
	}
	public void setCheckAlert(int checkAlert) {
		this.checkAlert = checkAlert;
	}

	private boolean likeOrNot;
	private String enterResume;
	private ArrayList<String> resumeList;

	public boolean isLikeOrNot() {
		return likeOrNot;
	}
	public void setLikeOrNot(String id) {
		boolean likeOrNot = false;
		for(int i=0;i<resumeList.size();i++) {
			if(resumeList.get(i).equals(id)) {
				likeOrNot = true;
				break;
			}
		}
		this.likeOrNot = likeOrNot;
	}
	
	public String getEnterResume() {
		return enterResume;
	}
	public void setEnterResume(String enterResume) {
		this.enterResume = enterResume;
	}
	
	public ArrayList<String> getResumeList() {
		return resumeList;
	}
	public void setResumeList(String enterResume) {
		String [] list = enterResume.split(",");
		ArrayList<String> resumeList = new ArrayList<String>();
		for(int i=0;i<list.length;i++) {
			resumeList.add(list[i]);
		}
		this.resumeList = resumeList;
	}
	
	public String getEnterprise_num() {
		return enterprise_num;
	}
	public void setEnterprise_num(String enterprise_num) {
		this.enterprise_num = enterprise_num;
	}
	public String getEnterprise_name() {
		return enterprise_name;
	}
	public void setEnterprise_name(String enterprise_name) {
		this.enterprise_name = enterprise_name;
	}
	public String getEnterprise_ceo() {
		return enterprise_ceo;
	}
	public void setEnterprise_ceo(String enterprise_ceo) {
		this.enterprise_ceo = enterprise_ceo;
	}
	public String getEnterprise_address() {
		return enterprise_address;
	}
	public void setEnterprise_address(String enterprise_address) {
		this.enterprise_address = enterprise_address;
	}
	public String getEnterprise_address_detail() {
		return enterprise_address_detail;
	}
	public void setEnterprise_address_detail(String enterprise_address_detail) {
		this.enterprise_address_detail = enterprise_address_detail;
	}
	public String getEnterprise_phone_num() {
		return enterprise_phone_num;
	}
	public void setEnterprise_phone_num(String enterprise_phone_num) {
		this.enterprise_phone_num = enterprise_phone_num;
	}
	public String getEnterprise_pax_num() {
		return enterprise_pax_num;
	}
	public void setEnterprise_pax_num(String enterprise_pax_num) {
		this.enterprise_pax_num = enterprise_pax_num;
	}
	public String getEnterprise_type() {
		return enterprise_type;
	}
	public void setEnterprise_type(String enterprise_type) {
		this.enterprise_type = enterprise_type;
	}
	public String getEnterprise_info() {
		return enterprise_info;
	}
	public void setEnterprise_info(String enterprise_info) {
		this.enterprise_info = enterprise_info;
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public String getEnterprise_password() {
		return enterprise_password;
	}
	public void setEnterprise_password(String enterprise_password) {
		this.enterprise_password = enterprise_password;
	}
	public String getEnterprise_password_confirm() {
		return enterprise_password_confirm;
	}
	public void setEnterprise_password_confirm(String enterprise_password_confirm) {
		this.enterprise_password_confirm = enterprise_password_confirm;
	}
	public String getEnterprise_charge() {
		return enterprise_charge;
	}
	public void setEnterprise_charge(String enterprise_charge) {
		this.enterprise_charge = enterprise_charge;
	}
	public String getEnterprise_charge_phone() {
		return enterprise_charge_phone;
	}
	public void setEnterprise_charge_phone(String enterprise_charge_phone) {
		this.enterprise_charge_phone = enterprise_charge_phone;
	}
	public String getEnterprise_email() {
		return enterprise_email;
	}
	public void setEnterprise_email(String enterprise_email) {
		this.enterprise_email = enterprise_email;
	}
	public Date getEnterprise_regDate() {
		return enterprise_regDate;
	}
	public void setEnterprise_regDate(Date enterprise_regDate) {
		this.enterprise_regDate = enterprise_regDate;
	}
	public String getM_nick() {
		return m_nick;
	}
	public void setM_nick(String m_nick) {
		this.m_nick = m_nick;
	}
	public int getM_grade() {
		return m_grade;
	}
	public void setM_grade(int m_grade) {
		this.m_grade = m_grade;
	}
	@Override
	public String toString() {
		return "EnterpriseUserCommand [enterprise_num=" + enterprise_num + ", enterprise_name=" + enterprise_name
				+ ", m_nick=" + m_nick + ", enterprise_ceo=" + enterprise_ceo + ", enterprise_address="
				+ enterprise_address + ", enterprise_address_detail=" + enterprise_address_detail
				+ ", enterprise_phone_num=" + enterprise_phone_num + ", enterprise_pax_num=" + enterprise_pax_num
				+ ", enterprise_type=" + enterprise_type + ", enterprise_info=" + enterprise_info + ", m_id=" + m_id
				+ ", m_grade=" + m_grade + ", enterprise_password=" + enterprise_password
				+ ", enterprise_password_confirm=" + enterprise_password_confirm + ", enterprise_charge="
				+ enterprise_charge + ", enterprise_charge_phone=" + enterprise_charge_phone + ", enterprise_email="
				+ enterprise_email + ", enterprise_regDate=" + enterprise_regDate + ", enterNames=" + enterNames
				+ ", checkAlert=" + checkAlert + ", likeOrNot=" + likeOrNot + ", enterResume=" + enterResume
				+ ", resumeList=" + resumeList + "]";
	}
	
}
