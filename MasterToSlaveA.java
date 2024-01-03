import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class MasterToSlaveA extends Thread {
    private Socket socket;

    public MasterToSlaveA(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

