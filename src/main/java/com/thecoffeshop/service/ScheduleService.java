package com.thecoffeshop.service;

import com.thecoffeshop.DAO.ScheduleDAO;
import com.thecoffeshop.DAOImpl.ScheduleDAOImp;
import com.thecoffeshop.entity.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
@Transactional
public class ScheduleService implements ScheduleDAOImp {

	@Autowired
	ScheduleDAO scheduleDAO;

	@Override
	public Boolean addSchedule(Schedule schedule) {
		// TODO Auto-generated method stub
		return scheduleDAO.addSchedule(schedule);
	}

	@Override
	public List<Schedule> findAll() {
		// TODO Auto-generated method stub
		return scheduleDAO.findAll();
	}

	@Override
	public Schedule getInfoById(String scheduleid) {
		// TODO Auto-generated method stub
		return scheduleDAO.getInfoById(scheduleid);
	}

	@Override
	public Boolean deleteSchedule(String scheduleid) {
		// TODO Auto-generated method stub
		return scheduleDAO.deleteSchedule(scheduleid);
	}

	@Override
	public Boolean editSchedule(Schedule schedule) {
		// TODO Auto-generated method stub
		return scheduleDAO.editSchedule(schedule);
	}

	@Override
	public List<Schedule> findLimit(int startPosition) {
		// TODO Auto-generated method stub
		return scheduleDAO.findLimit(startPosition);
	}
}