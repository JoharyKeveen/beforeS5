/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package windows;

import connection.Connex;
import java.util.Vector;
import table.Produit;
import java.sql.*;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import listener.Alistener;

/**
 *
 * @author Achyl
 */
public class Client extends javax.swing.JFrame {

    public Client(String[][] args) {
        initComponents(args);
    }

    void initComponents(String[][] args) {
        String[] entete={"id","nom","prix"};
        title = new javax.swing.JLabel();
        area1 = new javax.swing.JComboBox<>();
        area2 = new javax.swing.JTextField();
        legend1 = new javax.swing.JLabel();
        legend2 = new javax.swing.JLabel();
        legend3 = new javax.swing.JLabel();
        area3 = new javax.swing.JTextField();
        buttAcheter = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableProd = new JTable(args,entete);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        title.setFont(new java.awt.Font("Segoe UI Black", 3, 36)); // NOI18N
        title.setForeground(new java.awt.Color(200, 16, 16));
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("Client Star");

        area1.setModel(new DefaultComboBoxModel<>(new String[] { "Antananarivo", "Fianarantsoa","Mahajanga", "Toliara", "Antsiranana" }));

        legend1.setText("Province :");

        legend2.setText("Id produit :");

        legend3.setText("Nombre :");

        buttAcheter.setText("Acheter");
        buttAcheter.setFocusable(false);
        buttAcheter.addActionListener(new Alistener(this));

        tableProd.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tableProd.setDragEnabled(true);
        tableProd.setFocusable(false);
        tableProd.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tableProd);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(124, 124, 124))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(legend3, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(area3, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(legend2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(area2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(legend1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(area1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(11, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(buttAcheter, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(area1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(legend1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(legend2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(area2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(area3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(legend3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(buttAcheter, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );

        pack();
    }
    public static void main(String args[]) 
    {
        Connex co=new Connex();
        Connection lo=co.log();
        try{
            Vector<Produit> listProd=new Produit().get_Tab(new Produit().select(lo));
            String[][] list=new String[listProd.size()][3];
            for(int i=0;i<list.length;i++)
            {
                list[i][0]=listProd.get(i).getId();
                list[i][1]=listProd.get(i).getNom();
                list[i][2]=listProd.get(i).getPrix().toString();
            }
            new Client(list).setVisible(true);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> area1;
    private javax.swing.JTextField area2;
    private javax.swing.JTextField area3;
    private javax.swing.JButton buttAcheter;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel legend1;
    private javax.swing.JLabel legend2;
    private javax.swing.JLabel legend3;
    private javax.swing.JTable tableProd;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables

    public JComboBox<String> getArea1() {
        return area1;
    }

    public void setArea1(JComboBox<String> area1) {
        this.area1 = area1;
    }

    public JTextField getArea2() {
        return area2;
    }

    public void setArea2(JTextField area2) {
        this.area2 = area2;
    }

    public JTextField getArea3() {
        return area3;
    }

    public void setArea3(JTextField area3) {
        this.area3 = area3;
    }

    public JButton getButtAcheter() {
        return buttAcheter;
    }

    public void setButtAcheter(JButton buttAcheter) {
        this.buttAcheter = buttAcheter;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public JLabel getLegend1() {
        return legend1;
    }

    public void setLegend1(JLabel legend1) {
        this.legend1 = legend1;
    }

    public JLabel getLegend2() {
        return legend2;
    }

    public void setLegend2(JLabel legend2) {
        this.legend2 = legend2;
    }

    public JLabel getLegend3() {
        return legend3;
    }

    public void setLegend3(JLabel legend3) {
        this.legend3 = legend3;
    }

    public JTable getTableProd() {
        return tableProd;
    }

    public void setTableProd(JTable tableProd) {
        this.tableProd = tableProd;
    }

    public JLabel getTitlee() {
        return title;
    }

    public void setTitle(JLabel title) {
        this.title = title;
    }
}
