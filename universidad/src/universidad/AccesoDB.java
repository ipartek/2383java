package universidad;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.sql.PreparedStatement;

public class AccesoDB {
	
	private static Connection conn = null;
	private static PreparedStatement ps = null;
	private static ResultSet rs = null;
	
	public static ArrayList<Alumno> getAlumnos(){
		ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
		openConexion();
		
		try {
			ps = conn.prepareStatement("select * from alumnos");
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Alumno a = new Alumno(rs.getInt("idAlumnos"), rs.getString("nombre"), rs.getString("apellidos"), rs.getString("dni"));
				alumnos.add(a);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeConexion();
		}
		
		return alumnos;
	}
	
	public static ArrayList<Alumno> getAlumnosConCarrera(){
		ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
		openConexion();
		PreparedStatement psCarrera = null;
		ResultSet rsCarrera = null;
		
		try {
			ps = conn.prepareStatement("select * from alumnos");
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int idCarrera = rs.getInt("carreras_id");
				
				psCarrera = conn.prepareStatement("Select * from carreras where idCarreras = ?");
				psCarrera.setInt(1, idCarrera);
				
				rsCarrera = psCarrera.executeQuery();
				
				Carrera carrera = null;
				
				if(rsCarrera.next()) {
					carrera = new Carrera(rsCarrera.getInt(1), rsCarrera.getString(2));
				}
				
				
				Alumno a = new Alumno(rs.getInt("idAlumnos"), rs.getString("nombre"), rs.getString("apellidos"), rs.getString("dni"), carrera);
				
				alumnos.add(a);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
			try {
				if(rsCarrera!=null) {
					rsCarrera.close();
				}
				if(psCarrera!=null) {
					psCarrera.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			closeConexion();
		}
		
		return alumnos;
	}
	
	public static void saveAlumno(Alumno a) {
		openConexion();
		
		try {
			ps = conn.prepareStatement("INSERT INTO alumnos (nombre, apellidos, dni) VALUES (?,?,?)");
			ps.setString(1, a.nombre);
			ps.setString(2, a.apellidos);
			ps.setString(3, a.dni);
			
			int filas = ps.executeUpdate();
			
			System.out.println("Han sido afectadas " + filas + " filas");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeConexion();
		}
		
	}
	
	private static void openConexion() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/universidad", "root", "root");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static void closeConexion() {
		try {
			if(rs!=null) {
				rs.close();
			}
			
			if(ps!=null) {
				ps.close();
			}
			
			if(conn != null) {
				conn.close();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
