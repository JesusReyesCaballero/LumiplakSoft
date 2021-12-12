package Interfaces;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.*;
import lumiplaksoft.LumiplakSoft;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Calendar;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

public class Ventas extends javax.swing.JFrame {

    LumiplakSoft cc = new LumiplakSoft();
    Connection con = cc.conectar();

    public Ventas() {
        initComponents();
        this.setLocationRelativeTo(null);
        usuarioLog();
        idVenta();
        txtIVA.setText("16");

        tablaVentas.setModel(modelo);

        Date fecha = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyyy");
        txtDate.setDate(fecha);
        Timer tiempo = new Timer(100, new Ventas.horas());
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

    public void Confirmar() {
        if (JOptionPane.showConfirmDialog(null, "¿Desea cerrar sesión actual?", "Sistema Sicapy", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            claveAcceso();
            salidas();
            Login l = new Login();
            l.setVisible(true);
            this.dispose();
        }
    }

    class horas implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            Date hora = new Date();
            String pmAm = "hh:mm:ss";
            SimpleDateFormat format = new SimpleDateFormat(pmAm);
            Calendar hoy = Calendar.getInstance();
            lblHora.setText(String.format(format.format(hora), hoy));

        }
    }

    String Clave = null;

    public void claveAcceso() {
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

    public void salidas() {

        String sql = "insert into Salidas(idSalida, Usuario, FechaSalida, HoraSalida) values (?, ?, ?, ?)";
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, Clave);
            pst.setString(2, lblVendedor.getText());

            //Date fecha = new Date();
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            String Fecha = formato.format(txtDate.getDate());
            pst.setString(3, Fecha);

            pst.setString(4, lblHora.getText());
            pst.execute();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

        }
    }
    
    public void guardarCliente(){
        try{
            String sql = "insert into Clientes (Apellidos, Nombre, Telefono, EMail, Direccion) values (?, ?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(sql);
            
            pst.setString(1, txtApellidos.getText());
            pst.setString(2, txtNombre.getText());
            pst.setString(3, txtTelefono.getText());
            pst.setString(4, "Correo aun no ingresado");
            pst.setString(5, txtDireccion.getText());
            
            pst.execute();
            JOptionPane.showMessageDialog(null, "Se ha registrado los datos con exito", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Se ha producido un error al registrar los datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaVentas = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNombreP = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtDate = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblVendedor = new javax.swing.JLabel();
        txtIVA = new javax.swing.JLabel();
        txtSubtotal = new javax.swing.JLabel();
        txtTotal = new javax.swing.JLabel();
        txtIVA1 = new javax.swing.JLabel();
        txtIVA2 = new javax.swing.JLabel();
        txtIVA3 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtClaveV = new javax.swing.JLabel();
        cancelarV = new javax.swing.JButton();
        lblHora = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtApellidos = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuRegresar = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tablaVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaVentas);

        jLabel2.setFont(new java.awt.Font("Liberation Serif", 3, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Realizar Venta");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("IVA: ");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("Subtotal: ");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setText("Total: ");

        txtNombreP.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtNombreP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNombrePKeyPressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("Nombre Producto:");

        txtDate.setDateFormatString("d-MM-yyyy");

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setText("Fecha: ");

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel8.setText("Vendedor: ");

        lblVendedor.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblVendedor.setText("Usuario");

        txtIVA.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        txtIVA.setText("0.00");

        txtSubtotal.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        txtSubtotal.setText("0.00");

        txtTotal.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        txtTotal.setText("0.00");

        txtIVA1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        txtIVA1.setText("%");

        txtIVA2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        txtIVA2.setText("$");

        txtIVA3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        txtIVA3.setText("$");

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel11.setText("No. Venta: ");

        txtClaveV.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtClaveV.setText("0");

        cancelarV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Icono Cancelar.png"))); // NOI18N
        cancelarV.setText("Cancelar Venta");
        cancelarV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarVActionPerformed(evt);
            }
        });

        lblHora.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblHora.setText("00:00:00");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Icono Venta.png"))); // NOI18N
        jButton1.setText("Realizar Venta");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos de Cliente"));

        jLabel6.setText("Apellidos:");

        jLabel10.setText("Nombre:");

        jLabel12.setText("Dirección:");

        jLabel13.setText("Telefono:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDireccion)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(txtNombre))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Icono Opciones.png"))); // NOI18N
        jMenu1.setText("Opciones");
        jMenu1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        menuRegresar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        menuRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Icono Regresar.png"))); // NOI18N
        menuRegresar.setText("Cerrar Sesión");
        menuRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRegresarActionPerformed(evt);
            }
        });
        jMenu1.add(menuRegresar);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblHora))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(86, 86, 86))
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtClaveV))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNombreP, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(219, 219, 219)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblVendedor)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIVA)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIVA1)
                        .addGap(35, 35, 35)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIVA2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSubtotal)
                        .addGap(40, 40, 40)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIVA3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotal)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelarV)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblHora))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txtNombreP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel7)
                        .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtClaveV)
                    .addComponent(jLabel8)
                    .addComponent(lblVendedor))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIVA)
                    .addComponent(jLabel4)
                    .addComponent(txtSubtotal)
                    .addComponent(jLabel5)
                    .addComponent(txtTotal)
                    .addComponent(txtIVA1)
                    .addComponent(txtIVA2)
                    .addComponent(txtIVA3)
                    .addComponent(jButton1)
                    .addComponent(cancelarV)
                    .addComponent(jLabel3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    String[] titulos = {"Codigo", "Nombre", "Precio Unitario", "Cantidad", "SubTotal"};
    String[] registros = new String[6];
    DefaultTableModel modelo = new DefaultTableModel(null, titulos);

    String cantidad = null;

    public void limpiar() {
        txtSubtotal.setText("0.00");
        txtTotal.setText("0.00");
        txtApellidos.setText("");;
        txtNombre.setText("");
        txtDireccion.setText("");
        txtTelefono.setText("");
    }

    public void idVenta() {
        String sql = "select idVenta from Ventas";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            int a = 0;
            int b = 0;
            while (rs.next()) {
                String c = rs.getString("idVenta");
                a = Integer.parseInt("" + c);

                if (a > b) {
                    b = a;
                    a = b + 1;
                    txtClaveV.setText("" + a);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al incrementar la clave de ventas" + e.getMessage());

        }
    }

    public void limpiarTabla() {
        for (int i = 0; i < tablaVentas.getRowCount(); i++) {
            modelo.removeRow(i);
            i -= 1;
        }
        tablaVentas.setModel(new DefaultTableModel(null, titulos));
    }

    double i = 0;

    public void calcular() {
        double iva = Double.parseDouble(txtIVA.getText().toString());
        double subtotal = Double.parseDouble(txtSubtotal.getText().toString());
        i = subtotal * iva / 100;
        double total = subtotal + i;

        txtTotal.setText("" + total);

    }

    public void agregar() {
        String p = null;
        double can = 0, pre = 0, Total = 0;
        String nombre = txtNombreP.getText();
        String sql = "select * from Productos where Nombre = '" + nombre + "'";
        cantidad = JOptionPane.showInputDialog(null, "Ingrese Cantidad");
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                registros[0] = rs.getString("idProducto");
                registros[1] = rs.getString("Nombre");
                p = registros[2] = rs.getString("Precio");
                registros[3] = cantidad;

                can = Double.parseDouble(cantidad.toString());
                pre = Double.parseDouble(p.toString());
                Total = can * pre;
                String t = Double.toString(Total);
                registros[4] = t;
                modelo.addRow(registros);
            }
            tablaVentas.setModel(modelo);

            double fila = 0;
            double total = 0;
            for (int i = 0; i < tablaVentas.getRowCount(); i++) {
                fila = Double.parseDouble(tablaVentas.getValueAt(i, 4).toString());
                total += fila;

            }
            txtSubtotal.setText("" + total);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Se ha producido un error al mostrar los datos" + e.getMessage(), "Sistema Sicapy", JOptionPane.ERROR_MESSAGE);
        }
        txtNombreP.setText("");
        calcular();
    }

    public void usuarioLog() {
        String a = null;
        String sql = "select max(idAcceso) from Accesos";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                a = rs.getString(1);

            }
            String mysql = "select * from Accesos where idAcceso = '" + a + "'";
            Statement ts = con.createStatement();
            ResultSet sr = ts.executeQuery(mysql);
            while (sr.next()) {
                lblVendedor.setText(sr.getString("Usuario"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    public void vender() {
        idVenta();
        String efectivo = JOptionPane.showInputDialog("null", "Paga con");

        double pago = Double.parseDouble(txtTotal.getText().toString());
        double cambio = 0;
        double ingreso = Double.parseDouble(efectivo);
        cambio = (pago - ingreso) * -1;
        JOptionPane.showMessageDialog(null, "Cambio: $" + String.format("%.1f", cambio), "Sistema Sicapy", JOptionPane.INFORMATION_MESSAGE);
        venta();
        limpiar();
        limpiarTabla();
        idVenta();

    }

    public void venta() {
        String sql = "insert into Ventas(idVenta, Usuario, Subtotal, Iva, Total, FechaVenta, HoraVenta) values (?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, txtClaveV.getText());
            pst.setString(2, lblVendedor.getText());
            pst.setString(3, txtSubtotal.getText());
            pst.setString(4, "" + i);
            pst.setString(5, txtTotal.getText());

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String fecha = sdf.format(txtDate.getDate());
            pst.setString(6, fecha);

            pst.setString(7, lblHora.getText());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Se ha realizado la venta con exito", "Sistema Sicapy", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private void txtNombrePKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombrePKeyPressed
        char tecla = evt.getKeyChar();
        if (tecla == KeyEvent.VK_ENTER) {
            agregar();
        }
    }//GEN-LAST:event_txtNombrePKeyPressed

    private void cancelarVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarVActionPerformed
        if (JOptionPane.showConfirmDialog(null, "¿Desea cancelar la venta?", "Sistema Sicapy", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            limpiarTabla();
        }
    }//GEN-LAST:event_cancelarVActionPerformed

    private void menuRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRegresarActionPerformed
        if (JOptionPane.showConfirmDialog(null, "¿Desea cerrar sesión actual?", "Sistema Sicapy", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            claveAcceso();
            salidas();
            Login l = new Login();
            l.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_menuRegresarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(JOptionPane.showConfirmDialog(null, "¿Desea registrar un nuevo cliente?", "Mensaje", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
            guardarCliente();
            vender();
        }else{
            vender();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelarV;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblHora;
    private javax.swing.JLabel lblVendedor;
    private javax.swing.JMenuItem menuRegresar;
    private javax.swing.JTable tablaVentas;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JLabel txtClaveV;
    private com.toedter.calendar.JDateChooser txtDate;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JLabel txtIVA;
    private javax.swing.JLabel txtIVA1;
    private javax.swing.JLabel txtIVA2;
    private javax.swing.JLabel txtIVA3;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombreP;
    private javax.swing.JLabel txtSubtotal;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JLabel txtTotal;
    // End of variables declaration//GEN-END:variables
}
