package kr.spring.qnaboard.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

//import kr.spring.board.domain.BoardCommand;
import kr.spring.qnaboard.dao.QnABoardMapper;
import kr.spring.qnaboard.domain.QnABoardCommand;
import kr.spring.qnaboard.domain.QnABoardReplyCommand;

@Service("qnaBoardService")
public class QnABoardServiceImpl implements QnABoardService{
	
	// DB DAO
	@Resource
	private QnABoardMapper qnABoardMapper;

	// ��� ī��Ʈ
	@Override
	public int getQnaRowCnt(Map<String, Object> map) {
		return qnABoardMapper.getQnaListRowCount(map);
	}
	
	// - ���
	@Override
	public List<QnABoardCommand> getQnAList(Map<String, Object> map) {
		return qnABoardMapper.getQnAList(map);
	}

	// ��� ��
	@Override
	public QnABoardCommand getQnADetail(Integer num) {
		return qnABoardMapper.getQnADetail(num);
	}

	// ��� ���
	@Override
	public void insertQnA(QnABoardCommand board) {
		qnABoardMapper.insertQnA(board);	
	}
	//��� ��ȸ�� ���� 
	@Override
	public void updateHitQnA(Integer num) {
		qnABoardMapper.updateHitQnA(num);	
	}
	
	// ��� ����
	@Override
	public void updateQnA(QnABoardCommand board) {
		qnABoardMapper.updateQnA(board);	
	}
	
	//�亯����
	@Override
	public void updateAnswerQnA(QnABoardCommand board) {
		qnABoardMapper.updateQnAAnswer(board);	
	}

	// ��� ����
	@Override
	public void deleteQnA(Integer num) {
		//����� �����ϸ� ����� �켱 �����ϰ� �θ���� ���� 
		qnABoardMapper.deleteReplyByNum(num);
		//�θ�� ���� 
		qnABoardMapper.deleteQnA(num);	
	}

	
	//��ۺκ�
	
	//��� ī����
	@Override
	public int getQnAReplyRowCount(Map<String, Object> map) {
		return qnABoardMapper.getQnAReplyRowCount(map);
	}
	
	//��� ��� 
	@Override
	public List<QnABoardReplyCommand> getQnAReplyList(Map<String, Object> map) {
		return qnABoardMapper.getQnAReplyList(map);
	}
	//��۵��
	@Override
	public void insertReply(QnABoardReplyCommand boardReply) {
		qnABoardMapper.insertReply(boardReply);
	}
	//��ۼ���
	@Override
	public void updateReply(QnABoardReplyCommand boardReply) {
		qnABoardMapper.updateReply(boardReply);
	}
	//��ۻ���
	@Override
	public void deleteReply(Integer br_num) {
		qnABoardMapper.deleteReply(br_num);
	}

}
