package kr.spring.lecture.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Update;

import kr.spring.lecture.domain.Le_numCommand;

public interface Le_numMapper {
	//강의 수강 신청(in XML)
	public void insertLeNum(HashMap<String, Object> map);
	//접속 중인 아이디가 해당 강의를 수강 중인가?(in XML)
	public int checkLectureUseId(HashMap<String, Object> map);
	//강의 수강 완료
	@Update("UPDATE le_num SET eDate=sysdate WHERE l_m_num=#{l_m_num}")
	public void finishLearn(Integer l_m_num);
	//유저&강의 번호로 수강 정보 검색
	public Le_numCommand selectLM(HashMap<String, Object> map);
	//수강 완료한 강의 출력
	public List<Le_numCommand> selectFinLMList(HashMap<String, Object> map);
	//수강 중인 강의 목록 출력
	public List<Le_numCommand> selectNoFinLMList(HashMap<String, Object> map);
	//수강 신청한(완료/미완료 전부) 강의 리스트 검색
	public List<Le_numCommand> selectLMList(String m_id);
	//기본키로 강좌 셀렉션하고 해당 강좌의 강의 수 카운팅
	public int countLcontent(Integer l_m_num);
	//기본키를 이용해 수강 완료한 강의 수 카운팅
	public int countLcmemIsComdate(Integer l_m_num);
}