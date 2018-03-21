package kr.spring.member.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.spring.enterprise.domain.EnterpriseUserCommand;
import kr.spring.enterprise.service.EnterpriseUserService;
import kr.spring.mail.Email;
import kr.spring.mail.EmailSender;
import kr.spring.member.domain.MemberCommand;
import kr.spring.member.service.MemberService;

@Controller
public class MemberLoginController {
	
	@Resource
	private MemberService memberService;
	@Resource
	private EnterpriseUserService enterpriserUserService; 
	@Autowired
	private Email email;
	@Autowired
	private EmailSender emailSender;
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@ModelAttribute("command")
	public MemberCommand initCommand() {
		return new MemberCommand();
	}
	
	@RequestMapping(value="/user/admin.do")
	public String adminPage(Model model) {
		List<MemberCommand> listMember = memberService.selectAllMember();
		List<EnterpriseUserCommand> listEnter = enterpriserUserService.enterM_idSelectAll();
		
		model.addAttribute("member",listMember);
		model.addAttribute("enter",listEnter);
		return "adminMain";
	}
	
	@RequestMapping(value="/user/findPasswd.do",method=RequestMethod.POST)
	public ModelAndView findPasswd(@ModelAttribute("memberCommand")MemberCommand memberCommand) throws Exception{
		ModelAndView mav = new ModelAndView();
		String passwd = memberService.selectFindPasswd(memberCommand);
		if(passwd==null||passwd.equals("")) {
			log.debug("passwd : " + passwd);
			mav.setViewName("passwdNotFound");
			return mav;
		}
		MemberCommand command = new MemberCommand();
		String id = memberCommand.getM_id();
		command.setM_id(id);
		String pass = null;
		for(int i = 0;i<12;i++) {
			int c = (int)(Math.random()*3)+1;
			char random = '0';
			int ranNum = 0;
			if(c==1) {
				random = (char)((Math.random()*25)+65);
				if(pass==null) {
					pass = Character.toString(random);
				}else {
					pass += Character.toString(random);
				}
			}else if(c==2) {
				random = (char)((Math.random()*25)+97);
				if(pass==null) {
					pass = Character.toString(random);
				}else {
					pass += Character.toString(random);
				}
			}else if(c==3) {
				ranNum = (int)(Math.random()*10)+1;
				if(pass==null) {
					pass = ranNum+"";
				}else {
					pass += ranNum+"";
				}
			}
		}
		email.setContent("임시 비밀 번호는 \""+ pass + "\"입니다.");
		email.setReceiver(id);
		email.setSubject(id + "님의 임시 비밀번호 메일 입니다.");
		emailSender.SendEmail(email);
		
		log.debug("random : " + pass);
		mav.setViewName("passFound");
		return mav;
	}
	
	@RequestMapping(value="/user/findId.do")
	@ResponseBody
	public Map<String,Object> findId(@RequestParam("m_nick")String nick,@RequestParam("md_name")String name) {
		Map<String,Object> map = new HashMap<String,Object>();
		MemberCommand memberCommand = new MemberCommand();
		memberCommand.setM_nick(nick);
		memberCommand.setMd_name(name);
		String id = memberService.selectFindId(memberCommand);
		log.debug("id : " + id);
		if(id!=null) {
			map.put("result", "yes");
			map.put("id", id);
			return map;
		}else {
			map.put("result", "no");
			return map;
		}
	}
	@RequestMapping(value="/user/findIdForm.do")
	public String findIdForm() {
		
		return "findIdForm";
	}
	
	@RequestMapping(value="/user/findPasswdForm.do")
	public String findPasswdForm() {
		return "findPasswdForm";
	}
	
	@RequestMapping(value="/user/loginForm.do", method=RequestMethod.GET)
	public String loginForm() {
		return "loginForm";
	}
	
	@RequestMapping(value="/user/login.do", method=RequestMethod.POST)
	public String login(@ModelAttribute("command") @Valid MemberCommand memberCommand,BindingResult result,HttpSession session,Model model) {
		
		if(result.hasFieldErrors("m_id") || result.hasFieldErrors("m_pw")) {
			return loginForm();
		}
		
		try {
			MemberCommand command = memberService.selectMember(memberCommand.getM_id());
			log.debug("command:"+command);
			EnterpriseUserCommand enterpriseUserCommand = enterpriserUserService.enPriInfoSelect(memberCommand.getM_id());
			log.debug("enter:"+enterpriseUserCommand);
				boolean check = false;
				if(command != null&&enterpriseUserCommand==null) {
					log.debug("access:"+command.getM_access());
					if(command.getM_access()==1) {
						return "AccessDenied";
					}
					//비밀번호 일치 여부
					check = command.isCheckedPasswd(memberCommand.getM_pw());
					
					if(check) {
						List<EnterpriseUserCommand> list = enterpriserUserService.selectEnterpriseUser(memberCommand.getM_id());
						if(list!=null) {
							boolean like = false;
							for(int i=0;i<list.size();i++) {
								if(list.get(i).getCheckAlert()==1) {
									like=true;
								}
							}
							session.setAttribute("like", like);
						}
						session.setAttribute("userId", command.getM_id());
						session.setAttribute("userNick", command.getM_nick());
						session.setAttribute("userGrade", command.getM_grade());
						return "redirect:/main/main.do";
				}
				}else if(enterpriseUserCommand!=null&&command==null) {
					if(enterpriseUserCommand.getM_access()==1) {
						return "AccessDenied";
					}
					//비밀번호 일치 여부
					if(memberCommand.getM_pw().equals(enterpriseUserCommand.getEnterprise_password())) {
						check = true;
					}
				
				if(check) {
					
					session.setAttribute("userId", enterpriseUserCommand.getM_id());
					session.setAttribute("userNick", enterpriseUserCommand.getM_nick());
					session.setAttribute("userGrade", enterpriseUserCommand.getM_grade());
					return "redirect:/main/main.do";
				}
				}else {
					throw new Exception();
				}
				
				return "main";
				
		}catch(Exception e) {
			System.out.println("예외사항 발생");
			result.reject("invalidIdOrPassword");
			return loginForm();
		}
	}
	
	//로그아웃 컨트롤러만 일단
	@RequestMapping("/user/logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/main/main.do";
	}
	@RequestMapping("/user/accessMember.do")
	@ResponseBody
	public Map<String,String> accessMember(@RequestParam("btn")String btn,@RequestParam("id")String id){
		Map<String,String> map = new HashMap<String,String>();
		log.debug("btn : " + btn);
		log.debug("id : " + id);
		MemberCommand command = new MemberCommand();
		command.setM_id(id);
		if(btn.equals("재명")) {
			command.setM_access(1);
			memberService.updateAccess(command);
			map.put("result", "inactive");
		}else if(btn.equals("비재명")) {
			command.setM_access(0);
			memberService.updateAccess(command);
			map.put("result", "active");
		}
		return map;
	}
	@RequestMapping("/user/confirmNickMem.do")
	@ResponseBody
	public Map<String,String> checkNick(@RequestParam("m_nick")String nick){
		Map<String,String> map = new HashMap<String, String>();
		String nickName = memberService.selectMemberByNick(nick);
		if(nickName==null) {
			map.put("result", "solo");
		}
		if(nickName!=null) {
			map.put("result", "du");
		}
		return map;
	}
}








































