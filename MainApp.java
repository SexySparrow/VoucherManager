import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainApp {
    private JPanel panel1;
    private JButton button1;
    private JButton button2;
    private JButton button3;

    public MainApp() {
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                panel1.setVisible(false);
            }
        });
    }

    public static void main(String[] args) {
        MainApp mainApp = new MainApp();

    }
}
