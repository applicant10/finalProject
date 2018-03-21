package kr.spring.enterprise.service;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.spring.enterprise.domain.EnterpriseUserCommand;
import kr.spring.resume.domain.UserResumeCommand;

@Transactional
@Service("enterpriseUserService")
public interface EnterpriseUserService {
	public String enterM_idSelect(String m_id);
	public String memberM_idSelect(String m_id);
	public String enterResumeSelect(String m_id);
	public String enterPassword(String m_id);
	public List<UserResumeCommand> enPriSelect();
	public EnterpriseUserCommand enPriInfoSelect(String m_id);
	public List<UserResumeCommand> selectById(String m_id);
	public List<UserResumeCommand> selectByJob(String r_job);
	public List<UserResumeCommand> addResume(int num);
	public List<EnterpriseUserCommand> selectEnterpriseUser(String m_id);
	public EnterpriseUserCommand enterDetailAllSelect(String m_id);
	public UserResumeCommand selectAllResume(String m_id);
	public List<UserResumeCommand> selectAlloption(UserResumeCommand command);
	public List<UserResumeCommand> selectByLoc(String loc); 
	public List<EnterpriseUserCommand> enterM_idSelectAll();
	
	public void whoLikesModify(String m_id);
	public void enterResumeUpdate(String id);
	public void enterpriseInfoModify(EnterpriseUserCommand enterpriseUserCommand);
	
	public void enterLikeResume(EnterpriseUserCommand enterpriseUserCommand);
	public void enPriRegister(EnterpriseUserCommand enterpriseUserCommand);
	public void enPriUserInsert(EnterpriseUserCommand enterpriseUserCommand);
	public void enterResumeInsert(EnterpriseUserCommand enterpriseUserCommand);
	
	public void enterResumeDelete(String id);
	public void enterResumeDeleteAll(String m_id);
	public void enterMemberDelete(String id);
	public void enterDetailDelete(String id);
	public void enterLikeDelete(String m_id);
}
