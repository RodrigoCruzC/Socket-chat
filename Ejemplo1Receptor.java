 import java.net.*;
  import java.io.*;

  /**
  *    Este ejemplo ilustra las llamadas de método básicas para sockets
  *    datagrama sin conexión.
  *    @author M. L. Liu
  */
  public class Ejemplo1Receptor {
  
  //  Una aplicación  que recibe un mensaje utilizando un socket datagrama 
  //  sin conexión.
  //  Se espera un argumento de línea de mandato:
  //  <número de puerto del socket del receptor>
  //  Nota: se debería especificar el mismo número de puerto 
  //  en los argumentos de línea de mandato del emisor.

    public static void main(String[] args) {
      if (args.length != 1)
        System.out.println
          ("Este programa requiere un argumento de línea de mandato.");
      else {
        int puerto = Integer.parseInt(args[0]);
        final int MAX_LON = 10;
        // Esta es la longitud máxima asumida en octetos 
        // del datagrama que se va a recibir.
        try {
          DatagramSocket miSocket = new DatagramSocket(5000);
          // instancia un socket datagrama para recibir los datos 
          byte[ ] almacen = new byte[MAX_LON];
          DatagramPacket datagrama =
            new DatagramPacket(almacen, MAX_LON);
          miSocket.receive(datagrama);
          String mensaje = new String(almacen);
          System.out.println(mensaje);
          miSocket.close( );
        } // fin de try
        catch (Exception ex) {
          ex.printStackTrace( );
        } // fin de catch
      } // fin de else
    } // fin de main
  } // fin de class
