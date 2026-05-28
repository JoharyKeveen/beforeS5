/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package windows;
import javax.swing.*;
import connection.Connex;
import java.sql.*;
import java.util.*;
import listener.Alistener;
import table.Produit;

/**
 *
 * @author Achyl
 */
public class Serveur extends JFrame {

    public Serveur(String[][] args) {
        initComponents(args);
    }

    void initComponents(String[][] args) {
        String[] entete={"id","nom","prix"};
        title = new JLabel();
        area1 = new JComboBox<>();
        area2 = new JTextField();
        legend1 = new JLabel();
        legend2 = new JLabel();
        legend3 = new JLabel();
        area3 = new JTextField();
        buttFabriquation = new JButton();
        jScrollPane1 = new JScrollPane();
        tableProd = new JTable(args,entete);
        buttStock = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Serveur");

        title.setFont(new java.awt.Font("Segoe UI Black", 3, 36)); // NOI18N
        title.setForeground(new java.awt.Color(200, 16, 16));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setText("Serveur Star");

        area1.setModel(new DefaultComboBoxModel<>(new String[] { "Antananarivo", "Fianarantsoa","Mahajanga", "Toliara", "Antsiranana" }));

        legend1.setText("Province :");

        legend2.setText("Id produit :");

        legend3.setText("Nombre :");

        buttFabriquation.setText("Fabriquer");
        buttFabriquation.setFocusable(false);
        buttFabriquation.addActionListener(new Alistener(this));


        tableProd.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tableProd.setDragEnabled(true);
        tableProd.setFocusable(false);
        tableProd.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tableProd);


        buttStock.setFont(new java.awt.Font("Caladea", 3, 18)); // NOI18N
        buttStock.setText("Voir le stock");
        buttStock.setFocusable(false);
        buttStock.setHorizontalTextPosition(SwingConstants.CENTER);
        buttStock.setOpaque(true);
        buttStock.addActionListener(new Alistener(this));

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(title, GroupLayout.PREFERRED_SIZE, 293, GroupLayout.PREFERRED_SIZE)
                        .addGap(124, 124, 124))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 303, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(legend3, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(area3, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(legend2, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(area2, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(legend1, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(area1, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(36, Short.MAX_VALUE))
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addComponent(buttStock, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttFabriquation, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
                .addGap(93, 93, 93))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(area1, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                            .addComponent(legend1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(legend2, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                            .addComponent(area2, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(area3, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                            .addComponent(legend3, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(buttStock, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttFabriquation, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );

        pack();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    JComboBox<String> area1;
    JTextField area2;
    JTextField area3;
    JButton buttFabriquation;
    JButton buttStock;
    JScrollPane jScrollPane1;
    JLabel legend1;
    JLabel legend2;
    JLabel legend3;
    JTable tableProd;
    JLabel title;
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

    public JButton getButtFabriquation() {
        return buttFabriquation;
    }

    public void setButtFabriquation(JButton buttFabriquation) {
        this.buttFabriquation = buttFabriquation;
    }

    public JButton getButtStock() {
        return buttStock;
    }

    public void setButtStock(JButton buttStock) {
        this.buttStock = buttStock;
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
           new Serveur(list).setVisible(true);
       }
       catch(Exception e){
           System.out.println(e.getMessage());
       }
   }
}
