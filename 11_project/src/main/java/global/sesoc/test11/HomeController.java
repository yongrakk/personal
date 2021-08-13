package global.sesoc.test11;


import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import global.sesoc.test11.dao.BoardRepository;
import global.sesoc.test11.dao.CommentsRepository;
import global.sesoc.test11.dao.PlayListRepository;
import global.sesoc.test11.dto.Board;
import global.sesoc.test11.dto.Comments;
import global.sesoc.test11.dto.PlayList;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
	BoardRepository repository;
	@Autowired
	PlayListRepository repository2;
	@Autowired
	CommentsRepository repository3;
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String index() {
		return "home";
	}
	
	@RequestMapping(value = "index", method = RequestMethod.GET)
	public String home(Model model) {
		
		return "home";
	}
	@RequestMapping(value="/board",method=RequestMethod.GET)
	public String board(Model model) {
		List<Board> boardlist =repository.selectBoard();
		model.addAttribute("boardlist", boardlist);
		return "board";
	}
	@RequestMapping(value="/about",method=RequestMethod.GET)
	public String about(Model model) {
		List<Comments> list =repository3.selectALl();
		model.addAttribute("commentList", list);
		return "about";
	}
	
	@RequestMapping(value="karaoke",method=RequestMethod.GET)
	public String karaoke(HttpSession session,Model model) {
		String userid=(String)session.getAttribute("loginId");
		List<PlayList> playlist = repository2.selectList(userid);
		model.addAttribute("playList", playlist);
		return "karaoke";
	}
	
	@RequestMapping(value="videoget",method=RequestMethod.GET)
	public String getVideo(String id,Model model,HttpSession session,String playlisttitle) {
		String userid=(String)session.getAttribute("loginId");
		String videoid = id;
		if(id != null) {
		id = id.replaceAll("\"", "");
		videoid = "'"+id+"'";
		}
		model.addAttribute("videoid", videoid);
		List<PlayList> list =repository2.selectList(userid);
		model.addAttribute("title", playlisttitle);
		model.addAttribute("playList", list);
		return "karaoke";
	}
	
	@ResponseBody
	@RequestMapping(value="addList",method=RequestMethod.POST)
	public List<PlayList> addList(@RequestBody Map<String,String> map,HttpSession session) {
		String userid = (String)session.getAttribute("loginId");
		String videoid=map.get("videoid");
		String thumnail = map.get("thumnail");
		String title = map.get("title");
		PlayList playlist = new PlayList();
		playlist.setUserid(userid);
		playlist.setVideoid(videoid);
		playlist.setPlaylisttitle(title);
		playlist.setThumnail(thumnail);
		repository2.insertList(playlist);
		List<PlayList> list = repository2.selectList(userid);
		return list;
	}
	@RequestMapping(value="deleteList",method=RequestMethod.GET)
	public String deleteList(int listnum,HttpSession session,PlayList playlist) {
		String userid=(String)session.getAttribute("loginId");
		playlist.setPlaylistnum(listnum);
		playlist.setUserid(userid);
		System.out.println(playlist);
		repository2.deleteList(playlist);
		
		return "redirect:videoget";
	}
	
}
