package primitivewritechars;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 *
 * @author Alba
 */
public class Metodos {

    public static void gravarChars() {
        try {
            FileOutputStream fos = new FileOutputStream("texto4.txt");
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            DataOutputStream dos = new DataOutputStream(bos);
            FileInputStream fis = new FileInputStream("texto4.txt");
            BufferedInputStream bis = new BufferedInputStream(fis);
            DataInputStream dis = new DataInputStream(bis);

            String s = "o tempo está xélido";
            System.out.println("A cadea a escribir é: " + s);
            System.out.println("A lonxitude desta cadea en caracteres é: " + s.length());
            
            dos.writeChars(s);
            System.out.println("writeChars escribiu: " + dos.size() + " bytes");
            
            int t = dos.size(); //reinicializamos la variable para poner el contador de bytes a 0 y
            //así ponga el tamaño de cada cadena independientemente
            dos.writeChars(s);
            System.out.println("writeChars escribiu: " + t + " bytes");
            
            
            System.out.println("Bytes totais escritos: " + dos.size());
            dos.close();

//            while ((dis.available()) != 0) { //otra forma de hacer los bucles
//
//                char a = dis.readChar();
//                System.out.println(a);
//            }

            System.out.print("Lemos a primeira cadea: ");
            for (int i = 0; i < s.length(); i++) {
                char a = dis.readChar();
                System.out.print(a);
            }
            
            System.out.print("\nLemos a segunda cadea: ");
            for (int i = 0; i < s.length(); i++) {
                char a = dis.readChar();
                System.out.print(a);
            }

            System.out.println("\nNumero de bytes lidos: " + dos.size());

            System.out.println("Bytes restantes por ler: " + dis.available());
            dis.close();
//            bos.close(); //no son estrictamente necesarios
//            fos.close();
//            bis.close();
//            fis.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
