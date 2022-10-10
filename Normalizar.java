import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Normalizar {

	public static void main(String[] args) {
		try (Scanner s = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
			String mensaje = s.nextLine();
			System.out.println(mensaje.toUpperCase());
		}
	}

}

