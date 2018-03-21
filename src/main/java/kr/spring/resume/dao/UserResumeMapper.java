package kr.spring.resume.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.spring.resume.domain.UserResumeCommand;

public interface UserResumeMapper {
	@Select("select * from resume join member using(m_id) where rownum <=12")
	public List<UserResumeCommand> selectAll();
	@Select("select * from resume join member using(m_id) where rownum <=12 and publictype='public'")
	public List<UserResumeCommand> selectPublicResume();
	
	@Select("select * from resume where m_id=#{m_id}")
	public UserResumeCommand selectResume(String m_id);//이력서 진입시
	@Select("select * from career where m_id=#{m_id}")
	public UserResumeCommand selectCareer(String m_id);
	@Select("select * from awards where m_id=#{m_id}")
	public UserResumeCommand selectAwards(String id);
	@Select("select * from achieve where m_id=#{m_id}")
	public UserResumeCommand selectAchieve(String id);
	@Select("select * from hobby where m_id=#{m_id}")
	public UserResumeCommand selectHobby(String id);
	@Select("select * from license where m_id=#{m_id}")
	public UserResumeCommand selectLicense(String id);
	@Select("select * from portfolio where m_id=#{m_id}")
	public UserResumeCommand selectPortfolio(String id);
	
	@Select("select m_id from member where m_id=#{m_id}")
	public String checkUserId(String id);
	@Select("select enterprise_num from enterprise where enterprise_num=#{enterprise_num}")
	public String checkUserNum(String num);
	
	@Select("select * from member join member_detail using(m_id) where m_id=#{m_id}")
	public UserResumeCommand selectUserInfo(String id);
	
	@Insert("insert into resume(m_id,r_loc,r_price,r_job,r_intro,r_guitar,r_pic,r_pname,r_date,r_type,r_num,publicType) values(#{m_id},#{r_loc},#{r_price},#{r_job},#{r_intro},#{r_guitar},#{r_pic},#{r_pname},sysdate,#{r_type},r_seq.nextval,#{publicType})")
	public void insertResumeBasic(UserResumeCommand resumeCommand);//기본 정보 입력
	@Insert("insert into career values(#{m_id},#{rl_title},#{rl_position},#{rl_sd},#{rl_ed},#{rl_def})")
	public void insertCareer(UserResumeCommand resumeCommand);//커리어 입력
	@Insert("insert into awards values(#{m_id},#{rc_title},#{rc_inst},#{rc_year},#{rc_content})")
	public void insertAwards(UserResumeCommand resumeCommand);//수상경력 입력
	@Insert("insert into achieve values(#{m_id},#{a_title},#{a_ed},#{a_grade})")
	public void insertAchieve(UserResumeCommand resumeCommand);//학력 입력
	@Insert("insert into hobby values(#{m_id},#{h_name})")
	public void insertHobby(UserResumeCommand resumeCommand);//취미 입력
	@Insert("insert into license values(#{m_id},#{l_name},#{l_com},#{l_year})")
	public void insertLicense(UserResumeCommand resumeCommand);//자격증 입력
	@Insert("insert into portfolio values(#{m_id},#{fname},#{fbytes})")
	public void insertPortfolio(UserResumeCommand resumeCommand);//포트 폴리오 입력
	@Insert("insert into member_detail(md_name,md_phone) values(#{md_name},#{md_phone})")
	public void insertNaPho(UserResumeCommand resumeCommand);
	
	@Update("update resume set r_loc=#{r_loc},r_price=#{r_price},r_job=#{r_job},r_intro=#{r_intro},r_guitar=#{r_guitar},r_pic=#{r_pic},r_pname=#{r_pname},r_date=sysdate,r_type=#{r_type},publicType=#{publicType} where m_id=#{m_id}")
	public void modifyResumeGeneral(UserResumeCommand resumeCommand);
	@Update("update career set rl_title=#{rl_title},rl_position=#{rl_position},rl_sd=#{rl_sd},rl_ed=#{rl_ed},rl_def=#{rl_def} where m_id=#{m_id}")
	public void modifyResumeCareer(UserResumeCommand resumeCommand);
	@Update("update awards set rc_title=#{rc_title},rc_inst=#{rc_inst},rc_year=#{rc_year},rc_content=#{rc_content} where m_id=#{m_id}")
	public void modifyResumeAwards(UserResumeCommand resumeCommand);
	@Update("update achieve set a_title=#{a_title},a_ed=#{a_ed},a_grade=#{a_grade} where m_id=#{m_id}")
	public void modifyResumeAchieve(UserResumeCommand resumeCommand);
	@Update("update hobby set h_name=#{h_name} where m_id=#{m_id}")
	public void modifyResumeHobby(UserResumeCommand resumeCommand);
	@Update("update license set l_name=#{l_name},l_com=#{l_com},l_year=#{l_year} where m_id=#{m_id}")
	public void modifyResumeLicense(UserResumeCommand resumeCommand);
	@Update("update portfolio set fname=#{fname},fbytes=#{fbytes} where m_id=#{m_id}")
	public void modifyResumePortfolio(UserResumeCommand resumeCommand);
	@Update("update member_detail set md_name=#{md_name},md_phone=#{md_phone} where m_id=#{m_id}")
	public void modifyNaPho(UserResumeCommand resumeCommand);
	
	@Delete("delete from resume where m_id=#{m_id}")
	public void deleteResumeGeneral(String m_id);
	@Delete("delete from career where m_id=#{m_id}")
	public void deleteCareer(String m_id);
	@Delete("delete from awards where m_id=#{m_id}")
	public void deleteAwards(String m_id);
	@Delete("delete from achieve where m_id=#{m_id}")
	public void deleteAchieve(String m_id);
	@Delete("delete from hobby where m_id=#{m_id}")
	public void deleteHobby(String m_id);
	@Delete("delete from license where m_id=#{m_id}")
	public void deleteLicense(String m_id);
	@Delete("delete from portfolio where m_id=#{m_id}")
	public void deletePortfolio(String m_id);
}


















