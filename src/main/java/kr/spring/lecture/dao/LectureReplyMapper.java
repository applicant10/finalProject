package kr.spring.lecture.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;

import kr.spring.lecture.domain.LecturePointCommand;
import kr.spring.lecture.domain.LectureReplyCommand;

public interface LectureReplyMapper {

	public LectureReplyCommand myReply(Map<String, Object> map);
	public Integer alreadyDone(Map<String, Object> map);

	public List<LectureReplyCommand> list(Map<String, Object> map);
	public int getRowCountReply(Map<String, Object> map);
	public void insertReply(LectureReplyCommand lrCommand);
	public void updateReply(LectureReplyCommand lrCommand);
	public void deleteReply(Integer lr_num);

	@Delete("delete from lecture_reply WHERE l_num=#{l_num}")
	public void deleteReplyByLcNum(Integer l_num);

	//평점 평균
	public void averagePoint(Integer l_num);

	//평점 분포
	public LecturePointCommand lecturePoint(Integer l_num);
}