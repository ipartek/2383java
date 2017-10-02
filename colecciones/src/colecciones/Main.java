package colecciones;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Main {
	
	private static Random random = new Random(Calendar.getInstance().getTimeInMillis());

	public static void main(String[] args) {

		cargarPremios();
		
		System.out.println("carga de premios terminada");
		
		List<Premio> premios = obtenerPremios();
		
		System.out.println("premios obtenidos de fichero");
		
		ArrayList<FrecuenciaPremio> premiosRepetidos = new ArrayList<FrecuenciaPremio>();
		
		for(int i=0;i<premios.size();i++) {
			for(int j=i+1;j<premios.size();j++) {
				if(premios.get(i).getNumeroPremiado() == premios.get(j).getNumeroPremiado()) {
					System.out.println("el numero " + premios.get(i).getNumeroPremiado() +" esta repetido");

				}
			}
		}
		
		System.out.println("FIN");

	}

	private static Premio getPremio(int dia, int mes, int anyo) {
		 return new Premio(dia, mes, anyo, random.nextInt(100000));
	 }
	 
	 private static void cargarPremios(){
			Calendar fecha = Calendar.getInstance();
			ArrayList<Premio> premios = new ArrayList<Premio>();
			fecha.add(Calendar.YEAR, -50);
			
			Calendar fechaHoy = Calendar.getInstance();
			
			while(fechaHoy.compareTo(fecha)>0) {
				fecha.add(Calendar.DAY_OF_YEAR, +7);
				
				Premio p = getPremio(fecha.get(Calendar.DAY_OF_MONTH), 
						(fecha.get(Calendar.MONTH)+1), 
						fecha.get(Calendar.YEAR));
				
				premios.add(p);
			}

			FileOutputStream fos = null;
			ObjectOutputStream oos = null;
			try {
				fos = new FileOutputStream("premios.txt");
				oos = new ObjectOutputStream(fos); 
				
				for(Premio p : premios) {
					oos.writeObject(p);
				}
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
				try {
					if(oos!=null) {
						oos.close();
					}
					
					if(fos!=null) {
						fos.close();
					}
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
	 }
	 
	 private static ArrayList<Premio> obtenerPremios() {
		 FileInputStream fis = null;
		 ObjectInputStream ois = null;
		 ArrayList<Premio> premios = new ArrayList<Premio>();
		try {
			fis = new FileInputStream("premios.txt");
			ois = new ObjectInputStream(fis);
			
			Premio premio = null;
			
			while((premio=(Premio)ois.readObject())!=null) {
				premios.add(premio);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			try {
				if(ois!=null) {
					ois.close();
				}
				
				if(fis!=null) {
					fis.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return premios;
	}

}
