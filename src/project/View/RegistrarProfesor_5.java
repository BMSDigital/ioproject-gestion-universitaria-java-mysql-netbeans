package project.View;

import java.util.ArrayList;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import project.Model.Profesor;

public class RegistrarProfesor_5 extends javax.swing.JPanel
{ 
    java.util.ArrayList<project.Model.Carrera> carreras;
    java.util.ArrayList<project.Model.Semestre> semestres;
    java.util.ArrayList<project.Model.Seccion> secciones;
    java.util.ArrayList<project.Model.AsignaturaSeccion> asignaturas;
    java.util.ArrayList<project.Model.AsignaturaSeccion> horario = new java.util.ArrayList();
    
    project.Model.Profesor profesor;
    
    public enum EDITION_MODE
    {
        NORMAL,
        AGREGAR_MATERIA,
        ACEPTAR_MATERIA_AGREGADA,
        ELIMINAR_MATERIA,
        ACEPTAR_MATERIA_ELIMINADA
    }
    
    public RegistrarProfesor_5()
    {
        initComponents();
        establecerModo( EDITION_MODE.NORMAL );
    }
    private void establecerModo( EDITION_MODE mode )
    {
        switch(mode)
        {
            case NORMAL:
            {
                addbtn.setEnabled(true);
                delbtn.setEnabled(true);
                
                addbtn.setIcon(new javax.swing.ImageIcon(project.Controller.Application.getThemeItem("add", 16, 16)));
                delbtn.setIcon(new javax.swing.ImageIcon(project.Controller.Application.getThemeItem("del", 16, 16)));
                
                addbtn.setText("Agregar");
                delbtn.setText("Eliminar");
                
                addbtn.setName("agregar");
                delbtn.setName("eliminar");
                
                carreratxt.setEnabled(false);
                semestretxt.setEnabled(false);
                secciontxt.setEnabled(false);
                asignaturatxt.setEnabled(false);
                
                delinfo.setText( " " );
                
                horariotbl.setFocusable(false);
                horariotbl.setColumnSelectionAllowed(false);
                horariotbl.setCellSelectionEnabled(false);
                horariotbl.setRowSelectionAllowed(false);
                
                finalizar.setOpaque(true);
                reiniciar.setOpaque(true);
                cancelar.setOpaque(true);
                
                finalizar.setBackground( new java.awt.Color( 255, 255, 255, 125 ) );
                reiniciar.setBackground( new java.awt.Color( 255, 255, 255, 125 ) );
                cancelar.setBackground( new java.awt.Color( 255, 255, 255, 125 ) );
            }break;
            case AGREGAR_MATERIA:
            {
                addbtn.setEnabled(true);
                delbtn.setEnabled(false);
                
                addbtn.setIcon(new javax.swing.ImageIcon(project.Controller.Application.getThemeItem("complete", 16, 16)));
                addbtn.setText("Aceptar");
                addbtn.setName("completar");
                
                carreratxt.setEnabled(true);
                semestretxt.setEnabled(true);
                secciontxt.setEnabled(true);
                asignaturatxt.setEnabled(true);
                
                cargarCarreras();
                cargarSemestres();
                cargarSecciones();
                cargarAsignaturas();
            }break;
            case ACEPTAR_MATERIA_AGREGADA:
            {
                if( agregarMateria() )
                    establecerModo( EDITION_MODE.NORMAL );
            }break;
            case ELIMINAR_MATERIA:
            {
                addbtn.setEnabled(false);
                delbtn.setEnabled(true);
                
                carreratxt.setEnabled(false);
                semestretxt.setEnabled(false);
                secciontxt.setEnabled(false);
                asignaturatxt.setEnabled(false);
                
                delbtn.setIcon(new javax.swing.ImageIcon(project.Controller.Application.getThemeItem("complete", 16, 16)));
                delbtn.setName("completar");
                delbtn.setText("Aceptar");
                
                delinfo.setVisible(true);
                delinfo.setText("Haz Click en la celda donde se encuentra la asignatura a eliminar");
                
                horariotbl.setFocusable(true);
                horariotbl.setColumnSelectionAllowed(true);
                horariotbl.setCellSelectionEnabled(true);
                horariotbl.setRowSelectionAllowed(true);
            }break;
            case ACEPTAR_MATERIA_ELIMINADA:
            {
                if( eliminarMateria() )
                    establecerModo( EDITION_MODE.NORMAL );
            }break;
        }
    }
    
    public void cargarCarreras()
    {
        carreras = project.Controller.Application.loadDbItems( new project.Model.Carrera() );
        if( carreras != null )
        {
            ComboBoxModel model = new DefaultComboBoxModel<>();
            for( project.Model.Carrera c : carreras)
                ((DefaultComboBoxModel)model).addElement(c.getNombre());

            carreratxt.setModel(model);
        }
    }
    public void cargarSemestres()
    {
        String key = "cod_carrera";
        String value = "" + carreratxt.getSelectedIndex()+1;
                
        semestres = project.Controller.Application.loadDbItems( new project.Model.Semestre(), key, value );
        if( semestres != null )
        {
            ComboBoxModel model = new DefaultComboBoxModel<>();
            for( project.Model.Semestre s : semestres )
                ((DefaultComboBoxModel)model).addElement(s.getNombre());

            semestretxt.setModel(model);
        }
    }
    public void cargarSecciones()
    {
        String[] keys = { "cod_carrera", "cod_semestre" };
        String[] values = { "" + carreratxt.getSelectedIndex()+1, "" + semestretxt.getSelectedIndex()+1 };
        
        ComboBoxModel model = new DefaultComboBoxModel<>();
        secciones = project.Controller.Application.loadDbItems( new project.Model.Seccion(), keys, values);

        if( secciones != null && !secciones.isEmpty() )
        {
            for( project.Model.Seccion s : secciones )    
               ((DefaultComboBoxModel)model).addElement(s.getKeyCarrera() + "D" + s.getId() + "IS");
        }
        secciontxt.setModel(model);
        
        if( secciontxt.getItemCount() == 0 )
            establecerModo( EDITION_MODE.NORMAL );
    }
    public void cargarAsignaturas()
    {
        String[] key = { "cod_seccion" };
        String[] value = { "" + secciontxt.getSelectedIndex()+1 };
        
        java.util.ArrayList<project.Model.Bloque> bloques = project.Controller.Application.loadDbItems( new project.Model.Bloque(), key, value );
        if( bloques != null )
        {
            while( !bloques.isEmpty() )
            {
                java.util.ArrayList<project.Model.Bloque> asignaturaBloques = new java.util.ArrayList();
                asignaturaBloques.add(bloques.get(0));
                for( int i = 1; i < bloques.size(); ++i )
                    if( bloques.get(i).getKeyAsignatura() == asignaturaBloques.get(i).getKeyAsignatura() )
                    {
                        asignaturaBloques.add(bloques.get(i));
                        bloques.remove(i--);
                    }
                
                key = new String[] { "id" };
                value = new String[] { "" + asignaturaBloques.get(0).getKeyAsignatura() };
                
                java.util.ArrayList<project.Model.Asignatura> asignaturas = project.Controller.Application.loadDbItems( new project.Model.Asignatura(), key, value );
                if( asignaturas != null && !asignaturas.isEmpty() )
                {
                    project.Model.Asignatura m_asignatura = asignaturas.get(0);
                    
                    project.Model.AsignaturaSeccion asignaturaSeccion = new project.Model.AsignaturaSeccion();
                    asignaturaSeccion.setCodigo( m_asignatura.getCodigo() );
                    asignaturaSeccion.setNombre( m_asignatura.getNombre() );
                    asignaturaSeccion.setCarrera( m_asignatura.getCarrera() );
                    asignaturaSeccion.setDescripcion( m_asignatura.getDescripcion() );
                    asignaturaSeccion.setDuracionPracticas( m_asignatura.getDuracionPracticas() );
                    asignaturaSeccion.setDuracionTeoricas( m_asignatura.getDuracionTeoricas() );
                    
                    for( project.Model.Bloque b : asignaturaBloques )
                        asignaturaSeccion.agregarBloque(b);
                    
                    asignaturas.add(asignaturaSeccion);
                }
            }
            
            ComboBoxModel model = new DefaultComboBoxModel<>();
            
            if( asignaturas != null )
            {
                for( project.Model.AsignaturaSeccion a : asignaturas )
                {
                    boolean yaExiste = false;
                    for( int i = 0; i < horario.size(); ++i )
                        if( horario.get(i).getNombre().equals(a.getNombre()) && horario.get(i).getBloques().get(0).getKeySeccion() == a.getBloques().get(0).getKeySeccion() )
                        {
                            yaExiste = true;
                            break;
                        }

                    if( !yaExiste )
                        ((DefaultComboBoxModel)model).addElement(a.getNombre());
                }
            }
            
            asignaturatxt.setModel(model);
        }
        
        if( asignaturatxt.getItemCount() == 0 )
            establecerModo( EDITION_MODE.NORMAL );
    }
    
    public boolean agregarMateria()
    {
        return(true);
    }
    public boolean eliminarMateria()
    {
        return(true);
    }
    
    @SuppressWarnings( "unchecked" )
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jComboBox14 = new javax.swing.JComboBox();
        jComboBox15 = new javax.swing.JComboBox();
        lblCedula25 = new javax.swing.JLabel();
        lblCedula47 = new javax.swing.JLabel();
        lblCedula48 = new javax.swing.JLabel();
        lblCedula49 = new javax.swing.JLabel();
        lblCedula50 = new javax.swing.JLabel();
        lblCedula51 = new javax.swing.JLabel();
        lblCedula52 = new javax.swing.JLabel();
        horariopanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        horariotbl = new javax.swing.JTable();
        delinfo = new javax.swing.JLabel();
        lblCedula27 = new javax.swing.JLabel();
        asignaturapanel = new javax.swing.JPanel();
        semestretxt = new javax.swing.JComboBox();
        carreratxt = new javax.swing.JComboBox();
        lblCedula43 = new javax.swing.JLabel();
        lblCedula44 = new javax.swing.JLabel();
        secciontxt = new javax.swing.JComboBox();
        lblCedula45 = new javax.swing.JLabel();
        lblCedula89 = new javax.swing.JLabel();
        asignaturatxt = new javax.swing.JComboBox();
        addbtn = new javax.swing.JButton();
        delbtn = new javax.swing.JButton();
        finalizar = new javax.swing.JButton();
        reiniciar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();

        jPanel5.setBackground(new java.awt.Color( 255, 255, 255, 75 ));
        jPanel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        jPanel5.setDoubleBuffered(false);

        jComboBox14.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jComboBox14.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--" }));
        jComboBox14.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jComboBox14.setOpaque(false);
        jComboBox14.setPreferredSize(new java.awt.Dimension(36, 21));

        jComboBox15.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jComboBox15.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--" }));
        jComboBox15.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jComboBox15.setOpaque(false);
        jComboBox15.setPreferredSize(new java.awt.Dimension(36, 21));

        lblCedula25.setBackground(new java.awt.Color( 255, 255, 255, 75 ));
        lblCedula25.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblCedula25.setForeground(new java.awt.Color(255, 255, 255));
        lblCedula25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCedula25.setText("Asignatura");
        lblCedula25.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        lblCedula25.setOpaque(true);

        lblCedula47.setBackground(new java.awt.Color( 255, 255, 255, 75 ));
        lblCedula47.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblCedula47.setForeground(new java.awt.Color(255, 255, 255));
        lblCedula47.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCedula47.setText("Semestre");
        lblCedula47.setOpaque(true);

        lblCedula48.setBackground(new java.awt.Color( 255, 255, 255, 75 ));
        lblCedula48.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblCedula48.setForeground(new java.awt.Color(255, 255, 255));
        lblCedula48.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCedula48.setText("Nombre");
        lblCedula48.setOpaque(true);

        lblCedula49.setBackground(new java.awt.Color( 255, 255, 255, 75 ));
        lblCedula49.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblCedula49.setForeground(new java.awt.Color(255, 255, 255));
        lblCedula49.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCedula49.setText("Clases de práctica");
        lblCedula49.setOpaque(true);

        lblCedula50.setBackground(new java.awt.Color( 255, 255, 255, 75 ));
        lblCedula50.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblCedula50.setForeground(new java.awt.Color(255, 255, 255));
        lblCedula50.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCedula50.setText("Clases de teoría");
        lblCedula50.setOpaque(true);

        lblCedula51.setBackground(new java.awt.Color( 255, 255, 255, 75 ));
        lblCedula51.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblCedula51.setForeground(new java.awt.Color(255, 255, 255));
        lblCedula51.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCedula51.setText("0");
        lblCedula51.setOpaque(true);

        lblCedula52.setBackground(new java.awt.Color( 255, 255, 255, 75 ));
        lblCedula52.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblCedula52.setForeground(new java.awt.Color(255, 255, 255));
        lblCedula52.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCedula52.setText("0");
        lblCedula52.setOpaque(true);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(lblCedula25, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCedula47, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCedula48, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCedula49, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCedula50, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox14, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblCedula52, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblCedula51, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jComboBox15, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 13, Short.MAX_VALUE))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblCedula25)
                .addGap(20, 20, 20)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCedula47)
                    .addComponent(jComboBox15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCedula48)
                    .addComponent(jComboBox14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCedula49)
                    .addComponent(lblCedula51))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCedula50)
                    .addComponent(lblCedula52))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        setBackground(new java.awt.Color(0, 0, 0));
        setMaximumSize(new java.awt.Dimension(930, 460));
        setMinimumSize(new java.awt.Dimension(930, 460));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(930, 460));

        horariopanel.setBackground(new java.awt.Color( 255, 255, 255, 75 ));
        horariopanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        horariopanel.setDoubleBuffered(false);

        jScrollPane1.setBorder(null);
        jScrollPane1.setOpaque(false);

        horariotbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"<html><center><p>7:00 a 7:45</p></center></html>", null, null, null, null, null, null, null},
                {"7:45 a 8:30", null, null, null, null, null, null, null},
                {"8:30 a 9:15", null, null, null, null, null, null, null},
                {"9:30 a 10:15", null, null, null, null, null, null, null},
                {"10:15 a 11:00", null, null, null, null, null, null, null},
                {"11:00 a 11:45", null, null, null, null, null, null, null},
                {"11:45 a 12:30", null, null, null, null, null, null, null},
                {"12:30 a 13:15", null, null, null, null, null, null, null},
                {"13:15 a 14:00", null, null, null, null, null, null, null},
                {"14:00 a 14:45", null, null, null, null, null, null, null},
                {"15:00 a 15:45", null, null, null, null, null, null, null},
                {"15:45 a 16:30", null, null, null, null, null, null, null},
                {"16:30 a 17:15", null, null, null, null, null, null, null},
                {"17:15 a 18:00", null, null, null, null, null, null, null}
            },
            new String [] {
                "Hora", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        horariotbl.setCellSelectionEnabled(true);
        horariotbl.setGridColor(new java.awt.Color(204, 204, 204));
        horariotbl.setOpaque(false);
        horariotbl.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        horariotbl.getTableHeader().setResizingAllowed(false);
        horariotbl.getTableHeader().setReorderingAllowed(false);
        horariotbl.setUpdateSelectionOnSort(false);
        horariotbl.setVerifyInputWhenFocusTarget(false);
        jScrollPane1.setViewportView(horariotbl);
        horariotbl.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        delinfo.setBackground(new java.awt.Color( 255, 255, 255, 75 ));
        delinfo.setText("Haz Click en la celda donde se encuentra la asignatura a eliminar");
        delinfo.setOpaque(true);

        javax.swing.GroupLayout horariopanelLayout = new javax.swing.GroupLayout(horariopanel);
        horariopanel.setLayout(horariopanelLayout);
        horariopanelLayout.setHorizontalGroup(
            horariopanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(horariopanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(horariopanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 557, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(horariopanelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(delinfo)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        horariopanelLayout.setVerticalGroup(
            horariopanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(horariopanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(delinfo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblCedula27.setBackground(new java.awt.Color( 255, 255, 255, 75 ));
        lblCedula27.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblCedula27.setForeground(new java.awt.Color(255, 255, 255));
        lblCedula27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCedula27.setText("ACTUALIZACIÓN DE HORARIO DE PROFESOR");
        lblCedula27.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        lblCedula27.setOpaque(true);

        asignaturapanel.setBackground(new java.awt.Color( 255, 255, 255, 75 ));
        asignaturapanel.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true), "Nueva Asignatura", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 20), new java.awt.Color(255, 255, 255))); // NOI18N
        asignaturapanel.setDoubleBuffered(false);

        semestretxt.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        semestretxt.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--" }));
        semestretxt.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        semestretxt.setOpaque(false);
        semestretxt.setPreferredSize(new java.awt.Dimension(36, 21));
        semestretxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                semestretxtActionPerformed(evt);
            }
        });

        carreratxt.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        carreratxt.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--" }));
        carreratxt.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        carreratxt.setOpaque(false);
        carreratxt.setPreferredSize(new java.awt.Dimension(36, 21));
        carreratxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carreratxtActionPerformed(evt);
            }
        });

        lblCedula43.setBackground(new java.awt.Color( 255, 255, 255, 75 ));
        lblCedula43.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblCedula43.setForeground(new java.awt.Color(255, 255, 255));
        lblCedula43.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCedula43.setText("Carrera");
        lblCedula43.setOpaque(true);

        lblCedula44.setBackground(new java.awt.Color( 255, 255, 255, 75 ));
        lblCedula44.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblCedula44.setForeground(new java.awt.Color(255, 255, 255));
        lblCedula44.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCedula44.setText("Semestre");
        lblCedula44.setOpaque(true);

        secciontxt.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        secciontxt.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--" }));
        secciontxt.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        secciontxt.setOpaque(false);
        secciontxt.setPreferredSize(new java.awt.Dimension(36, 21));

        lblCedula45.setBackground(new java.awt.Color( 255, 255, 255, 75 ));
        lblCedula45.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblCedula45.setForeground(new java.awt.Color(255, 255, 255));
        lblCedula45.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCedula45.setText("Sección");
        lblCedula45.setOpaque(true);

        lblCedula89.setBackground(new java.awt.Color( 255, 255, 255, 75 ));
        lblCedula89.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblCedula89.setForeground(new java.awt.Color(255, 255, 255));
        lblCedula89.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCedula89.setText("Asignatura");
        lblCedula89.setOpaque(true);

        asignaturatxt.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        asignaturatxt.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--" }));
        asignaturatxt.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        asignaturatxt.setOpaque(false);
        asignaturatxt.setPreferredSize(new java.awt.Dimension(36, 21));
        asignaturatxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asignaturatxtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout asignaturapanelLayout = new javax.swing.GroupLayout(asignaturapanel);
        asignaturapanel.setLayout(asignaturapanelLayout);
        asignaturapanelLayout.setHorizontalGroup(
            asignaturapanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(asignaturapanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(asignaturapanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(asignaturapanelLayout.createSequentialGroup()
                        .addComponent(lblCedula45, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(secciontxt, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(asignaturapanelLayout.createSequentialGroup()
                        .addGroup(asignaturapanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCedula44, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCedula43, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(asignaturapanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(carreratxt, 0, 142, Short.MAX_VALUE)
                            .addComponent(semestretxt, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(asignaturapanelLayout.createSequentialGroup()
                        .addComponent(lblCedula89, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(asignaturatxt, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(9, 9, 9))
        );
        asignaturapanelLayout.setVerticalGroup(
            asignaturapanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(asignaturapanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(asignaturapanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCedula43)
                    .addComponent(carreratxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(asignaturapanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCedula44)
                    .addComponent(semestretxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(asignaturapanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCedula45)
                    .addComponent(secciontxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(asignaturapanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCedula89)
                    .addComponent(asignaturatxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        addbtn.setBackground(new java.awt.Color( 255, 255, 255, 125 ));
        addbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Themes/Razor/add.png"))); // NOI18N
        addbtn.setText("Agregar");
        addbtn.setToolTipText("Haz click para agregar una asignatura");
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
        delbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Themes/Razor/del.png"))); // NOI18N
        delbtn.setText("Eliminar");
        delbtn.setToolTipText("Haz click para eliminar una asignatura");
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

        finalizar.setBackground(new java.awt.Color( 255, 255, 255, 125 ));
        finalizar.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        finalizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Themes/Razor/finish.png"))); // NOI18N
        finalizar.setText("Finalizar");
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

        reiniciar.setBackground(new java.awt.Color( 255, 255, 255, 125 ));
        reiniciar.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        reiniciar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Themes/Razor/reload.png"))); // NOI18N
        reiniciar.setText("Reiniciar");
        reiniciar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        reiniciar.setContentAreaFilled(false);
        reiniciar.setOpaque(true);
        reiniciar.setPreferredSize(new java.awt.Dimension(100, 25));
        reiniciar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                reiniciarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                reiniciarMouseExited(evt);
            }
        });

        cancelar.setBackground(new java.awt.Color( 255, 255, 255, 125 ));
        cancelar.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblCedula27, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(reiniciar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(finalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(asignaturapanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(delbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(addbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(horariopanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(28, 28, 28))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lblCedula27, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(horariopanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(asignaturapanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(delbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(finalizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(reiniciar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

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

    private void addbtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_addbtnActionPerformed
    {//GEN-HEADEREND:event_addbtnActionPerformed
        if( addbtn.getName().equals("agregar") )
            establecerModo( EDITION_MODE.AGREGAR_MATERIA );
        else
            establecerModo( EDITION_MODE.ACEPTAR_MATERIA_AGREGADA );
    }//GEN-LAST:event_addbtnActionPerformed

    private void delbtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_delbtnActionPerformed
    {//GEN-HEADEREND:event_delbtnActionPerformed
       if( delbtn.getName().equals("eliminar") )
            establecerModo( EDITION_MODE.ELIMINAR_MATERIA );
        else
            establecerModo( EDITION_MODE.ACEPTAR_MATERIA_ELIMINADA );
    }//GEN-LAST:event_delbtnActionPerformed

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

    private void reiniciarMouseEntered(java.awt.event.MouseEvent evt)//GEN-FIRST:event_reiniciarMouseEntered
    {//GEN-HEADEREND:event_reiniciarMouseEntered
        reiniciar.setBackground( new java.awt.Color( 255, 255, 255, 175 ) );
        project.Controller.Application.repaintScreen();
    }//GEN-LAST:event_reiniciarMouseEntered

    private void reiniciarMouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_reiniciarMouseExited
    {//GEN-HEADEREND:event_reiniciarMouseExited
        reiniciar.setBackground( new java.awt.Color( 255, 255, 255, 125 ) );
        project.Controller.Application.repaintScreen();
    }//GEN-LAST:event_reiniciarMouseExited

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
        // TODO add your handling code here:
    }//GEN-LAST:event_finalizarActionPerformed

    private void carreratxtActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_carreratxtActionPerformed
    {//GEN-HEADEREND:event_carreratxtActionPerformed
        cargarSemestres();
        cargarSecciones();
        cargarAsignaturas();
    }//GEN-LAST:event_carreratxtActionPerformed

    private void semestretxtActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_semestretxtActionPerformed
    {//GEN-HEADEREND:event_semestretxtActionPerformed
        cargarSecciones();
        cargarAsignaturas();
        
    }//GEN-LAST:event_semestretxtActionPerformed

    private void asignaturatxtActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_asignaturatxtActionPerformed
    {//GEN-HEADEREND:event_asignaturatxtActionPerformed
        cargarAsignaturas();
    }//GEN-LAST:event_asignaturatxtActionPerformed

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
    private javax.swing.JPanel asignaturapanel;
    private javax.swing.JComboBox asignaturatxt;
    private javax.swing.JButton cancelar;
    private javax.swing.JComboBox carreratxt;
    private javax.swing.JButton delbtn;
    private javax.swing.JLabel delinfo;
    private javax.swing.JButton finalizar;
    private javax.swing.JPanel horariopanel;
    private javax.swing.JTable horariotbl;
    private javax.swing.JComboBox jComboBox14;
    private javax.swing.JComboBox jComboBox15;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCedula25;
    private javax.swing.JLabel lblCedula27;
    private javax.swing.JLabel lblCedula43;
    private javax.swing.JLabel lblCedula44;
    private javax.swing.JLabel lblCedula45;
    private javax.swing.JLabel lblCedula47;
    private javax.swing.JLabel lblCedula48;
    private javax.swing.JLabel lblCedula49;
    private javax.swing.JLabel lblCedula50;
    private javax.swing.JLabel lblCedula51;
    private javax.swing.JLabel lblCedula52;
    private javax.swing.JLabel lblCedula89;
    private javax.swing.JButton reiniciar;
    private javax.swing.JComboBox secciontxt;
    private javax.swing.JComboBox semestretxt;
    // End of variables declaration//GEN-END:variables
}
