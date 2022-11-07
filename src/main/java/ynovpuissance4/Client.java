package ynovpuissance4;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class Client {

    /*
     * This method is the main Client part. It makes a client and connect to the server. Then it communicates with it to play an online game.
     */







     /*
      * This Method is the ears of the client. It listens to the server and receive messages from it.
      * @param message The message received from the server.
      * @throws IOException
      */
    public static String Listen(SocketChannel clientSocket) throws IOException {
        ByteBuffer bytes = ByteBuffer.allocate(1024);
        int bytesRead = clientSocket.read(bytes);
        if (bytesRead <= 0 ) {
            clientSocket.close();
            return "";
        }
        String message = new String(bytes.array(),"UTF-8");
        return message;
}
