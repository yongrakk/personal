package global.sesoc.test11.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import global.sesoc.test11.dto.PlayList;

@Repository
public class PlayListRepository {
	@Autowired
	SqlSession session;
	
	public int insertList(PlayList playlist) {
		PlayListMapper mapper = session.getMapper(PlayListMapper.class);
		int result =mapper.insertList(playlist);
		return result;
	}
	
	public List<PlayList> selectList(String userid){
		PlayListMapper mapper = session.getMapper(PlayListMapper.class);
		List<PlayList> playList = mapper.selectList(userid);
		return playList;
	}
	
	public int deleteList(PlayList playlist) {
		PlayListMapper mapper = session.getMapper(PlayListMapper.class);
		int result = mapper.deleteList(playlist);
		return result;
	}
}
