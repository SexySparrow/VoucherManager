import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
/*
 * Created by JFormDesigner on Fri Jan 10 18:26:01 EET 2020
 */



/**
 * @author unknown
 */
public class VoucherFrameGuest extends JPanel {
    private VoucherFrameGuest() {
        initComponents();
    }
    public static VoucherFrameGuest voucherFrameGuest;
    public static VoucherFrameGuest getInstance()
    {
        if(voucherFrameGuest == null)
            voucherFrameGuest = new VoucherFrameGuest();
        return voucherFrameGuest;
    }

    private void button1ActionPerformed(ActionEvent e) {
        MeniuOptions.getInstance().setVisible(true);
        AppFrame.getInstance().add(MeniuOptions.getInstance());
        VoucherFrameGuest.getInstance().setVisible(false);
        AppFrame.getInstance().remove(VoucherFrameGuest.getInstance());
    }

    private void button2ActionPerformed(ActionEvent e) {
        table1.setModel(new DefaultTableModel());
        String[] columns = { "Campanie","Email", "Cod", "Status"};
        String[][] data = new String[100][columns.length];
        int index = 0;
        for (Voucher v:VMS.getInstance().current.vouchers) {

                String s = "" + v.campaignID;
                data[index][0] = s;
                data[index][1] = v.email;
                data[index][2] = v.code;
                data[index][3] = v.voucherStatusType.toString();
                index++;
        }
        DefaultTableModel model = new DefaultTableModel(data,columns);
        table1.setModel(model);
        table1.setAutoCreateRowSorter(true);
        table1.setUpdateSelectionOnSort(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        button2 = new JButton();
        button1 = new JButton();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();

        //======== this ========
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border
        . EmptyBorder( 0, 0, 0, 0) , "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn", javax. swing. border. TitledBorder. CENTER, javax
        . swing. border. TitledBorder. BOTTOM, new java .awt .Font ("Dia\u006cog" ,java .awt .Font .BOLD ,
        12 ), java. awt. Color. red) , getBorder( )) );  addPropertyChangeListener (new java. beans
        . PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("\u0062ord\u0065r" .equals (e .
        getPropertyName () )) throw new RuntimeException( ); }} );
        setLayout(null);

        //---- button2 ----
        button2.setText("Afisare");
        button2.addActionListener(e -> button2ActionPerformed(e));
        add(button2);
        button2.setBounds(new Rectangle(new Point(515, 90), button2.getPreferredSize()));

        //---- button1 ----
        button1.setText("Inapoi");
        button1.addActionListener(e -> button1ActionPerformed(e));
        add(button1);
        button1.setBounds(new Rectangle(new Point(515, 120), button1.getPreferredSize()));

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }
        add(scrollPane1);
        scrollPane1.setBounds(new Rectangle(new Point(10, 10), scrollPane1.getPreferredSize()));

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
    private JButton button2;
    private JButton button1;
    private JScrollPane scrollPane1;
    private JTable table1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
