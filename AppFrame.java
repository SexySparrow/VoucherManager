import javax.swing.*;
import java.awt.*;

public class AppFrame extends JFrame {
   private static JFrame theframe;

    public static JFrame getInstance(){
        if(theframe == null)
            theframe = new JFrame();
        return theframe;
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel ("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                AppFrame.getInstance().add(Meniu.getInstance());
                AppFrame.getInstance().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                AppFrame.getInstance().setVisible(true);
                AppFrame.getInstance().setSize(750, 500);
            }
        });
    }

}
