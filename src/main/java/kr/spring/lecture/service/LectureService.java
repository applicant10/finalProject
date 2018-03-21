package kr.spring.lecture.service;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import kr.spring.lecture.domain.LectureCommand;
import kr.spring.lecture.domain.LecturePointCommand;

@Transactional
public interface LectureService {
	public void insertLecture(LectureCommand lecture);
	@Transactional(readOnly=true)
	public List<LectureCommand> list(Map<String, Object> map);
	@Transactional(readOnly=true)
	public List<LectureCommand> listOtherSearch(Map<String, Object> map);
	@Transactional(readOnly=true)
	public int getRowCount(Map<String, Object> map);
	@Transactional(readOnly=true)
	public int getRowCount_otherSearch(Map<String, Object> map);
	@Transactional(readOnly=true)
	public LectureCommand selectLecture(Integer l_num);
	@Transactional(readOnly=true)
	public List<LectureCommand> selectLectureUseId(String m_id);
	@Transactional(readOnly=true)
	public List<LectureCommand> selectLectureUseId_self(String m_id);
	@Transactional(readOnly=true)
	public int countLectureUseId(String m_id);
	@Transactional(readOnly=true)
	public List<LectureCommand> selectLectureUseNick(String m_nick);
	@Transactional(readOnly=true)
	public int countLectureUseNick(String m_nick);
	@Transactional(readOnly=true)
	public List<LectureCommand> lecture_JoinLeNum_UseLMNum_Calc(String m_id);
	public void modifyLecture(LectureCommand lecture);
	public void lectureOpenSet(Integer l_num);
	public void lectureCloseSet(Integer l_num);
	public void lectureIncreaseHit(Integer l_num);
}
