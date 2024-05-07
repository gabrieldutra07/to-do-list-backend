package com.example.todolist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.todolist.connectionfactory.ConnectionFactory;
import com.example.todolist.dto.ListTaskCountDTO;

public class ListAndTasksDAO {
	
	public ListTaskCountDTO getTasksAndLists(Long userId) throws SQLException {

		Connection con = ConnectionFactory.getConnectionBd();

		String sql = "SELECT COUNT(DISTINCT l.id) AS total_lists, COUNT(DISTINCT t.id) AS total_tasks, COUNT(DISTINCT CASE WHEN t.is_complete = 1 THEN t.id END) AS completed_tasks FROM users u LEFT JOIN lists l ON u.id = l.user_id LEFT JOIN tasks t ON l.id = t.list_id WHERE u.id = ? GROUP BY u.id;";

		PreparedStatement stmt = con.prepareStatement(sql);
		
		stmt.setLong(1, userId);

		ResultSet rs = stmt.executeQuery();
		
		ListTaskCountDTO list = new ListTaskCountDTO();

		if (rs.next()) {
			list.setCompletedTaskCount(rs.getLong("completed_tasks"));
			list.setListCount(rs.getLong("total_lists"));
			list.setTaskCount(rs.getLong("total_tasks"));

			rs.close();
			stmt.close();
			con.close();
			

		}

		rs.close();
		stmt.close();
		con.close();
		
		return list;

	}

}
