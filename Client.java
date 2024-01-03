import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("127.0.0.1", 30121)) {
            ClientToMaster clientToMaster = new ClientToMaster(socket);
            clientToMaster.start();
            try {
                clientToMaster.join();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
