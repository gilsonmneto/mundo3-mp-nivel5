
package cadastroclient;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import model.Produtos;


public class CadastroClient {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     * @throws java.lang.ClassNotFoundException
     */
    public static void main(String[] args)throws IOException, ClassNotFoundException {
        try (Socket socket = new Socket("localhost", 4321);
             ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
             ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {
                        
            out.writeObject("op1"); 
            out.writeObject("op1"); 
            out.writeObject("L"); 


            List<Produtos> produtos = (List<Produtos>) in.readObject();
            for (Produtos produto : produtos) {
                System.out.println(produto.getNome());
            }
        }
    }   
}
