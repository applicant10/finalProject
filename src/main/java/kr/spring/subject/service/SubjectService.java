package kr.spring.subject.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import kr.spring.subject.domain.SubjectCommand;

@Transactional
public interface SubjectService {
	public void insert(SubjectCommand subject);
	public void update(SubjectCommand subject);
	public void delete(int s_num);
	@Transactional(readOnly=true)
	public List<SubjectCommand> selectLv1();
	@Transactional(readOnly=true)
	public List<SubjectCommand> selectLv2(String lv1);
	@Transactional(readOnly=true)
	public SubjectCommand selectOneUseSnum(Integer s_num);
	@Transactional(readOnly=true)
	public List<SubjectCommand> selectLv2AllSearch();
}
