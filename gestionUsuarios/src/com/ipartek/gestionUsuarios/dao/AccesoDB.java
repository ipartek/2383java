package com.ipartek.gestionUsuarios.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ipartek.gestionUsuarios.domain.Usuario;

public class AccesoDB {
	
	private static Connection conexion = null;
	private static PreparedStatement ps = null;
	private static ResultSet rs = null;
	
	private static void crearConexion() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestionUsuarios", "root", "root");
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
	
	public static void addUsuario(Usuario u){
		crearConexion();
		try {
			ps = conexion.prepareStatement("insert into usuarios (nombre, apellidos) values (?,?)");
			
			ps.setString(1, u.getNombre());
			ps.setString(2, u.getApellidos());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		cerrarConexion();
	}

	public static boolean existeEmail(String email) {
		crearConexion();
		
		try {
			ps = conexion.prepareStatement("select * from usuarios where email = ?");
			
			ps.setString(1, email);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				return true;
			}else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return true;
		}finally {
			cerrarConexion();
		}
		
	}

	public static ArrayList<Usuario> getUsuarios() {
		crearConexion();
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		
		try {
			ps = conexion.prepareStatement("select * from usuarios");
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Usuario u = new Usuario(rs.getString(1), rs.getString(2), rs.getString(3));
				usuarios.add(u);
			}
			
			return usuarios;
		} catch (SQLException e) {
			e.printStackTrace();
			return usuarios;
		}finally {
			cerrarConexion();
		}
		
	}
	
}
