package kr.spring.board.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.spring.board.dao.BoardMapper;
import kr.spring.board.domain.BoardCommand;
import kr.spring.board.domain.BoardReplyCommand;

@Service("boardService")
public class BoardServiceImpl implements BoardService{
	
	@Resource
	private BoardMapper boardMapper;
	
	@Override
	public List<BoardCommand> list(Map<String, Object> map) {
		return boardMapper.list(map);
	}

	@Override
	public int getRowCount(Map<String, Object> map) {
		return boardMapper.getRowCount(map);
	}

	@Override
	public void insert(BoardCommand board) {
		boardMapper.insert(board);
		
	}

	@Override
	public BoardCommand selectBoard(Integer num) {
		return boardMapper.selectBoard(num);
	}

	@Override
	public void updateHit(Integer num) {
		boardMapper.updateHit(num);
	}

	@Override
	public void update(BoardCommand board) {
		boardMapper.update(board);
	}

	@Override
	public void delete(Integer num) {
		//댓글이 존재하면 댓글을 우선 삭제하고 부모글을 삭제
		boardMapper.deleteReplyByNum(num);
		//부모글 삭제
		boardMapper.delete(num);
	}

	@Override
	public List<BoardReplyCommand> listReply(Map<String, Object> map) {
		return boardMapper.listReply(map);
	}

	@Override
	public int getRowCountReply(Map<String, Object> map) {
		return boardMapper.getRowCountReply(map);
	}

	@Override
	public void insertReply(BoardReplyCommand boardReply) {
		boardMapper.insertReply(boardReply);
	}
	
	@Override
	public void updateReply(BoardReplyCommand boardReply) {
		boardMapper.updateReply(boardReply);
	}

	@Override
	public void deleteReply(Integer re_num) {
		boardMapper.deleteReply(re_num);
	}
	
}
