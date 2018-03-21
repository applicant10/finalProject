package kr.spring.lecture.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.spring.lecture.domain.L_contentCommand;
import kr.spring.lecture.service.L_contentService;
import kr.spring.lecture.service.LectureService;

@Controller
public class MyLectureManageAjaxController {
	@Resource
	private L_contentService l_contentService;
	
	@Resource
	private LectureService lectureService;


	@RequestMapping("/lecture/myLcShow.do")
	@ResponseBody
	public Map<String, Object> myLcShow(@RequestParam("l_num") int l_num){
		int count = l_contentService.countLcUseLnum(l_num);
		Map<String, Object> mapJson = new HashMap<String, Object>();

		if(count > 0) {
			List<L_contentCommand> list = l_contentService.selectLcUseLnum(l_num);
			mapJson.put("list", list);
		}

		mapJson.put("count", count);
		return mapJson;
	}

	@RequestMapping("/lecture/lcSequenceSort.do")
	@ResponseBody
	public Map<String, Object> lcSequenceSort(@RequestParam("list[]") int[] list) {
		int a=1;
		for (int i : list) {

			l_contentService.lcSequence(a, i);
			a++;
		}

		Map<String, Object> mapJson = new HashMap<String, Object>();
		mapJson.put("result", "success");

		return mapJson;
	}

	//눈 모양 버튼 l_open 토글 기능
	@RequestMapping("/lecture/lectureOpen.do")
	@ResponseBody
	public Map<String, Object> lectureOpenSet(@RequestParam("l_num") int l_num, Model model) {
		lectureService.lectureOpenSet(l_num);
		
		Map<String, Object> mapJson = new HashMap<String, Object>();
		mapJson.put("result", "success");
		
		return mapJson;
	}
	//눈 모양 버튼 l_open 토글 기능
	@RequestMapping("/lecture/lectureClose.do")
	@ResponseBody
	public Map<String, Object> lectureCloseSet(@RequestParam("l_num") int l_num, Model model) {
		lectureService.lectureCloseSet(l_num);
		
		Map<String, Object> mapJson = new HashMap<String, Object>();
		mapJson.put("result", "success");
		
		return mapJson;
	}
}
