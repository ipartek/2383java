package colecciones;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
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
					System.out.println("el numero " + premios.get(i).getNumeroPremiado() +" esta repetido " + i + " " + j);
					boolean existe = false;
					for(int k=0;k<premiosRepetidos.size();k++) {
						if(premios.get(j).getNumeroPremiado() == premiosRepetidos.get(k).getNumeroPremiado()) {
							premiosRepetidos.set(k, new FrecuenciaPremio(premiosRepetidos.get(k).getNumeroPremiado(), premiosRepetidos.get(k).getNumVeces()+1));
							existe = true;
							break;
						}
					}
					
					if(!existe) {
						FrecuenciaPremio fp = new FrecuenciaPremio(premios.get(i).getNumeroPremiado(), 1);
						premiosRepetidos.add(fp);	
					}
					
					break;
				}
			}
		}
/*
		ArrayList<FrecuenciaPremio> todosPremiosRepetidos = new ArrayList<FrecuenciaPremio>();
		for(int i=0;i<premios.size();i++) {
			FrecuenciaPremio fp = new FrecuenciaPremio(premios.get(i).getNumeroPremiado(), 0);
			
			if(!todosPremiosRepetidos.isEmpty()) {
				boolean repetido = false;
				for(int j=0;j<todosPremiosRepetidos.size();j++) {
					if(premios.get(i).getNumeroPremiado() == todosPremiosRepetidos.get(j).getNumeroPremiado()) {
						todosPremiosRepetidos.set(j, new FrecuenciaPremio(todosPremiosRepetidos.get(j).getNumeroPremiado(), todosPremiosRepetidos.get(j).getNumVeces()+1));
						repetido = true;
					}
				}

				if(!repetido) {
					todosPremiosRepetidos.add(fp);
				}
			}else {
				todosPremiosRepetidos.add(fp);
			}
			
		}
		
		ArrayList<FrecuenciaPremio> premiosRepetidos = new ArrayList<FrecuenciaPremio>();
		
		for(FrecuenciaPremio fp : todosPremiosRepetidos) {
			if(fp.getNumVeces()>0) {
				premiosRepetidos.add(fp);
			}
		}
		
		
*/
		
		System.out.println("FIN");
	}

	private static Premio getPremio(int dia, int mes, int anyo) {
		 return new Premio(dia, mes, anyo, random.nextInt(10));
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
			
		} catch (EOFException e) {
			
		}catch (FileNotFoundException e) {
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
