package kr.spring.resume.service;


import java.util.List;

import kr.spring.resume.domain.UserResumeCommand;

public interface UserResumeService {
	
	public List<UserResumeCommand> selectAll();
	
	public String checkUserId(String id);
	public String checkUserNum(String num);
	//이력서 진입시 메서드
	public UserResumeCommand selectResume(String id);
	public UserResumeCommand selectCareer(String m_id);
	public UserResumeCommand selectAwards(String id);
	public UserResumeCommand selectAchieve(String id);
	public UserResumeCommand selectHobby(String id);
	public UserResumeCommand selectLicense(String id);
	public UserResumeCommand selectPortfolio(String id);
	public List<UserResumeCommand> selectPublicResume();
	//이름과 전화번호 넘겨 받는 메서드
	public UserResumeCommand selectUserInfo(String id);
	//이력서 작성
	public void insertResumeBasic(UserResumeCommand resumeCommand);
	public void insertCareer(UserResumeCommand resumeCommand);
	public void insertAwards(UserResumeCommand resumeCommand);
	public void insertAchieve(UserResumeCommand resumeCommand);
	public void insertHobby(UserResumeCommand resumeCommand);
	public void insertLicense(UserResumeCommand resumeCommand);
	public void insertPortfolio(UserResumeCommand resumeCommand);
	//이력서 이름,전화번호 따로 인서트
	public void insertNaPho(UserResumeCommand resumeCommand);
	
	//이력서 수정
	public void modifyResumeGeneral(UserResumeCommand resumeCommand);
	public void modifyResumeCareer(UserResumeCommand resumeCommand);
	public void modifyResumeAwards(UserResumeCommand resumeCommand);
	public void modifyResumeAchieve(UserResumeCommand resumeCommand);
	public void modifyResumeHobby(UserResumeCommand resumeCommand);
	public void modifyResumeLicense(UserResumeCommand resumeCommand);
	public void modifyResumePortfolio(UserResumeCommand resumeCommand);
	public void modifyNaPho(UserResumeCommand resumeCommand);
	
	//이력서 삭제
	public void deleteResumeGeneral(String userId);
	public void deleteCareer(String userId);
	public void deleteAwards(String userId);
	public void deleteAchieve(String userId);
	public void deleteHobby(String userId);
	public void deleteLicense(String userId);
	public void deletePortfolio(String userId);
	
}
