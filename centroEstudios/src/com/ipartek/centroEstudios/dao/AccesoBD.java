package com.ipartek.centroEstudios.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ipartek.centroEstudios.domain.Asignatura;
import com.ipartek.centroEstudios.domain.Libro;
import com.ipartek.centroEstudios.domain.Profesor;

public class AccesoBD {
	private static Connection conexion = null;
	private static PreparedStatement ps = null;
	private static ResultSet rs = null;
	
	private static void crearConexion() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/colegio", "root", "root");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	private static void cerrarConexion() {
		try {
			if(rs!=null) {
				rs.close();
			}
			
			if(ps!=null) {
				ps.close();
			}
			
			if(conexion!=null) {
				conexion.close();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static ArrayList<Asignatura> getAsignaturas(){
		crearConexion();
		ArrayList<Asignatura> asignaturas = new ArrayList<>();
		
		try {
			ps = conexion.prepareStatement("select * from asignaturas");
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Asignatura a = new Asignatura(rs.getInt(1), rs.getString(2));
				asignaturas.add(a);
			}
			
			return asignaturas;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return asignaturas;
		}finally {
			cerrarConexion();
		}
	}

	public static Profesor getProfesorById(int idProfesor) {
		crearConexion();
		
		try {
			ps = conexion.prepareStatement("select * from profesores where id = ?");
			ps.setInt(1, idProfesor);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				return new Profesor(rs.getInt(1), rs.getString("nombre"), rs.getString("apellidos"), rs.getString("email"), rs.getString("telefono"), rs.getString("direccion"), rs.getDouble("sueldo"));
			}
			
			return null;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally {
			cerrarConexion();
		}
	}

	public static void createLibro(Libro libro) {
		crearConexion();
		
		try {
			ps = conexion.prepareStatement("insert into libros (isbn, titulo, autor, editorial, asignaturas_id) values (?,?,?,?,?)");
			ps.setString(1, libro.getISBN());
			ps.setString(2, libro.getTitulo());
			ps.setString(3, libro.getAutor());
			ps.setString(4, libro.getEditorial());
			ps.setInt(5, libro.getAsignatura().getId());
			
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
