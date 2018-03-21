package kr.spring.record.service;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import kr.spring.record.domain.RecordCommand;

@Transactional
public interface RecordService {
	
	public void insertRecord(Map<String, String> map);
	
	@Transactional(readOnly=true)
	public List<RecordCommand> list(Map<String,Object> map);
	@Transactional(readOnly=true)
	public int getRowCount(Map<String,Object> map);
	
}
