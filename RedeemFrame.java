import java.awt.*;
import java.awt.event.*;
import java.time.LocalDateTime;
import javax.swing.*;
/*
 * Created by JFormDesigner on Fri Jan 10 17:53:40 EET 2020
 */



/**
 * @author unknown
 */
public class RedeemFrame extends JPanel {
    public RedeemFrame() {
        initComponents();
    }

    private void button1ActionPerformed(ActionEvent e) {
        int cid = Integer.parseInt(textField1.getText());
        int vid = Integer.parseInt(textField4.getText());

        Campaign c = VMS.getInstance().getCampaign(cid);
        c.redeemVoucher(vid, LocalDateTime.now());

        this.setVisible(false);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        label1 = new JLabel();
        textField1 = new JTextField();
        label4 = new JLabel();
        textField4 = new JTextField();
        button1 = new JButton();

        //======== this ========
        setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing
        .border.EmptyBorder(0,0,0,0), "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn",javax.swing.border.TitledBorder
        .CENTER,javax.swing.border.TitledBorder.BOTTOM,new java.awt.Font("Dia\u006cog",java.
        awt.Font.BOLD,12),java.awt.Color.red), getBorder()))
        ; addPropertyChangeListener(new java.beans.PropertyChangeListener(){@Override public void propertyChange(java.beans.PropertyChangeEvent e
        ){if("\u0062ord\u0065r".equals(e.getPropertyName()))throw new RuntimeException();}})
        ;
        setLayout(null);

        //---- label1 ----
        label1.setText("Campaign ID");
        add(label1);
        label1.setBounds(new Rectangle(new Point(30, 35), label1.getPreferredSize()));
        add(textField1);
        textField1.setBounds(125, 35, 85, textField1.getPreferredSize().height);

        //---- label4 ----
        label4.setText("Voucher ID");
        add(label4);
        label4.setBounds(30, 55, 71, label4.getPreferredSize().height);
        add(textField4);
        textField4.setBounds(125, 55, 85, textField4.getPreferredSize().height);

        //---- button1 ----
        button1.setText("OK");
        button1.addActionListener(e -> button1ActionPerformed(e));
        add(button1);
        button1.setBounds(new Rectangle(new Point(95, 140), button1.getPreferredSize()));

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
    private JLabel label4;
    private JTextField textField4;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
