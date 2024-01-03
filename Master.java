import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Master {
    public static void main(String[] args) {
        ArrayList<String> jobs = new ArrayList<>();
        Object JOBS_LOCK = new Object();
        try (ServerSocket serverSocket = new ServerSocket(30121)) {
            Socket clientSocket = serverSocket.accept();
            MasterFromClient masterFromClient = new MasterFromClient(clientSocket, jobs, JOBS_LOCK);
            masterFromClient.start();
            try {
                masterFromClient.join();
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
