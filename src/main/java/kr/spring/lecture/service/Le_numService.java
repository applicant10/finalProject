package kr.spring.lecture.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import kr.spring.lecture.domain.Le_numCommand;
@Transactional
public interface Le_numService {
	public void insertLeNum(String m_id, Integer l_num);
	@Transactional(readOnly=true)
	public boolean checkLectureUseId(String m_id, Integer l_num);
	public void finishLearn(Integer l_m_num);
	@Transactional(readOnly=true)
	public Le_numCommand selectLM(String m_id, Integer l_num);
	@Transactional(readOnly=true)
	public List<Le_numCommand> selectFinLMList(String m_id, Integer l_num);
	@Transactional(readOnly=true)
	public List<Le_numCommand> selectNoFinLMList(String m_id, Integer l_num);
	@Transactional(readOnly=true)
	public List<Le_numCommand> selectLMList(String m_id);
	
}