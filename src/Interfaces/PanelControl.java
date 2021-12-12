package Interfaces;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import lumiplaksoft.LumiplakSoft;
import javax.swing.*;
import javax.swing.Timer;
public class PanelControl extends javax.swing.JFrame {

    public PanelControl() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setBackground(new Color(51, 51, 55));
        java.util.Date fecha = new java.util.Date();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Fecha= formato.format(fecha);
        
        Timer tiempo = new Timer(100, new PanelControl.horas());
        tiempo.start();
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
        if(JOptionPane.showConfirmDialog(null, "¿Desea cerrar sesión como Administrador?", "Sistema Sicapy", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
            usuarioLog();
            claveAcceso();
            salidas();
            Login l = new Login();
            l.setVisible(true);
            this.dispose();
        }
    }
    
    String Hora = null;
    String Fecha = null;
    class horas implements ActionListener{
      public void actionPerformed(ActionEvent e)  {
          java.util.Date hora = new java.util.Date();
          String pmAm = "hh:mm:ss";
          SimpleDateFormat format = new SimpleDateFormat(pmAm);
          Calendar hoy = Calendar.getInstance();
          Hora = String.format(format.format(hora), hoy);
      }
    }
    
    LumiplakSoft cc = new LumiplakSoft();
    Connection con = cc.conectar();

    public void salidas(){
        
        String sql = "insert into Salidas(idSalida, Usuario, FechaSalida, HoraSalida) values (?, ?, ?, ?)";
        try{
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, Clave);
            pst.setString(2, Usuariolog);
            pst.setString(3, Fecha);
            pst.setString(4, Hora);
            pst.execute();
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
             
        }
    }
    
    String Usuariolog = null;
    public void usuarioLog(){
        String a = null;
        String sql = "select max(idAcceso) from Accesos";
        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                a = rs.getString(1);
                
            }
            String mysql = "select * from Accesos where idAcceso = '" + a + "'";
            Statement ts = con.createStatement();
            ResultSet sr = ts.executeQuery(mysql);
            while(sr.next()){
                Usuariolog = sr.getString("Usuario");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
    }
    
    String Clave = null;
    public void claveAcceso(){
        String sql = "Select max(idSalida) from Salidas";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            int a = 0;
            int b = 0;
            while (rs.next()) {
                String c = rs.getString(1);
                a = Integer.parseInt("" + c);

                if (a > b) {
                    b = a;
                    a = b + 1;
                    Clave = "" + a;
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al incrementar la clave de Salidas" + e.getMessage());

        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuUsuarios = new javax.swing.JMenuItem();
        menuClientes = new javax.swing.JMenuItem();
        menuProductos = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenuBar1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Icono Archivo.png"))); // NOI18N
        jMenu1.setText("Archivo");
        jMenu1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        menuUsuarios.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuUsuarios.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        menuUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Icono Usuario.png"))); // NOI18N
        menuUsuarios.setText("Admin. Usuarios");
        menuUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuUsuariosActionPerformed(evt);
            }
        });
        jMenu1.add(menuUsuarios);

        menuClientes.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuClientes.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        menuClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Icono Cliente.png"))); // NOI18N
        menuClientes.setText("Admin. Clientes");
        menuClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuClientesActionPerformed(evt);
            }
        });
        jMenu1.add(menuClientes);

        menuProductos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuProductos.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        menuProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Icono Producto.png"))); // NOI18N
        menuProductos.setText("Admin. Productos");
        menuProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuProductosActionPerformed(evt);
            }
        });
        jMenu1.add(menuProductos);

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Icono Regresar.png"))); // NOI18N
        jMenuItem5.setText("Cerrar Sesion");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuBar1.add(jMenu1);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Icono Reporte.png"))); // NOI18N
        jMenu2.setText("Reportes");
        jMenu2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        jMenuItem6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Icono RUsuario.png"))); // NOI18N
        jMenuItem6.setText("Repo. Usuarios");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem6);

        jMenuItem7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Icono RVenta.png"))); // NOI18N
        jMenuItem7.setText("Repo. Ventas");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem7);

        jMenuItem8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jMenuItem8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Icono Inventario.png"))); // NOI18N
        jMenuItem8.setText("Repo. Inventario");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem8);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 942, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 465, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuUsuariosActionPerformed
        AdUsuarios au = new AdUsuarios();
        au.setVisible(true);
    }//GEN-LAST:event_menuUsuariosActionPerformed

    private void menuClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuClientesActionPerformed
        AdClientes ac = new AdClientes();
        ac.setVisible(true);
    }//GEN-LAST:event_menuClientesActionPerformed

    private void menuProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuProductosActionPerformed
        AdProductos ap = new AdProductos();
        ap.setVisible(true);
    }//GEN-LAST:event_menuProductosActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        if(JOptionPane.showConfirmDialog(null, "¿Desea cerrar sesión como Administrador?", "Sistema Sicapy", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
            usuarioLog();
            claveAcceso();
            salidas();
            Login l = new Login();
            l.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        RepoAccesos ra = new RepoAccesos();
        ra.setVisible(true);
        //this.dispose();
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        RepoVentas rv = new RepoVentas();
        rv.setVisible(true);
        //this.dispose();
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        RepoProductos rp = new RepoProductos();
        rp.setVisible(true);
        //this.dispose();
    }//GEN-LAST:event_jMenuItem8ActionPerformed

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
            java.util.logging.Logger.getLogger(PanelControl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PanelControl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PanelControl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PanelControl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PanelControl().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem menuClientes;
    private javax.swing.JMenuItem menuProductos;
    private javax.swing.JMenuItem menuUsuarios;
    // End of variables declaration//GEN-END:variables
}
