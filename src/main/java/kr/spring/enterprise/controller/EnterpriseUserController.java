package kr.spring.enterprise.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.spring.enterprise.domain.EnterpriseUserCommand;
import kr.spring.enterprise.service.EnterpriseUserService;
import kr.spring.resume.domain.UserResumeCommand;
import kr.spring.resume.service.UserResumeService;

@Controller
public class EnterpriseUserController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private EnterpriseUserService enterpriseUserService;
	@Resource
	private UserResumeService userResumeService;
	
	@RequestMapping(value="/user/enterDetailInfo.do")
	public ModelAndView detailInfo(@RequestParam("email")String email) {
		ModelAndView mav = new ModelAndView();
		EnterpriseUserCommand enterpriseUserCommand = enterpriseUserService.enterDetailAllSelect(email);
		mav.setViewName("enterDetailInfo");
		mav.addObject("info",enterpriseUserCommand);
		return mav;
	}
	
	@RequestMapping(value="/user/enterpriseMod.do")
	public String enterpriseMod(@ModelAttribute("enterpriseUserCommand")EnterpriseUserCommand enterpriseUserCommand,HttpSession session) {
		String userId = (String)session.getAttribute("userId");
		enterpriseUserCommand.setM_id(userId);
		enterpriseUserService.enterpriseInfoModify(enterpriseUserCommand);
		return "enterInfo";
	}
	
	@RequestMapping(value="/user/enterpriseModifyInfo.do")
	public ModelAndView enterpriseModifyInfo(HttpSession session) {
		
		String id = (String)session.getAttribute("userId");
		ModelAndView mav = new ModelAndView();
		
		EnterpriseUserCommand enterpriseUserCommand= enterpriseUserService.enPriInfoSelect(id);
		
		mav.setViewName("enterModifyInfo");
		mav.addObject("enterpriseUserCommand",enterpriseUserCommand);
		
		return mav;
	}
	
	@RequestMapping(value="/user/enterpriseDeleteInfo.do")
	public String enterpriseDeleteInfo(HttpSession session,@RequestParam("password")String password) {
		String id = (String)session.getAttribute("userId");
		String enter = enterpriseUserService.enterM_idSelect(id);
		String passwd = enterpriseUserService.enterPassword(id);
		String member = enterpriseUserService.memberM_idSelect(id);
		String enterResume = enterpriseUserService.enterResumeSelect(id);

		if(!passwd.equals(password)) {
			return "false";
		}
		
		if(enterResume!=null) {
			enterpriseUserService.enterResumeDeleteAll(id);
		}
		if(enter!=null) {
			enterpriseUserService.enterDetailDelete(id);
		}
		if(member!=null) {
			enterpriseUserService.enterMemberDelete(id);
		}
		session.invalidate();
		return "main";
	}
	
	@RequestMapping(value="/user/deleteEnterResume.do")
	public String deleteEnterResume(@RequestParam("chLikeResume")String it,HttpSession session) {
		log.debug("it : " + it );
		List<String> listUp = new ArrayList<String>();
		List<String> list = new ArrayList<String>();
		EnterpriseUserCommand enterpriseUserCommand = new EnterpriseUserCommand();
		enterpriseUserCommand.setResumeList(it);
		list = enterpriseUserCommand.getResumeList();
		
		String userId = (String)session.getAttribute("userId");

		List<String> listDb = new ArrayList<String>();
		EnterpriseUserCommand enterpriseUserCommandDb = new EnterpriseUserCommand();
		String enterResume = enterpriseUserService.enterResumeSelect(userId);
		enterpriseUserCommandDb.setResumeList(enterResume);
		listDb = enterpriseUserCommandDb.getResumeList();
		log.debug("listDb : " + listDb);
		log.debug("list : " + list);
		enterpriseUserService.enterLikeDelete(userId);
		
		if(listDb.size()==1||listDb.size()==list.size()) {
			enterpriseUserService.enterResumeDeleteAll(userId);
			return "redirect:/user/enterResume.do";
		}
		Iterator<String> iter = listDb.iterator();
		while(iter.hasNext()) {
			String remove = iter.next();
			for(int i=0;i<list.size();i++) {
				if(list.get(i).equals(remove)) {
					iter.remove();
				}
			}
		}
		log.debug("listDb2 : " + listDb);
		
		String data = null;
		if(listDb.size()>1) {
			for(int i=0;i<listDb.size();i++) {
				if(i==0) {
					data = listDb.get(i)+",";
				}
				if(i>0&&i<listDb.size()-1) {
					data += listDb.get(i)+",";
				}
				log.debug("listUp:"+listDb.get(i));
				if(i==listDb.size()-1){
					data += listDb.get(i);
					log.debug("listUpEnd:"+listDb.get(i));
				}
			}
		}
		if(listDb.size()==1) {
			data = listDb.get(0);
		}
		enterpriseUserService.enterResumeDelete(data);
		return "redirect:/user/enterResume.do";
	}
	
	@RequestMapping(value="/user/registerEnterpriseForm.do", method=RequestMethod.GET)
	public String registerEnterpriseForm() {
		return "registerEnterpriseForm";
	}
	
	@RequestMapping(value="/user/enterpriseReg.do",method=RequestMethod.POST)
	public String registerEnterprise(@ModelAttribute("enterpriseUserCommand") @Valid EnterpriseUserCommand enterpriseUserCommand,HttpSession session) {

		enterpriseUserService.enPriRegister(enterpriseUserCommand);
		enterpriseUserService.enPriUserInsert(enterpriseUserCommand);
		EnterpriseUserCommand command = enterpriseUserService.enPriInfoSelect(enterpriseUserCommand.getM_id());
		session.setAttribute("userId", enterpriseUserCommand.getM_id());
		session.setAttribute("userNick", command.getM_nick());
		session.setAttribute("userGrade", command.getM_grade());
		
		return "main";
	}
	@RequestMapping(value="/user/searchJungler.do")
	public ModelAndView resumeSearchWithOption(@RequestParam Map<String,String> map,HttpSession session) {
		log.debug(map);
		ModelAndView mav = new ModelAndView();
		List<UserResumeCommand> list = new ArrayList<UserResumeCommand>();
		int level = (Integer)session.getAttribute("userGrade");
		String id = (String)session.getAttribute("userId");
		if(!map.get("r_loc").equals("없음")&&map.get("m_id").equals("")) {
			list = enterpriseUserService.selectByLoc(map.get("r_loc"));
			log.debug("list : " + list.size());
			Iterator<UserResumeCommand> iter = list.iterator();
			while(iter.hasNext()) {
				UserResumeCommand command = iter.next();
				if(command.getPublicType().equals("private")&&level>=20) {
					log.debug("private : " + list);
					iter.remove();
					if(list.size()==0) {
						break;
					}
				}else if((!id.equals(command.getM_id())&&command.getPublicType().equals("onlyEnter"))&&level<20) {
					log.debug("onlyEnter : " + list);
					iter.remove();
					if(list.size()==0) {
						log.debug("0");
						break;
					}
				}else if(command.getPublicType().equals("default")&&!id.equals(command.getM_id())) {
					log.debug("default");
					iter.remove();
					if(list.size()==0) {
						break;
					}
				}
			}
		}
		if(!map.get("r_loc").equals("없음")&&!map.get("m_id").equals("")) {
			UserResumeCommand userCommand = new UserResumeCommand();
			userCommand.setR_loc(map.get("r_loc"));
			userCommand.setM_id(map.get("m_id"));
			list = enterpriseUserService.selectAlloption(userCommand);
			Iterator<UserResumeCommand> iter = list.iterator();
			while(iter.hasNext()) {
				UserResumeCommand command = iter.next();
				if(command.getPublicType().equals("private")&&level>=20) {
					log.debug("private : " + list);
					iter.remove();
					if(list.size()==0) {
						break;
					}
				}else if((!id.equals(command.getM_id())&&command.getPublicType().equals("onlyEnter"))&&level<20) {
					log.debug("onlyEnter : " + list);
					iter.remove();
					if(list.size()==0) {
						log.debug("0");
						break;
					}
				}else if(command.getPublicType().equals("default")&&!id.equals(command.getM_id())) {
					log.debug("default");
					iter.remove();
					if(list.size()==0) {
						break;
					}
				}
			}
		}
		if(map.get("r_loc").equals("없음")&&!map.get("m_id").equals("")) {
			list = enterpriseUserService.selectById(map.get("m_id"));
			Iterator<UserResumeCommand> iter = list.iterator();
			while(iter.hasNext()) {
				UserResumeCommand command = iter.next();
				if(command.getPublicType().equals("private")&&level>=20) {
					log.debug("private : " + list);
					iter.remove();
					if(list.size()==0) {
						break;
					}
				}else if((!id.equals(command.getM_id())&&command.getPublicType().equals("onlyEnter"))&&level<20) {
					log.debug("onlyEnter : " + list);
					iter.remove();
					if(list.size()==0) {
						log.debug("0");
						break;
					}
				}else if(command.getPublicType().equals("default")&&!id.equals(command.getM_id())) {
					log.debug("default");
					iter.remove();
					if(list.size()==0) {
						break;
					}
				}
			}
		}
		if(list.size()>0) {
			for(int i=0;i<list.size();i++) {
				if(list.get(i).getR_intro()!=null) {
					if(list.get(i).getR_intro().length()>=15) {
					String intro = list.get(i).getR_intro().substring(0, 15);
					list.get(i).setR_intro(intro+"...");
					}else {
						list.get(i).setR_intro(list.get(i).getR_intro()+"...");
					}
				}
				if(list.get(i).getR_job()==null) {
					list.get(i).setR_job("어떤일이든 맡겨만 주세요!");
				}
			}
		}
		int num=1;
		if(list.isEmpty()) {
			num=0;
		}
		mav.setViewName("resumeList");
		mav.addObject("list",list);
		mav.addObject("numm",num);
				
		return mav;
	}
	@RequestMapping(value="/user/resumeList.do")
	public ModelAndView resumeList(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		int level = (Integer)session.getAttribute("userGrade");
		String id = (String)session.getAttribute("userId");
		List<UserResumeCommand> list = new ArrayList<UserResumeCommand>();
		List<UserResumeCommand> listSub = new ArrayList<UserResumeCommand>();
		list = enterpriseUserService.enPriSelect();
		if(level>=20) {
			Iterator<UserResumeCommand> iter = list.iterator();
			while(iter.hasNext()) {
				UserResumeCommand command = iter.next();
				if(command.getPublicType().equals("default")||command.getPublicType().equals("private")) {
						iter.remove();
				}
			}
		}else if(level<20) {
			Iterator<UserResumeCommand> iter = list.iterator();
			while(iter.hasNext()) {
				UserResumeCommand command = iter.next();
				if(command.getPublicType().equals("onlyEnter")&&!command.getM_id().equals(id)) {
					iter.remove();
				}else if(command.getPublicType().equals("default")&&!command.getM_id().equals(id)) {
					iter.remove();
				}
			}
		}
		log.debug("list : " + list);
		log.debug("listsize : " + list.size());
		if(list.size()>0) {
			for(int i=0;i<list.size();i++) {
				if(list.get(i).getR_intro()!=null) {
					if(list.get(i).getR_intro().length()>=15) {
					String intro = list.get(i).getR_intro().substring(0, 15);
					list.get(i).setR_intro(intro+"...");
					}else {
						list.get(i).setR_intro(list.get(i).getR_intro()+"...");
					}
				}
				if(list.get(i).getR_job()==null) {
					list.get(i).setR_job("어떤일이든 맡겨만 주세요!");
				}
			}
		}
		if(list.size()>6) {
			for(int i=0;i<6;i++) {
				log.debug("list : " + list.get(i));
				listSub.add(list.get(i));
			}
		}
		if(list.size()==1||list.size()==2) {
			for(int i=0;i<list.size();i++) {
				log.debug("list : " + list.get(i));
				listSub.add(list.get(i));
			}
		}
		int num = 0;
		if(listSub.size()>0) {
			num = listSub.get(listSub.size()-1).getR_num();
		}
		log.debug("num :" + num);
		if(listSub.size()==0) {
			num=0;
			mav.setViewName("resumeList");
			mav.addObject("list",listSub);
			mav.addObject("num",num);
			return mav;
		}
		
		mav.setViewName("resumeList");
		mav.addObject("num",num);
		mav.addObject("list",listSub);
		
		return mav;
	}
	@RequestMapping(value="/user/enpriReView.do",method=RequestMethod.GET)
	public ModelAndView enterResumeDetail(@RequestParam("m_id") String m_id,HttpSession session) {
		ModelAndView mav = new ModelAndView();
		
		if(m_id.equals("Example")) {
			mav.setViewName("samplePage");
			return mav;
		}
		
		UserResumeCommand resumeCommand = userResumeService.selectResume(m_id);
		UserResumeCommand resumeGe = userResumeService.selectUserInfo(m_id);
		
		UserResumeCommand rcCareer = userResumeService.selectCareer(m_id);
		UserResumeCommand rcAwards = userResumeService.selectAwards(m_id);
		UserResumeCommand rcAchieve = userResumeService.selectAchieve(m_id);
		UserResumeCommand rcHobby = userResumeService.selectHobby(m_id);
		UserResumeCommand rcLicense = userResumeService.selectLicense(m_id);
		UserResumeCommand rcPortfolio = userResumeService.selectPortfolio(m_id);
		
		int finger = 0;
		
		String id = (String)session.getAttribute("userId");
		String enterResume = enterpriseUserService.enterResumeSelect(id);
		List<String> list = new ArrayList<String>();
		List<UserResumeCommand> listResume = new ArrayList<UserResumeCommand>();
		EnterpriseUserCommand enterpriseUserCommand = new EnterpriseUserCommand();
		if(enterResume!=null) {
			enterpriseUserCommand.setResumeList(enterResume);
			list = enterpriseUserCommand.getResumeList();
			log.debug("list : " + list);
			for(int i=0;i<list.size();i++) {
				UserResumeCommand userResumeCommand=enterpriseUserService.selectAllResume(list.get(i));
				log.debug("listResume : " + userResumeCommand);
				listResume.add(userResumeCommand);
			}
			for(int i=0;i<listResume.size();i++) {
				if(m_id.equals(listResume.get(i).getM_id())) {
					finger=1;
				}
			}
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
		if(resumeCommand.getR_type().equals("basic")) {
			mav.setViewName("basic");
		}else if(resumeCommand.getR_type().equals("standard")) {
			mav.setViewName("standard");
		}else if(resumeCommand.getR_type().equals("bubble")) {
			mav.setViewName("bubble");
		}else {
			mav.setViewName("resumeDetail");
		}
		mav.addObject("resumeCommand",resumeCommand);
		mav.addObject("finger",finger);
		
		return mav;
	}
	
	@RequestMapping("/user/enterInfo.do")
	public ModelAndView enterInfo(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		String id = (String)session.getAttribute("userId");
		
		EnterpriseUserCommand enterpriseUserCommand= enterpriseUserService.enPriInfoSelect(id);
		
		mav.setViewName("enterInfo");
		mav.addObject("enterpriseUserCommand",enterpriseUserCommand);
		
		return mav;
	}
	
	@RequestMapping("/user/enterResume.do")
	public ModelAndView enterResume(HttpSession session) {
		String id = (String)session.getAttribute("userId");
		String enterResume = enterpriseUserService.enterResumeSelect(id);
		List<String> list = new ArrayList<String>();
		List<UserResumeCommand> listResume = new ArrayList<UserResumeCommand>();
		EnterpriseUserCommand enterpriseUserCommand = new EnterpriseUserCommand();
		if(enterResume!=null) {
			enterpriseUserCommand.setResumeList(enterResume);
			list = enterpriseUserCommand.getResumeList();
			log.debug("list : " + list);
			for(int i=0;i<list.size();i++) {
				UserResumeCommand userResumeCommand=enterpriseUserService.selectAllResume(list.get(i));
				log.debug("listResume : " + userResumeCommand);
				listResume.add(userResumeCommand);
			}
		}
		log.debug("listResume"+listResume);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("enterResume");
		mav.addObject("listResume",listResume);
		mav.addObject("size",listResume.size());
		return mav;
	}
	
	@RequestMapping("/user/whoLikesMine.do")
	public ModelAndView whoLikesMine(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		String id = (String)session.getAttribute("userId");
		if(session.getAttribute("like")!=null) {
			session.removeAttribute("like");
			enterpriseUserService.whoLikesModify(id);
		}
		List<EnterpriseUserCommand> list = enterpriseUserService.selectEnterpriseUser(id);
		mav.setViewName("whoLikesMine");
		mav.addObject("list",list);

		return mav;
	}
	
	/*----------------------------------------*/
	
	
	@RequestMapping("/user/enprifile.do")
	public ModelAndView download(@RequestParam("m_id")String m_id) {
		UserResumeCommand resumeCommand = userResumeService.selectPortfolio(m_id);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("downloadView");
		mav.addObject("downloadFile",resumeCommand.getFbytes());
		mav.addObject("filename", resumeCommand.getFname());
		
		return mav;
	}
	
	//이미지 출력
	@RequestMapping("/user/enpriImageView.do")
	public ModelAndView viewImage(@RequestParam("m_id")String m_id) {
		UserResumeCommand resumeCommand = userResumeService.selectResume(m_id);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("imageView");
		mav.addObject("imageFile",resumeCommand.getR_pic());
		mav.addObject("filename",resumeCommand.getR_pname());
		
		return mav;
	}
	
	@RequestMapping(value="/user/confirmEnterId.do")
	@ResponseBody
	public Map<String,String> confirmEnterId(@RequestParam("m_id")String m_id){
		Map<String,String> map = new HashMap<String, String>();
		String id = userResumeService.checkUserId(m_id);
		log.debug("m_id : "+ m_id);
		log.debug("id : "+ id);
		if(m_id.length()>0&&m_id.contains("@")) {
			if(id!=null) {
				map.put("result","repeated");
			}else{
				map.put("result","canUse");
			}
		}else {
			map.put("result", "short");
		}
		log.debug("map : " + map);
		
		return map;
	}
	@RequestMapping(value="/user/confirmEnterNum.do")
	@ResponseBody
	public Map<String,String> confirmEnterNum(@RequestParam("num")String num){
		Map<String,String> map = new HashMap<String, String>();
		String enterprise_num = userResumeService.checkUserNum(num);
		if(num.length()>0) {
		if(enterprise_num!=null) {
			map.put("result","repeated");
		}else{
			map.put("result","canUse");
		}
		log.debug("map : " + map);
		}else {
			map.put("result", "short");
		}
		return map;
	}
	
	@RequestMapping(value="/user/likeResume.do")
	@ResponseBody
	public Map<String,String> likeResume(HttpSession session,@RequestParam("m_id")String id){
		String m_id = (String)session.getAttribute("userId");
		Map<String,String> map = new HashMap<String,String>();
		String enterResume = enterpriseUserService.enterResumeSelect(m_id);
		EnterpriseUserCommand euc = enterpriseUserService.enterDetailAllSelect(m_id);
		
		boolean having = true;
		log.debug("m_id,enterNames,checkAlert : "+ id+","+m_id);
		EnterpriseUserCommand enterEnterResume = new EnterpriseUserCommand();
		enterEnterResume.setM_id(id);
		enterEnterResume.setEnterNames(euc.getEnterprise_name());
		enterEnterResume.setEnterprise_email(m_id);
		enterEnterResume.setEnterprise_charge(euc.getEnterprise_charge());
		enterEnterResume.setCheckAlert(1);
		enterpriseUserService.enterLikeResume(enterEnterResume);
		log.debug("enterResume : " + enterResume);
		if(enterResume!=null) {
			List<String> list = new ArrayList<String>();
			EnterpriseUserCommand enterpriseUserCommand = new EnterpriseUserCommand();
			enterpriseUserCommand.setResumeList(enterResume);
			list = enterpriseUserCommand.getResumeList();
			log.debug("list : " + list.size());
			if(list.size()<=20) {
				log.debug("list : " + list);
				for(int i=0;i<list.size();i++) {
					if(list.get(i).equals(id)) {
						log.debug("list.get(i) : " + list.get(i));
						map.put("result", "AlreadyHas");
						having=false;
						break;
					}
				}
				if(having) {
					enterpriseUserService.enterResumeUpdate(enterResume+","+id);
					map.put("result", "add");
				}
			}
			if(list.size()==20) {  
				map.put("result", "full");
			}
		}else if(enterResume==null) {
			EnterpriseUserCommand enterpriseUserCommand = new EnterpriseUserCommand();
			enterpriseUserCommand.setM_id(m_id);
			enterpriseUserCommand.setEnterResume(id);
			enterpriseUserService.enterResumeInsert(enterpriseUserCommand);
			map.put("result", "canInsert");
		}
		log.debug("map : " + map);
		return map;
	}
	
	@RequestMapping(value="/user/addResume.do")
	@ResponseBody
	public Map<String,Object> addResume(@RequestParam("numero") int num,HttpSession session){
		Map<String,Object> map = new HashMap<String,Object>();
		List<UserResumeCommand> list = new ArrayList<UserResumeCommand>();
		List<UserResumeCommand> listSub = new ArrayList<UserResumeCommand>();
		log.debug("numero : " + num);
		String id = (String)session.getAttribute("userId");
		int level = (Integer)session.getAttribute("userGrade");
		if(num==0) {
			num = 2;
		}
		log.debug("numero : " + num);
		list = enterpriseUserService.addResume(num);
		log.debug("listsize : "+list.size());
		if(list.size()==0) {
			map.put("list", list);
			map.put("num", -1);
			map.put("result","add");
			return map;
		}
		
		if(list.size()>0) {
			if(level>=20) {
				Iterator<UserResumeCommand> iter = list.iterator();
				while(iter.hasNext()) {
					UserResumeCommand command = iter.next();
					if(command.getPublicType().equals("private")){
						iter.remove();
						if(list.size()==0) {
							break;
						}
					}
					if(command.getPublicType().equals("default")) {
						iter.remove();
						if(list.size()==0) {
							break;
						}
					}
					if(command.getR_num()<=num) {
						iter.remove();
						if(list.size()==0) {
							break;
						}
					}
				}
			}
			if(level<20) {
				Iterator<UserResumeCommand> iter = list.iterator();
				while(iter.hasNext()) {
					UserResumeCommand command = iter.next();
					if(command.getPublicType().equals("onlyEnter")&&!command.getM_id().equals(id)){
						iter.remove();
						if(list.size()==0) {
							break;
						}
					}
					if(command.getPublicType().equals("default")&&!command.getM_id().equals(id)) {
						iter.remove();
						if(list.size()==0) {
							break;
						}
					}
					if(command.getR_num()<=num) {
						iter.remove();
						if(list.size()==0) {
							break;
						}
					}
					log.debug("1");
				}
			}
		}
		
		if(list.size()>5) {
			for(int i=0;i<5;i++) {
				listSub.add(list.get(i));
			}
		}
		if(list.size()==5) {
			map.put("list", list);
			map.put("num", list.get(list.size()-1).getR_num());
			map.put("result","add");
			return map;
		}
		for(int i=0;i<listSub.size();i++) {
			log.debug(listSub.get(i)+","+i);
		}
		int numm = -1;
		
		if(!list.isEmpty()&&list.size()>5) {
			numm = listSub.get(listSub.size()-1).getR_num();
			log.debug("numm3333 : " + numm);
		}
		if(list.size()<5&&list.size()!=0) {
			numm = list.get(list.size()-1).getR_num();
			log.debug(numm);
			try {
				map.put("list", list);
				map.put("num", numm);
				map.put("result","add");
				log.debug("success");
				return map;
			}catch(Exception e) {
				map.put("result", "fail");
				return map;
			}
		}
		try {
			map.put("list", listSub);
			map.put("num", numm);
			map.put("result","add");
			log.debug("numm : " + numm);
			for(int i=0;i<listSub.size();i++) {
				log.debug("listSub : " + listSub.get(i));
			}
			log.debug("success");
			return map;
		}catch(Exception e) {
			map.put("result", "fail");
			return map;
		}
	}
	
}



































