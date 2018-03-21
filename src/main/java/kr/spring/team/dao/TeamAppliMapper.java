package kr.spring.team.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import kr.spring.record.domain.RecordCommand;
import kr.spring.team.domain.TeamAppliCommand;

public interface TeamAppliMapper {
	
	public List<TeamAppliCommand> list(Map<String,Object> map);
	
	public int getRowCount(Map<String,Object> map);
	
	public int applyCount(Map<String,Object> map);
	
	public int joinCount(Map<String,Object> map);
	
	//���� ��û
	@Insert("INSERT INTO appli (m_nick,g_num,a_num,a_content,a_date) VALUES (#{m_nick},#{g_num},appli_seq.nextval,#{a_content},sysdate)")
	public void insert(TeamAppliCommand appli);
	    
	//���� ����
	@Insert("INSERT INTO teamInfo (m_nick,g_num,g_date) VALUES (#{m_nick},#{g_num},sysdate)")
	public void join(TeamAppliCommand join);
	@Delete("DELETE FROM appli WHERE a_num=#{a_num}")
	public void after(Integer num);
	@Insert("INSERT INTO record (m_nick,r_content,record,r_date,r_num) VALUES (#{m_nick},#{g_name},'�׷쿡 ���ԵǾ����ϴ�.',sysdate,record_seq.nextval)")
	public void insertRecord(RecordCommand record);  
	
	@Select("SELECT * FROM teamInfo WHERE g_num=#{g_num}")
	public TeamAppliCommand selectInfo(Integer num);
	
	//���� ������
	@Select("SELECT * FROM appli WHERE a_num=#{a_num}")
	public TeamAppliCommand select(Integer num);
	
	//���� ����
	@Delete("DELETE FROM appli WHERE a_num=#{a_num}")
	public void delete(Integer num);
}
