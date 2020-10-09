import java.awt.*;
import java.awt.event.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.*;
/*
 * Created by JFormDesigner on Fri Jan 10 17:10:19 EET 2020
 */



/**
 * @author unknown
 */
public class EditareCampanie extends JPanel {
    public EditareCampanie() {
        initComponents();
    }

    private void button1ActionPerformed(ActionEvent e) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String name = textField1.getText();
        String desc = textField2.getText();
        LocalDateTime start = LocalDateTime.parse(textField3.getText(),formatter);
        LocalDateTime end = LocalDateTime.parse(textField4.getText(),formatter);
        int buget = Integer.parseInt(textField5.getText());
        int ID = Integer.parseInt(textField7.getText());
        Campaign c = new Campaign(ID,name,desc,start,end,"A",buget,LocalDateTime.now());
        VMS.getInstance().updateCampaign(ID,c,LocalDateTime.now());

        this.setVisible(false);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        label7 = new JLabel();
        label8 = new JLabel();
        label9 = new JLabel();
        label10 = new JLabel();
        label11 = new JLabel();
        textField1 = new JTextField();
        textField2 = new JTextField();
        textField3 = new JTextField();
        textField4 = new JTextField();
        textField5 = new JTextField();
        label1 = new JLabel();
        textField7 = new JTextField();
        button1 = new JButton();

        //======== this ========
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing.
        border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn", javax. swing. border. TitledBorder. CENTER
        , javax. swing. border. TitledBorder. BOTTOM, new java .awt .Font ("Dia\u006cog" ,java .awt .Font
        .BOLD ,12 ), java. awt. Color. red) , getBorder( )) );  addPropertyChangeListener (
        new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("\u0062ord\u0065r"
        .equals (e .getPropertyName () )) throw new RuntimeException( ); }} );
        setLayout(null);

        //---- label7 ----
        label7.setText("Nume");
        add(label7);
        label7.setBounds(new Rectangle(new Point(35, 65), label7.getPreferredSize()));

        //---- label8 ----
        label8.setText("Descriere");
        add(label8);
        label8.setBounds(new Rectangle(new Point(35, 85), label8.getPreferredSize()));

        //---- label9 ----
        label9.setText("Start");
        add(label9);
        label9.setBounds(new Rectangle(new Point(35, 105), label9.getPreferredSize()));

        //---- label10 ----
        label10.setText("End");
        add(label10);
        label10.setBounds(new Rectangle(new Point(35, 125), label10.getPreferredSize()));

        //---- label11 ----
        label11.setText("Buget");
        add(label11);
        label11.setBounds(new Rectangle(new Point(35, 145), label11.getPreferredSize()));
        add(textField1);
        textField1.setBounds(110, 65, 90, textField1.getPreferredSize().height);
        add(textField2);
        textField2.setBounds(110, 85, 90, textField2.getPreferredSize().height);
        add(textField3);
        textField3.setBounds(110, 105, 90, textField3.getPreferredSize().height);
        add(textField4);
        textField4.setBounds(110, 125, 90, textField4.getPreferredSize().height);
        add(textField5);
        textField5.setBounds(110, 145, 90, textField5.getPreferredSize().height);

        //---- label1 ----
        label1.setText("ID");
        add(label1);
        label1.setBounds(new Rectangle(new Point(35, 40), label1.getPreferredSize()));
        add(textField7);
        textField7.setBounds(110, 35, 90, textField7.getPreferredSize().height);

        //---- button1 ----
        button1.setText("OK");
        button1.addActionListener(e -> button1ActionPerformed(e));
        add(button1);
        button1.setBounds(new Rectangle(new Point(85, 210), button1.getPreferredSize()));

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
    private JLabel label7;
    private JLabel label8;
    private JLabel label9;
    private JLabel label10;
    private JLabel label11;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JLabel label1;
    private JTextField textField7;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
