package kr.spring.lecture.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.spring.lecture.dao.LectureReplyMapper;
import kr.spring.lecture.domain.LecturePointCommand;
import kr.spring.lecture.domain.LectureReplyCommand;

@Service("lectureReplyService")
public class LectureReplyServiceImpl implements LectureReplyService {
	
	@Resource
	private LectureReplyMapper lrMapper;

	@Override
	public LectureReplyCommand myReply(Map<String, Object> map) {
		return lrMapper.myReply(map);
	}

	@Override
	public List<LectureReplyCommand> list(Map<String, Object> map) {
		return lrMapper.list(map);
	}

	@Override
	public int getRowCountReply(Map<String, Object> map) {
		return lrMapper.getRowCountReply(map);
	}

	@Override
	public void insertReply(LectureReplyCommand lrCommand, Map<String, Object> map) {
		
		int count = lrMapper.alreadyDone(map);
		
		if(count == 0) {
			lrMapper.insertReply(lrCommand);
		}else if(count == 1) {
			lrMapper.updateReply(lrCommand);
		}
		
		lrMapper.averagePoint(Integer.parseInt(map.get("l_num").toString()));
	}

	@Override
	public void updateReply(LectureReplyCommand lrCommand) {
		lrMapper.updateReply(lrCommand);
	}

	@Override
	public void deleteReply(Integer lr_num) {
		lrMapper.deleteReply(lr_num);
	}

	@Override
	public void deleteReplyByLNum(Integer l_num) {
		lrMapper.deleteReplyByLcNum(l_num);
	}
	
	@Override
	public void averagePoint(Integer l_num) {
		lrMapper.averagePoint(l_num);
	}
	@Override
	public LecturePointCommand lecturePoint(Integer l_num) {
		return lrMapper.lecturePoint(l_num);
	}
}
