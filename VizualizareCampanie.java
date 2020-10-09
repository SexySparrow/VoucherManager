import java.awt.*;
import javax.swing.*;
/*
 * Created by JFormDesigner on Fri Jan 10 16:47:26 EET 2020
 */



/**
 * @author unknown
 */
public class VizualizareCampanie extends JPanel {
    public VizualizareCampanie(Campaign campaign) {
        initComponents();
        label1.setText(campaign.name);
        label2.setText(campaign.description);
        label3.setText(campaign.start.toString());
        label4.setText(campaign.finish.toString());
        label5.setText(campaign.totalVoucherCount + "");
        label6.setText(campaign.strategy);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();
        label7 = new JLabel();
        label8 = new JLabel();
        label9 = new JLabel();
        label10 = new JLabel();
        label11 = new JLabel();
        label12 = new JLabel();

        //======== this ========
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border. EmptyBorder(
        0, 0, 0, 0) , "JF\u006frmDes\u0069gner \u0045valua\u0074ion", javax. swing. border. TitledBorder. CENTER, javax. swing. border. TitledBorder
        . BOTTOM, new java .awt .Font ("D\u0069alog" ,java .awt .Font .BOLD ,12 ), java. awt. Color.
        red) , getBorder( )) );  addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .
        beans .PropertyChangeEvent e) {if ("\u0062order" .equals (e .getPropertyName () )) throw new RuntimeException( ); }} );
        setLayout(null);

        //---- label1 ----
        label1.setText("Nume");
        add(label1);
        label1.setBounds(175, 75, 165, label1.getPreferredSize().height);

        //---- label2 ----
        label2.setText("Descriere");
        add(label2);
        label2.setBounds(175, 95, 170, label2.getPreferredSize().height);

        //---- label3 ----
        label3.setText("Start");
        add(label3);
        label3.setBounds(175, 115, 175, label3.getPreferredSize().height);

        //---- label4 ----
        label4.setText("End");
        add(label4);
        label4.setBounds(175, 135, 170, label4.getPreferredSize().height);

        //---- label5 ----
        label5.setText("Buget");
        add(label5);
        label5.setBounds(new Rectangle(new Point(175, 160), label5.getPreferredSize()));

        //---- label6 ----
        label6.setText("Strategy");
        add(label6);
        label6.setBounds(new Rectangle(new Point(175, 185), label6.getPreferredSize()));

        //---- label7 ----
        label7.setText("Nume");
        add(label7);
        label7.setBounds(new Rectangle(new Point(40, 75), label7.getPreferredSize()));

        //---- label8 ----
        label8.setText("Descriere");
        add(label8);
        label8.setBounds(new Rectangle(new Point(40, 95), label8.getPreferredSize()));

        //---- label9 ----
        label9.setText("Start");
        add(label9);
        label9.setBounds(new Rectangle(new Point(40, 115), label9.getPreferredSize()));

        //---- label10 ----
        label10.setText("End");
        add(label10);
        label10.setBounds(new Rectangle(new Point(40, 135), label10.getPreferredSize()));

        //---- label11 ----
        label11.setText("Buget");
        add(label11);
        label11.setBounds(new Rectangle(new Point(40, 160), label11.getPreferredSize()));

        //---- label12 ----
        label12.setText("Strategy");
        add(label12);
        label12.setBounds(new Rectangle(new Point(40, 185), label12.getPreferredSize()));

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
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JLabel label8;
    private JLabel label9;
    private JLabel label10;
    private JLabel label11;
    private JLabel label12;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
