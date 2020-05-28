package com.ram.samstrack.service.branch;

import java.io.Serializable;
import java.util.List;

import com.ram.samstrack.model.Branch;

public interface Branch_Service {

	public Serializable addBranch(Branch branch);
	public List<Branch> getAllBranch();
}
