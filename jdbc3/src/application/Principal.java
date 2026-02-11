package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import db.DB;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Connection conn = null;
		PreparedStatement st = null;

		try {
			conn = DB.getConnection();
			/*
			 * Para Adc usuario st = conn.prepareStatement("INSERT INTO seller" +
			 * "(Name, Email,BirthDate,BaseSalary,DepartmentId)" + "VALUES" +
			 * "(?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS); st.setString(1,
			 * "Nara Santos"); st.setString(2, "naradSantos@gmail.com"); st.setDate(3, new
			 * java.sql.Date(sdf.parse("08/05/2000").getTime())); st.setDouble(4, 3500);
			 * st.setInt(5, 3); int rowsAffected = st.executeUpdate();
			 */
			// System.out.println("Done ! Rows affected : " + rowsAffected);
			// para adc departament
			st = conn.prepareStatement("insert into department (Name) values ('T.I'),('Suporte')",Statement.RETURN_GENERATED_KEYS);
			int rowsAffected = st.executeUpdate();
			if (rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				while (rs.next()) {
					int id = rs.getInt(1);
					System.out.println("Done! Id =" + id);
				}

			} else {
				System.out.println("No rown affected !");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}/*Exceção do date catch (ParseException e) {
			e.printStackTrace();
		} */finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}

	}

}
