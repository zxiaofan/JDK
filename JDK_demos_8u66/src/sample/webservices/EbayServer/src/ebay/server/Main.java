package sample.webservices.EbayServer.src.ebay.server;

import javax.xml.ws.Endpoint;

public class Main {

    /** Creates a new instance of Main */
    public Main() {
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Starting endpoint with address http://localhost:7070/Ebay");
        Endpoint.publish("http://localhost:7070/Ebay", new Ebay());
        Endpoint.publish("http://localhost:7070/ImageProvider", new ImageProvider());
    }
}
