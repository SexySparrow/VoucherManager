import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import net.miginfocom.swing.*;
/*
 * Created by JFormDesigner on Fri Jan 10 12:56:42 EET 2020
 */



/**
 * @author unknown
 */
public class Meniu extends JPanel {
    private Meniu() {
        initComponents();
        button1.setEnabled(false);
    }
    private static Meniu meniu;
    public static Meniu getInstance(){
        if(meniu == null)
            meniu = new Meniu();
        return meniu;
    }



    private void button1ActionPerformed(ActionEvent e) {
        String name = textField1.getText();
        String pass = String.valueOf(passwordField1.getPassword());
        User u = VMS.getInstance().getUserbyName(name);
        if(u != null)
        {
            if (u.password.equals(pass)){
                label4.setText("Yes");
                Meniu.getInstance().setVisible(false);
                MeniuOptions.getInstance().setVisible(true);
                AppFrame.getInstance().add(MeniuOptions.getInstance());
                AppFrame.getInstance().remove(Meniu.getInstance());
                VMS.getInstance().current = u;
                if(u.userType == User.UserType.ADMIN)
                    VMS.getInstance().level = 1;
                else
                    VMS.getInstance().level = 0;
            }
            else
                label4.setText("Nume/parola gresita");
        }
            else
                label4.setText("Mailul nu exitsa");
    }

    private void button2ActionPerformed(ActionEvent e) {
            String CampaignData = Test.readFileAsString("src\\campaigns.txt");
            String UsersData = Test.readFileAsString("src\\users.txt");
            System.out.println(UsersData);
            VMS.getInstance().addData(CampaignData,UsersData);
            label4.setText("Fisiere incarcate cu success");
            label5.setText("Status Fisier: Incarcat");
            button2.setEnabled(false);
            button1.setEnabled(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        label3 = new JLabel();
        label1 = new JLabel();
        textField1 = new JTextField();
        button1 = new JButton();
        label2 = new JLabel();
        button2 = new JButton();
        label4 = new JLabel();
        label5 = new JLabel();
        passwordField1 = new JPasswordField();

        //======== this ========
        setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing.border
        .EmptyBorder(0,0,0,0), "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn",javax.swing.border.TitledBorder.CENTER,javax
        .swing.border.TitledBorder.BOTTOM,new java.awt.Font("Dia\u006cog",java.awt.Font.BOLD,
        12),java.awt.Color.red), getBorder())); addPropertyChangeListener(new java.beans
        .PropertyChangeListener(){@Override public void propertyChange(java.beans.PropertyChangeEvent e){if("\u0062ord\u0065r".equals(e.
        getPropertyName()))throw new RuntimeException();}});
        setLayout(null);

        //---- label3 ----
        label3.setText("Voucher Management System");
        add(label3);
        label3.setBounds(115, 35, label3.getPreferredSize().width, 40);

        //---- label1 ----
        label1.setText("Username:");
        add(label1);
        label1.setBounds(new Rectangle(new Point(25, 103), label1.getPreferredSize()));
        add(textField1);
        textField1.setBounds(115, 100, 170, textField1.getPreferredSize().height);

        //---- button1 ----
        button1.setText("Login");
        button1.addActionListener(e -> button1ActionPerformed(e));
        add(button1);
        button1.setBounds(305, 115, 89, button1.getPreferredSize().height);

        //---- label2 ----
        label2.setText("Password:");
        add(label2);
        label2.setBounds(25, 138, 100, label2.getPreferredSize().height);

        //---- button2 ----
        button2.setText("Incarca fisiere");
        button2.addActionListener(e -> button2ActionPerformed(e));
        add(button2);
        button2.setBounds(new Rectangle(new Point(105, 200), button2.getPreferredSize()));

        //---- label4 ----
        label4.setText("Mesaj");
        add(label4);
        label4.setBounds(30, 170, 280, 25);

        //---- label5 ----
        label5.setText("Status fisier: ----");
        add(label5);
        label5.setBounds(155, 65, 165, label5.getPreferredSize().height);
        add(passwordField1);
        passwordField1.setBounds(115, 135, 170, passwordField1.getPreferredSize().height);

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < getComponentCount(); i++) {
                Rectangle bounds = getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            setMinimumSize(preferredSize);
            setPreferredSize(preferredSize);
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JLabel label3;
    private JLabel label1;
    private JTextField textField1;
    private JButton button1;
    private JLabel label2;
    private JButton button2;
    private JLabel label4;
    private JLabel label5;
    private JPasswordField passwordField1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}