package com.thecoffeshop.DAOImpl;

import com.thecoffeshop.entity.Schedule;

import java.util.List;

public interface ScheduleDAOImp extends CommonDAOImp {

	public Boolean addSchedule(Schedule schedule);

	public List<Schedule> findAll();

	public List<Schedule> findLimit(int startPosition);

	public Schedule getInfoById(String scheduleid);

	public Boolean deleteSchedule(String scheduleid);

	public Boolean editSchedule(Schedule schedule);
}
