package kr.spring.record.dao;

import java.util.List;
import java.util.Map;

import kr.spring.record.domain.RecordCommand;

public interface RecordMapper {
	
	public void insertRecord(Map<String, String> map);
	
	public List<RecordCommand> list(Map<String,Object> map);
	public int getRowCount(Map<String,Object> map);
	
}
