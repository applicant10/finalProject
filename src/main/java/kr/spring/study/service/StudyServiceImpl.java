package kr.spring.study.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.spring.study.dao.StudyMapper;
import kr.spring.study.domain.StudyCommand;
import kr.spring.study.domain.StudyReplyCommand;

@Service("studyService")
public class StudyServiceImpl implements StudyService{
	
	@Resource
	private StudyService studyService;
	
	@Resource
	private StudyMapper studyMapper;
	
	@Override
	public List<StudyCommand> list(Map<String, Object> map) {
		return studyMapper.list(map);
	}

	@Override
	public int getRowCount(Map<String, Object> map) {
		return studyMapper.getRowCount(map);
	} 

	@Override
	public void insert(StudyCommand study) {
		studyMapper.insert(study);
		
	}

	@Override
	public StudyCommand selectBoard(Integer num) {
		return studyMapper.selectBoard(num);
	}

	@Override
	public void update(StudyCommand study) {
		studyMapper.update(study);
		
	}

	@Override
	public void delete(Integer num) {
		//댓글이 존재하면 우선 삭제하고 부모글 삭제
		studyMapper.deleteReplyByNum(num);
		//부모글 삭제
		studyMapper.delete(num); 
		
	}
	@Override
	public List<StudyReplyCommand> studyReply(Map<String, Object> map) {
		return studyMapper.studyReply(map);
	}

	@Override
	public int getRowCountReply(Map<String, Object> map) {
		return studyMapper.getRowCountReply(map);
	}

	@Override
	public void insertReply(StudyReplyCommand studyReply) {
		studyMapper.insertReply(studyReply);
	}

	@Override
	public void updateReply(StudyReplyCommand studyReply) {
		studyMapper.updateReply(studyReply);
	}

	@Override
	public void deleteReply(Integer re_tnum) {
		studyMapper.deleteReply(re_tnum);
	}

	

	
	
}

