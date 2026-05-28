import java.net.*;
import java.io.*;

public class Client
{
    public static void main(String[] args)throws Exception
    {
        // Socket s=new Socket("192.168.20.69",3333);
        Socket s=new Socket("localhost",5152);

        DataOutputStream dos=new DataOutputStream(s.getOutputStream());
        dos.writeUTF("nena no nety ry JO a XD");
        dos.flush();
    }
}