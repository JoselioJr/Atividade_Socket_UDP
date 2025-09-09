import java.io.*;
import java.net.*;
import java.util.Random;

public class Sensor {
    public static void main(String[] args) {
        Random random = new Random();

        String nome;

        if (args.length > 0) {
            nome = args[0];
        } else {
            nome = "Sensor";
        }

        try (DatagramSocket socket = new DatagramSocket()) {
            InetAddress enderecoServidor = InetAddress.getByName("localhost");
            int porta = 12345;

            while (true) {
                double temperatura = 20 + random.nextDouble() * 10;
                int umidade = 40 + random.nextInt(30);

                String mensagem = nome + ": " + String.format("%.1f°C, %d%%RH", temperatura, umidade);

                byte[] dados = mensagem.getBytes();
                DatagramPacket pacote = new DatagramPacket(dados, dados.length, enderecoServidor, porta);
                socket.send(pacote);

                System.out.println("Enviado -> " + mensagem);

                Thread.sleep(1000);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
