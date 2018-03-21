package kr.spring.subject.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.spring.subject.domain.SubjectCommand;

public interface SubjectMapper {
	@Insert("INSERT INTO subject (s_num, lv1, lv2) VALUES (subject_seq.nextval, #{lv1}, #{lv2})")
	public void insertSubject(SubjectCommand subject);
	
	@Update("UPDATE subject SET lv1=#{lv1}, lv2=#{lv2}")
	public void updateSubject(SubjectCommand subject);
	
	@Delete("DELETE FROM subject WHERE s_num=#{s_num}")
	public void deleteSubject(int s_num);
	
	@Select("SELECT lv1, to_char(count(*))lv2 FROM subject GROUP BY lv1")
	public List<SubjectCommand> selectLv1();
	
	@Select("SELECT s_num, lv2 FROM subject WHERE lv1=#{lv1}")
	public List<SubjectCommand> selectLv2(String lv1);
	
	@Select("SELECT * FROM subject")
	public List<SubjectCommand> selectLv2AllSearch();
	
	@Select("SELECT * FROM subject WHERE s_num=#{s_num}")
	public SubjectCommand selectOneUseSnum(Integer s_num);
}