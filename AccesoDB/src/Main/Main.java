package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) {
		ResultSet rs = null;
		Statement st = null;
		Connection conexion = null;
		try {
			//cargar el driver
			Class.forName("com.mysql.jdbc.Driver");
			
			//crear la conexion
			conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/escuela", "root", "root");
			
			st = conexion.createStatement();
			
			rs = st.executeQuery("select * from alumnos");
			
			while(rs.next()) {
				System.out.println(rs.getString("nombre") + " " + rs.getString("apellidos"));
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				st.close();
				conexion.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}
