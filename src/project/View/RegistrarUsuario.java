/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package project.View;

import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author yenderson
 */
public class RegistrarUsuario extends javax.swing.JPanel {

 
  
    public RegistrarUsuario() {
        
        initComponents();
        
        
       
             
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        nombrestxt = new javax.swing.JTextField();
        apellidostxt = new javax.swing.JTextField();
        emailtxt = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        usetxt = new javax.swing.JTextField();
        passwtxt = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        tipotxt = new javax.swing.JComboBox();

        setBackground(new java.awt.Color( 255, 255, 255, 50 ));
        setDoubleBuffered(false);

        jPanel1.setBackground(new java.awt.Color( 255, 255, 255, 50 ));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.setDoubleBuffered(false);
        jPanel1.setFocusTraversalPolicyProvider(true);
        jPanel1.setPreferredSize(new java.awt.Dimension(491, 430));

        jLabel2.setBackground(new java.awt.Color( 255, 255, 255, 75 ));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("REGISTRO DE USUARIO");
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jButton1.setBackground(new java.awt.Color( 255, 255, 255, 125 ));
        jButton1.setText("GUARDAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        cancelar.setBackground(new java.awt.Color( 255, 255, 255, 125 ));
        cancelar.setText("CANCELAR");
        cancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cancelarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cancelarMouseExited(evt);
            }
        });
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color( 255, 255, 255, 50 ));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3), "Datos personales", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setDoubleBuffered(false);

        jLabel7.setBackground(new java.awt.Color( 255, 255, 255, 75 ));
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Nombre");

        jLabel1.setBackground(new java.awt.Color( 255, 255, 255, 75 ));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Apellido");

        jLabel8.setBackground(new java.awt.Color( 255, 255, 255, 75 ));
        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Email");

        nombrestxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombrestxtActionPerformed(evt);
            }
        });
        nombrestxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nombrestxtKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nombrestxtKeyTyped(evt);
            }
        });

        apellidostxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apellidostxtActionPerformed(evt);
            }
        });
        apellidostxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                apellidostxtKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                apellidostxtKeyTyped(evt);
            }
        });

        emailtxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailtxtActionPerformed(evt);
            }
        });
        emailtxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                emailtxtKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                emailtxtKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(emailtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nombrestxt, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(apellidostxt, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombrestxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(apellidostxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(emailtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color( 255, 255, 255, 50 ));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3), "Datos de Usuaio", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));

        jLabel3.setBackground(new java.awt.Color( 255, 255, 255, 75 ));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nivel de Acceso");

        jLabel4.setBackground(new java.awt.Color( 255, 255, 255, 75 ));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Usuario");

        jLabel5.setBackground(new java.awt.Color( 255, 255, 255, 75 ));
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Contrase??a");

        jLabel6.setBackground(new java.awt.Color( 255, 255, 255, 75 ));
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Confirmar Contrase??a");

        usetxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                usetxtKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                usetxtKeyTyped(evt);
            }
        });

        tipotxt.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "INVITADO", "ADMINISTRADOR" }));
        tipotxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipotxtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(56, 56, 56)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(usetxt, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(passwtxt, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tipotxt, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(usetxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(passwtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap(14, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(tipotxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                            .addComponent(cancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 30, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(45, 45, 45))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void nombrestxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombrestxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombrestxtActionPerformed

    private void apellidostxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apellidostxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_apellidostxtActionPerformed

    private void emailtxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailtxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailtxtActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
if( validarDatos() == true )
        {project.Model.Usuario usuario= new project.Model.Usuario();
     usuario.setNombre(usetxt.getText());
     usuario.setPasswd(passwtxt.getText());
     usuario.setTipo(tipotxt.getSelectedIndex()+1);
     usuario.setnombres(nombrestxt.getText());
     usuario.setapellidos(apellidostxt.getText());
     usuario.setemail(emailtxt.getText());
     
     
     boolean res= project.Controller.Application.onusuario(usuario);
        
     if(res== true){
         project.Controller.Application.showMessageDialog("REGISTRO EXITOSO");
     project.Controller.Application.callInicio();}
     else
         project.Controller.Application.showSqlErrorMessageDialog();       
       }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tipotxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipotxtActionPerformed
       
    }//GEN-LAST:event_tipotxtActionPerformed

    private void usetxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usetxtKeyPressed
     if(evt.isControlDown() || evt.isControlDown()){
           Toolkit.getDefaultToolkit().beep();
           evt.consume();
        }
           if(evt.isAltDown()|| evt.isAltDown()){
              Toolkit.getDefaultToolkit().beep();
              evt.consume();
        }
           
           if(evt.isShiftDown() || evt.isShiftDown()){
              Toolkit.getDefaultToolkit().beep();
              evt.consume();
           }  
    }//GEN-LAST:event_usetxtKeyPressed

    private void usetxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usetxtKeyTyped
int k = (int) evt.getKeyChar();
        char c = evt.getKeyChar();
        if(k >= 48 && k <= 57){
           evt.setKeyChar((char)KeyEvent.VK_CLEAR);
          // JOptionPane.showMessageDialog(null, "No puede ingresar digitos","Advertencia",JOptionPane.INFORMATION_MESSAGE);
        }
        
        if((k >= 33 && k <= 47) || (k >= 58 && k <= 64) || (k >= 91 && k <= 96) || (k >= 123 && k <= 126)){
           Toolkit.getDefaultToolkit().beep();
           evt.setKeyChar((char)KeyEvent.VK_CLEAR);
           JOptionPane.showMessageDialog(null, "No puede  ingresar caracteres especiales","Advertencia",JOptionPane.INFORMATION_MESSAGE);
        }
        //para validar caracteres raros que no se puede validar normalmente
        if((c == '?')||(c == '??') || (c == '??')||(c == '??') ||  (c == '??')||(c == '??') || (c == '??')||(c == '???')){
           Toolkit.getDefaultToolkit().beep();
           evt.setKeyChar((char)KeyEvent.VK_CLEAR);
           JOptionPane.showMessageDialog(null, "No puede ingresar caracteres especiales","Advertencia",JOptionPane.INFORMATION_MESSAGE);
        }
        
        if (k == 10) {//si se presiona enter
            //transfiere el foco
            usetxt.transferFocus();
        }
        
        if(usetxt.getText().length() >= 40){
           evt.setKeyChar((char)KeyEvent.VK_CLEAR);
           JOptionPane.showMessageDialog(null,"Ha excedido el numero maximo de caracter","Advertencia",JOptionPane.INFORMATION_MESSAGE);
        }        
    }//GEN-LAST:event_usetxtKeyTyped

    private void nombrestxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombrestxtKeyTyped
 int k = (int) evt.getKeyChar();
        char c = evt.getKeyChar();
        if(k >= 48 && k <= 57){
           evt.setKeyChar((char)KeyEvent.VK_CLEAR);
          // JOptionPane.showMessageDialog(null, "No puede ingresar digitos","Advertencia",JOptionPane.INFORMATION_MESSAGE);
        }
        
        if((k >= 33 && k <= 47) || (k >= 58 && k <= 64) || (k >= 91 && k <= 96) || (k >= 123 && k <= 126)){
           Toolkit.getDefaultToolkit().beep();
           evt.setKeyChar((char)KeyEvent.VK_CLEAR);
           JOptionPane.showMessageDialog(null, "No puede  ingresar caracteres especiales","Advertencia",JOptionPane.INFORMATION_MESSAGE);
        }
        //para validar caracteres raros que no se puede validar normalmente
        if((c == '?')||(c == '??') || (c == '??')||(c == '??') ||  (c == '??')||(c == '??') || (c == '??')||(c == '???')){
           Toolkit.getDefaultToolkit().beep();
           evt.setKeyChar((char)KeyEvent.VK_CLEAR);
         //  JOptionPane.showMessageDialog(null, "No puede ingresar caracteres especiales","Advertencia",JOptionPane.INFORMATION_MESSAGE);
        }
        
        if (k == 10) {//si se presiona enter
            //transfiere el foco
            nombrestxt.transferFocus();
        }
        
        if(nombrestxt.getText().length() >= 40){
           evt.setKeyChar((char)KeyEvent.VK_CLEAR);
           JOptionPane.showMessageDialog(null,"Ha excedido el numero maximo de caracter","Advertencia",JOptionPane.INFORMATION_MESSAGE);
        }    
    }//GEN-LAST:event_nombrestxtKeyTyped

    private void nombrestxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombrestxtKeyPressed
 // TODO add your handling code here:
        if(evt.isControlDown() || evt.isControlDown()){
           Toolkit.getDefaultToolkit().beep();
           evt.consume();
        }
           if(evt.isAltDown()|| evt.isAltDown()){
              Toolkit.getDefaultToolkit().beep();
              evt.consume();
        }
           
           if(evt.isShiftDown() || evt.isShiftDown()){
              Toolkit.getDefaultToolkit().beep();
              evt.consume();
           }       
    }//GEN-LAST:event_nombrestxtKeyPressed

    private void apellidostxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_apellidostxtKeyTyped
 int k = (int) evt.getKeyChar();
        char c = evt.getKeyChar();
        if(k >= 48 && k <= 57){
           evt.setKeyChar((char)KeyEvent.VK_CLEAR);
           //JOptionPane.showMessageDialog(null, "No puedes ingresar digitos","Advertencia",JOptionPane.INFORMATION_MESSAGE);
        }
        
        if((k >= 33 && k <= 47) || (k >= 58 && k <= 64) || (k >= 91 && k <= 96) || (k >= 123 && k <= 126)){
           Toolkit.getDefaultToolkit().beep();
           evt.setKeyChar((char)KeyEvent.VK_CLEAR);
           JOptionPane.showMessageDialog(null, "No puedes ingresar caracteres especiales","Advertencia",JOptionPane.INFORMATION_MESSAGE);
        }
        //para validar caracteres raros que no se puede validar normalmente
        if((c == '?')||(c == '??') || (c == '??')||(c == '??') ||  (c == '??')||(c == '??') || (c == '??')||(c == '???')){
           Toolkit.getDefaultToolkit().beep();
           evt.setKeyChar((char)KeyEvent.VK_CLEAR);
           JOptionPane.showMessageDialog(null, "No puedes ingresar caracteres especiales","Advertencia",JOptionPane.INFORMATION_MESSAGE);
        }
        
        if (k == 10) {//si se presiona enter
            //transfiere el foco
            apellidostxt.transferFocus();
        }
        
        if(apellidostxt.getText().length() >= 40){
           evt.setKeyChar((char)KeyEvent.VK_CLEAR);
           JOptionPane.showMessageDialog(null,"Ha excedido el numero maximo de caracter","Advertencia",JOptionPane.INFORMATION_MESSAGE);
        }        
    }//GEN-LAST:event_apellidostxtKeyTyped

    private void apellidostxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_apellidostxtKeyPressed
if(evt.isControlDown() || evt.isControlDown()){
           Toolkit.getDefaultToolkit().beep();
           evt.consume();
        }
           if(evt.isAltDown()|| evt.isAltDown()){
              Toolkit.getDefaultToolkit().beep();
              evt.consume();
        }
           
           if(evt.isShiftDown() || evt.isShiftDown()){
              Toolkit.getDefaultToolkit().beep();
              evt.consume();
           }        
    }//GEN-LAST:event_apellidostxtKeyPressed

    private void emailtxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_emailtxtKeyTyped
 // TODO add your handling code here:
        int k = (int) evt.getKeyChar();
        if (k == 10) {//si se presiona enter
            //transfiere el foco
            emailtxt.transferFocus();
        }
        
        if(emailtxt.getText().length() >= 40){
           evt.setKeyChar((char)KeyEvent.VK_CLEAR);
           JOptionPane.showMessageDialog(null,"Ha excedido el numero maximo de caracter","Advertencia",JOptionPane.INFORMATION_MESSAGE);
        }        
    }//GEN-LAST:event_emailtxtKeyTyped

    private void emailtxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_emailtxtKeyPressed
// TODO add your handling code here:
        if(evt.isControlDown() || evt.isControlDown()){
           Toolkit.getDefaultToolkit().beep();
           evt.consume();
        }
           if(evt.isAltDown()|| evt.isAltDown()){
              Toolkit.getDefaultToolkit().beep();
              evt.consume();
        }
           
           if(evt.isShiftDown() || evt.isShiftDown()){
              Toolkit.getDefaultToolkit().beep();
              evt.consume();
           }       
    }//GEN-LAST:event_emailtxtKeyPressed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
project.Controller.Application.callMainOption(new Welcome());       // TODO add your handling code here:
    }//GEN-LAST:event_cancelarActionPerformed

    private void cancelarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelarMouseEntered
cancelar.setBackground( new java.awt.Color( 255, 255, 255, 175 ) );
        project.Controller.Application.repaintScreen();        // TODO add your handling code here:
    }//GEN-LAST:event_cancelarMouseEntered

    private void cancelarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelarMouseExited
cancelar.setBackground( new java.awt.Color( 255, 255, 255, 125 ) );
        project.Controller.Application.repaintScreen();        // TODO add your handling code here:
    }//GEN-LAST:event_cancelarMouseExited

public boolean validarDatos(){
       String msj = "";
       
       
       if(usetxt.getText().equals("")){//si el campo nombre esta vacio
          msj += "Por favor ingrese el nombre, el campo es obligatorio\n";
       }
       if(passwtxt.getText().equals("")){//si el campo nombre esta vacio
          msj += "Por favor ingrese el nombre, el campo es obligatorio\n";
       }
       if(nombrestxt.getText().equals("")){//si el campo apellido esta vacio
          msj += "Por favor ingrese el apellido, el campo es obligatorio\n";
       }
       if(apellidostxt.getText().equals("")){//si el campo apellido esta vacio
          msj += "Por favor ingrese el apellido, el campo es obligatorio\n";
       }
       
       if(emailtxt.getText().equals("")){//si el campo de correo electronico esta vacio
          msj += "Por favor ingrese el correo eletronico, el campo es obligatorio\n";
       }
       if( msj.equals("") == false )
           return(false);
       
       return(true);
    }

        
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField apellidostxt;
    private javax.swing.JButton cancelar;
    private javax.swing.JTextField emailtxt;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField nombrestxt;
    private javax.swing.JTextField passwtxt;
    private javax.swing.JComboBox tipotxt;
    private javax.swing.JTextField usetxt;
    // End of variables declaration//GEN-END:variables
}
