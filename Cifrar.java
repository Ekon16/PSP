import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Cifrar {
	private static final int BASE_MAY = (int)'A';
	private static final int LONG_ABC = 26;
	
	public static void main(String[] args) {

		if (args.length == 0) {
			System.exit(0);
		}
		String operacion = args[0];
		boolean esCifrado = operacion.equalsIgnoreCase("C");
		int despl = esCifrado ? 3 : -3;
		try (Scanner s = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
			String mensaje = s.nextLine();
			String cifrado = "";
			for (char l : mensaje.toCharArray()) {
				cifrado += (char)(((int)l - BASE_MAY + despl) % LONG_ABC + BASE_MAY);
			}
			System.out.println(cifrado);
		}
	 }
}
