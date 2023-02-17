package com.revature.dao;

import java.util.List;

import com.revature.model.Bus;

public interface BusDAO {
	
	List<Bus> get();
	
	Bus get(String id);
	
	boolean save(Bus bus);
	
	boolean delete(String id);
	
	boolean update(Bus bus);
}
