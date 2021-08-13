package global.sesoc.test11.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import global.sesoc.test11.dto.Comments;

@Repository
public class CommentsRepository {
	@Autowired
	SqlSession session;
	
	public int insertComments(Comments co) {
		CommentMapper mapper = session.getMapper(CommentMapper.class);
		int result =mapper.insertComments(co);
		return result;
	}
	
	public List<Comments> selectALl(){
		CommentMapper mapper = session.getMapper(CommentMapper.class);
		List<Comments> list = mapper.selectAll();
		return list;
				
	}
	
	
}
