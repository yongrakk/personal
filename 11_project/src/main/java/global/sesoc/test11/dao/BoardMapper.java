package global.sesoc.test11.dao;

import java.util.List;

import global.sesoc.test11.dto.Board;

public interface BoardMapper {
	
	public int insertBoard(Board board);
	public List<Board> selectBoard();
	public Board selectOne(int boardnum);
	public int updateHitCount(int boardnum);
	public int updateBoard(Board board);
	public int deleteBoard(Board board);
}
