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

	// 목록 카운트
	@Override
	public int getQnaRowCnt(Map<String, Object> map) {
		return qnABoardMapper.getQnaListRowCount(map);
	}
	
	// - 목록
	@Override
	public List<QnABoardCommand> getQnAList(Map<String, Object> map) {
		return qnABoardMapper.getQnAList(map);
	}

	// 목록 상세
	@Override
	public QnABoardCommand getQnADetail(Integer num) {
		return qnABoardMapper.getQnADetail(num);
	}

	// 목록 등록
	@Override
	public void insertQnA(QnABoardCommand board) {
		qnABoardMapper.insertQnA(board);	
	}
	//목록 조회수 증가 
	@Override
	public void updateHitQnA(Integer num) {
		qnABoardMapper.updateHitQnA(num);	
	}
	
	// 목록 수정
	@Override
	public void updateQnA(QnABoardCommand board) {
		qnABoardMapper.updateQnA(board);	
	}
	
	//답변수정
	@Override
	public void updateAnswerQnA(QnABoardCommand board) {
		qnABoardMapper.updateQnAAnswer(board);	
	}

	// 목록 삭제
	@Override
	public void deleteQnA(Integer num) {
		//댓글이 존재하면 댓글을 우선 삭제하고 부모글을 삭제 
		qnABoardMapper.deleteReplyByNum(num);
		//부모글 삭제 
		qnABoardMapper.deleteQnA(num);	
	}

	
	//댓글부분
	
	//댓글 카운터
	@Override
	public int getQnAReplyRowCount(Map<String, Object> map) {
		return qnABoardMapper.getQnAReplyRowCount(map);
	}
	
	//댓글 목록 
	@Override
	public List<QnABoardReplyCommand> getQnAReplyList(Map<String, Object> map) {
		return qnABoardMapper.getQnAReplyList(map);
	}
	//댓글등록
	@Override
	public void insertReply(QnABoardReplyCommand boardReply) {
		qnABoardMapper.insertReply(boardReply);
	}
	//댓글수정
	@Override
	public void updateReply(QnABoardReplyCommand boardReply) {
		qnABoardMapper.updateReply(boardReply);
	}
	//댓글삭제
	@Override
	public void deleteReply(Integer br_num) {
		qnABoardMapper.deleteReply(br_num);
	}

}
