import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/*
 * Created by JFormDesigner on Fri Jan 10 14:16:14 EET 2020
 */



/**
 * @author unknown
 */
public class MeniuOptions extends JPanel {
    private  static MeniuOptions meniuOptions;
    public static MeniuOptions getInstance(){
        if(meniuOptions == null)
            meniuOptions = new MeniuOptions();
        return meniuOptions;
    }
    private MeniuOptions() {
        initComponents();
    }

    private void button3ActionPerformed(ActionEvent e) {
        MeniuOptions.getInstance().setVisible(false);
        AppFrame.getInstance().remove(MeniuOptions.getInstance());
        Meniu.getInstance().setVisible(true);
        AppFrame.getInstance().add(Meniu.getInstance());
    }

    private void button1ActionPerformed(ActionEvent e) {
        MeniuOptions.getInstance().setVisible(false);
        AppFrame.getInstance().remove(MeniuOptions.getInstance());
        if (VMS.getInstance().level == 0){
            CampaniFrameGuest.getInstance().setVisible(true);
            AppFrame.getInstance().add(CampaniFrameGuest.getInstance());
        }
        else {
            CampaniFrame.getInstance().setVisible(true);
            AppFrame.getInstance().add(CampaniFrame.getInstance());
        }
    }

    private void button2ActionPerformed(ActionEvent e) {
        MeniuOptions.getInstance().setVisible(false);
        AppFrame.getInstance().remove(MeniuOptions.getInstance());
        if (VMS.getInstance().level == 0){
            VoucherFrameGuest.getInstance().setVisible(true);
            AppFrame.getInstance().add(VoucherFrameGuest.getInstance());
        }
        else {
            VaucherFrame.getInstance().setVisible(true);
            AppFrame.getInstance().add(VaucherFrame.getInstance());
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();

        //======== this ========
        setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax . swing
        . border .EmptyBorder ( 0, 0 ,0 , 0) ,  "JFor\u006dDesi\u0067ner \u0045valu\u0061tion" , javax. swing .border . TitledBorder
        . CENTER ,javax . swing. border .TitledBorder . BOTTOM, new java. awt .Font ( "Dia\u006cog", java .
        awt . Font. BOLD ,12 ) ,java . awt. Color .red ) , getBorder () ) )
        ;  addPropertyChangeListener( new java. beans .PropertyChangeListener ( ){ @Override public void propertyChange (java . beans. PropertyChangeEvent e
        ) { if( "bord\u0065r" .equals ( e. getPropertyName () ) )throw new RuntimeException( ) ;} } )
        ;
        setLayout(null);

        //---- button1 ----
        button1.setText("Campanii");
        button1.addActionListener(e -> button1ActionPerformed(e));
        add(button1);
        button1.setBounds(new Rectangle(new Point(160, 80), button1.getPreferredSize()));

        //---- button2 ----
        button2.setText("Vouchere");
        button2.addActionListener(e -> button2ActionPerformed(e));
        add(button2);
        button2.setBounds(new Rectangle(new Point(160, 120), button2.getPreferredSize()));

        //---- button3 ----
        button3.setText("Delogare");
        button3.addActionListener(e -> button3ActionPerformed(e));
        add(button3);
        button3.setBounds(new Rectangle(new Point(160, 220), button3.getPreferredSize()));

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
    private JButton button1;
    private JButton button2;
    private JButton button3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
