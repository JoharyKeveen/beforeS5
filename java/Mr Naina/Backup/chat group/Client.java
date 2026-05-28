package message;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;
import java.util.*;

public class Client
{
    Socket socket; 
    BufferedReader bufferedReader;
    BufferedWriter bufferedWriter;
    String name;

    public Client(Socket socket,String name)
    {
        try
        {
            this.socket=socket;
            this.name=name;
            this.bufferedWriter=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            this.bufferedReader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
        }
        catch(Exception e)
        {}
    }

    public void send()
    {
        try
        {
            bufferedWriter.write(name);
            bufferedWriter.newLine();
            bufferedWriter.flush();

            Scanner scan=new Scanner(System.in);
            while(socket.isConnected())
            {
                String messageToSend=scan.nextLine();
                bufferedWriter.write(name+": "+messageToSend);
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
        }
        catch(Exception e)
        {}
    }

    public void listenForMessage()
    {
        new Thread(new Runnable()
        {
            public void run()
            {
                String messageFromGroupChat;
                while(socket.isConnected())
                {
                    try
                    {
                        messageFromGroupChat=bufferedReader.readLine();
                        System.out.println(messageFromGroupChat);
                    }
                    catch(Exception e)
                    {}
                }
            }
        }

        ).start();
    }

    public static void main(String[] args)throws Exception
    {
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter your username for the group chat: ");
        String username=scan.nextLine();
        Socket socket=new Socket("localhost",1234);
        Client client=new Client(socket,username);
        client.listenForMessage();
        client.send();
    }
}