package ynovpuissance4;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class Client {

    /*
     * This method is the main Client part. It makes a client and connect to the server. Then it communicates with it to play an online game.
     */

    public static void LaunchClient() {
        try {
            SocketChannel clientSocket = SocketChannel.open();
            clientSocket.connect(new InetSocketAddress("localhost", 4004)); ///Port 4004 as asked in the subject. (same as Server to communicate).
            int nbPlayer2 = Integer.parseInt(String.valueOf(Listen(clientSocket).charAt(0)));
            Grid grille = new Grid(nbPlayer2); 
            Display.printGrid(grille.grille);
            while(!Conditions.Equal(grille.grille) && !Conditions.Win(grille.grille)) { 
                String Turn = Listen(clientSocket);
                if (Turn.charAt(0) == 'Y') { 
                    System.out.println("Now's your turn to play !");
                    String choose = Display.TokenPos(grille.grille); 
                    String message = "Turn " + Turn.charAt(10) +" "+ choose;
                    ByteBuffer bytes = ByteBuffer.wrap(message.getBytes("UTF-8"));
                    while(bytes.hasRemaining()) {
                        clientSocket.write(bytes);
                    }
                }
                String Message = Listen(clientSocket); 
                Server.Turn(grille.grille,String.valueOf(Message.charAt(5)), String.valueOf(Message.charAt(7))); 
                Display.printGrid(grille.grille);
            }
        }catch (IOException e) {
            System.out.println("A Player has disconnected ...");
        }
    }
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
}