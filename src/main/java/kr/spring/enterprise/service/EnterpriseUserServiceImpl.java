package kr.spring.enterprise.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.spring.enterprise.dao.EnterpriseUserMapper;
import kr.spring.enterprise.domain.EnterpriseUserCommand;
import kr.spring.resume.domain.UserResumeCommand;

@Service("enterpriseUserService")
public class EnterpriseUserServiceImpl implements EnterpriseUserService{
	
	@Resource
	private EnterpriseUserMapper enterpriseUserMapper;
	
	@Override
	public void enPriRegister(EnterpriseUserCommand enterpriseUserCommand) {
		enterpriseUserMapper.enPriRegister(enterpriseUserCommand);
	}

	@Override
	public List<UserResumeCommand> enPriSelect() {
		List<UserResumeCommand> list = new ArrayList<UserResumeCommand>();
		list = enterpriseUserMapper.enPriSelect();
		return list;
	}

	@Override
	public void enPriUserInsert(EnterpriseUserCommand enterpriseUserCommand) {
		enterpriseUserMapper.enPriUserInsert(enterpriseUserCommand);
	}

	@Override
	public EnterpriseUserCommand enPriInfoSelect(String m_id) {
		
		EnterpriseUserCommand enterpriseUserCommand = enterpriseUserMapper.enPriInfoSelect(m_id);
		
		return enterpriseUserCommand;
	}

	@Override
	public String enterResumeSelect(String m_id) {
		String enterResume = enterpriseUserMapper.enterResumeSelect(m_id);
		return enterResume;
	}

	@Override
	public void enterResumeInsert(EnterpriseUserCommand enterpriseUserCommand) {
		enterpriseUserMapper.enterResumeInsert(enterpriseUserCommand);
	}

	@Override
	public void enterResumeUpdate(String id) {
		enterpriseUserMapper.enterResumeUpdate(id);
	}

	@Override
	public void enterResumeDelete(String id) {
		enterpriseUserMapper.enterResumeDelete(id);
	}

	@Override
	public void enterResumeDeleteAll(String m_id) {
		enterpriseUserMapper.enterResumeDeleteAll(m_id);
	}

	@Override
	public String enterM_idSelect(String m_id) {
		String id = enterpriseUserMapper.enterM_idSelect(m_id);
		return id;
	}

	@Override
	public String memberM_idSelect(String m_id) {
		String id = enterpriseUserMapper.memberM_idSelect(m_id);
		return id;
	}

	@Override
	public void enterMemberDelete(String id) {
		enterpriseUserMapper.enterMemberDelete(id);
	}

	@Override
	public void enterDetailDelete(String id) {
		enterpriseUserMapper.enterDetailDelete(id);
	}

	@Override
	public void enterpriseInfoModify(EnterpriseUserCommand enterpriseUserCommand) {
		enterpriseUserMapper.enterpriseInfoModify(enterpriseUserCommand);
	}

	@Override
	public List<UserResumeCommand> selectById(String m_id) {
		List<UserResumeCommand> list = new ArrayList<UserResumeCommand>();
		list = enterpriseUserMapper.selectById(m_id);
		return list;
	}

	@Override
	public List<UserResumeCommand> selectByJob(String r_job) {
		List<UserResumeCommand> list = new ArrayList<UserResumeCommand>();
		list = enterpriseUserMapper.selectByJob(r_job);
		return list;
	}

	@Override
	public List<UserResumeCommand> addResume(int num) {
		List<UserResumeCommand> list = new ArrayList<UserResumeCommand>();
		list = enterpriseUserMapper.addResume(num);
		return list;
	}

	@Override
	public void enterLikeResume(EnterpriseUserCommand enterpriseUserCommand) {
		enterpriseUserMapper.enterLikeResume(enterpriseUserCommand);
	}

	@Override
	public List<EnterpriseUserCommand> selectEnterpriseUser(String m_id) {
		List<EnterpriseUserCommand> list = new ArrayList<EnterpriseUserCommand>();
		list = enterpriseUserMapper.selectEnterpriseUser(m_id);
		return list;
	}

	@Override
	public void whoLikesModify(String m_id) {
		enterpriseUserMapper.whoLikesModify(m_id);
	}

	@Override
	public EnterpriseUserCommand enterDetailAllSelect(String m_id) {
		EnterpriseUserCommand enterpriseUserCommand = enterpriseUserMapper.enterDetailAllSelect(m_id);
		
		return enterpriseUserCommand;
	}

	@Override
	public void enterLikeDelete(String m_id) {
		enterpriseUserMapper.enterLikeDelete(m_id);
	}

	@Override
	public UserResumeCommand selectAllResume(String m_id) {
		UserResumeCommand userResumeCommand = enterpriseUserMapper.selectAllResume(m_id);
		return userResumeCommand;
	}

	@Override
	public String enterPassword(String m_id) {
		String password = enterpriseUserMapper.enterPassword(m_id);
		return password;
	}

	@Override
	public List<UserResumeCommand> selectAlloption(UserResumeCommand command) {
		List<UserResumeCommand> list = new ArrayList<UserResumeCommand>();
		list = enterpriseUserMapper.selectAlloption(command);
		return list;
	}

	@Override
	public List<UserResumeCommand> selectByLoc(String loc) {
		List<UserResumeCommand> list = new ArrayList<UserResumeCommand>();
		list = enterpriseUserMapper.selectByLoc(loc);
		return list;
	}
	@Override
	public List<EnterpriseUserCommand> enterM_idSelectAll() {
		List<EnterpriseUserCommand> list = enterpriseUserMapper.enterM_idSelectAll();
		return list;
	}
}
