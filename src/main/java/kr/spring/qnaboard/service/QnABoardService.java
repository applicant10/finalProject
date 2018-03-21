package kr.spring.qnaboard.service;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;


//import kr.spring.board.domain.BoardCommand;
//import kr.spring.board.domain.BoardReplyCommand;
import kr.spring.qnaboard.domain.QnABoardCommand;
import kr.spring.qnaboard.domain.QnABoardReplyCommand;

@Transactional
public interface QnABoardService {
	// ���  ��ȸ
	// - ��� ī��Ʈ
	@Transactional(readOnly=true)
	public int getQnaRowCnt(Map<String,Object> map);
	// - ���
	@Transactional(readOnly=true)
	public List<QnABoardCommand> getQnAList(Map<String,Object> map);
	
	// ��� ��
	@Transactional(readOnly=true)
	public QnABoardCommand getQnADetail(Integer num);
	
	// ��� ���
	public void insertQnA(QnABoardCommand board);
	
	// ��� ��ȸ�� ���� 
	public void updateHitQnA(Integer num);
	
	// ��� ����
	public void updateQnA(QnABoardCommand board);
	
	// ��� ����
	public void deleteQnA(Integer num);
	
	// - ��ϴ亯 
	
	// ��� �亯 ����
	public void updateAnswerQnA(QnABoardCommand board);
	
	
	//�����ȸ 
	
	//��� ī��Ʈ
	@Transactional(readOnly=true)
	public int getQnAReplyRowCount(Map<String,Object> map);
	//��۸��
	@Transactional(readOnly=true)
	public List<QnABoardReplyCommand> getQnAReplyList(Map<String, Object> map);
	///��۵��
	public void insertReply(QnABoardReplyCommand boardReply);
	//��� ���� 
	public void updateReply(QnABoardReplyCommand boardReply);
	//��ۻ��� 
	public void deleteReply(Integer br_num);
	
	
	
}









