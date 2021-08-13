package global.sesoc.test11.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import global.sesoc.test11.dto.Board;
import global.sesoc.test11.dto.Reply;

@Repository
public class BoardRepository {

	@Autowired
	SqlSession session;
	
	public int insertBoard(Board board) {
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		int result =mapper.insertBoard(board);
		return result;
	}
		
	public List<Board> selectBoard(){
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		List<Board> boardlist = mapper.selectBoard();
		return boardlist;
	}
	
	public Board selectOne(int boardnum) {
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		Board board = mapper.selectOne(boardnum);
		return board;
	}
	
	public int updateHitCount(int boardnum) {
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		int result = mapper.updateHitCount(boardnum);
		return result;
	}
	
	public int updateBoard(Board board) {
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		int result = mapper.updateBoard(board);
		return result;
	}
	
	public int deleteBoard(Board board) {
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		int result = mapper.deleteBoard(board);
		return result;
	}
	
	public List<Reply> selectReply(int boardnum){
		ReplyMapper mapper = session.getMapper(ReplyMapper.class);
		List<Reply> replyList = mapper.selectReply(boardnum);
		return replyList;
	}
	
	public int insertReply(Reply reply) {
		ReplyMapper mapper = session.getMapper(ReplyMapper.class);
		int result=mapper.insertReply(reply);
		return result;
	}
	
	public int deleteReply(Reply reply) {
		ReplyMapper mapper = session.getMapper(ReplyMapper.class);
		int result = mapper.deleteReply(reply);
		return result;
	}
	
	public int deleteReplyAll(int boardnum) {
		ReplyMapper mapper = session.getMapper(ReplyMapper.class);
		int result = mapper.deleteAllReply(boardnum);
		return result;
	}
}
