package kr.spring.record.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.spring.record.dao.RecordMapper;
import kr.spring.record.domain.RecordCommand;

@Service("recordService")
public class RecordServiceImpl implements RecordService{
	
	@Resource
	private RecordMapper recordMapper;
	
	
	@Override
	public void insertRecord(Map<String, String> map) {
		recordMapper.insertRecord(map);
	}
	
	@Override
	public List<RecordCommand> list(Map<String, Object> map) {
		return recordMapper.list(map);
	}

	@Override
	public int getRowCount(Map<String, Object> map) {
		return recordMapper.getRowCount(map);
	}


}
