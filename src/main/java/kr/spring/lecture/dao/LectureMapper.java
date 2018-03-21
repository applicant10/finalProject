package kr.spring.lecture.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.spring.lecture.domain.LectureCommand;
import kr.spring.lecture.domain.LecturePointCommand;

public interface LectureMapper {
	//강의 개설
	@Insert("INSERT INTO lecture (l_num,l_title,l_shortcon,l_content,l_date,l_hit,l_open,l_pay,l_adv,l_donation,m_id,s_num) VALUES (lecture_seq.nextval,#{l_title},#{l_shortcon},#{l_content},sysdate,0,'close',#{l_pay},#{l_adv},#{l_donation},#{m_id},#{s_num})")
	public void insertLecture(LectureCommand lecture);
	//강의 목록
	public List<LectureCommand> list(Map<String, Object> map);				//in XML
	//강의 목록(타인용)
	public List<LectureCommand> listOtherSearch(Map<String, Object> map);	//in XML
	//강좌 카운팅
	public int getRowCount(Map<String, Object> map);						//in XML
	public int getRowCount_otherSearch(Map<String, Object> map);			//in XML
	//강의 디테일보기
	@Select("SELECT * FROM lecture WHERE l_num=#{l_num}")
	public LectureCommand selectLecture(Integer l_num);
	//닉네임으로 강의 검색
	@Select("SELECT l_num, l_title, l_open FROM lecture WHERE m_id="
			+ "(SELECT m_id FROM member WHERE m_nick=#{m_nick}) ORDER BY l_num DESC")
	public List<LectureCommand> selectLectureUseNick(String m_nick);
	
	
	//닉네임으로 검색해서 나온 강좌 수 카운트
	@Select("SELECT count(*) l_count FROM lecture WHERE m_id=(SELECT m_id FROM member WHERE m_nick=#{m_nick})")
	public int countLectureUseNick(String m_nick);
	//id로 강좌 검색(타인 검색용)
	@Select("SELECT l_num, l_title, l_open FROM lecture WHERE m_id=#{m_id} ORDER BY l_num DESC")
	public List<LectureCommand> selectLectureUseId_self(String m_id);
	//id로 강좌 검색(본인용)
	@Select("SELECT l_num, l_title, l_open FROM lecture WHERE m_id=#{m_id} AND l_open='open' ORDER BY l_num DESC")
	public List<LectureCommand> selectLectureUseId(String m_id);
	
	//le_num과 조인하고 sDate DESC 순으로 강좌 정렬 셀랙션하기.
	public List<LectureCommand> selectLListUseLMsd(Integer l_m_num);
	
	//id으로 검색해서 나온 강좌 수 카운트
	@Select("SELECT count(*) l_count FROM lecture WHERE m_id=#{m_id}")
	public int countLectureUseId(String m_id);
	
	//update
	@Update("UPDATE lecture SET l_title=#{l_title}, l_shortcon=#{l_shortcon},l_content=#{l_content},l_redate=sysdate, l_open=#{l_open} WHERE l_num=#{l_num}")
	public void modifyLecture(LectureCommand lecture);
	//l_open -> open
	@Update("UPDATE lecture SET l_open='open' WHERE l_num=#{l_num}")
	public void lectureOpenSet(Integer l_num);
	//l_open -> close
	@Update("UPDATE lecture SET l_open='close' WHERE l_num=#{l_num}")
	public void lectureCloseSet(Integer l_num);
	
	//수강신청시 hit+1
	@Update("UPDATE lecture SET l_hit=l_hit+1 WHERE l_num=#{l_num}")
	public void lectureIncreaseHit(Integer l_num);
	
	//조인
	public List<LectureCommand> lecture_JoinLeNum_UseLMNum_Calc(String m_id);
	
	public List<LecturePointCommand> lecturePoint(Integer l_num);
	
}
