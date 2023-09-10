import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketClient {
    public static void main(String[] args) {
        String serverOutlook = "SMTP.office365.com";
        int portSMTP = 587 ;

        try (Socket socket = new Socket(serverOutlook, portSMTP)) {
            System.out.println("------------- Criando conexão com servidor outlook -----------------");
            System.out.println();

            InputStream input = socket.getInputStream();
            OutputStream output = socket.getOutputStream();

            PrintWriter writer = new PrintWriter(output, true);
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));


            String line = reader.readLine();
            System.out.println("------------- Servidor SMTP está pronto para continuar com sucesso -----------------");
            System.out.println(line);
            System.out.println();

            writer.println("helo");
            line = reader.readLine();
            System.out.println("------------- Ação de e-mail solicitada correta, concluída -----------------");
            System.out.println(line);
            System.out.println();

            writer.println("quit");
            line = reader.readLine();
            System.out.println("------------- Servidor SMTP fechando canal de transmissão-----------------");
            System.out.println(line);
            System.out.println();


        } catch (UnknownHostException exp) {
            System.out.println("O Servidor não foi encontrado: " + exp.getMessage());

        } catch (IOException exp) {
            System.out.println("Error: " + exp.getMessage());
        }
    }
}


