package global.sesoc.test11;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import global.sesoc.test11.dao.MemberRepository;
import global.sesoc.test11.dto.Member;

@Controller
public class MemberController {
	@Autowired
	MemberRepository repository;
	
	@RequestMapping(value="joinMember", method=RequestMethod.GET)
	public String joinForm() {
		
		return "joinForm";
	}
	@RequestMapping(value="join",method=RequestMethod.POST)
	public String join(Member member) {
		repository.insertMember(member);
		return "home";
	}
	
	@RequestMapping(value="loginMember",method=RequestMethod.GET)
	public String login() {
		return "loginForm";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String loginform(Member member,HttpSession session) {
		Member logMember= repository.login(member);
		if(logMember != null) {
			session.setAttribute("loginId", logMember.getUserid());
			session.setAttribute("userName", logMember.getUsername());
			
		}else {
			return "loginForm";
		}
		
		return "redirect:index";
	}
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String logout(HttpSession session) {
		session.getAttribute("loginId");
		session.invalidate();
		return "redirect:index";
	}
}
