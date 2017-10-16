   import java.net.*;
   import java.io.*;
 
   /**
   *    Este ejemplo ilustra las llamadas de método básicas para sockets
   *    datagrama sin conexión
   *    @author M. L. Liu
 */ public class Ejemplo1Emisor {

  //  Una aplicación que manda un mensaje utilizando un socket datagrama
  //  sin conexión.
  //  Se esperan tres argumentos de línea de mandato, en orden:
  // <nombre del dominio o dirección IP del receptor>
  // <número del puerto del socket del receptor>
  // <mensaje, una cadena, para mandar>

    public static void main(String[ ] args) {
      if (args.length != 3)
        System.out.println
          ("Este programa requiere 3 argumentos de línea de mandato");
      else {
        try {
          InetAddress maquinaReceptora = InetAddress.getByName(args[0]);
          int puertoReceptor = Integer.parseInt(args[1]);
          String mensaje = args[2];

          // instancia un socket datagrama para mandar los datos
          DatagramSocket miSocket = new DatagramSocket( );
          byte[ ] almacen = mensaje.getBytes( );
          DatagramPacket datagrama =
            new DatagramPacket(almacen, almacen.length,
              maquinaReceptora, puertoReceptor);
          miSocket.send(datagrama);
          miSocket.close( );
        } // fin de try
        catch (Exception ex) {
          ex.printStackTrace( );
        } // fin de catch
      } // fin de else
    } // fin de main
  } // fin de class
