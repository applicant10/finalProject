package kr.spring.enterprise.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.spring.enterprise.domain.EnterpriseUserCommand;
import kr.spring.resume.domain.UserResumeCommand;

public interface EnterpriseUserMapper {
	@Delete("delete from member where m_id=#{m_id}")
	public void enterMemberDelete(String id);
	@Delete("delete from enterprise where m_id=#{m_id}")
	public void enterDetailDelete(String id);
	@Update("update enterResume set enterresume=#{enterResume}")
	public void enterResumeDelete(String id);
	@Delete("delete from enterResume where m_id=#{m_id}")
	public void enterResumeDeleteAll(String m_id);
	@Delete("delete from enterlikeresume where m_id=#{m_id}")
	public void enterLikeDelete(String m_id);
	
	@Update("update enterResume set enterresume=#{enterResume}")
	public void enterResumeUpdate(String id);
	public void enterpriseInfoModify(EnterpriseUserCommand enterpriseUserCommand);
	@Update("update enterlikeresume set checkalert=0 where m_id=#{m_id}")
	public void whoLikesModify(String m_id);
	
	public void enPriRegister(EnterpriseUserCommand enterpriseUserCommand);
	@Insert("insert into member values(#{m_id},#{m_nick},20,0)")
	public void enPriUserInsert(EnterpriseUserCommand enterpriseUserCommand);
	@Insert("insert into enterResume values(#{m_id},#{enterResume})")
	public void enterResumeInsert(EnterpriseUserCommand enterpriseUserCommand);
	@Insert("insert into enterLikeResume values(#{m_id},#{enterNames},#{checkAlert},#{enterprise_charge},#{enterprise_email},sysdate)")
	public void enterLikeResume(EnterpriseUserCommand enterpriseUserCommand);
	
	@Select("select m_id from enterprise where m_id=#{m_id}")
	public String enterM_idSelect(String m_id);
	@Select("select * from member where m_grade>=20 and m_grade<30")
	public List<EnterpriseUserCommand> enterM_idSelectAll();
	@Select("select * from enterprise where m_id=#{m_id}")
	public EnterpriseUserCommand enterDetailAllSelect(String m_id);
	@Select("select * from resume where m_id=#{m_id}")
	public UserResumeCommand selectAllResume(String m_id);
	@Select("select m_id from member where m_id=#{m_id}")
	public String memberM_idSelect(String m_id);
	@Select("select * from enterprise join member using(m_id) where m_id=#{m_id}")
	public EnterpriseUserCommand enPriInfoSelect(String m_id);
	@Select("select * from resume order by r_num asc")
	public List<UserResumeCommand> enPriSelect();
	@Select("select * from resume where r_num>=#{num} order by r_num asc")
	public List<UserResumeCommand> addResume(int num);
	@Select("select * from resume where r_loc=#{r_loc} and m_id like '%'||#{m_id}||'%'")
	public List<UserResumeCommand> selectAlloption(UserResumeCommand command);
	@Select("select * from resume where r_loc=#{r_loc}")
	public List<UserResumeCommand> selectByLoc(String loc); 
	@Select("select * from resume where m_id like '%'||#{m_id}||'%'")
	public List<UserResumeCommand> selectById(String m_id);
	@Select("select * from resume where r_job=#{r_job}")
	public List<UserResumeCommand> selectByJob(String r_job);
	@Select("select enterresume from enterResume where m_id=#{m_id}")
	public String enterResumeSelect(String m_id);
	@Select("select * from enterlikeresume where m_id=#{m_id}")
	public List<EnterpriseUserCommand> selectEnterpriseUser(String m_id);
	@Select("select * from enterlikeresume where m_id=#{m_id} and enterprise_email=#{enterprise_email}")
	public EnterpriseUserCommand selectExisteAlert(String id,String email);
	@Select("select enterprise_password from enterprise where m_id=#{m_id}")
	public String enterPassword(String m_id);
}































