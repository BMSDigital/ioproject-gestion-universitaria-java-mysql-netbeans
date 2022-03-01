package project.View;

import javax.swing.JPanel;

public class MainForm extends javax.swing.JFrame 
{
    private java.awt.Image backImage;
    private boolean sqlState;
    private JPanel content;
    
    public MainForm() 
    {
        // Pintar Background
        javax.swing.JPanel contentPane = new javax.swing.JPanel()
        {
            @Override
            public void paintComponent( java.awt.Graphics g )
            {
                super.paintComponent(g); 
                if( backImage != null )
                    g.drawImage(backImage, 0, 0, this);
            }
        };
        setContentPane(contentPane);
        

        initComponents();
    }
    public void setContent( JPanel n_content )
    {
        int n_contentWidth = n_content.getMaximumSize().width;
        int n_contentHeight = n_content.getMaximumSize().height;
        int n_contentX = (int)(getWidth()*1.5);
        int n_contentY = (int)(getHeight()* 0.5f - n_contentHeight* 0.5 - 29);
        int disA = -(int)(getWidth()) - 8;
        int disB = -(int)( n_contentWidth* 0.5f );
            
        if( this.content != null )
        {
            class postMethod extends Egoist.Swing.Animator
            {
                volatile JPanel o_content = content;
                
                @Override
                public Egoist.Swing.Animator init(Object o, int i, long l, BEHAVIOUR bhvr, Object o1){ return(null); }
                @Override
                public void load()
                {
                    MainForm mainForm = project.Controller.Application.getScreen();
                        
                    if( mainForm != null )
                    {
                        if(o_content!=null)
                        {   
                            o_content.removeAll();
                            mainForm.getContentPane().remove(o_content);
                        }
                        
                        mainForm.pack();
                        mainForm.repaint(); 
                    }
                }
                @Override
                public void render(){}
                @Override
                public void finish(){}
                @Override
                public boolean isBroken()
                {
                    return(false);
                }
            }
            
            Egoist.Swing.Animator.build( Egoist.Swing.Animator.ANIMATION.Transition ).
                    init( new java.awt.Point( disA, 0 ), 20, 700, Egoist.Swing.Animator.BEHAVIOUR.AccelUp, this.content ).
                        enqueue( Egoist.Swing.Animator.build(Egoist.Swing.Animator.ANIMATION.Transition).
                            init( new java.awt.Point( disB, 0 ), 20, 600, Egoist.Swing.Animator.BEHAVIOUR.Rect, this.content ).
                                enqueue( new postMethod() ) ).
                                    start();
        }
  
        if( n_content != null )
        {
            this.content = n_content;
            this.content.setSize( n_contentWidth, n_contentHeight );
            this.content.setLocation( n_contentX, n_contentY );
            this.getContentPane().add(this.content, 0);

            Egoist.Swing.Animator.build( Egoist.Swing.Animator.ANIMATION.Transition).
                    init( new java.awt.Point( disA, 0 ), 20, 600, Egoist.Swing.Animator.BEHAVIOUR.Rect, this.content ).
                        enqueue( Egoist.Swing.Animator.build(Egoist.Swing.Animator.ANIMATION.Transition).
                                init( new java.awt.Point( disB, 0 ), 20, 700, Egoist.Swing.Animator.BEHAVIOUR.AccelDown, this.content ) ).
                                    start(); 

        }
        
        pack();
        repaint();
    }
    public void setReverseContent( JPanel n_content )
    {
        
    }
    public void setImmediatelyContent( JPanel n_content )
    {
        if(n_content!=null)
        {
            
        }
        else
        {
            this.content.removeAll();
            remove(this.content);
            
            this.pack();
            this.repaint();
        }
    }
    public void setContentVisible( boolean contentState )
    {
        this.content.setVisible(contentState);
    }
    public void setMenuVisible( boolean menuVisible )
    {
        if( menuVisible )
        {
            menu.setVisible(true);
        }
        else
        {
            menu.setVisible(false);
        }
    }
    public void setSqlIconState( boolean sqlState )
    {
        if( this.sqlState != sqlState || !this.sqlIcon.isEnabled() )
        {
            this.sqlState = sqlState;
            java.awt.Image icon;
        
            if( this.sqlState )
                icon = project.Controller.Application.getImage("connected", 32, 32 );
            else
                icon = project.Controller.Application.getImage("disconnected", 32, 32 );

            this.sqlIcon.setIcon( new javax.swing.ImageIcon(icon));
            if( !this.sqlIcon.isEnabled() )
                this.sqlIcon.setEnabled(true);
        }
    }
    @Override
    public void setSize( int width, int height )
    {
        setPreferredSize( new java.awt.Dimension(width, height) );
        super.setSize(width, height);
    }
    public java.awt.Image getBackImage()
    {
        return(backImage);
    }
    public void setBackImage( java.awt.Image backImage )
    {
        this.backImage = backImage;
    }
    /*
    boolean animating = false;
                for( int i = 0; i < getComponentCount(); ++i )
                    if( Egoist.Swing.Animator.isBeingAnimated(getComponent(i)) == true )
                    {
                        animating = true;
                        break;
                    }*/
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sqlIcon = new javax.swing.JLabel();
        menu = new javax.swing.JMenuBar();
        cerrarSesionItem = new javax.swing.JMenu();
        cerrarSesionItem1 = new javax.swing.JMenu();
        registrarprofesor = new javax.swing.JMenuItem();
        registrarusuario = new javax.swing.JMenuItem();
        actualizarasignatura = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenu1 = new javax.swing.JMenu();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        cerrarsesion = new javax.swing.JMenuItem();
        salir = new javax.swing.JMenuItem();
        cerrarSesionItem2 = new javax.swing.JMenu();
        actualizarprofesor1 = new javax.swing.JMenuItem();
        actualizarprofesor = new javax.swing.JMenuItem();
        actualizarseccion = new javax.swing.JMenuItem();
        HerramientasItem = new javax.swing.JMenu();
        bitacora = new javax.swing.JMenuItem();
        preferencias = new javax.swing.JMenuItem();
        AyudaItem = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("MainForm"); // NOI18N
        setSize(new java.awt.Dimension(800, 600));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });

        sqlIcon.setText(" ");
        sqlIcon.setEnabled(false);
        sqlIcon.setMaximumSize(new java.awt.Dimension(32, 32));
        sqlIcon.setMinimumSize(new java.awt.Dimension(32, 32));
        sqlIcon.setPreferredSize(new java.awt.Dimension(32, 32));

        cerrarSesionItem.setText("Inicio");
        cerrarSesionItem.setRequestFocusEnabled(false);
        cerrarSesionItem.setVerifyInputWhenFocusTarget(false);
        menu.add(cerrarSesionItem);

        cerrarSesionItem1.setText("Archivo");
        cerrarSesionItem1.setRequestFocusEnabled(false);
        cerrarSesionItem1.setVerifyInputWhenFocusTarget(false);

        registrarprofesor.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        registrarprofesor.setText("Nuevo Profesor");
        registrarprofesor.setName("Profesor"); // NOI18N
        registrarprofesor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarprofesorActionPerformed(evt);
            }
        });
        cerrarSesionItem1.add(registrarprofesor);

        registrarusuario.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_MASK));
        registrarusuario.setText("Nuevo Usuario");
        registrarusuario.setName("Horario"); // NOI18N
        registrarusuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarusuarioActionPerformed(evt);
            }
        });
        cerrarSesionItem1.add(registrarusuario);

        actualizarasignatura.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        actualizarasignatura.setText("Nueva Asignatura");
        actualizarasignatura.setName("Horario"); // NOI18N
        actualizarasignatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarasignaturaActionPerformed(evt);
            }
        });
        cerrarSesionItem1.add(actualizarasignatura);
        cerrarSesionItem1.add(jSeparator1);

        jMenu1.setText("Exportar...");
        cerrarSesionItem1.add(jMenu1);
        cerrarSesionItem1.add(jSeparator3);

        cerrarsesion.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.SHIFT_MASK));
        cerrarsesion.setText("Cerrar Sesión");
        cerrarsesion.setName("Horario"); // NOI18N
        cerrarSesionItem1.add(cerrarsesion);

        salir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        salir.setText("Salir");
        salir.setName("Horario"); // NOI18N
        cerrarSesionItem1.add(salir);

        menu.add(cerrarSesionItem1);

        cerrarSesionItem2.setText("Edición");
        cerrarSesionItem2.setRequestFocusEnabled(false);
        cerrarSesionItem2.setVerifyInputWhenFocusTarget(false);

        actualizarprofesor1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        actualizarprofesor1.setText("Listado de profesores");
        actualizarprofesor1.setName("Profesor"); // NOI18N
        actualizarprofesor1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarprofesor1ActionPerformed(evt);
            }
        });
        cerrarSesionItem2.add(actualizarprofesor1);

        actualizarprofesor.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        actualizarprofesor.setText("Actualizar Profesor");
        actualizarprofesor.setName("Profesor"); // NOI18N
        actualizarprofesor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarprofesorActionPerformed(evt);
            }
        });
        cerrarSesionItem2.add(actualizarprofesor);

        actualizarseccion.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        actualizarseccion.setText("Actualizar Sección");
        actualizarseccion.setName("Horario"); // NOI18N
        actualizarseccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarseccionActionPerformed(evt);
            }
        });
        cerrarSesionItem2.add(actualizarseccion);

        menu.add(cerrarSesionItem2);

        HerramientasItem.setLabel("Herramientas");

        bitacora.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK));
        bitacora.setLabel("Bitácora");
        bitacora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bitacoraActionPerformed(evt);
            }
        });
        HerramientasItem.add(bitacora);

        preferencias.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        preferencias.setLabel("Preferencias");
        preferencias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                preferenciasActionPerformed(evt);
            }
        });
        HerramientasItem.add(preferencias);

        menu.add(HerramientasItem);
        HerramientasItem.getAccessibleContext().setAccessibleName("Opciones");

        AyudaItem.setText("Ayuda");

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        jMenuItem5.setText("Ayuda...");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        AyudaItem.add(jMenuItem5);

        jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, java.awt.event.InputEvent.SHIFT_MASK));
        jMenuItem6.setText("Acerca de");
        AyudaItem.add(jMenuItem6);

        menu.add(AyudaItem);

        setJMenuBar(menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(1027, Short.MAX_VALUE)
                .addComponent(sqlIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(679, Short.MAX_VALUE)
                .addComponent(sqlIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(1024, 781));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void registrarprofesorActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_registrarprofesorActionPerformed
    {//GEN-HEADEREND:event_registrarprofesorActionPerformed
        project.Controller.Application.callMainOption( new RegistrarProfesor_1() );
    }//GEN-LAST:event_registrarprofesorActionPerformed

    private void actualizarasignaturaActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_actualizarasignaturaActionPerformed
    {//GEN-HEADEREND:event_actualizarasignaturaActionPerformed
        project.Controller.Application.callMainOption( new RegistrarMateria() );
    }//GEN-LAST:event_actualizarasignaturaActionPerformed

    private void actualizarprofesorActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_actualizarprofesorActionPerformed
    {//GEN-HEADEREND:event_actualizarprofesorActionPerformed
        int result = project.Controller.Application.showMessageDialog( "Actualización de Profesor", "", 1, new String[]{"Actualizar Datos", "Actualizar Horario"}, new String[]{"cancel","accept"} );
        if( result == 1 )
        {
            RegistrarProfesor_1 o = new RegistrarProfesor_1();

            project.Controller.Application.callMainOption(o);
        }
        else if( result == 2 )
        {
            project.Controller.Application.callMainOption( new RegistrarProfesor_5() );
        }
    }//GEN-LAST:event_actualizarprofesorActionPerformed

    private void registrarusuarioActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_registrarusuarioActionPerformed
    {//GEN-HEADEREND:event_registrarusuarioActionPerformed
       project.Controller.Application.callMainOption( new RegistrarUsuario() );
    
    }//GEN-LAST:event_registrarusuarioActionPerformed

    private void actualizarseccionActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_actualizarseccionActionPerformed
    {//GEN-HEADEREND:event_actualizarseccionActionPerformed
        project.Controller.Application.callMainOption( new RegistrarSeccion() );
    }//GEN-LAST:event_actualizarseccionActionPerformed

    private void preferenciasActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_preferenciasActionPerformed
    {//GEN-HEADEREND:event_preferenciasActionPerformed
        project.Controller.Application.callMainOption( new Preferencias() );
    }//GEN-LAST:event_preferenciasActionPerformed

    private void actualizarprofesor1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_actualizarprofesor1ActionPerformed
    {//GEN-HEADEREND:event_actualizarprofesor1ActionPerformed
        project.Controller.Application.callMainOption( new ListadoProfesor() );
    }//GEN-LAST:event_actualizarprofesor1ActionPerformed

    private void formComponentResized(java.awt.event.ComponentEvent evt)//GEN-FIRST:event_formComponentResized
    {//GEN-HEADEREND:event_formComponentResized
        backImage = project.Controller.Application.getThemeItem( "background", evt.getComponent().getWidth(), evt.getComponent().getHeight() );
    }//GEN-LAST:event_formComponentResized

    private void bitacoraActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_bitacoraActionPerformed
    {//GEN-HEADEREND:event_bitacoraActionPerformed
        project.Controller.Application.callMainOption( new ListadoBitacora() );
    }//GEN-LAST:event_bitacoraActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu AyudaItem;
    private javax.swing.JMenu HerramientasItem;
    private javax.swing.JMenuItem actualizarasignatura;
    private javax.swing.JMenuItem actualizarprofesor;
    private javax.swing.JMenuItem actualizarprofesor1;
    private javax.swing.JMenuItem actualizarseccion;
    private javax.swing.JMenuItem bitacora;
    private javax.swing.JMenu cerrarSesionItem;
    private javax.swing.JMenu cerrarSesionItem1;
    private javax.swing.JMenu cerrarSesionItem2;
    private javax.swing.JMenuItem cerrarsesion;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JMenuBar menu;
    private javax.swing.JMenuItem preferencias;
    private javax.swing.JMenuItem registrarprofesor;
    private javax.swing.JMenuItem registrarusuario;
    private javax.swing.JMenuItem salir;
    private javax.swing.JLabel sqlIcon;
    // End of variables declaration//GEN-END:variables
}
