
package Interfaces;

import java.sql.*;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import lumiplaksoft.LumiplakSoft;
import com.toedter.calendar.JDateChooser;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class RepoAccesos extends javax.swing.JFrame {

    public RepoAccesos() {
        initComponents();
        this.setLocationRelativeTo(null);
        repo();
        Cerrar();
    }
    
    public void Cerrar() {
        try {
            this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    Confirmar();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void Confirmar(){
        this.dispose();
    }

    LumiplakSoft cc = new LumiplakSoft();
    Connection con = cc.conectar();
    
    public void repo(){
        String[] titulos = {"Usuario", "FechaEntrada", "HoraEntrada", "FechaSalida", "HoraSalida"};
        String[] registros = new String[6];
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        
        String sql = "select * from Accesos";
        String mysql = "Select * from Salidas";
        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            Statement ts = con.createStatement();
            ResultSet sr = ts.executeQuery(mysql);
            
            while(rs.next() && sr.next()){
                registros[0] = rs.getString("Usuario");
                registros[1] = rs.getString("FechaAcceso");
                registros[2] = rs.getString("HoraAcceso");
                registros[3] = sr.getString("FechaSalida");
                registros[4] = sr.getString("HoraSalida");
                modelo.addRow(registros);
                
            }
            tablaAccesos.setModel(modelo);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaAccesos = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        menuRegresar = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tablaAccesos.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        tablaAccesos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaAccesos);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Icono Opciones.png"))); // NOI18N
        jMenu1.setText("Opciones");
        jMenu1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        jMenuItem2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Icono Imprimir.png"))); // NOI18N
        jMenuItem2.setText("Imprimir");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        menuRegresar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        menuRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Icono Regresar.png"))); // NOI18N
        menuRegresar.setText("Regresar");
        menuRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRegresarActionPerformed(evt);
            }
        });
        jMenu1.add(menuRegresar);

        jMenuBar1.add(jMenu1);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Icono Busqueda.png"))); // NOI18N
        jMenu2.setText("Buscar");
        jMenu2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Icono ES.png"))); // NOI18N
        jMenuItem7.setText("Entradas y Salidas");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem7);

        jMenuItem1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Icono Accesos.png"))); // NOI18N
        jMenuItem1.setText("Accesos");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Icono Salidas.png"))); // NOI18N
        jMenuItem6.setText("Salidas");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem6);

        jMenuItem3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Icono Diario.png"))); // NOI18N
        jMenuItem3.setText("Diario");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuItem4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Icono Semana.png"))); // NOI18N
        jMenuItem4.setText("Semanal");
        jMenu2.add(jMenuItem4);

        jMenuItem5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Icono Mensual.png"))); // NOI18N
        jMenuItem5.setText("Mensual");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 675, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        MessageFormat header = new MessageFormat("Reporte de Usuarios");
        MessageFormat footer = new MessageFormat("page{0,number,integer}");

        try{
            tablaAccesos.print(JTable.PrintMode.NORMAL, header, footer);

        }catch(java.awt.print.PrinterException e){

            JOptionPane.showMessageDialog(null, e.getMessage());

        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void menuRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRegresarActionPerformed
        PanelControl pc = new PanelControl();
        pc.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menuRegresarActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        String[] titulos = {"idAcceso", "Usuario", "FechaAcceso", "HoraAcceso"};
        String[] registros = new String[5];
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);

        String sql = "select * from Accesos";
        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while(rs.next()){
                registros[0] = rs.getString("idAcceso");
                registros[1] = rs.getString("Usuario");
                registros[2] = rs.getString("FechaAcceso");
                registros[3] = rs.getString("HoraAcceso");
                modelo.addRow(registros);
            }
            tablaAccesos.setModel(modelo);

        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        JDateChooser jd = new JDateChooser();
        String mensaje = "Seleccione Fecha\n";
        Object[] params = {mensaje, jd};
        JOptionPane.showMessageDialog(null, params, "Mensaje", JOptionPane.PLAIN_MESSAGE);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String fecha = sdf.format(((JDateChooser)params[1]).getDate());

        String[] titulos = {"Usuario", "FechaEntrada", "HoraEntrada", "FechaSalida", "HoraSalida"};
        String[] registros = new String[6];
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);

        String sql = "select * from Accesos where FechaAcceso = '" + fecha + "'";
        String mysql = "select * from Salidas where FechaSalida = '" + fecha + "'";
        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            Statement ts = con.createStatement();
            ResultSet sr = ts.executeQuery(mysql);
            while(rs.next() && sr.next()){
                registros[0] = rs.getString("Usuario");
                registros[1] = rs.getString("FechaAcceso");
                registros[2] = rs.getString("HoraAcceso");
                registros[3] = sr.getString("FechaSalida");
                registros[4] = sr.getString("HoraSalida");
                modelo.addRow(registros);
            }
            tablaAccesos.setModel(modelo);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        String[] titulos = {"idSalida", "Usuario", "FechaSalida", "HoraSalida"};
        String[] registros = new String[5];
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);

        String sql = "select * from Salidas";
        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while(rs.next()){
                registros[0] = rs.getString("idSalida");
                registros[1] = rs.getString("Usuario");
                registros[2] = rs.getString("FechaSalida");
                registros[3] = rs.getString("HoraSalida");
                modelo.addRow(registros);
            }
            tablaAccesos.setModel(modelo);

        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        repo();
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        String[] titulos = {"Usuario", "FechaEntrada", "HoraEntrada", "FechaSalida", "HoraSalida"};
        String[] registros = new String[6];
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        
        String mes = JOptionPane.showInputDialog(null, "Ingrese el número de mes y año a buscar: ");
        String fecha1 = mes + "-01";
        String fecha2 = mes + "-31";
        
        String sql = "select * from Accesos where FechaAcceso between '" + fecha1 + "'and'" + fecha2 + "'";
        String mysql = "select * from Salidas where FechaSalida between '" + fecha1 + "'and'" + fecha2 + "'";
        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            Statement ts = con.createStatement();
            ResultSet sr = ts.executeQuery(mysql);
            
            while(rs.next() && sr.next()){
                registros[0] = rs.getString("Usuario");
                registros[1] = rs.getString("FechaAcceso");
                registros[2] = rs.getString("HoraAcceso");
                registros[3] = sr.getString("FechaSalida");
                registros[4] = sr.getString("HoraSalida");
                modelo.addRow(registros);
                
            }
            tablaAccesos.setModel(modelo);
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RepoAccesos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RepoAccesos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RepoAccesos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RepoAccesos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RepoAccesos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem menuRegresar;
    private javax.swing.JTable tablaAccesos;
    // End of variables declaration//GEN-END:variables
}
