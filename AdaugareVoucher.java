import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/*
 * Created by JFormDesigner on Fri Jan 10 17:36:37 EET 2020
 */



/**
 * @author unknown
 */
public class AdaugareVoucher extends JPanel {
    public AdaugareVoucher() {
        initComponents();
    }

    private void button1ActionPerformed(ActionEvent e) {
        int cid = Integer.parseInt(textField1.getText());
        String email = textField2.getText();
        String type = textField3.getText();
        float value = Float.parseFloat(textField4.getText());

        Campaign c = VMS.getInstance().getCampaign(cid);
        User u = VMS.getInstance().getUser(email);

        if (!c.containsObs(u)) {
            c.users.add(u);
        }
        c.generateVoucher(email, type, value);

        this.setVisible(false);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        label1 = new JLabel();
        textField1 = new JTextField();
        label2 = new JLabel();
        textField2 = new JTextField();
        label3 = new JLabel();
        textField3 = new JTextField();
        label4 = new JLabel();
        textField4 = new JTextField();
        button1 = new JButton();

        //======== this ========
        setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder
        (0,0,0,0), "JFor\u006dDesi\u0067ner \u0045valu\u0061tion",javax.swing.border.TitledBorder.CENTER,javax.swing.border
        .TitledBorder.BOTTOM,new java.awt.Font("Dia\u006cog",java.awt.Font.BOLD,12),java.awt
        .Color.red), getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){@Override public void
        propertyChange(java.beans.PropertyChangeEvent e){if("bord\u0065r".equals(e.getPropertyName()))throw new RuntimeException()
        ;}});
        setLayout(null);

        //---- label1 ----
        label1.setText("Campaign ID");
        add(label1);
        label1.setBounds(new Rectangle(new Point(50, 40), label1.getPreferredSize()));
        add(textField1);
        textField1.setBounds(145, 40, 85, textField1.getPreferredSize().height);

        //---- label2 ----
        label2.setText("User mail");
        add(label2);
        label2.setBounds(50, 60, 71, 16);
        add(textField2);
        textField2.setBounds(145, 60, 85, 20);

        //---- label3 ----
        label3.setText("Tip");
        add(label3);
        label3.setBounds(50, 80, 71, 16);
        add(textField3);
        textField3.setBounds(145, 80, 85, 20);

        //---- label4 ----
        label4.setText("Valoare");
        add(label4);
        label4.setBounds(50, 100, 71, 16);
        add(textField4);
        textField4.setBounds(145, 100, 85, 20);

        //---- button1 ----
        button1.setText("OK");
        button1.addActionListener(e -> button1ActionPerformed(e));
        add(button1);
        button1.setBounds(new Rectangle(new Point(115, 145), button1.getPreferredSize()));

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
    private JLabel label1;
    private JTextField textField1;
    private JLabel label2;
    private JTextField textField2;
    private JLabel label3;
    private JTextField textField3;
    private JLabel label4;
    private JTextField textField4;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
