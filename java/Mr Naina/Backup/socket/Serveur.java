import java.net.*;
import java.io.*;

public class Serveur
{
    public static void main(String[] args)throws Exception
    {
        ServerSocket ss=new ServerSocket(5152);
        Socket recept=ss.accept();

        DataInputStream dis=new DataInputStream(recept.getInputStream());

        System.out.println("client: "+dis.readUTF());

        // InetAddress local=InetAddress.getLocalHost();
        // ServerSocket ss=new ServerSocket(3333,3,local);
        // Socket recept=ss.accept();
        // DataInputStream dis=new DataInputStream(recept.getInputStream());
        // System.out.println("client: "+dis.readUTF());
    }
}