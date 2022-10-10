import java.io.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class Main {


            public static void main(String[] args) throws IOException
            {
                // Creamos el archivo con el formato correspondiente.
                SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd_HHmmss");
                File dir = new File("C:\\Users\\jigod\\IdeaProjects\\EnviarSecreto\\out\\production\\EnviarSecreto");
                File archivo = new File("C:\\Users\\jigod\\IdeaProjects\\EnviarSecreto\\Secretos\\secreto"+ df.format(new Date()) +".shh");

                // Creamos los ProccesBuilder
                ProcessBuilder pbN = new ProcessBuilder("java", "Normalizar");
                ProcessBuilder pbC = new ProcessBuilder("java", "Cifrar", "C");


                // Redirigimos los ProcesBuilders al directorio "dir"
                pbN.directory(dir);
                pbC.directory(dir);

                // Redirigimos la salida al File "archivo"
                pbC.redirectOutput(archivo);

                //Inicializamos Normalizar como proceso
                Process pN = pbN.start();

                // osN se refiere a la salida del proceso Normalizar ("pN")
                OutputStream osN = pN.getOutputStream();

                System.out.println("Inserte el mensaje a para cifrar:\n");
                Scanner sc = new Scanner(System.in);
                String mensaje = sc.nextLine();

                //Cerramos el scaner para evitar que no lo pare de pedir (Con un salto de linea es mas q suficiente)
                sc.close();

                //Escribimos el mensaje q nos llegaba por el Scanner
                osN.write(mensaje.getBytes());
                osN.flush();
                osN.close();

                Process pC = pbC.start();

                OutputStream osC = pC.getOutputStream();
                InputStream isN = pN.getInputStream();


                int d;

                while ((d = isN.read()) != -1){
                    System.out.print((char)d);
                    //Escribimos la salida de "d"
                    osC.write(d);
                }



                isN.close();
                osC.flush();
                osC.close();

                //--------------------------


            }
    }