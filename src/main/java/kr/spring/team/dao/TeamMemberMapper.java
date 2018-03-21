package kr.spring.team.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;

import kr.spring.record.domain.RecordCommand;
import kr.spring.team.domain.TeamMemberCommand;

public interface TeamMemberMapper {
	//���Խ���
	public List<TeamMemberCommand> list(Map<String,Object> map);
	public int getRowCount(Map<String,Object> map);
	
	//ȸ�� ���
	public List<TeamMemberCommand> memberList(Map<String,Object> map);
	public int memberCount(Map<String,Object> map);
	
	//����
	@Delete("DELETE FROM teamInfo WHERE g_num=#{g_num} AND m_nick=#{m_nick}")
	public void redCard(Map<String,Object> map);
	@Insert("INSERT INTO record (m_nick,r_content,record,r_date,r_num) VALUES (#{m_nick},#{g_name},'�׷쿡�� �߹� �Ǿ����ϴ�.',sysdate,record_seq.nextval)")
	public void redCardRecord(Map<String,Object> map);
	
	//���͵� /������Ʈ ����
	@Insert("INSERT INTO teamInfo (m_nick,g_num,g_name,g_type,g_greet,g_date) VALUES (#{m_nick},board_seq.nextval,#{g_name},#{g_type},#{g_greet},sysdate)")
	public void insertInfo(TeamMemberCommand teamInfo);
	@Insert("INSERT INTO record (m_nick,r_content,record,r_date,r_num) VALUES (#{m_nick},#{g_name},'�׷��� �����Ͽ����ϴ�',sysdate,record_seq.nextval)")
	public void insertRecord(RecordCommand record);
	
	public TeamMemberCommand selectBoard(Integer num);
	
	//�׷� ����
	@Delete("DELETE FROM teamInfo WHERE g_num=#{g_num}")
	public void delete(Integer num);
	@Insert("INSERT INTO record (m_nick,r_content,record,r_date,r_num) VALUES (#{m_nick},#{g_name},'�׷��� �����Ͽ����ϴ�.',sysdate,record_seq.nextval)")
	public void deleteRecord(RecordCommand record);
	
	//�׷� Ż��
	@Delete("DELETE FROM teamInfo WHERE g_num=#{g_num} AND m_nick=#{m_nick}")
	public void deleteInfo(Map<String,Object> map);
	@Insert("INSERT INTO record (m_nick,r_content,record,r_date,r_num) VALUES (#{m_nick},#{g_name},'�׷쿡�� Ż���Ͽ����ϴ�.',sysdate,record_seq.nextval)")
	public void deleteInfoRecord(Map<String,Object> map);
	
	//�׷� ���� �� �Խñ� ����
	@Delete("DELETE FROM teamboard WHERE g_num=#{g_num}")
	public void deleteByNum(Integer num);

}
