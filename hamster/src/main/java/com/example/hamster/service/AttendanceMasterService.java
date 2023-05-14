package com.example.hamster.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.hamster.entity.AttendanceMaster;
import com.example.hamster.mapper.AttendanceMasterMapper;

@Service
public class AttendanceMasterService {

	@Autowired
	AttendanceMasterMapper mapper;

	@Transactional(rollbackFor = Exception.class)
	public AttendanceMaster insertMaster(AttendanceMaster master) {

		mapper.insertMaster(master);

		return selectOneMaster(master.getItemName());
	}

	@Transactional(rollbackFor = Exception.class)
	public AttendanceMaster updateMaster(AttendanceMaster master) {

		master.setUpdateDatetime(new Date());
		mapper.updateMaster(master);

		return selectOneMaster(master.getItemName());
	}

	@Transactional(rollbackFor = Exception.class)
	public int deleteMaster(AttendanceMaster master) {

		return mapper.deleteMaster(master);

	}

	public AttendanceMaster selectOneMaster(String itemName) {
		return mapper.selectMasterByItemName(itemName);
	}

	public List<AttendanceMaster> selectAllMaster(){
		return mapper.selectAllMaster();
	}

}
