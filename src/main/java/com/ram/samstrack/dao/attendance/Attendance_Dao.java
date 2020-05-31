package com.ram.samstrack.dao.attendance;

import java.io.Serializable;

import com.ram.samstrack.model.Practical_Attendance;
import com.ram.samstrack.model.Theory_Attendance;

public interface Attendance_Dao {
	public Serializable save_Theory_Attendance(Theory_Attendance attendance);
	public Serializable save_Practical_Attendance(Practical_Attendance attendance);

}
