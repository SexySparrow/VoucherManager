import java.awt.*;
import java.awt.event.*;
import java.time.LocalDateTime;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
/*
 * Created by JFormDesigner on Fri Jan 10 14:52:46 EET 2020
 */



/**
 * @author unknown
 */
public class CampaniFrame extends JPanel {
    private CampaniFrame() {
        initComponents();
    }

    private static CampaniFrame campaniFrame;
    public static CampaniFrame getInstance(){
        if(campaniFrame == null)
            campaniFrame = new CampaniFrame();
        return campaniFrame;
    }

    private void button6ActionPerformed(ActionEvent e) {
        MeniuOptions.getInstance().setVisible(true);
        AppFrame.getInstance().add(MeniuOptions.getInstance());
        CampaniFrame.getInstance().setVisible(false);
        AppFrame.getInstance().remove(CampaniFrame.getInstance());
    }

    private void button2ActionPerformed(ActionEvent e) {
        table1.setModel(new DefaultTableModel());
        String[] columns = { "ID","Nume", "Start", "Stop", "Status"};
        String[][] data = new String[VMS.getInstance().campaigns.size()][columns.length];
        int index = 0;
        for (Campaign c:VMS.getInstance().campaigns) {
            String s = "" + c.ID;
            data[index][0] = s;
            data[index][1] = c.name;
            data[index][2] = c.start.toString();
            data[index][3] = c.finish.toString();
            data[index][4] = c.campaignStatusType.toString();
            index++;
        }
        DefaultTableModel model = new DefaultTableModel(data,columns);
        table1.setModel(model);
        table1.setAutoCreateRowSorter(true);
        table1.setUpdateSelectionOnSort(true);
    }

    private void button4ActionPerformed(ActionEvent e) {
        int id = table1.getSelectedRow();
        id++;
        String ID = (String)table1.getValueAt(id- 1,0);
        id = Integer.parseInt(ID);
        VMS.getInstance().cancelCampaign(id, LocalDateTime.now());
    }

    private void button5ActionPerformed(ActionEvent e) {
        int id = table1.getSelectedRow();
        id++;
        String ID = (String)table1.getValueAt(id- 1,0);
        id = Integer.parseInt(ID);

        Campaign data = VMS.getInstance().getCampaign(id);
        JFrame frame = new JFrame();
        VizualizareCampanie vizualizareCampanie = new VizualizareCampanie(data);
        vizualizareCampanie.setVisible(true);
        frame.add(vizualizareCampanie);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(300, 300);
    }

    private void button1ActionPerformed(ActionEvent e) {
        JFrame frame = new JFrame();
        AdaugareCampanie adaugareCampanie = new AdaugareCampanie();
        adaugareCampanie.setVisible(true);
        frame.add(adaugareCampanie);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(300, 300);
    }

    private void button3ActionPerformed(ActionEvent e) {
        JFrame frame = new JFrame();
        EditareCampanie editareCampanie = new EditareCampanie();
        editareCampanie.setVisible(true);
        frame.add(editareCampanie);
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
        button5 = new JButton();
        button6 = new JButton();

        //======== this ========
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax
        . swing. border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frmDes\u0069gner \u0045valua\u0074ion", javax. swing
        . border. TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM, new java .awt .
        Font ("D\u0069alog" ,java .awt .Font .BOLD ,12 ), java. awt. Color. red
        ) , getBorder( )) );  addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override
        public void propertyChange (java .beans .PropertyChangeEvent e) {if ("\u0062order" .equals (e .getPropertyName (
        ) )) throw new RuntimeException( ); }} );
        setLayout(null);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }
        add(scrollPane1);
        scrollPane1.setBounds(new Rectangle(new Point(5, 10), scrollPane1.getPreferredSize()));

        //---- button1 ----
        button1.setText("Adaugare");
        button1.addActionListener(e -> button1ActionPerformed(e));
        add(button1);
        button1.setBounds(new Rectangle(new Point(505, 80), button1.getPreferredSize()));

        //---- button2 ----
        button2.setText("Afisare");
        button2.addActionListener(e -> button2ActionPerformed(e));
        add(button2);
        button2.setBounds(new Rectangle(new Point(505, 55), button2.getPreferredSize()));

        //---- button3 ----
        button3.setText("Editare");
        button3.addActionListener(e -> button3ActionPerformed(e));
        add(button3);
        button3.setBounds(new Rectangle(new Point(505, 105), button3.getPreferredSize()));

        //---- button4 ----
        button4.setText("Inchidere");
        button4.addActionListener(e -> button4ActionPerformed(e));
        add(button4);
        button4.setBounds(new Rectangle(new Point(505, 130), button4.getPreferredSize()));

        //---- button5 ----
        button5.setText("Vizualizare");
        button5.addActionListener(e -> button5ActionPerformed(e));
        add(button5);
        button5.setBounds(new Rectangle(new Point(505, 155), button5.getPreferredSize()));

        //---- button6 ----
        button6.setText("Inapoi");
        button6.addActionListener(e -> button6ActionPerformed(e));
        add(button6);
        button6.setBounds(new Rectangle(new Point(505, 225), button6.getPreferredSize()));

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
    private JButton button5;
    private JButton button6;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
