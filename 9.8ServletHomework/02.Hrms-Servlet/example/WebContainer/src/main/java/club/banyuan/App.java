package club.banyuan;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Hello world!
 */
public class App {

  public static void main(String[] args) throws Exception {

    ServerSocket serverSocket = new ServerSocket(8080);
    while (true) {
      System.out.println("等待接入");
      Socket socket = serverSocket.accept();
      System.out.println("接入成功");
      SocketThread thread = new SocketThread(socket);
      thread.start();
    }


  }
}
