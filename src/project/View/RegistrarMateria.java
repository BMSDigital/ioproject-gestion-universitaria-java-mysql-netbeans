package project.View;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;

public class RegistrarMateria extends javax.swing.JPanel
{
    project.Model.Asignatura asignatura;
    
    public RegistrarMateria()
    {
        initComponents();
        
        cargarCarreras();
        cargarSemestres();
    }    
    public void cargarCarreras()
    {
        java.util.ArrayList<project.Model.Carrera> carreras = project.Controller.Application.loadDbItems( new project.Model.Carrera() );
        ComboBoxModel model = new DefaultComboBoxModel<>();
        for( project.Model.Carrera c : carreras)
            ((DefaultComboBoxModel)model).addElement(c.getNombre());

        carreratxt.setModel(model);
    }
    public void cargarSemestres()
    {
        int cod_carrera = carreratxt.getSelectedIndex()+1;
        
        java.util.ArrayList<project.Model.Semestre> semestres = project.Controller.Application.loadDbItems( new project.Model.Semestre(), "cod_carrera", "" + cod_carrera );
        ComboBoxModel model = new DefaultComboBoxModel<>();
        for( project.Model.Semestre s : semestres )
            ((DefaultComboBoxModel)model).addElement(s.getNombre());
        
        semestretxt.setModel(model);
    }
    public boolean validarDatos()
    {
        return(true);
    }

    @SuppressWarnings( "unchecked" )
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCedula24 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lblCedula51 = new javax.swing.JLabel();
        nomtxt = new javax.swing.JTextField();
        lblCedula52 = new javax.swing.JLabel();
        lblCedula53 = new javax.swing.JLabel();
        practicatxt = new javax.swing.JSpinner();
        teoriatxt = new javax.swing.JSpinner();
        lblCedula54 = new javax.swing.JLabel();
        lblCedula55 = new javax.swing.JLabel();
        durpracticatxt = new javax.swing.JSpinner();
        lblCedula56 = new javax.swing.JLabel();
        lblCedula57 = new javax.swing.JLabel();
        lblCedula58 = new javax.swing.JLabel();
        uctxt = new javax.swing.JSpinner();
        jScrollPane1 = new javax.swing.JScrollPane();
        descripciontxt = new javax.swing.JTextArea();
        durteoriatxt = new javax.swing.JSpinner();
        lblCedula59 = new javax.swing.JLabel();
        carreratxt = new javax.swing.JComboBox();
        semestretxt = new javax.swing.JComboBox();
        finalizar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(480, 460));
        setMinimumSize(new java.awt.Dimension(480, 460));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(480, 460));

        lblCedula24.setBackground(new java.awt.Color( 255, 255, 255, 75 ));
        lblCedula24.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblCedula24.setForeground(new java.awt.Color(255, 255, 255));
        lblCedula24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCedula24.setText("REGISTRO DE ASIGNATURA");
        lblCedula24.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        lblCedula24.setOpaque(true);

        jPanel3.setBackground(new java.awt.Color( 255, 255, 255, 75 ));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        jPanel3.setDoubleBuffered(false);

        lblCedula51.setBackground(new java.awt.Color( 255, 255, 255, 75 ));
        lblCedula51.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCedula51.setForeground(new java.awt.Color(255, 255, 255));
        lblCedula51.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCedula51.setText("Nombre");
        lblCedula51.setOpaque(true);

        nomtxt.setToolTipText("");
        nomtxt.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        nomtxt.setFocusCycleRoot(true);

        lblCedula52.setBackground(new java.awt.Color( 255, 255, 255, 75 ));
        lblCedula52.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCedula52.setForeground(new java.awt.Color(255, 255, 255));
        lblCedula52.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCedula52.setText("Semestre");
        lblCedula52.setOpaque(true);

        lblCedula53.setBackground(new java.awt.Color( 255, 255, 255, 75 ));
        lblCedula53.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCedula53.setForeground(new java.awt.Color(255, 255, 255));
        lblCedula53.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCedula53.setText("Clases de práctica");
        lblCedula53.setOpaque(true);

        practicatxt.setModel(new javax.swing.SpinnerNumberModel(0, 0, 3, 1));

        teoriatxt.setModel(new javax.swing.SpinnerNumberModel(0, 0, 3, 1));

        lblCedula54.setBackground(new java.awt.Color( 255, 255, 255, 75 ));
        lblCedula54.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCedula54.setForeground(new java.awt.Color(255, 255, 255));
        lblCedula54.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCedula54.setText("Clases de teoría");
        lblCedula54.setOpaque(true);

        lblCedula55.setBackground(new java.awt.Color( 255, 255, 255, 75 ));
        lblCedula55.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCedula55.setForeground(new java.awt.Color(255, 255, 255));
        lblCedula55.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCedula55.setText("Horas de duración");
        lblCedula55.setOpaque(true);

        durpracticatxt.setModel(new javax.swing.SpinnerNumberModel(1, 1, 5, 1));

        lblCedula56.setBackground(new java.awt.Color( 255, 255, 255, 75 ));
        lblCedula56.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCedula56.setForeground(new java.awt.Color(255, 255, 255));
        lblCedula56.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCedula56.setText("Horas de duración");
        lblCedula56.setOpaque(true);

        lblCedula57.setBackground(new java.awt.Color( 255, 255, 255, 75 ));
        lblCedula57.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCedula57.setForeground(new java.awt.Color(255, 255, 255));
        lblCedula57.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCedula57.setText("Descripción");
        lblCedula57.setOpaque(true);

        lblCedula58.setBackground(new java.awt.Color( 255, 255, 255, 75 ));
        lblCedula58.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCedula58.setForeground(new java.awt.Color(255, 255, 255));
        lblCedula58.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCedula58.setText("Unidades de crédito");
        lblCedula58.setOpaque(true);

        uctxt.setModel(new javax.swing.SpinnerNumberModel(1, 1, 10, 1));
        uctxt.setEditor(new javax.swing.JSpinner.NumberEditor(uctxt, ""));

        descripciontxt.setColumns(20);
        descripciontxt.setRows(5);
        jScrollPane1.setViewportView(descripciontxt);

        durteoriatxt.setModel(new javax.swing.SpinnerNumberModel(1, 1, 5, 1));

        lblCedula59.setBackground(new java.awt.Color( 255, 255, 255, 75 ));
        lblCedula59.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCedula59.setForeground(new java.awt.Color(255, 255, 255));
        lblCedula59.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCedula59.setText("Carrera");
        lblCedula59.setOpaque(true);

        carreratxt.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        carreratxt.setOpaque(false);
        carreratxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carreratxtActionPerformed(evt);
            }
        });

        semestretxt.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        semestretxt.setOpaque(false);
        semestretxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                semestretxtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCedula58)
                            .addComponent(lblCedula51, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(lblCedula53, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblCedula54, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                                .addComponent(teoriatxt, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblCedula56, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(durteoriatxt, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(uctxt, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(practicatxt, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lblCedula55, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(durpracticatxt, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(nomtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(carreratxt, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(semestretxt, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE))))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCedula52, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCedula57, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCedula59, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCedula51)
                    .addComponent(nomtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCedula57)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 13, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCedula59)
                    .addComponent(carreratxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCedula52)
                    .addComponent(semestretxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCedula58)
                    .addComponent(uctxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCedula53)
                    .addComponent(practicatxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCedula55)
                    .addComponent(durpracticatxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCedula54)
                    .addComponent(teoriatxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCedula56)
                    .addComponent(durteoriatxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        finalizar.setBackground(new java.awt.Color( 255, 255, 255, 125 ));
        finalizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Themes/Razor/finish.png"))); // NOI18N
        finalizar.setText("Registrar");
        finalizar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        finalizar.setContentAreaFilled(false);
        finalizar.setOpaque(true);
        finalizar.setPreferredSize(new java.awt.Dimension(100, 25));
        finalizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                finalizarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                finalizarMouseExited(evt);
            }
        });
        finalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finalizarActionPerformed(evt);
            }
        });

        cancelar.setBackground(new java.awt.Color( 255, 255, 255, 125 ));
        cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Themes/Razor/cancel.png"))); // NOI18N
        cancelar.setText("Cancelar");
        cancelar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        cancelar.setContentAreaFilled(false);
        cancelar.setOpaque(true);
        cancelar.setPreferredSize(new java.awt.Dimension(100, 25));
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(finalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblCedula24, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(lblCedula24, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(finalizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void finalizarMouseEntered(java.awt.event.MouseEvent evt)//GEN-FIRST:event_finalizarMouseEntered
    {//GEN-HEADEREND:event_finalizarMouseEntered
        finalizar.setBackground( new java.awt.Color( 255, 255, 255, 175 ) );
        project.Controller.Application.repaintScreen();
    }//GEN-LAST:event_finalizarMouseEntered

    private void finalizarMouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_finalizarMouseExited
    {//GEN-HEADEREND:event_finalizarMouseExited
        finalizar.setBackground( new java.awt.Color( 255, 255, 255, 125 ) );
        project.Controller.Application.repaintScreen();
    }//GEN-LAST:event_finalizarMouseExited

    private void cancelarMouseEntered(java.awt.event.MouseEvent evt)//GEN-FIRST:event_cancelarMouseEntered
    {//GEN-HEADEREND:event_cancelarMouseEntered
        cancelar.setBackground( new java.awt.Color( 255, 255, 255, 175 ) );
        project.Controller.Application.repaintScreen();
    }//GEN-LAST:event_cancelarMouseEntered

    private void cancelarMouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_cancelarMouseExited
    {//GEN-HEADEREND:event_cancelarMouseExited
        cancelar.setBackground( new java.awt.Color( 255, 255, 255, 125 ) );
        project.Controller.Application.repaintScreen();
    }//GEN-LAST:event_cancelarMouseExited

    private void finalizarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_finalizarActionPerformed
    {//GEN-HEADEREND:event_finalizarActionPerformed
        if( validarDatos() )
        {
            asignatura = new project.Model.Asignatura();
            asignatura.setNombre(nomtxt.getText());
            asignatura.setDescripcion(descripciontxt.getText());
            asignatura.setTeoricas(Integer.parseInt( "" + teoriatxt.getValue()));
            asignatura.setDuracionTeoricas(Integer.parseInt( "" + durteoriatxt.getValue()));
            asignatura.setPracticas( Integer.parseInt( "" + practicatxt.getValue()));
            asignatura.setDuracionPracticas( Integer.parseInt( "" + durpracticatxt.getValue()));
            asignatura.setSemestre( semestretxt.getSelectedIndex()+1 );
            asignatura.setCarrera( carreratxt.getSelectedIndex()+1 );
            asignatura.setCreditos((int)uctxt.getValue());
            
            if( project.Controller.Application.onRegisterMateria(asignatura) == true )
            {
                project.Controller.Application.showMessageDialog( "Se ha registrado la asignatura con éxito" );
            }
            else
                project.Controller.Application.showSqlErrorMessageDialog();
        }
    }//GEN-LAST:event_finalizarActionPerformed

    private void carreratxtActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_carreratxtActionPerformed
    {//GEN-HEADEREND:event_carreratxtActionPerformed
        cargarSemestres();
    }//GEN-LAST:event_carreratxtActionPerformed

    private void semestretxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_semestretxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_semestretxtActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
project.Controller.Application.callMainOption(new Welcome());        // TODO add your handling code here:
    }//GEN-LAST:event_cancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelar;
    private javax.swing.JComboBox carreratxt;
    private javax.swing.JTextArea descripciontxt;
    private javax.swing.JSpinner durpracticatxt;
    private javax.swing.JSpinner durteoriatxt;
    private javax.swing.JButton finalizar;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCedula24;
    private javax.swing.JLabel lblCedula51;
    private javax.swing.JLabel lblCedula52;
    private javax.swing.JLabel lblCedula53;
    private javax.swing.JLabel lblCedula54;
    private javax.swing.JLabel lblCedula55;
    private javax.swing.JLabel lblCedula56;
    private javax.swing.JLabel lblCedula57;
    private javax.swing.JLabel lblCedula58;
    private javax.swing.JLabel lblCedula59;
    private javax.swing.JTextField nomtxt;
    private javax.swing.JSpinner practicatxt;
    private javax.swing.JComboBox semestretxt;
    private javax.swing.JSpinner teoriatxt;
    private javax.swing.JSpinner uctxt;
    // End of variables declaration//GEN-END:variables
}
