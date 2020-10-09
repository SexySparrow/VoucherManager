import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
/*
 * Created by JFormDesigner on Fri Jan 10 18:03:59 EET 2020
 */



/**
 * @author unknown
 */
public class CampaniFrameGuest extends JPanel {
    private CampaniFrameGuest() {
        initComponents();
    }
    public static CampaniFrameGuest campaniFrameGuest;
    public static CampaniFrameGuest getInstance(){
        if(campaniFrameGuest == null)
            campaniFrameGuest = new CampaniFrameGuest();
        return campaniFrameGuest;
    }

    private void button1ActionPerformed(ActionEvent e) {
        MeniuOptions.getInstance().setVisible(true);
        AppFrame.getInstance().add(MeniuOptions.getInstance());
        CampaniFrameGuest.getInstance().setVisible(false);
        AppFrame.getInstance().remove(CampaniFrameGuest.getInstance());
    }

    private void button2ActionPerformed(ActionEvent e) {
        table1.setModel(new DefaultTableModel());
        String[] columns = { "ID","Nume", "Start", "Stop", "Status"};
        String[][] data = new String[VMS.getInstance().current.vouchers.size()][columns.length];
        int index = 0;
        ArrayList<Campaign> campaigns = new ArrayList<>();
        for (Voucher v:VMS.getInstance().current.vouchers) {
            Campaign c = VMS.getInstance().getCampaign(v.campaignID);
            if(!campaigns.contains(c)) {
                String s = "" + c.ID;
                data[index][0] = s;
                data[index][1] = c.name;
                data[index][2] = c.start.toString();
                data[index][3] = c.finish.toString();
                data[index][4] = c.campaignStatusType.toString();
                index++;
                campaigns.add(c);
            }
        }
        DefaultTableModel model = new DefaultTableModel(data,columns);
        table1.setModel(model);
        table1.setAutoCreateRowSorter(true);
        table1.setUpdateSelectionOnSort(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        button1 = new JButton();
        button2 = new JButton();

        //======== this ========
        setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax
        .swing.border.EmptyBorder(0,0,0,0), "JF\u006frmDes\u0069gner \u0045valua\u0074ion",javax.swing
        .border.TitledBorder.CENTER,javax.swing.border.TitledBorder.BOTTOM,new java.awt.
        Font("D\u0069alog",java.awt.Font.BOLD,12),java.awt.Color.red
        ), getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){@Override
        public void propertyChange(java.beans.PropertyChangeEvent e){if("\u0062order".equals(e.getPropertyName(
        )))throw new RuntimeException();}});
        setLayout(null);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }
        add(scrollPane1);
        scrollPane1.setBounds(new Rectangle(new Point(10, 10), scrollPane1.getPreferredSize()));

        //---- button1 ----
        button1.setText("Inapoi");
        button1.addActionListener(e -> button1ActionPerformed(e));
        add(button1);
        button1.setBounds(new Rectangle(new Point(520, 140), button1.getPreferredSize()));

        //---- button2 ----
        button2.setText("Afisare");
        button2.addActionListener(e -> button2ActionPerformed(e));
        add(button2);
        button2.setBounds(new Rectangle(new Point(520, 110), button2.getPreferredSize()));

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
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
