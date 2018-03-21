package kr.spring.team.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;

import kr.spring.record.domain.RecordCommand;
import kr.spring.team.domain.TeamMemberCommand;

public interface TeamMemberMapper {
	//팀게시판
	public List<TeamMemberCommand> list(Map<String,Object> map);
	public int getRowCount(Map<String,Object> map);
	
	//회원 목록
	public List<TeamMemberCommand> memberList(Map<String,Object> map);
	public int memberCount(Map<String,Object> map);
	
	//강퇴
	@Delete("DELETE FROM teamInfo WHERE g_num=#{g_num} AND m_nick=#{m_nick}")
	public void redCard(Map<String,Object> map);
	@Insert("INSERT INTO record (m_nick,r_content,record,r_date,r_num) VALUES (#{m_nick},#{g_name},'그룹에서 추방 되었습니다.',sysdate,record_seq.nextval)")
	public void redCardRecord(Map<String,Object> map);
	
	//스터디 /프로젝트 개설
	@Insert("INSERT INTO teamInfo (m_nick,g_num,g_name,g_type,g_greet,g_date) VALUES (#{m_nick},board_seq.nextval,#{g_name},#{g_type},#{g_greet},sysdate)")
	public void insertInfo(TeamMemberCommand teamInfo);
	@Insert("INSERT INTO record (m_nick,r_content,record,r_date,r_num) VALUES (#{m_nick},#{g_name},'그룹을 개설하였습니다',sysdate,record_seq.nextval)")
	public void insertRecord(RecordCommand record);
	
	public TeamMemberCommand selectBoard(Integer num);
	
	//그룹 폐지
	@Delete("DELETE FROM teamInfo WHERE g_num=#{g_num}")
	public void delete(Integer num);
	@Insert("INSERT INTO record (m_nick,r_content,record,r_date,r_num) VALUES (#{m_nick},#{g_name},'그룹을 폐지하였습니다.',sysdate,record_seq.nextval)")
	public void deleteRecord(RecordCommand record);
	
	//그룹 탈퇴
	@Delete("DELETE FROM teamInfo WHERE g_num=#{g_num} AND m_nick=#{m_nick}")
	public void deleteInfo(Map<String,Object> map);
	@Insert("INSERT INTO record (m_nick,r_content,record,r_date,r_num) VALUES (#{m_nick},#{g_name},'그룹에서 탈퇴하였습니다.',sysdate,record_seq.nextval)")
	public void deleteInfoRecord(Map<String,Object> map);
	
	//그룹 폐지 시 게시글 삭제
	@Delete("DELETE FROM teamboard WHERE g_num=#{g_num}")
	public void deleteByNum(Integer num);

}
