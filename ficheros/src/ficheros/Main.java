package ficheros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el nombre de un fichero");
		FileReader fr = null;
		BufferedReader br = null;
		FileWriter fw = null;
		BufferedWriter bw = null;

		String nombreFichero = sc.nextLine();

		try {
			fr = new FileReader(nombreFichero);
			br = new BufferedReader(fr);

			fw = new FileWriter("resultado.txt");
			bw = new BufferedWriter(fw);

			/*
			 * int i; while((i = fr.read())>=0) { char c = (char) i; System.out.print(c); }
			 */
			String texto = "";
			while ((texto = br.readLine()) != null) {
				System.out.println(texto);
				if (texto.charAt(0) == '+') {
					bw.write(texto.substring(1));
					bw.newLine();
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}

				if (fr != null) {
					fr.close();
				}

				if (bw != null) {
					bw.close();
				}

				if (fw != null) {
					fw.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
