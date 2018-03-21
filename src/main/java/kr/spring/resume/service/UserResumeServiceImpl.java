package kr.spring.resume.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.spring.resume.dao.UserResumeMapper;
import kr.spring.resume.domain.UserResumeCommand;

@Service("userResumeService")
public class UserResumeServiceImpl implements UserResumeService{
	
	@Resource
	private UserResumeService userResumeService;
	
	@Resource
	private UserResumeMapper userResumeMapper;
	
	//--------------------select
	@Override
	public UserResumeCommand selectResume(String id) {
		UserResumeCommand resumeCommand = new UserResumeCommand();
		resumeCommand = userResumeMapper.selectResume(id);
		return resumeCommand;
	}
	@Override
	public UserResumeCommand selectCareer(String m_id) {
		UserResumeCommand resumeCommand = new UserResumeCommand();
		resumeCommand = userResumeMapper.selectCareer(m_id);
		return resumeCommand;
	}
	@Override
	public UserResumeCommand selectAwards(String id) {
		UserResumeCommand resumeCommand = new UserResumeCommand();
		resumeCommand = userResumeMapper.selectAwards(id);
		return resumeCommand;
	}
	@Override
	public UserResumeCommand selectAchieve(String id) {
		UserResumeCommand resumeCommand = new UserResumeCommand();
		resumeCommand = userResumeMapper.selectAchieve(id);
		return resumeCommand;
	}
	@Override
	public UserResumeCommand selectHobby(String id) {
		UserResumeCommand resumeCommand = new UserResumeCommand();
		resumeCommand = userResumeMapper.selectHobby(id);
		return resumeCommand;
	}
	@Override
	public UserResumeCommand selectLicense(String id) {
		UserResumeCommand resumeCommand = new UserResumeCommand();
		resumeCommand = userResumeMapper.selectLicense(id);
		return resumeCommand;
	}
	@Override
	public UserResumeCommand selectPortfolio(String id) {
		UserResumeCommand resumeCommand = new UserResumeCommand();
		resumeCommand = userResumeMapper.selectPortfolio(id);
		return resumeCommand;
	}
	@Override
	public UserResumeCommand selectUserInfo(String id) {
		UserResumeCommand resumeCommand = userResumeMapper.selectUserInfo(id);
		return resumeCommand;
	}
	
	//----------------------------insert
	@Override
	public void insertResumeBasic(UserResumeCommand resumeCommand) {
		userResumeMapper.insertResumeBasic(resumeCommand);
	}

	@Override
	public void insertCareer(UserResumeCommand resumeCommand) {
		userResumeMapper.insertCareer(resumeCommand);
	}

	@Override
	public void insertAwards(UserResumeCommand resumeCommand) {
		userResumeMapper.insertAwards(resumeCommand);
	}

	@Override
	public void insertAchieve(UserResumeCommand resumeCommand) {
		userResumeMapper.insertAchieve(resumeCommand);
	}

	@Override
	public void insertHobby(UserResumeCommand resumeCommand) {
		userResumeMapper.insertHobby(resumeCommand);
	}

	@Override
	public void insertLicense(UserResumeCommand resumeCommand) {
		userResumeMapper.insertLicense(resumeCommand);
	}

	@Override
	public void insertPortfolio(UserResumeCommand resumeCommand) {
		userResumeMapper.insertPortfolio(resumeCommand);
	}

	@Override
	public void insertNaPho(UserResumeCommand resumeCommand) {
		userResumeMapper.insertNaPho(resumeCommand);
	}
	
	//---------------------update
	
	@Override
	public void modifyResumeGeneral(UserResumeCommand resumeCommand) {
		userResumeMapper.modifyResumeGeneral(resumeCommand);
		
	}
	@Override
	public void modifyResumeCareer(UserResumeCommand resumeCommand) {
		userResumeMapper.modifyResumeCareer(resumeCommand);
	}
	@Override
	public void modifyResumeAwards(UserResumeCommand resumeCommand) {
		userResumeMapper.modifyResumeAwards(resumeCommand);
	}
	@Override
	public void modifyResumeAchieve(UserResumeCommand resumeCommand) {
		userResumeMapper.modifyResumeAchieve(resumeCommand);
	}
	@Override
	public void modifyResumeHobby(UserResumeCommand resumeCommand) {
		userResumeMapper.modifyResumeHobby(resumeCommand);
	}
	@Override
	public void modifyResumeLicense(UserResumeCommand resumeCommand) {
		userResumeMapper.modifyResumeLicense(resumeCommand);
	}
	@Override
	public void modifyResumePortfolio(UserResumeCommand resumeCommand) {
		userResumeMapper.modifyResumePortfolio(resumeCommand);
	}
	@Override
	public void modifyNaPho(UserResumeCommand resumeCommand) {
		userResumeMapper.modifyNaPho(resumeCommand);
	}
	
	
	//---------------------delete
	
	@Override
	public void deleteResumeGeneral(String userId) {
		userResumeMapper.deleteResumeGeneral(userId);
	}
	@Override
	public void deleteCareer(String userId) {
		userResumeMapper.deleteCareer(userId);
	}
	@Override
	public void deleteAwards(String userId) {
		userResumeMapper.deleteAwards(userId);
	}
	@Override
	public void deleteAchieve(String userId) {
		userResumeMapper.deleteAchieve(userId);
	}
	@Override
	public void deleteHobby(String userId) {
		userResumeMapper.deleteHobby(userId);
	}
	@Override
	public void deleteLicense(String userId) {
		userResumeMapper.deleteLicense(userId);
	}
	@Override
	public void deletePortfolio(String userId) {
		userResumeMapper.deletePortfolio(userId);
	}
	@Override
	public List<UserResumeCommand> selectAll() {
		List<UserResumeCommand> list = new ArrayList<UserResumeCommand>();
		list = userResumeMapper.selectAll();
		return list;
	}
	@Override
	public String checkUserId(String id) {
		String m_id = userResumeMapper.checkUserId(id);
		return m_id;
	}
	@Override
	public String checkUserNum(String num) {
		String enterprise_num = userResumeMapper.checkUserNum(num);
		return enterprise_num;
	}
	@Override
	public List<UserResumeCommand> selectPublicResume() {
		List<UserResumeCommand> list = new ArrayList<UserResumeCommand>();
		list = userResumeMapper.selectPublicResume();
		return list;
	}
}
























