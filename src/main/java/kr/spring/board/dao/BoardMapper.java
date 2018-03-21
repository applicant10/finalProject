package kr.spring.board.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.spring.board.domain.BoardCommand;
import kr.spring.board.domain.BoardReplyCommand;

public interface BoardMapper {
	//부모글
	public List<BoardCommand> list(Map<String,Object> map);
	public int getRowCount(Map<String,Object> map);
	@Insert("INSERT INTO board (b_num,b_title,b_content,b_date, b_hit,b_ip,b_nick,m_id) VALUES (board_seq.nextval,#{b_title},#{b_content},sysdate,0,#{b_ip},#{b_nick},#{m_id})")
	public void insert(BoardCommand board);
	@Select("SELECT * FROM board WHERE b_num=#{b_num}")
	public BoardCommand selectBoard(Integer b_num);
	@Update("UPDATE board SET b_hit=b_hit+1 WHERE b_num=#{b_num}")
	public void updateHit(Integer b_num);
	@Update("UPDATE board SET b_title=#{b_title},b_content=#{b_content},b_ip=#{b_ip} WHERE b_num=#{b_num}")
	public void update(BoardCommand board);
	@Delete("DELETE FROM board WHERE b_num=#{b_num}")
	public void delete(Integer b_num);
	
	//댓글
	public List<BoardReplyCommand> listReply(Map<String,Object> map);
	@Select("SELECT count(*) FROM board_reply WHERE b_num=#{b_num}")
	public int getRowCountReply(Map<String,Object> map);
	@Insert("INSERT INTO board_reply (br_num,br_content,br_date,br_ip,b_num,m_id) VALUES (reply_seq.nextval,#{br_content},sysdate,#{br_ip},#{b_num},#{m_id})")
	public void insertReply(BoardReplyCommand boardReply);
	@Update("UPDATE board_reply SET br_content=#{br_content},br_ip=#{br_ip} WHERE br_num=#{br_num}")
	public void updateReply(BoardReplyCommand boardReply);
	@Delete("DELETE FROM board_reply WHERE br_num=#{br_num}")
	public void deleteReply(Integer br_num);
	
	//부모글 삭제시 댓글이 존재하면 부모글 삭제전 댓글 삭제
	@Delete("DELETE FROM board_reply WHERE br_num=#{br_num}")
	public void deleteReplyByNum(Integer b_num);
}
