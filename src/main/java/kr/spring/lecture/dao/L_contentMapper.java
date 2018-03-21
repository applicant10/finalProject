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
	//���� ��ȣ�� ���������� �� �� ����Ʈ
	@Select("SELECT * FROM l_content WHERE l_num=#{l_num} ORDER BY lc_sequence")
	public List<L_contentCommand> selectLcUseLnum(Integer l_num);
	//���� ��ȣ�� ���� ������ ���� ����
	@Select("SELECT count(*) FROM l_content WHERE l_num=#{l_num}")
	public int countLcUseLnum(Integer l_num);
	
	//���� ��ȣ�� �� �� �˻�
	@Select("SELECT * FROM l_content WHERE lc_num=#{lc_num}")
	public L_contentCommand selectOne(Integer lc_num);
	//l_content & lc_mem ���̺� �����ؼ� �ش� ������ �������� ���� ���� ������(�۳��� ����X)
	public List<L_contentCommand> selectLcJoinLcmUseLm(HashMap<String, Integer> map);
	//�� ���� ����
	public List<L_contentCommand> selectLcJoinLcmUseLmCon(HashMap<String, Integer> map);
	//���� �������� ���� lc_num�� �̿��� 1���� ���� �˻�
	public L_contentCommand selectLcJoinLcmOne(HashMap<String, Integer> map);
	
	//���� ���� �ٲٱ�!
	public void lcSequence(HashMap<String, Integer> map);
	
	//���� ����
	@Update("UPDATE l_content SET lc_title=#{lc_title}, lc_content=#{lc_content}, lc_redate=sysdate WHERE lc_num=#{lc_num}")
	public void updateL_content(L_contentCommand lcCommand);
	
	//���� ����
	@Delete("DELETE FROM l_content WHERE lc_num=#{lc_num}")
	public void deleteL_content(Integer lc_num);
}