import java.io.*;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by 99670 on 11.11.2020.
 */

//heroku ps:scale worker=1

//стартануть прогу
public class Main {
    static {
        System.out.println("проверка запуска");
    }
    public static void main(String[] args) {
        System.out.println("aloha salam app run");
        System.out.println(System.getenv("PORT")+" PORT");
        try {
            ServerSocket serverSocket = new ServerSocket(Integer.parseInt(System.getenv("PORT")));
            Socket socket = serverSocket.accept();
            InetAddress inetAddress =  socket.getInetAddress();
            System.out.println(inetAddress.toString()+" это адрес клиента");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println( bufferedReader.readLine());
            bufferedReader.close();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bufferedWriter.write("aloha salam s servaka");
            bufferedWriter.close();
           /* Socket socket = new Socket();
            socket.connect(new InetSocketAddress("quiet-castle-20445.herokuapp.com",80));

            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bufferedWriter.write("aloha salam s clienta");*/
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
//www.socketkg.herokuapp.com 8080