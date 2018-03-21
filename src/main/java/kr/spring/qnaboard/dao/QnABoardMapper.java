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

	// �Խñ� ���
	
	// ��� ī��Ʈ
		public List<QnABoardCommand> getQnAList(Map<String, Object> map);
	// ��� ī��Ʈ
	public int getQnaListRowCount(Map<String, Object> map);
	
	// ��� ��
	@Select("SELECT Q_NUM, Q_TITLE, Q_CONTENT, M_ID, TO_CHAR(Q_DATE, 'YYYY-MM-DD') AS Q_DATE, Q_HIT FROM QNABOARD WHERE Q_NUM=#{q_num}")
	public QnABoardCommand getQnADetail(Integer q_num);
	
	// ��� ���
	@Insert("INSERT INTO QNABOARD(Q_NUM,Q_COL,Q_TITLE,Q_CONTENT,Q_DATE,Q_HIT,Q_IP,Q_NICK,Q_PRIVATE,M_ID)VALUES(QNABOARD_SEQ.NEXTVAL,'',#{q_title},#{q_content},SYSDATE,0,#{q_ip},#{q_nick},'N',#{m_id})")
	public void insertQnA(QnABoardCommand board);
	
	// ��� ����
	@Update("UPDATE QNABOARD SET Q_TITLE = #{q_title}, Q_CONTENT = #{q_content} WHERE Q_NUM = #{q_num}")
	public void updateQnA(QnABoardCommand board);
	
	// ��� �亯
	@Update("UPDATE QNABOARD SET Q_ANSWER = #{q_answer} WHERE Q_NUM = #{q_num}")
	public void updateQnAAnswer(QnABoardCommand board);
	
	//��� ��ȸ�� �ø��� 
	@Update("UPDATE QNABOARD SET q_hit=q_hit+1 WHERE Q_NUM=#{q_num}")
	public void updateHitQnA(Integer num);
	
	// ��� ����
	@Delete("DELETE FROM QNABOARD WHERE Q_NUM = #{q_num}")
	public void deleteQnA(Integer q_num);
	
	
	//��� ��� 
	
	//��� ī��Ʈ 
	public List<QnABoardReplyCommand> getQnAReplyList(Map<String,Object>map);
	@Select("SELECT count(*) FROM QNA_REPLY WHERE q_num=#{q_num}")
	public int getQnAReplyRowCount(Map<String,Object> map);
	@Insert("INSERT INTO QNA_REPLY (br_num,br_content,br_date,br_ip,q_num,m_id) VALUES (reply_seq.nextval,#{br_content},sysdate,#{br_ip},#{q_num},#{m_id})")
	public void insertReply(QnABoardReplyCommand boardReply);
	@Update("UPDATE QNA_REPLY SET br_content=#{br_content},br_ip=#{br_ip} WHERE br_num=#{br_num}")
	public void updateReply(QnABoardReplyCommand boardReply);
	@Delete("DELETE FROM QNA_REPLY WHERE br_num = #{br_num}")
	public void deleteReply(Integer br_num);
	
	//�θ�� ������ ����� �����ϸ� �θ�� ������ ��� ����
	@Delete("DELETE FROM QNA_REPLY WHERE Q_NUM=#{q_num}")
	public void deleteReplyByNum(Integer q_num);
}








