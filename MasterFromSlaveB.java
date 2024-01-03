import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;

public class MasterFromSlaveB extends Thread {
    private Socket socket;
    private ArrayList<String> jobs;
    private final Object JOBS_LOCK;

    public MasterFromSlaveB(Socket socket, ArrayList<String> jobs, Object JOBS_LOCK) {
        this.socket = socket;
        this.jobs = jobs;
        this.JOBS_LOCK = JOBS_LOCK;
    }

    @Override
    public void run() {
        try (BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
