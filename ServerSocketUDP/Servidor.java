import java.io.*;
import java.net.*;
import java.util.*;

public class Servidor {
    public static void main(String[] args) {
        Map<String, String> dados = new HashMap<>();

        try (DatagramSocket servidor = new DatagramSocket(12345)) {
            System.out.println("Servidor aguardando leituras...");

            byte[] buffer = new byte[1024];
            DatagramPacket pacote = new DatagramPacket(buffer, buffer.length);

            while (true) {
                servidor.receive(pacote);
                String mensagem = new String(pacote.getData(), 0, pacote.getLength());

                String[] partes = mensagem.split(":", 2);
                if (partes.length == 2) {
                    String sensor = partes[0].trim();
                    String leitura = partes[1].trim();
                    dados.put(sensor, leitura);
                }

                System.out.println("\nÚltimas leituras:");
                for (Map.Entry<String, String> entrada : dados.entrySet()) {
                    System.out.println(entrada.getKey() + " -> " + entrada.getValue());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
