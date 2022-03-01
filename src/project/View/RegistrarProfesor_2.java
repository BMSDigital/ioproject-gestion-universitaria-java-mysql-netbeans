/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package project.View;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import project.Model.Profesor;

  
public class RegistrarProfesor_2 extends javax.swing.JPanel {

    project.Model.Profesor profesor;
    
    public RegistrarProfesor_2() 
    {
        initComponents();
        
        JComboBox comboBox = new JComboBox( new String[] { "PADRE", "MADRE", "HIJO" } );
        DefaultCellEditor defaultCellEditor=new DefaultCellEditor(comboBox);
        familiatable.getColumnModel().getColumn(4).setCellEditor(defaultCellEditor);
        
        comboBox = new JComboBox( new String[] { "MASCULINO", "FEMENINO" } );
        defaultCellEditor = new DefaultCellEditor(comboBox);
        familiatable.getColumnModel().getColumn(5).setCellEditor(defaultCellEditor);
    }

    public boolean validarDatos()
    {
        return(true);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCedula24 = new javax.swing.JLabel();
        previous = new javax.swing.JButton();
        nextbtn = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        familiatable = new javax.swing.JTable();
        addbtn = new javax.swing.JButton();
        delbtn = new javax.swing.JButton();
        cancelbtn = new javax.swing.JButton();

        setBackground(new java.awt.Color( 255, 255, 255, 50 )
        );
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setDoubleBuffered(false);
        setMaximumSize(new java.awt.Dimension(856, 440));
        setMinimumSize(new java.awt.Dimension(856, 440));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(856, 440));

        lblCedula24.setBackground(new java.awt.Color( 255, 255, 255, 75 ));
        lblCedula24.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblCedula24.setForeground(new java.awt.Color(255, 255, 255));
        lblCedula24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCedula24.setText("REGISTRO DE PROFESOR");
        lblCedula24.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        lblCedula24.setOpaque(true);

        previous.setBackground(new java.awt.Color( 255, 255, 255, 125 ));
        previous.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        previous.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Themes/Razor/previous.png"))); // NOI18N
        previous.setText("Anterior");
        previous.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        previous.setContentAreaFilled(false);
        previous.setOpaque(true);
        previous.setPreferredSize(new java.awt.Dimension(100, 25));
        previous.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                previousMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                previousMouseExited(evt);
            }
        });
        previous.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previousActionPerformed(evt);
            }
        });

        nextbtn.setBackground(new java.awt.Color( 255, 255, 255, 125 ));
        nextbtn.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        nextbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Themes/Razor/next.png"))); // NOI18N
        nextbtn.setText("Siguiente");
        nextbtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        nextbtn.setContentAreaFilled(false);
        nextbtn.setOpaque(true);
        nextbtn.setPreferredSize(new java.awt.Dimension(100, 25));
        nextbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                nextbtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                nextbtnMouseExited(evt);
            }
        });
        nextbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextbtnActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color( 255, 255, 255, 50 ));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true), "Datos Familiares", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 20), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel5.setDoubleBuffered(false);

        familiatable.setAutoCreateRowSorter(true);
        familiatable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombres", "Apellidos", "Cédula", "Fecha de nacimiento", "Parentesco", "Sexo", "Grado de instrucción"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        familiatable.setColumnSelectionAllowed(true);
        familiatable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        familiatable.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(familiatable);
        familiatable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        addbtn.setBackground(new java.awt.Color( 255, 255, 255, 125 ));
        addbtn.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        addbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Themes/Razor/add.png"))); // NOI18N
        addbtn.setText("Agregar");
        addbtn.setToolTipText("Haz click para agregar un familiar");
        addbtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        addbtn.setContentAreaFilled(false);
        addbtn.setOpaque(true);
        addbtn.setPreferredSize(new java.awt.Dimension(100, 25));
        addbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addbtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addbtnMouseExited(evt);
            }
        });
        addbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addbtnActionPerformed(evt);
            }
        });

        delbtn.setBackground(new java.awt.Color( 255, 255, 255, 125 ));
        delbtn.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        delbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Themes/Razor/del.png"))); // NOI18N
        delbtn.setText("Eliminar");
        delbtn.setToolTipText("Haz click para eliminar un familiar");
        delbtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        delbtn.setContentAreaFilled(false);
        delbtn.setOpaque(true);
        delbtn.setPreferredSize(new java.awt.Dimension(100, 25));
        delbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                delbtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                delbtnMouseExited(evt);
            }
        });
        delbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(delbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(delbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        cancelbtn.setBackground(new java.awt.Color( 255, 255, 255, 125 ));
        cancelbtn.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        cancelbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Themes/Razor/cancel.png"))); // NOI18N
        cancelbtn.setText("Cancelar");
        cancelbtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        cancelbtn.setContentAreaFilled(false);
        cancelbtn.setOpaque(true);
        cancelbtn.setPreferredSize(new java.awt.Dimension(100, 25));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lblCedula24, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cancelbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(previous, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nextbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(lblCedula24, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nextbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(previous, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(57, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void previousMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_previousMouseExited
        previous.setBackground( new java.awt.Color( 255, 255, 255, 125 ) );
        project.Controller.Application.repaintScreen();
    }//GEN-LAST:event_previousMouseExited

    private void previousMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_previousMouseEntered
        previous.setBackground( new java.awt.Color( 255, 255, 255, 175 ) );
        project.Controller.Application.repaintScreen();
    }//GEN-LAST:event_previousMouseEntered

    private void nextbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextbtnActionPerformed
        if( validarDatos() == true )
        {
            int cantidadFamiliares = familiatable.getRowCount();
            if( cantidadFamiliares > 0 )
            {
                project.Model.Familiar[] familiares = new project.Model.Familiar[cantidadFamiliares];
                for( int i = 0; i < cantidadFamiliares; ++i )
                {
                    familiares[i] = new project.Model.Familiar();
                    
                    familiares[i].setNombre( "" + familiatable.getValueAt(i, 0) );
                    familiares[i].setApellido( "" + familiatable.getValueAt(i, 1) );
                    familiares[i].setCedula( "" + familiatable.getValueAt(i, 2) );
                    familiares[i].setNacimiento( "" + familiatable.getValueAt(i, 3) );
                    familiares[i].setParentesco( "" + familiatable.getValueAt(i, 4) );
                    familiares[i].setSexo( "" + familiatable.getValueAt(i, 5) );
                    familiares[i].setGradoInstruccion( "" + familiatable.getValueAt(i, 6) );
                }
                
                profesor.setFamiliares(familiares);
            }
            
            RegistrarProfesor_3 o = new RegistrarProfesor_3();
            o.setProfesor(profesor);
            
            project.Controller.Application.callMainOption(o);
        }
    }//GEN-LAST:event_nextbtnActionPerformed

    private void nextbtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nextbtnMouseExited
        nextbtn.setBackground( new java.awt.Color( 255, 255, 255, 125 ) );
        project.Controller.Application.repaintScreen();
    }//GEN-LAST:event_nextbtnMouseExited

    private void nextbtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nextbtnMouseEntered
        nextbtn.setBackground( new java.awt.Color( 255, 255, 255, 175 ) );
        project.Controller.Application.repaintScreen();
    }//GEN-LAST:event_nextbtnMouseEntered

    private void addbtnMouseEntered(java.awt.event.MouseEvent evt)//GEN-FIRST:event_addbtnMouseEntered
    {//GEN-HEADEREND:event_addbtnMouseEntered
        addbtn.setBackground( new java.awt.Color( 255, 255, 255, 200 ) );
        project.Controller.Application.repaintScreen();
    }//GEN-LAST:event_addbtnMouseEntered

    private void addbtnMouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_addbtnMouseExited
    {//GEN-HEADEREND:event_addbtnMouseExited
        addbtn.setBackground( new java.awt.Color( 255, 255, 255, 125 ) );
        project.Controller.Application.repaintScreen();
    }//GEN-LAST:event_addbtnMouseExited

    private void addbtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_addbtnActionPerformed
    {//GEN-HEADEREND:event_addbtnActionPerformed
        DefaultTableModel model = ( DefaultTableModel ) familiatable.getModel();
        model.addRow((Object[])null);
    }//GEN-LAST:event_addbtnActionPerformed

    private void delbtnMouseEntered(java.awt.event.MouseEvent evt)//GEN-FIRST:event_delbtnMouseEntered
    {//GEN-HEADEREND:event_delbtnMouseEntered
        delbtn.setBackground( new java.awt.Color( 255, 255, 255, 200 ) );
        project.Controller.Application.repaintScreen();
    }//GEN-LAST:event_delbtnMouseEntered

    private void delbtnMouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_delbtnMouseExited
    {//GEN-HEADEREND:event_delbtnMouseExited
        delbtn.setBackground( new java.awt.Color( 255, 255, 255, 125 ) );
        project.Controller.Application.repaintScreen();
    }//GEN-LAST:event_delbtnMouseExited

    private void delbtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_delbtnActionPerformed
    {//GEN-HEADEREND:event_delbtnActionPerformed
        DefaultTableModel model = ( DefaultTableModel ) familiatable.getModel();
        if( familiatable.getSelectedRow() >= 0 )
            model.removeRow(familiatable.getSelectedRow());
    }//GEN-LAST:event_delbtnActionPerformed

    private void previousActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_previousActionPerformed
    {//GEN-HEADEREND:event_previousActionPerformed
        RegistrarProfesor_1 o = new RegistrarProfesor_1();
        o.setProfesor(profesor);
        
        project.Controller.Application.callMainOption(o);
    }//GEN-LAST:event_previousActionPerformed

    public Profesor getProfesor()
    {
        return profesor;
    }
    public void setProfesor(Profesor profesor)
    {
        this.profesor = profesor;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addbtn;
    private javax.swing.JButton cancelbtn;
    private javax.swing.JButton delbtn;
    private javax.swing.JTable familiatable;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCedula24;
    private javax.swing.JButton nextbtn;
    private javax.swing.JButton previous;
    // End of variables declaration//GEN-END:variables
}
