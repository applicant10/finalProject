package kr.spring.qnaboard.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

//import kr.spring.board.domain.BoardReplyCommand;
import kr.spring.qnaboard.domain.QnABoardCommand;
import kr.spring.qnaboard.domain.QnABoardReplyCommand;

public interface QnABoardMapper {

	// 게시글 목록
	
	// 목록 카운트
		public List<QnABoardCommand> getQnAList(Map<String, Object> map);
	// 목록 카운트
	public int getQnaListRowCount(Map<String, Object> map);
	
	// 목록 상세
	@Select("SELECT Q_NUM, Q_TITLE, Q_CONTENT, M_ID, TO_CHAR(Q_DATE, 'YYYY-MM-DD') AS Q_DATE, Q_HIT FROM QNABOARD WHERE Q_NUM=#{q_num}")
	public QnABoardCommand getQnADetail(Integer q_num);
	
	// 목록 등록
	@Insert("INSERT INTO QNABOARD(Q_NUM,Q_COL,Q_TITLE,Q_CONTENT,Q_DATE,Q_HIT,Q_IP,Q_NICK,Q_PRIVATE,M_ID)VALUES(QNABOARD_SEQ.NEXTVAL,'',#{q_title},#{q_content},SYSDATE,0,#{q_ip},#{q_nick},'N',#{m_id})")
	public void insertQnA(QnABoardCommand board);
	
	// 목록 수정
	@Update("UPDATE QNABOARD SET Q_TITLE = #{q_title}, Q_CONTENT = #{q_content} WHERE Q_NUM = #{q_num}")
	public void updateQnA(QnABoardCommand board);
	
	// 목록 답변
	@Update("UPDATE QNABOARD SET Q_ANSWER = #{q_answer} WHERE Q_NUM = #{q_num}")
	public void updateQnAAnswer(QnABoardCommand board);
	
	//목록 조회수 올리기 
	@Update("UPDATE QNABOARD SET q_hit=q_hit+1 WHERE Q_NUM=#{q_num}")
	public void updateHitQnA(Integer num);
	
	// 목록 삭제
	@Delete("DELETE FROM QNABOARD WHERE Q_NUM = #{q_num}")
	public void deleteQnA(Integer q_num);
	
	
	//댓글 목록 
	
	//댓글 카운트 
	public List<QnABoardReplyCommand> getQnAReplyList(Map<String,Object>map);
	@Select("SELECT count(*) FROM QNA_REPLY WHERE q_num=#{q_num}")
	public int getQnAReplyRowCount(Map<String,Object> map);
	@Insert("INSERT INTO QNA_REPLY (br_num,br_content,br_date,br_ip,q_num,m_id) VALUES (reply_seq.nextval,#{br_content},sysdate,#{br_ip},#{q_num},#{m_id})")
	public void insertReply(QnABoardReplyCommand boardReply);
	@Update("UPDATE QNA_REPLY SET br_content=#{br_content},br_ip=#{br_ip} WHERE br_num=#{br_num}")
	public void updateReply(QnABoardReplyCommand boardReply);
	@Delete("DELETE FROM QNA_REPLY WHERE br_num = #{br_num}")
	public void deleteReply(Integer br_num);
	
	//부모글 삭제시 댓글이 존재하면 부모글 삭제전 댓글 삭제
	@Delete("DELETE FROM QNA_REPLY WHERE Q_NUM=#{q_num}")
	public void deleteReplyByNum(Integer q_num);
}








