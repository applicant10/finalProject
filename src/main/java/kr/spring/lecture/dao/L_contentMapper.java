package kr.spring.lecture.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.spring.lecture.domain.L_contentCommand;

public interface L_contentMapper {
	@Insert("INSERT INTO l_content (lc_num, lc_title, lc_content, lc_date, lc_hit, lc_sequence, l_num) VALUES(l_content_seq.nextval,#{lc_title},#{lc_content}, sysdate, #{lc_hit}, #{lc_sequence}, #{l_num})")
	public void insertL_content(L_contentCommand lcCommand);
	//강의 번호로 강의컨텐츠 쭉 다 셀렉트
	@Select("SELECT * FROM l_content WHERE l_num=#{l_num} ORDER BY lc_sequence")
	public List<L_contentCommand> selectLcUseLnum(Integer l_num);
	//강의 번호로 강의 컨텐츠 갯수 구함
	@Select("SELECT count(*) FROM l_content WHERE l_num=#{l_num}")
	public int countLcUseLnum(Integer l_num);
	
	//강의 번호로 한 개 검색
	@Select("SELECT * FROM l_content WHERE lc_num=#{lc_num}")
	public L_contentCommand selectOne(Integer lc_num);
	//l_content & lc_mem 테이블 조인해서 해당 유저의 컨텐츠별 수강 정보 셀렉션(글내용 포함X)
	public List<L_contentCommand> selectLcJoinLcmUseLm(HashMap<String, Integer> map);
	//글 내용 포함
	public List<L_contentCommand> selectLcJoinLcmUseLmCon(HashMap<String, Integer> map);
	//위의 쿼리에서 현재 lc_num을 이용한 1개의 강의 검색
	public L_contentCommand selectLcJoinLcmOne(HashMap<String, Integer> map);
	
	//강의 순서 바꾸기!
	public void lcSequence(HashMap<String, Integer> map);
	
	//강의 수정
	@Update("UPDATE l_content SET lc_title=#{lc_title}, lc_content=#{lc_content}, lc_redate=sysdate WHERE lc_num=#{lc_num}")
	public void updateL_content(L_contentCommand lcCommand);
	
	//강의 삭제
	@Delete("DELETE FROM l_content WHERE lc_num=#{lc_num}")
	public void deleteL_content(Integer lc_num);
}