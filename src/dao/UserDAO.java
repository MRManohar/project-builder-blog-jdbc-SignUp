package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.time.LocalDate;

import model.User;
import utility.ConnectionManager;

public class UserDAO implements UserDaoInterface{

	@Override
	public int signUp(User user) throws Exception {
		String email = user.getEmail();
		String password = user.getPassword();
		LocalDate date = user.getDate();
		
		ConnectionManager connectionManager = new ConnectionManager();
		Connection connection = connectionManager.getConnection();
		
		String sql = "INSERT INTO userdetails (EMAIL,PASSWORD,DATES) VALUES (?,?,?)";
		
		PreparedStatement preparedStatment = connection.prepareStatement(sql);
		
		preparedStatment.setString(1, email);
		preparedStatment.setString(2, password);
		preparedStatment.setDate(3, Date.valueOf(date) );
		
		int status = preparedStatment.executeUpdate();
		System.out.println("Insertion update status = "+status);
		return status;
	}

	@Override
	public boolean loginUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}
	
}