
package cadastroclientv2;

import java.io.ObjectInputStream;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;


public class ThreadClient extends Thread {
    private  ObjectInputStream in;
    private final JTextArea textArea;

    public ThreadClient(ObjectInputStream in, JTextArea textArea) {
        this.in = in;
        this.textArea = textArea;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Object data = in.readObject();
                String mensagem = (String) data;
                SwingUtilities.invokeLater(() -> {
                textArea.append( mensagem + "\n");
                textArea.setCaretPosition(textArea.getDocument().getLength()); // Rolagem automática
                });   
            }
        } catch (Exception e) {
            // Lidar com exceções, se necessário
        }
    }
}
