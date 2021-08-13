package global.sesoc.test11.dao;

import java.util.List;

import global.sesoc.test11.dto.Comments;

public interface CommentMapper {
	public int insertComments(Comments co);
	public List<Comments> selectAll();
}
