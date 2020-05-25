package com.ram.samstrack.service;

import java.io.Serializable;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ram.samstrack.dao.Branch_Dao;
import com.ram.samstrack.model.Branch;
@Service
@Transactional
public class Branch_ServiceImpl implements Branch_Service {

	@Autowired
	private Branch_Dao branch_Dao;
	
	@Override
	public Serializable addBranch(Branch branch) {
		// TODO Auto-generated method stub
		return branch_Dao.addBranch(branch);
	}

}
