package kr.spring.subject.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.spring.subject.domain.SubjectCommand;
import kr.spring.subject.service.SubjectService;

@Controller
public class SubjectLv2AjaxController {
	
	@Resource
	private SubjectService subjectService;
	
	@RequestMapping("/subject/loadSubjectLv2.do")
	@ResponseBody
	public Map<String, Object> getLv2List(@RequestParam("lv1")String lv1){
		
		Map<String, Object> mapJson = new HashMap<String, Object>();
		
		List<SubjectCommand> list = subjectService.selectLv2(lv1);
		
		mapJson.put("list", list);
		mapJson.put("count", list.size());
		return mapJson;
	}
}
