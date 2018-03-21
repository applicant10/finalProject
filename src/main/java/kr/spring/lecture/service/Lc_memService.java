package kr.spring.lecture.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import kr.spring.lecture.domain.Lc_memCommand;

@Transactional
public interface Lc_memService {
	public void insertLcmem (Integer lc_num, Integer l_m_num);
	public List<Lc_memCommand> selectLCMuseLn(Integer l_m_num);
	public int selectCommLCMuseLn(Integer l_m_num);
	public void completeLearnContent(Integer lc_num, Integer l_m_num, Integer l_num);
}