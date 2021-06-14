import Database.Database;
import Objects.*;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static Database.Database.getDatabase;

class ClientHandler implements Runnable {
    static int clientCounter = 1;
    Socket socket;
    DataInputStream dataIn;
    DataOutputStream dataOut;

    public ClientHandler(Socket socket) throws IOException {
        this.socket = socket;
        dataIn = new DataInputStream(socket.getInputStream());
        dataOut = new DataOutputStream(socket.getOutputStream());
    }

    @Override
    public void run() {
        System.out.println("client " + clientCounter++ + " added.");
        try {
            //EnteringPage
            boolean validUser = false;
            String clientMessage = "";
            String inputPhoneNumberEnter = "";
            String inputPasswordEnter = "";
            clientMessage = this.dataIn.readLine();
            System.out.println(clientMessage);
            dataOut.writeBytes(data());
            inputPhoneNumberEnter = clientMessage.substring(7, clientMessage.lastIndexOf(','));
            System.out.println(inputPhoneNumberEnter);
            inputPasswordEnter = clientMessage.substring(clientMessage.lastIndexOf(':')+2);
            System.out.println(inputPasswordEnter);


//        for(int i = 0; i < widget.restaurants.length; i++){
//            if(inputPhoneNumberEnter == widget.restaurants[i].getPhoneNumber() &&
//                    inputPasswordEnter == widget.restaurants[i].getPassword()) {
//                Navigator.pushReplacement(
//                        context,
//                        MaterialPageRoute(builder: (context) =>
//                Nav(widget.restaurants[i])),
//                          );
//            }
//        }

        } catch (Exception e) {
            try {
                this.socket.close();
                this.dataOut.close();
                this.dataIn.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }

    private String data() {
        String data;
        Database database=getDatabase();
        Restaurant restaurant=database.restaurants.get(0);
        data=restaurant.getName()+"&";
        data+=restaurant.getPassword()+"&";
        data+=restaurant.getPhoneNumber()+"&";
        data+=restaurant.getId()+"&";
        data+=restaurant.getComments()+"&";

//        data+=restaurant.getName()+"&";
//        data+=restaurant.getName()+"&";
//        data+=restaurant.getName()+"&";
//        data+=restaurant.getName()+"&";
//        data+=restaurant.getName()+"&";
//        data+=restaurant.getName()+"&";
//        data+=restaurant.getName()+"&";

        return data;
    }

}

class Server {
    Socket socket = null;
    ServerSocket serverSocket = null;
    DataInputStream dataIn = null;
    DataOutputStream dataOut = null;

    public Server(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        while (true) {
            socket = serverSocket.accept();
            Thread clientThread = new Thread(new ClientHandler(socket));
            clientThread.start();
        }
    }

}

class Main {
    public static void main(String[] args) throws IOException {

        Server server = new Server(8080);



    }
}

