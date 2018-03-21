package kr.spring.lecture.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import kr.spring.lecture.dao.Le_numMapper;
import kr.spring.lecture.dao.LectureMapper;
import kr.spring.lecture.domain.Le_numCommand;
import kr.spring.lecture.domain.LectureCommand;
import kr.spring.lecture.domain.LecturePointCommand;
import kr.spring.record.service.RecordService;

@Service("le_numService")
public class Le_numServiceImpl implements Le_numService {
	
	public HashMap<String, Object> map(String m_id, Integer l_num){
		HashMap<String, Object> objm = new HashMap<String, Object>();
		objm.put("m_id", m_id);
		objm.put("l_num", l_num);
		
		return objm;
	}
	
	@Resource
	private Le_numMapper lnMapper;
	@Resource
	private LectureMapper lectureMapper;
	@Resource
	private RecordService recordService;

	@Override
	public void insertLeNum(String m_id, Integer l_num) {
		//강좌번호, id를 가지고 수강테이블 생성
		lnMapper.insertLeNum(map(m_id, l_num));
		lectureMapper.lectureIncreaseHit(l_num);
		
		Map<String, String> maps = new HashMap<String, String>();
		
		LectureCommand lecture = lectureMapper.selectLecture(l_num);
		maps.put("m_nick", RequestContextHolder.getRequestAttributes().getAttribute("userNick", RequestAttributes.SCOPE_SESSION).toString());
		maps.put("record", "강좌 수강 신청하셨습니다.");
		maps.put("r_content", lecture.getL_title());
		
		recordService.insertRecord(maps);
	}

	@Override
	public boolean checkLectureUseId(String m_id, Integer l_num) {
		boolean result = false;
		if(lnMapper.checkLectureUseId(map(m_id, l_num)) > 0)
			result = true;
		
		return result;
	}

	@Override
	public void finishLearn(Integer l_m_num) {
		lnMapper.finishLearn(l_m_num);
	}

	@Override
	public Le_numCommand selectLM(String m_id, Integer l_num) {
		return lnMapper.selectLM(map(m_id, l_num));
	}

	@Override
	public List<Le_numCommand> selectFinLMList(String m_id, Integer l_num) {
		return lnMapper.selectFinLMList(map(m_id, l_num));
	}

	@Override
	public List<Le_numCommand> selectNoFinLMList(String m_id, Integer l_num) {
		return lnMapper.selectNoFinLMList(map(m_id, l_num));
	}
	@Override
	public List<Le_numCommand> selectLMList(String m_id) {
		return lnMapper.selectLMList(m_id);
	}
}