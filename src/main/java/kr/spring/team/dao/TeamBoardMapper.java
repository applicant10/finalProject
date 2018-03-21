package kr.spring.team.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.spring.team.domain.TeamBoardCommand;
import kr.spring.team.domain.TeamBoardReplyCommand;

public interface TeamBoardMapper {	
	//게시판 게시글 리스트
	public List<TeamBoardCommand> list(Map<String,Object> map);
	
	//게시판 게시글 카운트
	public int getRowCount(Map<String,Object> map);
	
	//자료 게시판 글쓰기
	@Insert("INSERT INTO teamboard (m_nick,g_num,tb_num,tb_title,tb_content,uploadfile,filename,tb_date) VALUES (#{m_nick},#{g_num},board_seq.nextval,#{tb_title},#{tb_content},#{uploadfile},#{filename},sysdate)")
	public void insert(TeamBoardCommand board);
	
	//게시판 글 보기
	@Select("SELECT * FROM teamboard WHERE tb_num=#{tb_num}")
	public TeamBoardCommand select(Integer num);
	
	//팀보드 게시판 글 수정
	@Update("UPDATE teamboard SET tb_title=#{tb_title},tb_content=#{tb_content},uploadfile=#{uploadfile},filename=#{filename} WHERE tb_num=#{tb_num}")
	public void update(TeamBoardCommand board);
	
	//팀보드 게시판 글 삭제
	@Delete("DELETE FROM teamboard WHERE tb_num=#{tb_num}")
	public void delete(Integer num);

	
	//댓글
	public List<TeamBoardReplyCommand> teamReply(Map<String, Object> map);
	@Select("SELECT count(*) FROM teamReply WHERE tb_num=#{tb_num}")
	public int g_getRowCountReply(Map<String,Object> map);
	@Insert("INSERT INTO teamreply (re_gnum,re_gcontent,re_gdate,tb_num,m_nick) VALUES (reply_seq.nextval,#{re_gcontent},sysdate,#{tb_num},#{m_nick})")
	public void g_insertReply(TeamBoardReplyCommand teamReplyCommand);
	@Update("UPDATE teamreply SET re_gcontent=#{re_gcontent} WHERE re_gnum=#{re_gnum}")
	public void g_updateReply(TeamBoardReplyCommand teamReplyCommand);
	@Delete("DELETE FROM teamreply WHERE re_gnum=#{re_gnum}")
	public void g_deleteReply(Integer re_gnum);

	@Delete("DELETE FROM teamReply WHERE tb_num=#{tb_num}")
	public void g_deleteReplyByNum(Integer num);
}
