package project.View;

import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import project.Model.Profesor;

public class RegistrarProfesor_3 extends javax.swing.JPanel
{
    project.Model.Profesor profesor;

    public RegistrarProfesor_3()
    {
        initComponents();
    }
    public boolean validarDatos()
    {
        return(true);
    }

    @SuppressWarnings( "unchecked" )
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jPanel5 = new javax.swing.JPanel();
        lblCedula47 = new javax.swing.JLabel();
        lblCedula51 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        titulostxt = new javax.swing.JTextArea();
        profesiontxt = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        especialidadtxt = new javax.swing.JTextArea();
        lblCedula53 = new javax.swing.JLabel();
        lblCedula24 = new javax.swing.JLabel();
        nextbtn = new javax.swing.JButton();
        previous = new javax.swing.JButton();
        cancelbtn = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        lblCedula54 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        catedrastxt = new javax.swing.JTextArea();
        lblCedula56 = new javax.swing.JLabel();
        contratotxt = new javax.swing.JComboBox();
        ingresotxt = new javax.swing.JFormattedTextField();
        lblCedula55 = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(500, 600));
        setMinimumSize(new java.awt.Dimension(500, 600));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(500, 600));

        jPanel5.setBackground(new java.awt.Color( 255, 255, 255, 50 ));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true), "Datos Académicos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 20), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel5.setDoubleBuffered(false);

        lblCedula47.setBackground(new java.awt.Color( 255, 255, 255, 75 ));
        lblCedula47.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCedula47.setForeground(new java.awt.Color(255, 255, 255));
        lblCedula47.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCedula47.setText("Profesión");
        lblCedula47.setOpaque(true);

        lblCedula51.setBackground(new java.awt.Color( 255, 255, 255, 75 ));
        lblCedula51.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCedula51.setForeground(new java.awt.Color(255, 255, 255));
        lblCedula51.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCedula51.setText("Títulos obtenidos");
        lblCedula51.setOpaque(true);

        titulostxt.setColumns(20);
        titulostxt.setRows(5);
        jScrollPane2.setViewportView(titulostxt);

        profesiontxt.setToolTipText("");
        profesiontxt.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        profesiontxt.setFocusCycleRoot(true);

        especialidadtxt.setColumns(20);
        especialidadtxt.setRows(5);
        jScrollPane1.setViewportView(especialidadtxt);

        lblCedula53.setBackground(new java.awt.Color( 255, 255, 255, 75 ));
        lblCedula53.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCedula53.setForeground(new java.awt.Color(255, 255, 255));
        lblCedula53.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCedula53.setText("Especialidades");
        lblCedula53.setOpaque(true);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(lblCedula53, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCedula51, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCedula47, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(profesiontxt)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(26, 26, 26))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCedula47)
                    .addComponent(profesiontxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCedula51)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCedula53))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        lblCedula24.setBackground(new java.awt.Color( 255, 255, 255, 75 ));
        lblCedula24.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblCedula24.setForeground(new java.awt.Color(255, 255, 255));
        lblCedula24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCedula24.setText("REGISTRO DE PROFESOR");
        lblCedula24.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        lblCedula24.setOpaque(true);

        nextbtn.setBackground(new java.awt.Color( 255, 255, 255, 125 ));
        nextbtn.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        nextbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Themes/Razor/next.png"))); // NOI18N
        nextbtn.setText("Siguiente");
        nextbtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        nextbtn.setContentAreaFilled(false);
        nextbtn.setOpaque(true);
        nextbtn.setPreferredSize(new java.awt.Dimension(100, 25));
        nextbtn.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseEntered(java.awt.event.MouseEvent evt)
            {
                nextbtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt)
            {
                nextbtnMouseExited(evt);
            }
        });
        nextbtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                nextbtnActionPerformed(evt);
            }
        });

        previous.setBackground(new java.awt.Color( 255, 255, 255, 125 ));
        previous.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        previous.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Themes/Razor/previous.png"))); // NOI18N
        previous.setText("Anterior");
        previous.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        previous.setContentAreaFilled(false);
        previous.setOpaque(true);
        previous.setPreferredSize(new java.awt.Dimension(100, 25));
        previous.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseEntered(java.awt.event.MouseEvent evt)
            {
                previousMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt)
            {
                previousMouseExited(evt);
            }
        });
        previous.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                previousActionPerformed(evt);
            }
        });

        cancelbtn.setBackground(new java.awt.Color( 255, 255, 255, 125 ));
        cancelbtn.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        cancelbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Themes/Razor/cancel.png"))); // NOI18N
        cancelbtn.setText("Cancelar");
        cancelbtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        cancelbtn.setContentAreaFilled(false);
        cancelbtn.setOpaque(true);
        cancelbtn.setPreferredSize(new java.awt.Dimension(100, 25));

        jPanel6.setBackground(new java.awt.Color( 255, 255, 255, 50 ));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true), "Historia en la Unefa", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 20), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel6.setDoubleBuffered(false);

        lblCedula54.setBackground(new java.awt.Color( 255, 255, 255, 75 ));
        lblCedula54.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCedula54.setForeground(new java.awt.Color(255, 255, 255));
        lblCedula54.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCedula54.setText("Tipo de contrato");
        lblCedula54.setOpaque(true);

        catedrastxt.setColumns(20);
        catedrastxt.setRows(5);
        jScrollPane6.setViewportView(catedrastxt);

        lblCedula56.setBackground(new java.awt.Color( 255, 255, 255, 75 ));
        lblCedula56.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCedula56.setForeground(new java.awt.Color(255, 255, 255));
        lblCedula56.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCedula56.setText("<html><center>Cátedras que ha impartido</center></html>");
        lblCedula56.setOpaque(true);

        contratotxt.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "TV", "MT" }));
        contratotxt.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        contratotxt.setOpaque(false);

        ingresotxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        ingresotxt.setForeground(new java.awt.Color(204, 204, 204));
        ingresotxt.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));
        ingresotxt.setText(" Ejemplo: 08/08/1996");
        ingresotxt.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        ingresotxt.setMaximumSize(new java.awt.Dimension(6, 20));
        ingresotxt.setName("nacimientohint"); // NOI18N
        ingresotxt.setPreferredSize(new java.awt.Dimension(6, 20));
        ingresotxt.addFocusListener(new java.awt.event.FocusAdapter()
        {
            public void focusLost(java.awt.event.FocusEvent evt)
            {
                ingresotxtFocusLost(evt);
            }
        });
        ingresotxt.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                ingresotxtMouseClicked(evt);
            }
        });
        ingresotxt.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                ingresotxtValidarCrtShib(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt)
            {
                ingresotxtValidarFechaNacimiento(evt);
            }
        });

        lblCedula55.setBackground(new java.awt.Color( 255, 255, 255, 75 ));
        lblCedula55.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCedula55.setForeground(new java.awt.Color(255, 255, 255));
        lblCedula55.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCedula55.setText("Fecha de ingreso");
        lblCedula55.setOpaque(true);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCedula55, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCedula56, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCedula54, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(contratotxt, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ingresotxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE))
                .addGap(21, 21, 21))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(ingresotxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(contratotxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(lblCedula55)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCedula56, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblCedula54)))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cancelbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(previous, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nextbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(50, 50, 50)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblCedula24, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(lblCedula24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nextbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(previous, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(59, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void nextbtnMouseEntered(java.awt.event.MouseEvent evt)//GEN-FIRST:event_nextbtnMouseEntered
    {//GEN-HEADEREND:event_nextbtnMouseEntered
        nextbtn.setBackground( new java.awt.Color( 255, 255, 255, 175 ) );
        project.Controller.Application.repaintScreen();
    }//GEN-LAST:event_nextbtnMouseEntered

    private void nextbtnMouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_nextbtnMouseExited
    {//GEN-HEADEREND:event_nextbtnMouseExited
        nextbtn.setBackground( new java.awt.Color( 255, 255, 255, 125 ) );
        project.Controller.Application.repaintScreen();
    }//GEN-LAST:event_nextbtnMouseExited

    private void nextbtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_nextbtnActionPerformed
    {//GEN-HEADEREND:event_nextbtnActionPerformed
        if(validarDatos())
        {
            profesor.setProfesion(profesiontxt.getText());
            profesor.setTitulos(titulostxt.getText());
            profesor.setEspecialidades( especialidadtxt.getText() );
            profesor.setFechaIngreso( ingresotxt.getText() );
            profesor.setCatedras(catedrastxt.getText());
            profesor.setTipoContrato( "" + contratotxt.getSelectedItem() );
            
            RegistrarProfesor_4 o = new RegistrarProfesor_4();
            o.setProfesor(profesor);
        
            project.Controller.Application.callMainOption(o);
        }
    }//GEN-LAST:event_nextbtnActionPerformed

    private void previousMouseEntered(java.awt.event.MouseEvent evt)//GEN-FIRST:event_previousMouseEntered
    {//GEN-HEADEREND:event_previousMouseEntered
        previous.setBackground( new java.awt.Color( 255, 255, 255, 175 ) );
        project.Controller.Application.repaintScreen();
    }//GEN-LAST:event_previousMouseEntered

    private void previousMouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_previousMouseExited
    {//GEN-HEADEREND:event_previousMouseExited
        previous.setBackground( new java.awt.Color( 255, 255, 255, 125 ) );
        project.Controller.Application.repaintScreen();
    }//GEN-LAST:event_previousMouseExited

    private void previousActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_previousActionPerformed
    {//GEN-HEADEREND:event_previousActionPerformed
        RegistrarProfesor_2 o = new RegistrarProfesor_2();
        o.setProfesor(profesor);
        
        project.Controller.Application.callMainOption(o);
    }//GEN-LAST:event_previousActionPerformed

    private void ingresotxtFocusLost(java.awt.event.FocusEvent evt)//GEN-FIRST:event_ingresotxtFocusLost
    {//GEN-HEADEREND:event_ingresotxtFocusLost
        if( ingresotxt.getText().length() == 0 )
        {
            ingresotxt.setFont( new java.awt.Font( "Tahoma", java.awt.Font.ITALIC, 11) );
            ingresotxt.setForeground( new java.awt.Color( 204,204,204 ) );
            ingresotxt.setText("   Ejemplo: 08/08/1996");
            ingresotxt.setName("nacimientohint");
        }
    }//GEN-LAST:event_ingresotxtFocusLost

    private void ingresotxtMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_ingresotxtMouseClicked
    {//GEN-HEADEREND:event_ingresotxtMouseClicked
        if( ingresotxt.getName().equals("nacimientohint") )
        {
            ingresotxt.setFont( new java.awt.Font( "Tahoma", java.awt.Font.PLAIN, 11) );
            ingresotxt.setForeground( new java.awt.Color( 0, 0, 0 ) );
            ingresotxt.setText("");
            ingresotxt.setName("nacimientonohint");
        }
    }//GEN-LAST:event_ingresotxtMouseClicked

    private void ingresotxtValidarCrtShib(java.awt.event.KeyEvent evt)//GEN-FIRST:event_ingresotxtValidarCrtShib
    {//GEN-HEADEREND:event_ingresotxtValidarCrtShib
        // TODO add your handling code here:
        if(evt.isControlDown() || evt.isControlDown())
        {
            Toolkit.getDefaultToolkit().beep();
            evt.consume();
        }
        if(evt.isAltDown()|| evt.isAltDown())
        {
            Toolkit.getDefaultToolkit().beep();
            evt.consume();
        }

        if(evt.isShiftDown() || evt.isShiftDown())
        {
            Toolkit.getDefaultToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_ingresotxtValidarCrtShib

    private void ingresotxtValidarFechaNacimiento(java.awt.event.KeyEvent evt)//GEN-FIRST:event_ingresotxtValidarFechaNacimiento
    {//GEN-HEADEREND:event_ingresotxtValidarFechaNacimiento
        // TODO add your handling code here:
        int k = (int) evt.getKeyChar();
        char c = evt.getKeyChar();
        if((k >= 97 && k <= 122) || (k >= 65 && k <= 90))
        {
            evt.setKeyChar((char)KeyEvent.VK_CLEAR);
            JOptionPane.showMessageDialog(null, "No puedes ingresar letras","Advertencia",JOptionPane.INFORMATION_MESSAGE);
        }

        if((k >= 32 && k <= 46) || (k >= 58 && k <= 64) || (k >= 91 && k <= 96) || (k >= 123 && k <= 126))
        {
            Toolkit.getDefaultToolkit().beep();
            evt.setKeyChar((char)KeyEvent.VK_CLEAR);
            JOptionPane.showMessageDialog(null, "No puedes ingresar caracteres especiales!!!","Advertencia",JOptionPane.INFORMATION_MESSAGE);
        }
        //para validar caracteres raros que no se puede validar normalmente
        if((c == '?')||(c == '¡') ||(c == 'ñ')||(c == 'Ñ') || (c == '´')||(c == 'ç') ||  (c == 'º')||(c == 'ª') || (c == '·')||(c == '☺'))
        {
            Toolkit.getDefaultToolkit().beep();
            evt.setKeyChar((char)KeyEvent.VK_CLEAR);
            JOptionPane.showMessageDialog(null, "No puedes ingresar caracteres especiales","Advertencia",JOptionPane.INFORMATION_MESSAGE);
        }

        if (k == 10) {//si se presiona enter
            //transfiere el foco
            ingresotxt.transferFocus();
        }

        if(ingresotxt.getText().length() >= 10)
        {
            evt.setKeyChar((char)KeyEvent.VK_CLEAR);
            JOptionPane.showMessageDialog(null,"Ha excedido el numero maximo de caracter","Advertencia",JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_ingresotxtValidarFechaNacimiento

    public Profesor getProfesor()
    {
        return profesor;
    }
    public void setProfesor(Profesor profesor)
    {
        this.profesor = profesor;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelbtn;
    private javax.swing.JTextArea catedrastxt;
    private javax.swing.JComboBox contratotxt;
    private javax.swing.JTextArea especialidadtxt;
    private javax.swing.JFormattedTextField ingresotxt;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JLabel lblCedula24;
    private javax.swing.JLabel lblCedula47;
    private javax.swing.JLabel lblCedula51;
    private javax.swing.JLabel lblCedula53;
    private javax.swing.JLabel lblCedula54;
    private javax.swing.JLabel lblCedula55;
    private javax.swing.JLabel lblCedula56;
    private javax.swing.JButton nextbtn;
    private javax.swing.JButton previous;
    private javax.swing.JTextField profesiontxt;
    private javax.swing.JTextArea titulostxt;
    // End of variables declaration//GEN-END:variables
}
