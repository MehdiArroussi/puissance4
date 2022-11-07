package ynovpuissance4;

import java.util.ArrayList;
import java.util.Random;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.HashMap;
import java.util.Map;






public class Server {

    /*
     * This method is the main Server part. It makes a server and wait for the players (as Client) to connect. Then it communicates with it and launch an online game.
     */
    
    public static void LaunchServeur(int numberPlayer) {
        ArrayList<SocketChannel> listClient = new ArrayList<SocketChannel>();
        try {
            ServerSocketChannel serverSocket  = ServerSocketChannel.open();
            serverSocket.bind(new InetSocketAddress(4004)); ///Port 4004 as asked in the subject.
            while(numberPlayer != listClient.size()) { 
                SocketChannel clientSocket = serverSocket.accept();
                System.out.println("A Player has connected ! Get Ready !");
                listClient.add(clientSocket);
                broadcast(Integer.toString(numberPlayer), clientSocket);
            }
        }catch (IOException e) {
            System.err.println(e.toString());
        }
        Player playerPlay = PlayerRandomizer(numberPlayer); 
        Grid grid = new Grid(numberPlayer);
        Map<Player, SocketChannel> dictionary = new HashMap<Player, SocketChannel>();
        for (int i = 0; i < listClient.size(); i++) {
            Player player;
            if (i==0) {player = Player.Player1;}else if (i==1) {player = Player.Player2;}else {player = Player.Player3;}
            dictionary.put(player, listClient.get(i));
        }
        while(!Conditions.Win(grid.grille)&& !Conditions.Equal(grid.grille)) { 
            for (SocketChannel socketChannel : listClient) {
                if (socketChannel == dictionary.get(playerPlay)) { 
                    switch (playerPlay) {
                        case Player1:
                            broadcast("Player X , It's your turn !",socketChannel);
                            break;
                        case Player2:
                            broadcast("Player O , It's your turn !",socketChannel);
                            break;
                        default:
                            broadcast("Player V , It's your turn !",socketChannel);
                            break;
                    }
                }else {
                    broadcast("Turn",socketChannel);
                }
            }
            String Message = "";
            try {
                Message = Client.Listen(dictionary.get(playerPlay)); 
            }catch (IOException e) {
                System.err.println("A player has disconnected ...");
            }
            for (SocketChannel socketChannel : listClient) {
                broadcast(Message, socketChannel); 
            }
            playerPlay = NextPlayer(numberPlayer, playerPlay);
            if (Message != "") {
                Turn(grid.grille,String.valueOf(Message.charAt(5)),String.valueOf(Message.charAt(7)));
            }else {
                break;
            }
        }
    }

    /**
     * This Method is for the online game, it sends a message to the Client.
     * @param message the message (type String) we wanna send to the Client.
     * @param clientSocket the socket of the Client.
     */
    public static void broadcast(String message, SocketChannel clientSocket){
        try{
            ByteBuffer bytes = ByteBuffer.wrap(message.getBytes("UTF-8"));
        while(bytes.hasRemaining()){
            clientSocket.write(bytes);
        }
        }catch(IOException e){
            System.err.println(e.toString());
        }
    }
 
    /**
     * @param player this is the playing player
     * @param index this is the index of the column where the token has been thrown
     * @param Grid the Grid players are playing on
     * This method puprpose is to add the token in the grid after the player has chosen a column where he wants to play. This meethod has a server/client approach.
     */

    public static void Turn(ArrayList<ArrayList<String>> Grid,String player, String indexString ) {
        String letter = "abcdefghijkl";
        int index = letter.indexOf(indexString);
        for (int i = Grid.size()-1; i >= 0; i--) {
            if (Grid.get(i).get(index) == " ") {
                Grid.get(i).set(index, player);
                return;
        } 

    } 
    }


    /**
     *This Method have the purpose to have the next player playing after the current one. 
     * @param playerNb the number of players concerned in the game
     * @param player the current player playing.
     * @return Next player playing.
     */

    public static Player NextPlayer(int playerNb,Player player) {
        switch (player) {
            case Player1:
                return Player.Player2;
            case Player2:
                if (playerNb == 3) {
                    return Player.Player3;
                }
                return Player.Player1;
            case Player3:
                return Player.Player1;
        }
        return NextPlayer(playerNb, player);
}
/*
 * This Method have the purpose of randomizing the first player playing in the game.
 */

public static Player PlayerRandomizer(int playerNb) {
    Random rnd = new Random();
    int random = rnd.nextInt(playerNb);
    System.out.println(random);
    switch(random) {
        case 0 : 
            return Player.Player1;
        case 1 :
            return Player.Player2;
        case 2 :
            return Player.Player3;
    }
    return PlayerRandomizer(playerNb);
}
}
