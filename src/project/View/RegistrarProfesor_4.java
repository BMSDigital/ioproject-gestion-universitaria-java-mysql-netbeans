/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.View;

import java.awt.HeadlessException;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import project.Model.Profesor;
public class RegistrarProfesor_4 extends javax.swing.JPanel
{

    String imageString;
    project.Model.Profesor profesor;
    boolean imageLoaded = false;

    public RegistrarProfesor_4()
    {
        initComponents();
    }

    public boolean validarDatos()
    {
        return (true);
    }

    @SuppressWarnings( "unchecked" )
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        lblCedula24 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        examinar = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        pic = new javax.swing.JLabel();
        finishbtn = new javax.swing.JButton();
        previous = new javax.swing.JButton();
        cancelbtn = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(420, 420));
        setMinimumSize(new java.awt.Dimension(420, 420));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(420, 420));

        lblCedula24.setBackground(new java.awt.Color( 255, 255, 255, 75 ));
        lblCedula24.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblCedula24.setForeground(new java.awt.Color(255, 255, 255));
        lblCedula24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCedula24.setText("REGISTRO DE PROFESOR");
        lblCedula24.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        lblCedula24.setOpaque(true);

        jPanel5.setBackground(new java.awt.Color( 255, 255, 255, 50 ));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true), "Cargar Fotografía", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 20), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel5.setDoubleBuffered(false);

        examinar.setBackground(new java.awt.Color( 255, 255, 255, 125 ));
        examinar.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        examinar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Themes/Razor/search.png"))); // NOI18N
        examinar.setText("Examinar");
        examinar.setToolTipText("Haz click para agregar un familiar");
        examinar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        examinar.setContentAreaFilled(false);
        examinar.setOpaque(true);
        examinar.setPreferredSize(new java.awt.Dimension(100, 25));
        examinar.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseEntered(java.awt.event.MouseEvent evt)
            {
                examinarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt)
            {
                examinarMouseExited(evt);
            }
        });
        examinar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                examinarActionPerformed(evt);
            }
        });

        jPanel6.setBackground(new java.awt.Color( 255, 255, 255, 50 ));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 24), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel6.setDoubleBuffered(false);
        jPanel6.setMaximumSize(new java.awt.Dimension(128, 128));
        jPanel6.setMinimumSize(new java.awt.Dimension(128, 128));
        jPanel6.setPreferredSize(new java.awt.Dimension(128, 128));

        pic.setText(" ");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pic, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pic, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(examinar, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(85, 85, 85))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(examinar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        finishbtn.setBackground(new java.awt.Color( 255, 255, 255, 125 ));
        finishbtn.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        finishbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Themes/Razor/finish.png"))); // NOI18N
        finishbtn.setText("Finalizar");
        finishbtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        finishbtn.setContentAreaFilled(false);
        finishbtn.setOpaque(true);
        finishbtn.setPreferredSize(new java.awt.Dimension(100, 25));
        finishbtn.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseEntered(java.awt.event.MouseEvent evt)
            {
                finishbtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt)
            {
                finishbtnMouseExited(evt);
            }
        });
        finishbtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                finishbtnActionPerformed(evt);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lblCedula24, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cancelbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(previous, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(finishbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(lblCedula24)
                .addGap(10, 10, 10)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(finishbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(previous, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(61, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void examinarMouseEntered(java.awt.event.MouseEvent evt)//GEN-FIRST:event_examinarMouseEntered
    {//GEN-HEADEREND:event_examinarMouseEntered
        examinar.setBackground(new java.awt.Color(255, 255, 255, 200));
        project.Controller.Application.repaintScreen();
    }//GEN-LAST:event_examinarMouseEntered

    private void examinarMouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_examinarMouseExited
    {//GEN-HEADEREND:event_examinarMouseExited
        examinar.setBackground(new java.awt.Color(255, 255, 255, 125));
        project.Controller.Application.repaintScreen();
    }//GEN-LAST:event_examinarMouseExited

    private void examinarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_examinarActionPerformed
    {//GEN-HEADEREND:event_examinarActionPerformed
        try
        {
            JFileChooser chooser = new JFileChooser();
            chooser.setFileFilter(new FileNameExtensionFilter("Imágenes", "jpg", "png", "bmp", "gif"));
            int opcion = chooser.showDialog(this, "Seleccionar");
            if( opcion == JFileChooser.APPROVE_OPTION )
            {
                File file = chooser.getSelectedFile();
                if( file != null )
                {

                }
            }
            imageLoaded = true;
        }
        catch( Exception e )
        {
            project.Controller.Application.showMessageDialog("No pudo cargarse el archivo");
            imageLoaded = false;
        }
    }//GEN-LAST:event_examinarActionPerformed

    private void finishbtnMouseEntered(java.awt.event.MouseEvent evt)//GEN-FIRST:event_finishbtnMouseEntered
    {//GEN-HEADEREND:event_finishbtnMouseEntered
        finishbtn.setBackground(new java.awt.Color(255, 255, 255, 175));
        project.Controller.Application.repaintScreen();
    }//GEN-LAST:event_finishbtnMouseEntered

    private void finishbtnMouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_finishbtnMouseExited
    {//GEN-HEADEREND:event_finishbtnMouseExited
        finishbtn.setBackground(new java.awt.Color(255, 255, 255, 125));
        project.Controller.Application.repaintScreen();
    }//GEN-LAST:event_finishbtnMouseExited

    private void finishbtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_finishbtnActionPerformed
    {//GEN-HEADEREND:event_finishbtnActionPerformed
        if( validarDatos() )
        {
            profesor.setFoto(imageString);

            /*Se procede a registrar al profesor en la base de datos*/
            java.util.ArrayList registrados = project.Controller.Application.loadDbItems(profesor, "cedula", profesor.getCedula());
            if( registrados == null || registrados.isEmpty() )
            {
                if( profesor.getStatus() == 0 )
                    profesor.setStatus('a');
                
                boolean res = project.Controller.Application.onRegisterProfesor(profesor);
                if( res )
                {
                    project.Controller.Application.showMessageDialog("Registro completado", "Se ha registrado el profesor con éxito", 3, new String[]
                    {
                        "Aceptar"
                    }, new String[]
                    {
                        "Accept"
                    });
                }
                else
                {
                    project.Controller.Application.showSqlErrorMessageDialog();
                    return;
                }
            }
            else
            {
                project.Controller.Application.showMessageDialog("Se ha producido un error", "Ya existe el número de cédula", 1, new String[]
                {
                    "Aceptar"
                }, new String[]
                {
                    "accept"
                });
                return;
            }
            /* Se pregunta si se desea registrar el horario del profesor */
            int res = project.Controller.Application.showMessageDialog("Registrar horario", "¿Desea registrar el horario del profesor ahora?", 2, new String[]
            {
                "Tal vez más tarde", "Aceptar"
            }, new String[]
            {
                "cancel", "accept"
            });
            if( res == 2 )
            {
                RegistrarProfesor_5 o = new RegistrarProfesor_5();
                o.setProfesor(profesor);
                
                project.Controller.Application.callMainOption(o);
            }
            else
            {
                project.Controller.Application.callInicio();
            }
        }
    }//GEN-LAST:event_finishbtnActionPerformed

    private void previousMouseEntered(java.awt.event.MouseEvent evt)//GEN-FIRST:event_previousMouseEntered
    {//GEN-HEADEREND:event_previousMouseEntered
        previous.setBackground(new java.awt.Color(255, 255, 255, 175));
        project.Controller.Application.repaintScreen();
    }//GEN-LAST:event_previousMouseEntered

    private void previousMouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_previousMouseExited
    {//GEN-HEADEREND:event_previousMouseExited
        previous.setBackground(new java.awt.Color(255, 255, 255, 125));
        project.Controller.Application.repaintScreen();
    }//GEN-LAST:event_previousMouseExited

    private void previousActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_previousActionPerformed
    {//GEN-HEADEREND:event_previousActionPerformed
        RegistrarProfesor_3 o = new RegistrarProfesor_3();
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
    private javax.swing.JButton cancelbtn;
    private javax.swing.JButton examinar;
    private javax.swing.JButton finishbtn;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel lblCedula24;
    private javax.swing.JLabel pic;
    private javax.swing.JButton previous;
    // End of variables declaration//GEN-END:variables
}
