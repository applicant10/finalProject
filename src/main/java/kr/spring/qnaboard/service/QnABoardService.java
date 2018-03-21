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
	// 목록  조회
	// - 목록 카운트
	@Transactional(readOnly=true)
	public int getQnaRowCnt(Map<String,Object> map);
	// - 목록
	@Transactional(readOnly=true)
	public List<QnABoardCommand> getQnAList(Map<String,Object> map);
	
	// 목록 상세
	@Transactional(readOnly=true)
	public QnABoardCommand getQnADetail(Integer num);
	
	// 목록 등록
	public void insertQnA(QnABoardCommand board);
	
	// 목록 조회수 증가 
	public void updateHitQnA(Integer num);
	
	// 목록 수정
	public void updateQnA(QnABoardCommand board);
	
	// 목록 삭제
	public void deleteQnA(Integer num);
	
	// - 목록답변 
	
	// 목록 답변 수정
	public void updateAnswerQnA(QnABoardCommand board);
	
	
	//댓글조회 
	
	//댓글 카운트
	@Transactional(readOnly=true)
	public int getQnAReplyRowCount(Map<String,Object> map);
	//댓글목록
	@Transactional(readOnly=true)
	public List<QnABoardReplyCommand> getQnAReplyList(Map<String, Object> map);
	///댓글등록
	public void insertReply(QnABoardReplyCommand boardReply);
	//댓글 수정 
	public void updateReply(QnABoardReplyCommand boardReply);
	//댓글삭제 
	public void deleteReply(Integer br_num);
	
	
	
}









