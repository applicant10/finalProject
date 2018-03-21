package kr.spring.lecture.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import kr.spring.lecture.domain.Lc_memCommand;

public interface Lc_memMapper {
	//수강신청 시 자동으로 해당 강좌들 싹 다 insert할 때
	public void insertLcmem (HashMap<String, Integer> map);
	//수강번호를 이용한 강의수강리스트 셀렉션(출력용 date,redate,title 조인)
	@Transactional(readOnly=true)
	public List<Lc_memCommand> selectLCMuseLn(Integer l_m_num);
	//수강번호를 사용한 셀렉션(완료한 강의 수 구하기)
	@Transactional(readOnly=true)
	public int selectCommLCMuseLn(Integer l_m_num);
	//lc_num(강의기본키), l_m_num(강의_회원 기본키)를 이용해서 셀랙션한 row에 comdate update
	public void completeLearnContent(HashMap<String, Integer> map);
	//수강신청한 강의인지 확인하기 위해
	public int selectLcmem_use_lcNum_lmNum(HashMap<String, Integer> map);
}