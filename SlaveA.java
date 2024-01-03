import java.io.*;
import java.net.*;
import java.util.*;

public class SlaveA {
    static String DONE_MESSAGE = "DONE";
    static String MORE_MESSAGE = "Client needs more packages";
    static String HAS_ALL_P = "Client has all packages";

    public static void main(String[] args) throws IOException {
        try (Socket socketSlaveA = new Socket("127.0.0.1", 30122);
             BufferedReader inputA = new BufferedReader(new InputStreamReader(socketSlaveA.getInputStream()));
             PrintWriter outputA = new PrintWriter(socketSlaveA.getOutputStream(), true)) {

            while (true) {
                System.out.println("SlaveA is running");
            }
            /*
            ArrayList<String> receivedJobList = new ArrayList<>();

            // Receive packets until DONE is received
            String slavAJobs;
            slavAJobs = inputA.readLine();
            System.out.println("Received: " + slavAJobs);

            while (!(slavAJobs = inputA.readLine()).equals("SlaveA")) {
                receivedJobList.add(slavAJobs);
                System.out.println("Received: " + slavAJobs);
            }

            //int properNumberOfPackets = Integer.parseInt(receivedJobList.get(0).split(",")[1]);


            // Sort packets based on sequence number
            Collections.sort(receivedJobList, (s1, s2) -> {
                int one = Integer.parseInt(s1.split(",")[0]);
                int two = Integer.parseInt(s2.split(",")[0]);
                return Integer.compare(one, two);
            });

            boolean done = false;
            /*while (!done) {
                // make a boolean array to check which packets the client got and what its missing
                boolean[] tracker = new boolean[properNumberOfPackets];
                // figure out which packets it is missing
                for (String packet : receivedJobList) {
                    int index = Integer.parseInt(packet.split(",")[0]);
                    tracker[index] = true;
                }
                // figure out which packets we don't have
                StringBuilder missingPackets = new StringBuilder();
                for (int i = 0; i < tracker.length; i++) {
                    if (!tracker[i]) {
                        missingPackets.append(i + ",");
                    }
                }
                if (!missingPackets.isEmpty()) {
                    missingPackets.deleteCharAt(missingPackets.length() - 1);
                    // sending the missing packets to the server
                    output.println(MORE_MESSAGE);
                    output.println(missingPackets);
                    // needs to get the missing packets
                    while (!(receivedPacket = input.readLine()).equals(DONE_MESSAGE)) {
                        receivedJobList.add(receivedPacket);
                        System.out.println("Received: " + receivedPacket);
                    }
                    // Sort packets based on sequence number
                    Collections.sort(receivedJobList, (s1, s2) -> {
                        int one = Integer.parseInt(s1.split(",")[0]);
                        int two = Integer.parseInt(s2.split(",")[0]);
                        return Integer.compare(one, two);
                    });
                } else {
                    output.println(HAS_ALL_P);
                    done = true;
                }
            }*/

            // Get the data from the packets
           /* StringBuilder finishedMessage = new StringBuilder();
            for (String packet : receivedJobList) {
                finishedMessage.append(packet.split(",")[2]);
            }
            // Display the finished message :)
            System.out.println("Message: " + finishedMessage.toString());*/
        }
    }
}