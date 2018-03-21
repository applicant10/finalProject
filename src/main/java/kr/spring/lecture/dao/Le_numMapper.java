package kr.spring.lecture.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Update;

import kr.spring.lecture.domain.Le_numCommand;

public interface Le_numMapper {
	//���� ���� ��û(in XML)
	public void insertLeNum(HashMap<String, Object> map);
	//���� ���� ���̵� �ش� ���Ǹ� ���� ���ΰ�?(in XML)
	public int checkLectureUseId(HashMap<String, Object> map);
	//���� ���� �Ϸ�
	@Update("UPDATE le_num SET eDate=sysdate WHERE l_m_num=#{l_m_num}")
	public void finishLearn(Integer l_m_num);
	//����&���� ��ȣ�� ���� ���� �˻�
	public Le_numCommand selectLM(HashMap<String, Object> map);
	//���� �Ϸ��� ���� ���
	public List<Le_numCommand> selectFinLMList(HashMap<String, Object> map);
	//���� ���� ���� ��� ���
	public List<Le_numCommand> selectNoFinLMList(HashMap<String, Object> map);
	//���� ��û��(�Ϸ�/�̿Ϸ� ����) ���� ����Ʈ �˻�
	public List<Le_numCommand> selectLMList(String m_id);
	//�⺻Ű�� ���� �������ϰ� �ش� ������ ���� �� ī����
	public int countLcontent(Integer l_m_num);
	//�⺻Ű�� �̿��� ���� �Ϸ��� ���� �� ī����
	public int countLcmemIsComdate(Integer l_m_num);
}