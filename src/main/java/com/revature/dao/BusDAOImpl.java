package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.Bus;
import com.revature.util.DataBaseConnection;

public class BusDAOImpl implements BusDAO {
	
	Connection connection = null;
	ResultSet rs = null;
	Statement statement = null;
	PreparedStatement preparedStatement = null;
	
	@Override
	public List<Bus> get() {
		
		List<Bus> list = null;
		Bus bus = null;
		
		try {
			
			list = new ArrayList<Bus>();
			String sql = "SELECT * FROM bus";
			connection = DataBaseConnection.getConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery(sql);
			while(rs.next()) {
			    bus = new Bus();
				bus.setBusRegNo(rs.getString(1));
				bus.setBusType(rs.getString(2));
				bus.setTotalSeats(rs.getInt(3));
				bus.setTotalBerths(rs.getString(4));
				list.add(bus);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Bus get(String bid) {
		Bus bus = null;
		try {
			bus = new Bus();
			String sql = "SELECT * FROM bus where Bus_Reg_No="+bid;
			connection = DataBaseConnection.getConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery(sql);
			if(rs.next()) {
				bus.setBusRegNo(rs.getString(1));
				bus.setBusType(rs.getString(2));
				bus.setTotalSeats(rs.getInt(3));
				bus.setTotalBerths(rs.getString(4));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return bus;
	}

	@Override
	public boolean save(Bus b) {
		boolean flag = false;
		try {
			String sql = "INSERT INTO bus VALUES"
					+ "('"+b.getBusRegNo()+"', '"+b.getBusType()+"', '"+b.getTotalSeats()+"', '"+b.getTotalBerths()+"')";
			connection = DataBaseConnection.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			flag = true;
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean delete(String bid) {
		boolean flag = false;
		try {
			String sql = "DELETE FROM bus where Bus_Reg_No=?";
			connection = DataBaseConnection.getConnection();
			preparedStatement  = connection.prepareStatement(sql);
			preparedStatement.setString(1,bid);
			preparedStatement.executeUpdate();
			flag = true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean update(Bus bus) {
		boolean flag = false;
		try {
			String sql = "UPDATE bus SET Bus_Type = '"+bus.getBusType()+"', "
					+ "', Total_Seats = '"+bus.getTotalSeats()+"', No_of_Births= '"+bus.getTotalBerths()+"' where Bus_Reg_No="+bus.getBusRegNo();
			connection = DataBaseConnection.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			flag = true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

}
