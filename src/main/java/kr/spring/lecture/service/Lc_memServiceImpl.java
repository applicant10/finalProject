package kr.spring.lecture.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import kr.spring.lecture.dao.L_contentMapper;
import kr.spring.lecture.dao.Lc_memMapper;
import kr.spring.lecture.dao.Le_numMapper;
import kr.spring.lecture.dao.LectureMapper;
import kr.spring.lecture.domain.L_contentCommand;
import kr.spring.lecture.domain.Lc_memCommand;
import kr.spring.lecture.domain.LectureCommand;
import kr.spring.record.service.RecordService;

@Service("lc_memService")
public class Lc_memServiceImpl implements Lc_memService{
	@Resource
	private Lc_memMapper lc_memMapper;
	@Resource
	private Le_numMapper le_numMapper;
	@Resource
	private LectureMapper lectureMapper;
	@Resource
	private RecordService recordService;
	@Resource
	private L_contentMapper lcontentMapper;
	
	//수강신청
	@Override
	public void insertLcmem(Integer lc_num, Integer l_m_num) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("lc_num", lc_num);
		map.put("l_m_num", l_m_num);
		
		if(lc_memMapper.selectLcmem_use_lcNum_lmNum(map)>0) {
			
		}else {
			lc_memMapper.insertLcmem(map);
		}
	}
	@Override
	public List<Lc_memCommand> selectLCMuseLn(Integer l_m_num) {
		return lc_memMapper.selectLCMuseLn(l_m_num);
	}
	@Override
	public int selectCommLCMuseLn(Integer l_m_num) {
		return lc_memMapper.selectCommLCMuseLn(l_m_num);
	}
	//강의 학습 완료
	@Override
	public void completeLearnContent(Integer lc_num, Integer l_m_num, Integer l_num) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("lc_num", lc_num);
		map.put("l_m_num", l_m_num);
		
		lc_memMapper.completeLearnContent(map);
		
		int lcount = le_numMapper.countLcontent(l_m_num);
		int complete = le_numMapper.countLcmemIsComdate(l_m_num);
		
		L_contentCommand lcontent = lcontentMapper.selectOne(lc_num);
		
		Map<String, String> map2 = new HashMap<String, String>();
		
		map2.put("m_nick", RequestContextHolder.getRequestAttributes().getAttribute("userNick", RequestAttributes.SCOPE_SESSION).toString());
		map2.put("record", "강의를 수강했습니다.");
		map2.put("r_content", lcontent.getLc_title());
		
		recordService.insertRecord(map2);
		
		
		if(lcount - complete == 0) {
			System.out.println("le_num (l_m_num : "+l_m_num+") is finished");
			le_numMapper.finishLearn(l_m_num);
			
			LectureCommand lecture = lectureMapper.selectLecture(l_num);
			
			Map<String, String> map3 = new HashMap<String, String>();
			
			map3.put("m_nick", RequestContextHolder.getRequestAttributes().getAttribute("userNick", RequestAttributes.SCOPE_SESSION).toString());
			map3.put("record", "강좌를 모두 학습했습니다!");
			map3.put("r_content", lecture.getL_title());
			
			recordService.insertRecord(map3);
		}
	}
}