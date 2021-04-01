
package co.unicauca.restaurant.client.interfaz;

import java.util.ArrayList;
import javax.swing.JOptionPane;




public class Menudia extends javax.swing.JFrame {

    public Menudia() {
        initComponents();
    }
    ArrayList<String> item = new ArrayList<String>();
    
    String itema="";

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelBebida = new javax.swing.JLabel();
        jButtonSalir = new javax.swing.JButton();
        jLabelProteina = new javax.swing.JLabel();
        jComboBoxProteina = new javax.swing.JComboBox<>();
        jComboBoxBebida = new javax.swing.JComboBox<>();
        jLabelFrutasyVegetales = new javax.swing.JLabel();
        jComboBoxFrutasyVegetales = new javax.swing.JComboBox<>();
        jComboBoxCarbohidrato = new javax.swing.JComboBox<>();
        jLabelCarbohidrato = new javax.swing.JLabel();
        jLabelAdicion = new javax.swing.JLabel();
        jComboBoxAdicion = new javax.swing.JComboBox<>();
        jButtonGuardar = new javax.swing.JButton();
        jLabelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelBebida.setText("Bebida :");
        getContentPane().add(jLabelBebida, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 70, 20));

        jButtonSalir.setText("Salir");
        jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 270, 80, 30));

        jLabelProteina.setText("Proteina :");
        getContentPane().add(jLabelProteina, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));

        jComboBoxProteina.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pollo", "Carne Cerdo", "Res", "Pescado" }));
        getContentPane().add(jComboBoxProteina, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, 120, -1));

        jComboBoxBebida.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Limonada", "Gaseosa", "Agua" }));
        getContentPane().add(jComboBoxBebida, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 120, -1));

        jLabelFrutasyVegetales.setText("Frutas y Vegetales :");
        getContentPane().add(jLabelFrutasyVegetales, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, -1, -1));

        jComboBoxFrutasyVegetales.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ensalada de frutas", "Tomates", "Brocoly" }));
        getContentPane().add(jComboBoxFrutasyVegetales, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, 120, -1));

        jComboBoxCarbohidrato.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Arroz", "Pasta", "Lentejas", "Frijol" }));
        getContentPane().add(jComboBoxCarbohidrato, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 90, 100, -1));

        jLabelCarbohidrato.setText("Carbohidrato :");
        getContentPane().add(jLabelCarbohidrato, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 90, -1, -1));

        jLabelAdicion.setText("Adicion :");
        getContentPane().add(jLabelAdicion, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 170, -1, -1));

        jComboBoxAdicion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Postre", "Arroz", "Chocolate" }));
        getContentPane().add(jComboBoxAdicion, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 170, 100, -1));

        jButtonGuardar.setText("Guardar");
        jButtonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 240, 130, 60));

        jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondoazul.png"))); // NOI18N
        jLabelFondo.setText("Proteina");
        getContentPane().add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 466));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
       System.exit(0);
    }//GEN-LAST:event_jButtonSalirActionPerformed

    private void jButtonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarActionPerformed
      /*
      item = (ArrayList<String>) jComboBoxBebida.getSelectedItem();
      item = (ArrayList<String>) jComboBoxProteina.getSelectedItem();
      item = (ArrayList<String>) jComboBoxFrutasyVegetales.getSelectedItem();
      item = (ArrayList<String>) jComboBoxCarbohidrato.getSelectedItem();
      item = (ArrayList<String>) jComboBoxAdicion.getSelectedItem();
      
      JOptionPane.showMessageDialog(null, "Los item seleccionado es "+
              item.get(1)+item.get(2)+item.get(3)+item.get(4)+item.get(5));
        */
      itema = jComboBoxBebida.getSelectedItem().toString();
      JOptionPane.showMessageDialog(null, "Los item seleccionado es "+itema);
    }//GEN-LAST:event_jButtonGuardarActionPerformed

 public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menudia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menudia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menudia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menudia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menudia().setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonGuardar;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JComboBox<String> jComboBoxAdicion;
    private javax.swing.JComboBox<String> jComboBoxBebida;
    private javax.swing.JComboBox<String> jComboBoxCarbohidrato;
    private javax.swing.JComboBox<String> jComboBoxFrutasyVegetales;
    private javax.swing.JComboBox<String> jComboBoxProteina;
    private javax.swing.JLabel jLabelAdicion;
    private javax.swing.JLabel jLabelBebida;
    private javax.swing.JLabel jLabelCarbohidrato;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JLabel jLabelFrutasyVegetales;
    private javax.swing.JLabel jLabelProteina;
    // End of variables declaration//GEN-END:variables
}
