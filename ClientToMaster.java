import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;

public class ClientToMaster extends Thread {
    private Socket socket;

    public ClientToMaster(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (PrintWriter output = new PrintWriter(socket.getOutputStream(), true)) {
            ArrayList<Integer> jobList = new ArrayList<>();

            for (int i = 0; i <= 15; i++) // need to find out how many jobs are sent
            {
                Random random = new Random();
                int jobType = random.nextInt(0, 2);
                jobList.add(jobType);
            }
            for (int i : jobList) {
                output.println(i);
                System.out.println("Sent: " + i);
            }
            output.println("-1");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
