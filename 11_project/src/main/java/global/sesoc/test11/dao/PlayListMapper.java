package global.sesoc.test11.dao;

import java.util.List;

import global.sesoc.test11.dto.PlayList;

public interface PlayListMapper {

	public int insertList(PlayList playlist);
	public List<PlayList> selectList(String userid);
	public int deleteList(PlayList playlist);
}
