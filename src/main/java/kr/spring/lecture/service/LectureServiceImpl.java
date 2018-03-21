package kr.spring.lecture.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import kr.spring.lecture.dao.LectureMapper;
import kr.spring.lecture.domain.LectureCommand;
import kr.spring.record.service.RecordService;

@Service("lectureService")
public class LectureServiceImpl implements LectureService {
	@Resource
	private LectureMapper lectureMapper;
	
	@Resource
	private RecordService recordService;
	
	@Override
	public void insertLecture(LectureCommand lecture) {
		lectureMapper.insertLecture(lecture);
		
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("m_nick", RequestContextHolder.getRequestAttributes().getAttribute("userNick", RequestAttributes.SCOPE_SESSION).toString());
		map.put("record", "강좌를 개설했습니다.");
		map.put("r_content", lecture.getL_title());
		
		recordService.insertRecord(map);
	}

	@Override
	public List<LectureCommand> list(Map<String, Object> map) {
		return lectureMapper.list(map);
	}
	
	@Override
	public List<LectureCommand> listOtherSearch(Map<String, Object> map) {
		return lectureMapper.listOtherSearch(map);
	}

	@Override
	public int getRowCount(Map<String, Object> map) {
		return lectureMapper.getRowCount(map);
	}
	
	@Override
	public int getRowCount_otherSearch(Map<String, Object> map) {
		return lectureMapper.getRowCount_otherSearch(map);
	}

	@Override
	public LectureCommand selectLecture(Integer l_num) {
		return lectureMapper.selectLecture(l_num);
	}

	@Override
	public List<LectureCommand> selectLectureUseId(String m_id) {
		return lectureMapper.selectLectureUseId(m_id);
	}
	
	@Override
	public List<LectureCommand> selectLectureUseId_self(String m_id) {
		return lectureMapper.selectLectureUseId_self(m_id);
	}

	@Override
	public List<LectureCommand> selectLectureUseNick(String m_nick) {
		return lectureMapper.selectLectureUseNick(m_nick);
	}

	@Override
	public int countLectureUseId(String m_id) {
		return lectureMapper.countLectureUseId(m_id);
	}

	@Override
	public int countLectureUseNick(String m_nick) {
		return lectureMapper.countLectureUseNick(m_nick);
	}
	
	@Override
	public List<LectureCommand> lecture_JoinLeNum_UseLMNum_Calc(String m_id) {
		return lectureMapper.lecture_JoinLeNum_UseLMNum_Calc(m_id);
	}
	@Override
	public void modifyLecture(LectureCommand lecture) {
		lectureMapper.modifyLecture(lecture);
	}
	@Override
	public void lectureOpenSet(Integer l_num) {
		lectureMapper.lectureOpenSet(l_num);
		
	}
	@Override
	public void lectureCloseSet(Integer l_num) {
		lectureMapper.lectureCloseSet(l_num);
	}
	
	@Override
	public void lectureIncreaseHit(Integer l_num) {
		lectureMapper.lectureIncreaseHit(l_num);
	}
}
