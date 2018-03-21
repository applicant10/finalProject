package kr.spring.subject.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.spring.subject.dao.SubjectMapper;
import kr.spring.subject.domain.SubjectCommand;

@Service("subjectService")
public class SubjectServiceImple implements SubjectService {

	@Resource
	private SubjectMapper subjectMapper;
	
	@Override
	public void insert(SubjectCommand subject) {
		subjectMapper.insertSubject(subject);
	}

	@Override
	public void update(SubjectCommand subject) {
		subjectMapper.updateSubject(subject);
	}

	@Override
	public void delete(int s_num) {
		subjectMapper.deleteSubject(s_num);
	}

	@Override
	public List<SubjectCommand> selectLv1() {
		return subjectMapper.selectLv1();
	}

	@Override
	public List<SubjectCommand> selectLv2(String lv1) {
		return subjectMapper.selectLv2(lv1);
	}
	
	@Override
	public SubjectCommand selectOneUseSnum(Integer s_num) {
		return subjectMapper.selectOneUseSnum(s_num);
	}
	
	@Override
	public List<SubjectCommand> selectLv2AllSearch() {
		return subjectMapper.selectLv2AllSearch();
	}
}
