import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.*;

public class Test {
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(88);
        Socket socket = serverSocket.accept();
        System.out.println("Connect client");

        DataInputStream dataIn = new DataInputStream(socket.getInputStream());
        DataOutputStream dataOut = new DataOutputStream(socket.getOutputStream());

        String numbers = "";

        for (int i = 0; i < 500 ; i++) {
            numbers += " "+i+" ";
        }

        dataOut.writeBytes(numbers);

    }
}
