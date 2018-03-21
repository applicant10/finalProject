package kr.spring.resume.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.spring.enterprise.service.EnterpriseUserService;
import kr.spring.resume.dao.UserResumeMapper;
import kr.spring.resume.domain.UserResumeCommand;
import kr.spring.resume.service.UserResumeService;

@Controller
public class UserResumeController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private UserResumeService userResumeService;
	
	@Resource
	private EnterpriseUserService enterpriseUserService;
	
	@Resource
	private UserResumeMapper userResumeMapper;
	
	@RequestMapping(value="/user/address.do")
	public String address() {
		return "address";
	}
	@RequestMapping(value="/main/main.do")
	public ModelAndView resumeList(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		String id = (String)session.getAttribute("userId");
		List<UserResumeCommand> list = new ArrayList<UserResumeCommand>();
		List<UserResumeCommand> listSub = new ArrayList<UserResumeCommand>();
		if(id!=null) {
			list = userResumeService.selectAll();
			Iterator<UserResumeCommand> iter = list.iterator();
			int level = (Integer)session.getAttribute("userGrade");
			while(iter.hasNext()) {
				UserResumeCommand command = iter.next();
				if(command.getPublicType().equals("private")&&level>=20) {
					log.debug("private : " + list);
					iter.remove();
					if(list.size()==0) {
						break;
					}
				}
				if((!id.equals(command.getM_id())&&command.getPublicType().equals("onlyEnter"))&&level<20) {
					log.debug("onlyEnter : " + list);
					iter.remove();
					if(list.size()==0) {
						log.debug("0");
						break;
					}
				}
			}
			
		}
		if(id==null) {
			list = userResumeService.selectPublicResume();
		}
		if(list.size()>0) {
			Iterator<UserResumeCommand> iter = list.iterator();
			while(iter.hasNext()) {
				UserResumeCommand command = iter.next();
				if(command.getPublicType().equals("default")&&!id.equals(command.getM_id())) {
					log.debug("default");
					iter.remove();
					if(list.size()==0) {
						break;
					}
				}
			}
		}
		if(list.size()==0||list==null) {
			UserResumeCommand command = new UserResumeCommand();
			command.setM_id("Example");
			command.setM_nick("Example");
			listSub.add(command);
		}
		
		log.debug("list : " + list);
		if(list.size()>0) {
			mav.setViewName("main");
			mav.addObject("list",list);
		}else if(list.size()==0) {
			mav.setViewName("main");
			mav.addObject("list",listSub);
		}
		log.debug("list 333: "+list);
		return mav;
	}
	
	@RequestMapping(value="/user/myPageMain.do")
	public String myPageMain(HttpSession session) {
		int level = Integer.parseInt(session.getAttribute("userGrade").toString());
		log.debug("level : " + level);
		if(level>=20&&30>level) {
			return "myEnterPageMain";
		}
		return "myPageMain";
	}
	
	@RequestMapping(value="/user/myResumeForm.do")
	public String myResumeForm(Model model) {
		
		model.addAttribute("resumeCommand",new UserResumeCommand());
		return "myResumeForm";
	}
	
	@RequestMapping(value="/user/myResume.do")
	public String myResume(HttpSession session,Model model) {
		
		String m_id = (String)session.getAttribute("userId");
		
		UserResumeCommand resumeCommand = userResumeService.selectResume(m_id);
		UserResumeCommand resumeGe = userResumeService.selectUserInfo(m_id);
		
		UserResumeCommand rcCareer = userResumeService.selectCareer(m_id);
		UserResumeCommand rcAwards = userResumeService.selectAwards(m_id);
		UserResumeCommand rcAchieve = userResumeService.selectAchieve(m_id);
		UserResumeCommand rcHobby = userResumeService.selectHobby(m_id);
		UserResumeCommand rcLicense = userResumeService.selectLicense(m_id);
		UserResumeCommand rcPortfolio = userResumeService.selectPortfolio(m_id);
		
		if(resumeCommand==null) {
			return "myResumeNotFound";
		}
		if(resumeGe!=null) {
			resumeCommand.setMd_name(resumeGe.getMd_name());
			resumeCommand.setMd_phone(resumeGe.getMd_phone());
		}
		if(rcPortfolio!=null) {
			resumeCommand.setFbytes(rcPortfolio.getFbytes());
			resumeCommand.setFname(rcPortfolio.getFname());
		}
		if(rcLicense!=null){
			resumeCommand.setL_name(rcLicense.getL_name());
			resumeCommand.setL_com(rcLicense.getL_com());
			resumeCommand.setL_year(rcLicense.getL_year());
		}
		if(rcHobby!=null) {
			resumeCommand.setH_name(rcHobby.getH_name());
		}
		if(rcAchieve!=null) {
			resumeCommand.setA_title(rcAchieve.getA_title());
			resumeCommand.setA_ed(rcAchieve.getA_ed());
			resumeCommand.setA_grade(rcAchieve.getA_grade());
		}
		if(rcAwards!=null) {
			resumeCommand.setRc_title(rcAwards.getRc_title());
			resumeCommand.setRc_inst(rcAwards.getRc_inst());
			resumeCommand.setRc_year(rcAwards.getRc_year());
			resumeCommand.setRc_content(rcAwards.getRc_content());
		}
		if(rcCareer!=null) {
			resumeCommand.setRl_title(rcCareer.getRl_title());
			resumeCommand.setRl_position(rcCareer.getRl_position());
			resumeCommand.setRl_sd(rcCareer.getRl_sd());
			resumeCommand.setRl_ed(rcCareer.getRl_ed());
			resumeCommand.setRl_def(rcCareer.getRl_def());
		}
		
		
		if(log.isDebugEnabled()) {
			log.debug("<<userResumeCommand>> : " + resumeCommand);
			log.debug("<<career>> : " + resumeCommand);
			log.debug("<<license>> : " + rcLicense);
			log.debug("<<portfolio>> : " + rcPortfolio);
			log.debug("<<achieve>> : " + rcAchieve);
			log.debug("<<awards>> : " + rcAwards);
			log.debug("<<hobby>> : " + rcHobby);
			log.debug("id : " + m_id);
		}
		
		model.addAttribute("resumeCommand",resumeCommand);
		if(resumeCommand.getR_type().equals("basic")) {
			return "basic";
		}else if(resumeCommand.getR_type().equals("standard")) {
			return "standard";
		}else if(resumeCommand.getR_type().equals("bubble")) {
			return "bubble";
		}else {
			return "myResume";
		}
	}
	
	//-----------------------------------이력서 작성
	@RequestMapping(value="/user/myResumeInsert.do",method=RequestMethod.POST)
	public String insertGeneral(@ModelAttribute("resumeCommand") UserResumeCommand resumeCommand,HttpSession session,BindingResult result) {
		
		String userId = (String)session.getAttribute("userId");
		
		UserResumeCommand urc = new UserResumeCommand();
		urc = userResumeMapper.selectUserInfo(userId);
		resumeCommand.setM_id(urc.getM_id());
		if(resumeCommand.getR_intro()!=null) {
			resumeCommand.setR_intro(resumeCommand.getR_intro().replace("\r\n","<br>"));
		}
		if(resumeCommand.getMd_name()==null) {
			resumeCommand.setMd_name(urc.getMd_name());
		}
		if(resumeCommand.getMd_phone()==null) {
			resumeCommand.setMd_phone(urc.getMd_phone());
		}
		
		if(log.isDebugEnabled()) {
			log.debug("<<userResumeCommand>> : " + resumeCommand);
		}
		
		userResumeService.insertResumeBasic(resumeCommand);
		
		if(resumeCommand.getFname()!=null) {
			userResumeService.insertPortfolio(resumeCommand);
		}
		if(resumeCommand.getL_name()!=null){
			userResumeService.insertLicense(resumeCommand);
		}
		if(resumeCommand.getH_name()!=null) {
			userResumeService.insertHobby(resumeCommand);
		}
		if(resumeCommand.getA_title()!=null) {
			userResumeService.insertAchieve(resumeCommand);
		}
		if(resumeCommand.getRc_title()!=null) {
			userResumeService.insertAwards(resumeCommand);
		}
		if(resumeCommand.getRl_title()!=null) {
			userResumeService.insertCareer(resumeCommand);
		}
		
		return "redirect:/main/main.do";
	}
	
	//----------------------------이력서 수정
	@RequestMapping(value="/resume/myResumeModifyForm.do")
	public String resumeModifyForm(HttpSession session,Model model) {
		String userId = (String)session.getAttribute("userId");
		
		UserResumeCommand resumeCommand = userResumeService.selectResume(userId);
		resumeCommand.setMd_name(userResumeService.selectUserInfo(userId).getMd_name());
		resumeCommand.setMd_phone(userResumeService.selectUserInfo(userId).getMd_phone());
		
		UserResumeCommand rcCareer = userResumeService.selectCareer(userId);
		UserResumeCommand rcAwards = userResumeService.selectAwards(userId);
		UserResumeCommand rcAchieve = userResumeService.selectAchieve(userId);
		UserResumeCommand rcHobby = userResumeService.selectHobby(userId);
		UserResumeCommand rcLicense = userResumeService.selectLicense(userId);
		UserResumeCommand rcPortfolio = userResumeService.selectPortfolio(userId);
		
		if(rcPortfolio!=null) {
			resumeCommand.setFbytes(rcPortfolio.getFbytes());
			resumeCommand.setFname(rcPortfolio.getFname());
		}
		if(rcLicense!=null){
			resumeCommand.setL_name(rcLicense.getL_name());
			resumeCommand.setL_com(rcLicense.getL_com());
			resumeCommand.setL_year(rcLicense.getL_year());
		}
		if(rcHobby!=null) {
			resumeCommand.setH_name(rcHobby.getH_name());
		}
		if(rcAchieve!=null) {
			resumeCommand.setA_title(rcAchieve.getA_title());
			resumeCommand.setA_ed(rcAchieve.getA_ed());
			resumeCommand.setA_grade(rcAchieve.getA_grade());
		}
		if(rcAwards!=null) {
			resumeCommand.setRc_title(rcAwards.getRc_title());
			resumeCommand.setRc_inst(rcAwards.getRc_inst());
			resumeCommand.setRc_year(rcAwards.getRc_year());
			resumeCommand.setRc_content(rcAwards.getRc_content());
		}
		if(rcCareer!=null) {
			resumeCommand.setRl_title(rcCareer.getRl_title());
			resumeCommand.setRl_position(rcCareer.getRl_position());
			resumeCommand.setRl_sd(rcCareer.getRl_sd());
			resumeCommand.setRl_ed(rcCareer.getRl_ed());
			resumeCommand.setRl_def(rcCareer.getRl_def());
		}
		
		model.addAttribute("resumeCommand",resumeCommand);
		
		return "myResumeModify";
	}
	
	@RequestMapping(value="/resume/myResumeModify.do",method=RequestMethod.POST)
	public String resumeModify(@ModelAttribute("resumeCommand")UserResumeCommand resumeCommand,HttpSession session) {
		log.debug("resumeCommand : " + resumeCommand);
		String userId = (String)session.getAttribute("userId");
		resumeCommand.setM_id(userId);
		if(resumeCommand.getR_intro()!=null) {
			resumeCommand.setR_intro(resumeCommand.getR_intro().replace("\r\n","<br>"));
		}
		UserResumeCommand rC = userResumeService.selectResume(userId);
		UserResumeCommand rP = userResumeService.selectPortfolio(userId);
		if(log.isDebugEnabled()) {
			log.debug(resumeCommand.getFname());
			log.debug("<<UserResumeCommand>>" + rP);
			log.debug("rC : " + rC.getR_pname());
		}
		if(rC!=null) {
			if(rC.getR_pname()!=null&&resumeCommand.getR_pname()==null) {
				resumeCommand.setR_pic(rC.getR_pic());
				resumeCommand.setR_pname(rC.getR_pname());
			}
		}
		if(rP!=null) {
			if(rP.getFname()!=null&&(resumeCommand.getfFile().isEmpty()||resumeCommand.getfFile()==null)) {
				resumeCommand.setFbytes(rP.getFbytes());
				resumeCommand.setFname(rP.getFname());
			}
		}
		
		UserResumeCommand rcCareer = userResumeService.selectCareer(userId);
		UserResumeCommand rcAwards = userResumeService.selectAwards(userId);
		UserResumeCommand rcAchieve = userResumeService.selectAchieve(userId);
		UserResumeCommand rcHobby = userResumeService.selectHobby(userId);
		UserResumeCommand rcLicense = userResumeService.selectLicense(userId);
		UserResumeCommand rcPortfolio = userResumeService.selectPortfolio(userId);
		
		userResumeService.modifyResumeGeneral(resumeCommand);

		if(rcCareer!=null&&resumeCommand.getRl_title()!=null) {
			userResumeService.modifyResumeCareer(resumeCommand);
		}else if(rcCareer==null&&resumeCommand.getRl_title()!=null) {
			userResumeService.insertCareer(resumeCommand);
		}
		if(rcAwards!=null&&resumeCommand.getRc_title()!=null) {
			userResumeService.modifyResumeAwards(resumeCommand);
		}else if(rcAwards==null&&resumeCommand.getRc_title()!=null) {
			userResumeService.insertAwards(resumeCommand);
		}
		if(rcAchieve!=null&&resumeCommand.getA_title()!=null) {
			userResumeService.modifyResumeAchieve(resumeCommand);
		}else if(rcAchieve==null&&resumeCommand.getA_title()!=null) {
			userResumeService.insertAchieve(resumeCommand);			
		}
		if(rcHobby!=null&&resumeCommand.getH_name()!=null) {
			userResumeService.modifyResumeHobby(resumeCommand);
		}else if(rcHobby==null&&resumeCommand.getH_name()!=null) {
			userResumeService.insertHobby(resumeCommand);
		}
		if(rcLicense!=null&&resumeCommand.getL_name()!=null) {
			userResumeService.modifyResumeLicense(resumeCommand);
		}else if(rcLicense==null&&resumeCommand.getL_name()!=null) {
			userResumeService.insertLicense(resumeCommand);			
		}
		if(rcPortfolio!=null&&resumeCommand.getFname()!=null) {
			userResumeService.modifyResumePortfolio(resumeCommand);	
		}else if(rcPortfolio==null&&resumeCommand.getFname()!=null) {
			userResumeService.insertPortfolio(resumeCommand);
		}
		return "myPageMain";
	}
	
	
	//----------------------------------이력서 삭제
	@RequestMapping(value="/resume/myResumeDeleteForm.do")
	public String resumeDeleteCheck() {
		
		return "myResumeDeleteCheck";
	}
	
	@RequestMapping(value="/user/myResumeDelete.do")
	public String resumeDelete(@RequestParam("password")String password,HttpSession session) {
		
		if(log.isDebugEnabled()) {
			log.debug("password : "+password);
		}
		String userId = (String)session.getAttribute("userId");
		String pw = userResumeService.selectUserInfo(userId).getM_pw();
		if(!password.equals(pw)) {
			return "myResume";
		}
		
		UserResumeCommand rcCareer = userResumeService.selectCareer(userId);
		UserResumeCommand rcAwards = userResumeService.selectAwards(userId);
		UserResumeCommand rcAchieve = userResumeService.selectAchieve(userId);
		UserResumeCommand rcHobby = userResumeService.selectHobby(userId);
		UserResumeCommand rcLicense = userResumeService.selectLicense(userId);
		UserResumeCommand rcPortfolio = userResumeService.selectPortfolio(userId);
		
		if(rcPortfolio!=null) {
			userResumeService.deletePortfolio(userId);
		}
		if(rcLicense!=null){
			userResumeService.deleteLicense(userId);
		}
		if(rcHobby!=null) {
			userResumeService.deleteHobby(userId);
		}
		if(rcAchieve!=null) {
			userResumeService.deleteAchieve(userId);
		}
		if(rcAwards!=null) {
			userResumeService.deleteAwards(userId);;
		}
		if(rcCareer!=null) {
			userResumeService.deleteCareer(userId);;
		}
		
		userResumeService.deleteResumeGeneral(userId);
		
		return "myPageMain";
	}
	
	//파일다운로드
	@RequestMapping("/user/file.do")
	public ModelAndView download(@RequestParam("userId")String userId) {
		UserResumeCommand resumeCommand = userResumeService.selectPortfolio(userId);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("downloadView");
		mav.addObject("downloadFile",resumeCommand.getFbytes());
		mav.addObject("filename", resumeCommand.getFname());
		
		return mav;
	}
	
	//이미지 출력
	@RequestMapping("/user/imageView.do")
	public ModelAndView viewImage(@RequestParam("userId")String userId) {
		UserResumeCommand resumeCommand = userResumeService.selectResume(userId);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("imageView");
		mav.addObject("imageFile",resumeCommand.getR_pic());
		mav.addObject("filename",resumeCommand.getR_pname());
		
		return mav;
	}	
}

























