package kr.spring.lecture.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import kr.spring.lecture.domain.L_contentCommand;

@Transactional
public interface L_contentService {
	public void insetL_content(L_contentCommand lcCommand, Integer l_num);
	@Transactional(readOnly=true)
	public List<L_contentCommand> selectLcUseLnum(Integer l_num);
	@Transactional(readOnly=true)
	public int countLcUseLnum(Integer l_num);
	@Transactional(readOnly=true)
	public L_contentCommand selectOne(Integer lc_num);
	@Transactional(readOnly=true)
	public List<L_contentCommand> selectLcJoinLcmUseLm(Integer l_num, Integer l_m_num);
	@Transactional(readOnly=true)
	public List<L_contentCommand> selectLcJoinLcmUseLmCon(Integer l_num, Integer l_m_num);
	@Transactional(readOnly=true)
	public L_contentCommand selectLcJoinLcmOne(Integer l_num, Integer l_m_num, Integer lc_num);
	public void lcSequence(Integer lc_sequence, Integer lc_num);
	public void updateL_content(L_contentCommand lcCommand);
	public void deleteL_content(Integer lc_num);
}