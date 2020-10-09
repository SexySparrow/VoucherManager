import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
/*
 * Created by JFormDesigner on Fri Jan 10 17:20:59 EET 2020
 */



/**
 * @author unknown
 */
public class VaucherFrame extends JPanel {
    private VaucherFrame() {
        initComponents();
    }

    public static VaucherFrame vaucherFrame;
    public static VaucherFrame getInstance()
    {
        if(vaucherFrame == null)
            vaucherFrame = new VaucherFrame();
        return vaucherFrame;
    }

    private void button1ActionPerformed(ActionEvent e) {
        table1.setModel(new DefaultTableModel());
        String[] columns = { "Campanie","Email", "Cod", "Status"};
        String[][] data = new String[100][columns.length];
        int index = 0;
        for (Campaign c:VMS.getInstance().campaigns) {
            for (Voucher v:c.vouchers) {

                String s = "" + v.campaignID;
                data[index][0] = s;
                data[index][1] = v.email;
                data[index][2] = v.code;
                data[index][3] = v.voucherStatusType.toString();
                index++;
            }
        }
        DefaultTableModel model = new DefaultTableModel(data,columns);
        table1.setModel(model);
        table1.setAutoCreateRowSorter(true);
        table1.setUpdateSelectionOnSort(true);
    }

    private void button4ActionPerformed(ActionEvent e) {
        MeniuOptions.getInstance().setVisible(true);
        AppFrame.getInstance().add(MeniuOptions.getInstance());
        VaucherFrame.getInstance().setVisible(false);
        AppFrame.getInstance().remove(VaucherFrame.getInstance());
    }

    private void button2ActionPerformed(ActionEvent e) {
        JFrame frame = new JFrame();
        AdaugareVoucher adaugareVoucher = new AdaugareVoucher();
        adaugareVoucher.setVisible(true);
        frame.add(adaugareVoucher);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(300, 300);
    }

    private void button3ActionPerformed(ActionEvent e) {
        JFrame frame = new JFrame();
        RedeemFrame redeemFrame = new RedeemFrame();
        redeemFrame.setVisible(true);
        frame.add(redeemFrame);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(300, 300);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();

        //======== this ========
        setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new
        javax . swing. border .EmptyBorder ( 0, 0 ,0 , 0) ,  "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn" , javax
        . swing .border . TitledBorder. CENTER ,javax . swing. border .TitledBorder . BOTTOM, new java
        . awt .Font ( "Dia\u006cog", java .awt . Font. BOLD ,12 ) ,java . awt
        . Color .red ) , getBorder () ) );  addPropertyChangeListener( new java. beans .
        PropertyChangeListener ( ){ @Override public void propertyChange (java . beans. PropertyChangeEvent e) { if( "\u0062ord\u0065r" .
        equals ( e. getPropertyName () ) )throw new RuntimeException( ) ;} } );
        setLayout(null);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }
        add(scrollPane1);
        scrollPane1.setBounds(new Rectangle(new Point(5, 5), scrollPane1.getPreferredSize()));

        //---- button1 ----
        button1.setText("Afisare");
        button1.addActionListener(e -> button1ActionPerformed(e));
        add(button1);
        button1.setBounds(new Rectangle(new Point(500, 75), button1.getPreferredSize()));

        //---- button2 ----
        button2.setText("Adaugare");
        button2.addActionListener(e -> button2ActionPerformed(e));
        add(button2);
        button2.setBounds(new Rectangle(new Point(500, 100), button2.getPreferredSize()));

        //---- button3 ----
        button3.setText("Redeem");
        button3.addActionListener(e -> button3ActionPerformed(e));
        add(button3);
        button3.setBounds(new Rectangle(new Point(500, 125), button3.getPreferredSize()));

        //---- button4 ----
        button4.setText("Inapoi");
        button4.addActionListener(e -> button4ActionPerformed(e));
        add(button4);
        button4.setBounds(new Rectangle(new Point(500, 240), button4.getPreferredSize()));

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
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
