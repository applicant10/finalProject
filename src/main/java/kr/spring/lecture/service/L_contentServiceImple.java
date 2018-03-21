package kr.spring.lecture.service;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.spring.lecture.dao.L_contentMapper;
import kr.spring.lecture.domain.L_contentCommand;
import kr.spring.member.dao.MemberMapper;

@Service("l_contentService")
public class L_contentServiceImple implements L_contentService{
	@Resource
	private L_contentMapper lcMapper;
	@Resource
	private MemberMapper memberMapper;
	
	private HashMap<String, Integer> map(Integer l_num, Integer l_m_num){
		HashMap<String, Integer> objm = new HashMap<String, Integer>();
		objm.put("l_num", l_num);
		objm.put("l_m_num", l_m_num);

		return objm;
	}
	
	@Override
	public void insetL_content(L_contentCommand lcCommand, Integer l_num) {
		int count = lcMapper.countLcUseLnum(l_num);
		
		lcCommand.setLc_sequence(count+1);
		
		lcMapper.insertL_content(lcCommand);
	}

	@Override
	public List<L_contentCommand> selectLcUseLnum(Integer l_num) {
		return lcMapper.selectLcUseLnum(l_num);
	}

	@Override
	public int countLcUseLnum(Integer l_num) {
		return lcMapper.countLcUseLnum(l_num);
	}
	
	@Override
	public L_contentCommand selectOne(Integer lc_num) {
		return lcMapper.selectOne(lc_num);
	}
	@Override
	public List<L_contentCommand> selectLcJoinLcmUseLm(Integer l_num, Integer l_m_num) {
		return lcMapper.selectLcJoinLcmUseLm(map(l_num, l_m_num));
	}
	@Override
	public List<L_contentCommand> selectLcJoinLcmUseLmCon(Integer l_num, Integer l_m_num) {
		return lcMapper.selectLcJoinLcmUseLmCon(map(l_num, l_m_num));
	}
	@Override
	public L_contentCommand selectLcJoinLcmOne(Integer l_num, Integer l_m_num, Integer lc_num) {
		HashMap<String, Integer> objm = new HashMap<String, Integer>();
		objm.put("l_num", l_num);
		objm.put("l_m_num", l_m_num);
		objm.put("lc_num", lc_num);
		return lcMapper.selectLcJoinLcmOne(objm);
	}
	@Override
	public void lcSequence(Integer lc_sequence, Integer lc_num) {
		HashMap<String, Integer> mapSequence = new HashMap<String, Integer>();
		mapSequence.put("lc_sequence", lc_sequence);
		mapSequence.put("lc_num", lc_num);
		
		lcMapper.lcSequence(mapSequence);
	}
	
	@Override
	public void updateL_content(L_contentCommand lcCommand) {
		lcMapper.updateL_content(lcCommand);		
	}
	
	@Override
	public void deleteL_content(Integer lc_num) {
		lcMapper.deleteL_content(lc_num);	
	}
}
