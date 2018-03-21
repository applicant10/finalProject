package kr.spring.member.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.spring.member.domain.MemberCommand;
import kr.spring.member.service.MemberService;

@Controller
public class MemberConfirmIdAjaxController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private MemberService memberService;
	
	//Ÿ�Ͻ��� ����ϸ� ���Ҽ��� ���� 
	@RequestMapping("/user/confirmId.do")
	@ResponseBody//map,list,�ڹٺ��� json���ڿ��� ���� return �ؼ� ������(json���̺귯�� �ʿ���)
	public Map<String,String> process(@RequestParam("m_id")String m_id){
		
		if(log.isDebugEnabled()) {
			log.debug("<<id>> : " + m_id);
		}
		
		Map<String,String> map = new HashMap<String,String>(); 
		
		MemberCommand member = memberService.selectMember(m_id);
		if(member!=null) {
			//���̵� �ߺ�
			map.put("result", "idDuplicated");
		}else {
			//���̵� ���ߺ�
			map.put("result", "idNotFound");
		}
		return map;
	}
	@RequestMapping("/user/confirmNick.do")
	@ResponseBody//map,list,�ڹٺ��� json���ڿ��� ���� return �ؼ� ������(json���̺귯�� �ʿ���)
	public Map<String,String> processNick(@RequestParam("m_nick")String m_nick){
		
		if(log.isDebugEnabled()) {
			log.debug("<<id>> : " + m_nick);
		}
		
		Map<String,String> map = new HashMap<String,String>(); 
		
		String member = memberService.selectMemberByNick(m_nick);
		if(member!=null&&!member.equals(m_nick)) {
			//���̵� �ߺ�
			map.put("result", "idDuplicated");
		}else if(member==null){
			//���̵� ���ߺ�
			map.put("result", "idNotFound");
		}else if(member.equals(m_nick)){
			map.put("result", "sameAs");
		}
		return map;
	}
}

































