package kr.spring.study.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.spring.study.domain.StudyCommand;
import kr.spring.study.domain.StudyReplyCommand;

public interface StudyMapper {
	//부모글
	public List<StudyCommand> list(Map<String,Object> map);
	public int getRowCount(Map<String,Object> map);
	@Insert("INSERT INTO studyboard (m_nick,g_num,t_num,t_sub,t_title,t_content,t_area,t_date) VALUES (#{m_nick},#{g_num},board_seq.nextval,#{t_sub},#{t_title},#{t_content},#{t_area},sysdate)")
	public void insert(StudyCommand study);
	@Select("SELECT * FROM studyboard WHERE t_num=#{t_num}")
	public StudyCommand selectBoard(Integer num);
	@Update("UPDATE studyboard SET t_title=#{t_title},t_content=#{t_content},t_sub=#{t_sub},t_area=#{t_area} WHERE t_num=#{t_num}")
	public void update(StudyCommand study);
	@Delete("DELETE FROM studyboard WHERE t_num=#{t_num}")
	public void delete(Integer num);
	
	//댓글
	public List<StudyReplyCommand> studyReply(Map<String,Object> map);
	@Select("SELECT count(*) FROM studyreply WHERE t_num=#{t_num}")
	public int getRowCountReply(Map<String,Object> map);
	@Insert("INSERT INTO studyreply (re_tnum,re_tcontent,re_tdate,t_num,m_nick) VALUES (reply_seq.nextval,#{re_tcontent},sysdate,#{t_num},#{m_nick})")
	public void insertReply(StudyReplyCommand studyReplyCommand);
	@Update("UPDATE studyreply SET re_tcontent=#{re_tcontent} WHERE re_tnum=#{re_tnum}")
	public void updateReply(StudyReplyCommand studyReplyCommand);
	@Delete("DELETE FROM studyreply WHERE re_tnum=#{re_tnum}")
	public void deleteReply(Integer re_tnum);
	
	//부모글 삭제시 댓글 삭제
	@Delete("DELETE FROM studyreply WHERE t_num=#{t_num}")
	public void deleteReplyByNum(Integer num);
	
	
}
