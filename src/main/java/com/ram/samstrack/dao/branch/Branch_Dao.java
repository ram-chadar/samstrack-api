package com.ram.samstrack.dao.branch;

import java.io.Serializable;
import java.util.List;

import com.ram.samstrack.model.Branch;

public interface Branch_Dao {

	public Serializable addBranch(Branch branch);
	public List<Branch> getAllBranch();

}
