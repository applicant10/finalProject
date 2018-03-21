package kr.spring.lecture.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import kr.spring.lecture.domain.Lc_memCommand;

public interface Lc_memMapper {
	//������û �� �ڵ����� �ش� ���µ� �� �� insert�� ��
	public void insertLcmem (HashMap<String, Integer> map);
	//������ȣ�� �̿��� ���Ǽ�������Ʈ ������(��¿� date,redate,title ����)
	@Transactional(readOnly=true)
	public List<Lc_memCommand> selectLCMuseLn(Integer l_m_num);
	//������ȣ�� ����� ������(�Ϸ��� ���� �� ���ϱ�)
	@Transactional(readOnly=true)
	public int selectCommLCMuseLn(Integer l_m_num);
	//lc_num(���Ǳ⺻Ű), l_m_num(����_ȸ�� �⺻Ű)�� �̿��ؼ� �������� row�� comdate update
	public void completeLearnContent(HashMap<String, Integer> map);
	//������û�� �������� Ȯ���ϱ� ����
	public int selectLcmem_use_lcNum_lmNum(HashMap<String, Integer> map);
}