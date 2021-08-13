package global.sesoc.test11;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import global.sesoc.test11.dao.BoardRepository;
import global.sesoc.test11.dao.CommentsRepository;
import global.sesoc.test11.dto.Board;
import global.sesoc.test11.dto.Comments;
import global.sesoc.test11.dto.Reply;

@Controller
public class BoardController {
	@Autowired
	BoardRepository repository;
	@Autowired
	CommentsRepository repository2;
	
		
	@RequestMapping(value="write",method=RequestMethod.GET)
	public String write() {
		return "writeForm";
	}
	@RequestMapping(value="saveBoard",method=RequestMethod.GET)
	public String saveboard(Board board,HttpSession session) {
		String userid= (String)session.getAttribute("loginId");
		board.setUserid(userid);
		repository.insertBoard(board);
		
		return "redirect:board";
	}
	@RequestMapping(value="detailBoard",method=RequestMethod.GET)
	public String detailBoard(int boardnum,Model model) {
		Board boardOne =repository.selectOne(boardnum);
		List<Reply> replyList = repository.selectReply(boardnum);
		repository.updateHitCount(boardnum);
		model.addAttribute("replyList", replyList);
		model.addAttribute("boardOne", boardOne);
		
		return "detailBoard";
	}
	
	@RequestMapping(value="update",method=RequestMethod.GET)
	public String update(Board board,Model model) {
		int boardnum=board.getBoardnum();
		Board selectedBoard=repository.selectOne(boardnum);
		String title = selectedBoard.getTitle();
		String boardtext = selectedBoard.getBoardtext();
		model.addAttribute("title", title);
		model.addAttribute("boardtext", boardtext);
		model.addAttribute("boardnum", boardnum);
		return "updateForm";
	}
	
	@RequestMapping(value="updateBoard",method=RequestMethod.GET)
	public String updateBoard(Board board,Model model,HttpSession session) {
		String userid = (String)session.getAttribute("loginId");
		board.setUserid(userid);
		repository.updateBoard(board);
		return "redirect:board";
	}
	
	@RequestMapping(value="deleteBoard",method=RequestMethod.GET)
	public String deleteBoard(Board board,Model model,HttpSession session) {
		String userid = (String)session.getAttribute("loginId");
		board.setUserid(userid);
		int boardnum = board.getBoardnum();
		System.out.println(boardnum);
		System.out.println(board);
		repository.deleteBoard(board);
		repository.deleteReplyAll(boardnum);
		
		return "redirect:board";
	}
	
	@RequestMapping(value="saveReply",method=RequestMethod.GET)
	public String saveReply(Reply reply,HttpSession session,RedirectAttributes rttr) {
		String userid =(String)session.getAttribute("loginId");
		reply.setUserid(userid);
		int boardnum = reply.getBoardnum();
		repository.insertReply(reply);
		rttr.addAttribute("boardnum",boardnum);
		return "redirect:detailBoard";
	}
	
	@RequestMapping(value="deleteReply",method=RequestMethod.GET)
	public String deleteReply(Reply reply,HttpSession session,RedirectAttributes rttr) {
		String userid = (String)session.getAttribute("loginId");
		reply.setUserid(userid);
		repository.deleteReply(reply);
		rttr.addAttribute("boardnum", reply.getBoardnum());
		return "redirect:detailBoard";
	}
	
	@RequestMapping(value="saveComments",method=RequestMethod.POST)
	public String saveComments(Comments comments) {
		repository2.insertComments(comments);
		return "redirect:about";
	}
	
}
