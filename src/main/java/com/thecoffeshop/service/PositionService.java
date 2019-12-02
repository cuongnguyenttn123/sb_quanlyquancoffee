package com.thecoffeshop.service;

import com.thecoffeshop.DAO.PositionDAO;
import com.thecoffeshop.DAOImpl.PositionDAOImp;
import com.thecoffeshop.entity.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
@Transactional
public class PositionService implements PositionDAOImp {

	@Autowired
	PositionDAO positionDAO;

	@Override
	public Boolean addPosition(Position position) {
		// TODO Auto-generated method stub
		return positionDAO.addPosition(position);
	}

	@Override
	public List<Position> findAll() {
		// TODO Auto-generated method stub
		return positionDAO.findAll();
	}

	@Override
	public Position getInfoById(String positionid) {
		// TODO Auto-generated method stub
		return positionDAO.getInfoById(positionid);
	}

	@Override
	public Boolean deletePosition(String positionid) {
		// TODO Auto-generated method stub
		return positionDAO.deletePosition(positionid);
	}

	@Override
	public Boolean editPosition(Position position) {
		// TODO Auto-generated method stub
		return positionDAO.editPosition(position);
	}

	@Override
	public Position getInfoByName(String name) {
		// TODO Auto-generated method stub
		return positionDAO.getInfoByName(name);
	}

	@Override
	public List<Position> findLimit(int startPosition) {
		// TODO Auto-generated method stub
		return positionDAO.findLimit(startPosition);
	}
}