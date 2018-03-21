package kr.spring.resume.domain;

import java.io.IOException;
import java.sql.Date;
import java.util.Arrays;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import com.sun.istack.internal.NotNull;

public class UserResumeCommand {
	//회원 상세 정보
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
	
	//-----------------------------------------------------------------------
	
	//이력서 테이블
	@NotEmpty
	private String r_loc;//희망 근무지
	private String r_price;//희망 급여
	private String r_job;//희망 업무
	private String r_intro;//자기소개
	private String r_guitar;//기타
	private MultipartFile r_picture;
	private byte[] r_pic;//사진
	private String r_pname;
	private String r_type;
	private Date r_date;
	private int r_num;
	private String publicType;

	public String getPublicType() {
		return publicType;
	}
	public void setPublicType(String publicType) {
		this.publicType = publicType;
	}
	public int getR_num() {
		return r_num;
	}
	public void setR_num(int r_num) {
		this.r_num = r_num;
	}
	public String getR_type() {
		return r_type;
	}
	public void setR_type(String r_type) {
		this.r_type = r_type;
	}
	public MultipartFile getR_picture() {
		return r_picture;
	}
	public void setR_picture(MultipartFile r_picture) throws IOException{
		this.r_picture = r_picture;
		setR_pic(r_picture.getBytes());
		setR_pname(r_picture.getOriginalFilename());
	}
	public String getR_pname() {
		return r_pname;
	}
	public void setR_pname(String r_pname) {
		this.r_pname = r_pname;
	}
	public String getR_loc() {
		return r_loc;
	}
	public void setR_loc(String r_loc) {
		this.r_loc = r_loc;
	}
	public String getR_price() {
		return r_price;
	}
	public void setR_price(String r_price) {
		this.r_price = r_price;
	}
	public String getR_job() {
		return r_job;
	}
	public void setR_job(String r_job) {
		this.r_job = r_job;
	}
	public String getR_intro() {
		return r_intro;
	}
	public void setR_intro(String r_intro) {
		this.r_intro = r_intro;
	}
	public String getR_guitar() {
		return r_guitar;
	}
	public void setR_guitar(String r_guitar) {
		this.r_guitar = r_guitar;
	}
	public byte[] getR_pic() {
		return r_pic;
	}
	public void setR_pic(byte[] r_pic) {
		this.r_pic = r_pic;
	}
	public Date getR_date() {
		return r_date;
	}
	public void setR_date(Date r_date) {
		this.r_date = r_date;
	}
	
	//-----------------------------------------------------------------------
	
	//자격증 테이블
	private String l_name;//자격증 이름
	private String l_com;//발급기관
	private String l_year;//발금 연도


	public String getL_name() {
		return l_name;
	}
	public void setL_name(String l_name) {
		this.l_name = l_name;
	}
	public String getL_com() {
		return l_com;
	}
	public void setL_com(String l_com) {
		this.l_com = l_com;
	}
	public String getL_year() {
		return l_year;
	}
	public void setL_year(String l_year) {
		this.l_year = l_year;
	}
	
	
	//-----------------------------------------------------------------------

	//포트 폴리오 테이블
	private String fname;//포폴 명
	private byte[] fbytes;//포폴 파일
	private MultipartFile fFile;

	public MultipartFile getfFile() {
		return fFile;
	}
	public void setfFile(MultipartFile fFile) throws IOException{
		this.fFile = fFile;
		setFname(fFile.getOriginalFilename());
		setFbytes(fFile.getBytes());
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public byte[] getFbytes() {
		return fbytes;
	}
	public void setFbytes(byte[] fbytes) {
		this.fbytes = fbytes;
	}
	
	//-----------------------------------------------------------------------
	
	//취미
	private String h_name;//취미명
	//취미 사진 추후 넣을것


	public String getH_name() {
		return h_name;
	}
	public void setH_name(String h_name) {
		this.h_name = h_name;
	}
	
	//-----------------------------------------------------------------------
	
	//학력
	private String a_title;//학교명
	private Date a_ed;//졸업일
	private String a_grade;//초,중,고 선택 사항


	public String getA_title() {
		return a_title;
	}
	public void setA_title(String a_title) {
		this.a_title = a_title;
	}
	public Date getA_ed() {
		return a_ed;
	}
	public void setA_ed(Date a_ed) {
		this.a_ed = a_ed;
	}
	public String getA_grade() {
		return a_grade;
	}
	public void setA_grade(String a_grade) {
		this.a_grade = a_grade;
	}
	
	//-----------------------------------------------------------------------
	
	//수상 경력
	private String rc_title;//수상명
	private String rc_inst;//수여기관
	private Date rc_year;//수상 연도
	private String rc_content;//수상 내용


	public String getRc_title() {
		return rc_title;
	}
	public void setRc_title(String rc_title) {
		this.rc_title = rc_title;
	}
	public String getRc_inst() {
		return rc_inst;
	}
	public void setRc_inst(String rc_inst) {
		this.rc_inst = rc_inst;
	}
	public Date getRc_year() {
		return rc_year;
	}
	public void setRc_year(Date rc_year) {
		this.rc_year = rc_year;
	}
	public String getRc_content() {
		return rc_content;
	}
	public void setRc_content(String rc_content) {
		this.rc_content = rc_content;
	}
	
	
	//-----------------------------------------------------------------------
	
	//경력
	private String rl_title;//회사명
	private String rl_position;//직급
	private String rl_sd;//시작일
	private String rl_ed;//종료일
	private String rl_def;//직무 내용


	public String getRl_title() {
		return rl_title;
	}
	public void setRl_title(String rl_title) {
		this.rl_title = rl_title;
	}
	public String getRl_position() {
		return rl_position;
	}
	public void setRl_position(String rl_position) {
		this.rl_position = rl_position;
	}
	public String getRl_sd() {
		return rl_sd;
	}
	public void setRl_sd(String rl_sd) {
		this.rl_sd = rl_sd;
	}
	public String getRl_ed() {
		return rl_ed;
	}
	public void setRl_ed(String rl_ed) {
		this.rl_ed = rl_ed;
	}
	public String getRl_def() {
		return rl_def;
	}
	public void setRl_def(String rl_def) {
		this.rl_def = rl_def;
	}
	
	
	//-----------------------------------------------------------------------

	@Override
	public String toString() {
		return "UserResumeCommand [m_id=" + m_id + ", m_pw=" + m_pw + ", m_grade=" + m_grade + ", m_nick=" + m_nick
				+ ", md_name=" + md_name + ", md_phone=" + md_phone + ", r_loc=" + r_loc + ", r_price=" + r_price
				+ ", r_job=" + r_job + ", r_intro=" + r_intro + ", r_guitar=" + r_guitar
				 + ", r_date=" + r_date + ", l_name=" + l_name + ", l_com=" + l_com
				+ ", l_year=" + l_year + ", fname=" + fname + ",  h_name="
				+ h_name + ", a_title=" + a_title + ", a_ed=" + a_ed + ", a_grade=" + a_grade + ", rc_title=" + rc_title
				+ ", rc_inst=" + rc_inst + ", rc_year=" + rc_year + ", rc_content=" + rc_content + ", rl_title="
				+ rl_title + ", rl_position=" + rl_position + ", rl_sd=" + rl_sd + ", rl_ed=" + rl_ed + ", rl_def="
				+ rl_def + "]";
	}
	
}




































