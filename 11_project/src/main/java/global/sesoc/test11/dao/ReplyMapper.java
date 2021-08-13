package global.sesoc.test11.dao;

import java.util.List;

import global.sesoc.test11.dto.Reply;

public interface ReplyMapper {

	public int insertReply(Reply reply);
	public List<Reply> selectReply(int boardnum);
	public int deleteReply(Reply reply);
	public int deleteAllReply(int boardnum);
}
