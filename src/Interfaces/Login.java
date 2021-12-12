
package Interfaces;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.*;
import lumiplaksoft.LumiplakSoft;
public class Login extends javax.swing.JFrame {
 
    public Login() {
        initComponents();
        this.setLocationRelativeTo(null);
        formSesion.dispose();
        
        java.util.Date fecha = new java.util.Date();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Fecha= formato.format(fecha);
        
        Timer tiempo = new Timer(100, new Login.horas());
        tiempo.start();
    }
    
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        formSesion = new javax.swing.JInternalFrame();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        txtContraseña = new javax.swing.JPasswordField();
        btnAcceso = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        formSesion.setVisible(true);

        jLabel1.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        jLabel1.setText("Usuario: ");

        jLabel2.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        jLabel2.setText("Contraseña:");

        txtUsuario.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        txtContraseña.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtContraseña.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtContraseñaKeyPressed(evt);
            }
        });

        btnAcceso.setFont(new java.awt.Font("Dialog", 3, 13)); // NOI18N
        btnAcceso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Icono Iniciar.png"))); // NOI18N
        btnAcceso.setText("Acceder");
        btnAcceso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAccesoActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Dialog", 3, 13)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Icono Csesion.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout formSesionLayout = new javax.swing.GroupLayout(formSesion.getContentPane());
        formSesion.getContentPane().setLayout(formSesionLayout);
        formSesionLayout.setHorizontalGroup(
            formSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formSesionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(formSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(formSesionLayout.createSequentialGroup()
                        .addComponent(btnAcceso)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
                        .addComponent(btnCancelar))
                    .addGroup(formSesionLayout.createSequentialGroup()
                        .addGroup(formSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(formSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtContraseña)
                            .addComponent(txtUsuario))))
                .addContainerGap())
        );
        formSesionLayout.setVerticalGroup(
            formSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formSesionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(formSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(formSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(formSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAcceso)
                    .addComponent(btnCancelar))
                .addContainerGap())
        );

        getContentPane().add(formSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 370, 170));

        jLabel3.setIcon(new javax.swing.ImageIcon("/home/jesus_reyes/Descargas/login.jpg")); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Icono Sistema.png"))); // NOI18N
        jMenu1.setText("Opciones de Sistema");
        jMenu1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        jMenuItem1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Icono Sesion.png"))); // NOI18N
        jMenuItem1.setText("Iniciar Sesion");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Icono Cerrar.png"))); // NOI18N
        jMenuItem2.setText("Cerrar");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    String Hora = null;
    String Fecha = null;
    public void limpiar(){
        txtUsuario.setText("");
        txtContraseña.setText("");
    }
    
    public void validar(){
        String tipo = null;
        int resultado = 0;
        String user = txtUsuario.getText();
        String pass = String.valueOf(txtContraseña.getPassword());
        String sql = "select * from Usuarios where Usuario = '" + user + "'and Contrasena = '" + pass + "'";
        
        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            if(rs.next()){
                resultado = 1;
                tipo = rs.getString("TipoAcceso");
                
                if(resultado == 1){
                    if(tipo.equals("Administrador")){
                        claveAcceso();
                        acceso();
                        JOptionPane.showMessageDialog(null, "Bienvenido al Administrador de Sistema " + user, "Sistema Sicapy", JOptionPane.INFORMATION_MESSAGE);
                        limpiar();
                        formSesion.dispose();
                        PanelControl pc = new PanelControl();
                        pc.setVisible(true);
                        this.dispose();
                        
                    }else if(tipo.equals("Empleado")){
                        claveAcceso();
                        acceso();
                        formSesion.dispose();
                        JOptionPane.showMessageDialog(null, "Bienvenido al sistema de Punto Venta Sicapy " + user, "Siistema Sicapy", JOptionPane.INFORMATION_MESSAGE);
                        Ventas v = new Ventas();
                        v.setVisible(true);
                        this.dispose();
                        limpiar();
                    }
                }
            }else{
                JOptionPane.showMessageDialog(null, "Usuario y/o Contraseña Incorrectos", "Sistema Sicapy", JOptionPane.ERROR_MESSAGE);
                limpiar();
            }
           
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
    }
    
    String Clave = null;
    public void claveAcceso(){
        String sql = "Select max(idAcceso) from Accesos";
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
            JOptionPane.showMessageDialog(null, "Error al incrementar la clave de Acceos" + e.getMessage());

        }
    }
    
    public void acceso(){
        String user = txtUsuario.getText();
        
        String sql = "insert into Accesos(idAcceso, Usuario, FechaAcceso, HoraAcceso) values (?, ?, ?, ?)";
        try{
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, Clave);
            pst.setString(2, user);
            pst.setString(3, Fecha);
            pst.setString(4, Hora);
            pst.execute();
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
             
        }
    }
    
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        formSesion.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void btnAccesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAccesoActionPerformed
        validar();
    }//GEN-LAST:event_btnAccesoActionPerformed

    private void txtContraseñaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContraseñaKeyPressed
        char tecla = evt.getKeyChar();
        if (tecla == KeyEvent.VK_ENTER){
            validar();
            
        }
    }//GEN-LAST:event_txtContraseñaKeyPressed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        formSesion.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAcceso;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JInternalFrame formSesion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPasswordField txtContraseña;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
