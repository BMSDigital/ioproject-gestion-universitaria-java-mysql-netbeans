package project.View;

import java.awt.Component;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


public class RegistrarSeccion extends javax.swing.JPanel
{
    project.Model.Asignatura m_asignatura;
    java.util.ArrayList<project.Model.Carrera> carreras;
    java.util.ArrayList<project.Model.Semestre> semestres;
    java.util.ArrayList<project.Model.Asignatura> asignaturas;
    
    project.Model.AsignaturaSeccion asignaturaSeccion;
    java.util.ArrayList<project.Model.AsignaturaSeccion> horario = new java.util.ArrayList();
    
    public enum EDITION_MODE
    {
        NORMAL,
        AGREGAR_ASIGNATURA,
        AGREGAR_ASIGNATURA_2,
        AGREGAR_ASIGNATURA_3,
        ELIMINAR_ASIGNATURA
    }
     
    EDITION_MODE m_mode;
    
    public RegistrarSeccion()
    {
        initComponents();
        establecerModo( EDITION_MODE.NORMAL );
        
        class CustomRenderer extends DefaultTableCellRenderer 
        {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) 
            {
                Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                if( value instanceof String )
                {
                    String str = (String) value;
                    if( !str.equals("") && column >= 1)
                    {
                        cell.setBackground( new java.awt.Color( 30, 140, 40, 120 ) );
                    }  
                    else
                        cell.setBackground( new java.awt.Color( 255, 255, 255 ) );
                }
                else
                {
                    cell.setBackground( new java.awt.Color( 255, 255, 255 ) );
                }
                return cell;
            }
        }
      
        horariotbl.setDefaultRenderer( String.class, new CustomRenderer() );
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
    public void cargarAsignaturas()
    {
        String[] keys = { "cod_carrera", "cod_semestre" };
        String[] values = { "" + carreratxt.getSelectedIndex()+1, "" + semestretxt.getSelectedIndex()+1 };
        
        asignaturas = project.Controller.Application.loadDbItems( new project.Model.Asignatura(), keys, values );
        if( asignaturas != null )
        {
            ComboBoxModel model = new DefaultComboBoxModel<>();
            for( project.Model.Asignatura a : asignaturas )
            {
                boolean yaExiste = false;
                for( int i = 0; i < horario.size(); ++i )
                    if( horario.get(i).getNombre().equals(a.getNombre()) )
                    {
                        yaExiste = true;
                        break;
                    }
                
                if( !yaExiste )
                    ((DefaultComboBoxModel)model).addElement(a.getNombre());
            }
            asignaturatxt.setModel(model);
        }
        
        if( asignaturatxt.getItemCount() == 0 )
            establecerModo( EDITION_MODE.NORMAL );
    }
    public void cargarHoras()
    {
        if( asignaturas != null && asignaturatxt.getItemCount() > 0 )
        {
            for( project.Model.Asignatura a : asignaturas )
                if( a.getNombre().equals( asignaturatxt.getSelectedItem() ) )
                {
                    m_asignatura = a;
                    break;
                }

            asignaturaSeccion = new project.Model.AsignaturaSeccion();
            asignaturaSeccion.setCodigo( m_asignatura.getCodigo() );
            asignaturaSeccion.setNombre( m_asignatura.getNombre() );
            asignaturaSeccion.setCarrera( m_asignatura.getCarrera() );
            asignaturaSeccion.setDescripcion( m_asignatura.getDescripcion() );
            asignaturaSeccion.setDuracionPracticas( m_asignatura.getDuracionPracticas() );
            asignaturaSeccion.setDuracionTeoricas( m_asignatura.getDuracionTeoricas() );

            actualizarHoras();
        }
    }
    public void actualizarHoras()
    {
        practicalbl.setText( "" + (m_asignatura.getPracticas()- asignaturaSeccion.getPracticas()) );
        teoricalbl.setText( "" + (m_asignatura.getTeoricas()-asignaturaSeccion.getTeoricas()) );
    }
    public void actualizarTabla()
    {
        DefaultTableModel model = ( DefaultTableModel ) horariotbl.getModel();
        for( int i = 1; i < model.getColumnCount(); ++i )
            for( int j = 0; j < model.getRowCount(); ++j )
                model.setValueAt("", j, i);

        for( project.Model.AsignaturaSeccion a : horario )
            for( project.Model.Bloque b : a.getBloques() )
                for( int i = 0; i < b.getDuracion(); ++i )
                    model.setValueAt( a.getNombre(), b.getEntrada() + i, b.getDia() );
        
        horariotbl.setModel(model);
    }
    
    private void establecerModo( EDITION_MODE mode )
    {
        m_mode = mode;
        switch(mode)
        {
            case NORMAL:
            {
                finalizar.setEnabled(true);
                limpiar.setEnabled(true);
                addbtn.setEnabled(true);
                delbtn.setEnabled(true);

                carreratxt.setEnabled(false);
                semestretxt.setEnabled(false);
                turnotxt.setEnabled(false);
                idtxt.setEnabled(false);
                nextseccionbtn.setEnabled(false);
                previousseccionbtn.setEnabled(false);

                asignaturatxt.setEnabled(false);
                nextmateriabtn.setEnabled(false);
                previousmateriabtn.setEnabled(false);
                
                aceptarbtn.setEnabled(false);
                
                practicalbl.setText("0");
                teoricalbl.setText("0");

                delinfo.setText(" ");
                
            }break;
            case AGREGAR_ASIGNATURA:
            {
                finalizar.setEnabled(true);
                limpiar.setEnabled(true);
                addbtn.setEnabled(false);
                delbtn.setEnabled(false);
                
                carreratxt.setEnabled(true);
                semestretxt.setEnabled(true);
                turnotxt.setEnabled(true);
                idtxt.setEnabled(true);
                nextseccionbtn.setEnabled(true);
                previousseccionbtn.setEnabled(true);
                
                asignaturatxt.setEnabled(false);
                nextmateriabtn.setEnabled(false);
                previousmateriabtn.setEnabled(false);
                
                aceptarbtn.setEnabled(false);
                
                delinfo.setText(" ");
                
                cargarCarreras();
                cargarSemestres();
            }break;
            case AGREGAR_ASIGNATURA_2:
            {
                finalizar.setEnabled(true);
                limpiar.setEnabled(true);
                addbtn.setEnabled(false);
                delbtn.setEnabled(false);
                
                carreratxt.setEnabled(false);
                semestretxt.setEnabled(false);
                turnotxt.setEnabled(false);
                idtxt.setEnabled(false);
                nextseccionbtn.setEnabled(false);
                previousseccionbtn.setEnabled(false);
                
                asignaturatxt.setEnabled(true);
                nextmateriabtn.setEnabled(true);
                previousmateriabtn.setEnabled(true);
                
                aceptarbtn.setEnabled(false);
                
                delinfo.setText(" ");
                
                cargarAsignaturas();
                cargarHoras();
            }break;
            case AGREGAR_ASIGNATURA_3:
            {
                finalizar.setEnabled(true);
                limpiar.setEnabled(true);
                addbtn.setEnabled(false);
                delbtn.setEnabled(false);
                
                carreratxt.setEnabled(false);
                semestretxt.setEnabled(false);
                turnotxt.setEnabled(false);
                idtxt.setEnabled(false);
                nextseccionbtn.setEnabled(false);
                previousseccionbtn.setEnabled(false);
                
                asignaturatxt.setEnabled(false);
                nextmateriabtn.setEnabled(false);
                previousmateriabtn.setEnabled(true);
                
                aceptarbtn.setEnabled(true);
                
                delinfo.setText("Haz Click en la celda donde desea agregar la asignatura");
            }break;
            case ELIMINAR_ASIGNATURA:
            {
                finalizar.setEnabled(true);
                limpiar.setEnabled(true);
                addbtn.setEnabled(false);
                delbtn.setEnabled(false);
                
                carreratxt.setEnabled(false);
                semestretxt.setEnabled(false);
                turnotxt.setEnabled(false);
                idtxt.setEnabled(false);
                nextseccionbtn.setEnabled(false);
                previousseccionbtn.setEnabled(false);
                
                asignaturatxt.setEnabled(false);
                nextmateriabtn.setEnabled(false);
                previousmateriabtn.setEnabled(false);
                
                aceptarbtn.setEnabled(false);
                
                delinfo.setText("Haz Click en la celda donde se encuentra la asignatura a eliminar");
            }break;
        }
    }
    
    @SuppressWarnings( "unchecked" )
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jPanel12 = new javax.swing.JPanel();
        asignaturatxt = new javax.swing.JComboBox();
        lblCedula89 = new javax.swing.JLabel();
        lblCedula90 = new javax.swing.JLabel();
        lblCedula91 = new javax.swing.JLabel();
        teoricalbl = new javax.swing.JLabel();
        practicalbl = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        semestretxt = new javax.swing.JComboBox();
        carreratxt = new javax.swing.JComboBox();
        lblCedula43 = new javax.swing.JLabel();
        lblCedula44 = new javax.swing.JLabel();
        lblCedula45 = new javax.swing.JLabel();
        idtxt = new javax.swing.JSpinner();
        lblCedula46 = new javax.swing.JLabel();
        turnotxt = new javax.swing.JComboBox();
        lblCedula25 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        horariotbl = new javax.swing.JTable();
        delinfo = new javax.swing.JLabel();
        nextmateriabtn = new javax.swing.JButton();
        nextseccionbtn = new javax.swing.JButton();
        finalizar = new javax.swing.JButton();
        limpiar = new javax.swing.JButton();
        previousseccionbtn = new javax.swing.JButton();
        previousmateriabtn = new javax.swing.JButton();
        addbtn = new javax.swing.JButton();
        delbtn = new javax.swing.JButton();
        aceptarbtn = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(920, 540));
        setMinimumSize(new java.awt.Dimension(920, 540));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(920, 540));
        setRequestFocusEnabled(false);

        jPanel12.setBackground(new java.awt.Color( 255, 255, 255, 75 ));
        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true), "Asignatura", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 24), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel12.setDoubleBuffered(false);

        asignaturatxt.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        asignaturatxt.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--" }));
        asignaturatxt.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        asignaturatxt.setOpaque(false);
        asignaturatxt.setPreferredSize(new java.awt.Dimension(36, 21));
        asignaturatxt.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                asignaturatxtActionPerformed(evt);
            }
        });

        lblCedula89.setBackground(new java.awt.Color( 255, 255, 255, 75 ));
        lblCedula89.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCedula89.setForeground(new java.awt.Color(255, 255, 255));
        lblCedula89.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCedula89.setText("Nombre");
        lblCedula89.setOpaque(true);

        lblCedula90.setBackground(new java.awt.Color( 255, 255, 255, 75 ));
        lblCedula90.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblCedula90.setForeground(new java.awt.Color(255, 255, 255));
        lblCedula90.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCedula90.setText("Clases de práctica");
        lblCedula90.setOpaque(true);

        lblCedula91.setBackground(new java.awt.Color( 255, 255, 255, 75 ));
        lblCedula91.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblCedula91.setForeground(new java.awt.Color(255, 255, 255));
        lblCedula91.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCedula91.setText("Clases de teoría");
        lblCedula91.setOpaque(true);

        teoricalbl.setBackground(new java.awt.Color( 255, 255, 255, 75 ));
        teoricalbl.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        teoricalbl.setForeground(new java.awt.Color(255, 255, 255));
        teoricalbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        teoricalbl.setText("0");
        teoricalbl.setOpaque(true);

        practicalbl.setBackground(new java.awt.Color( 255, 255, 255, 75 ));
        practicalbl.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        practicalbl.setForeground(new java.awt.Color(255, 255, 255));
        practicalbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        practicalbl.setText("0");
        practicalbl.setOpaque(true);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCedula90, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCedula91, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(teoricalbl, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(practicalbl, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(lblCedula89, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(asignaturatxt, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCedula89)
                    .addComponent(asignaturatxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCedula90)
                    .addComponent(practicalbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(teoricalbl)
                    .addComponent(lblCedula91))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color( 255, 255, 255, 75 ));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true), "Sección", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 20), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel4.setDoubleBuffered(false);

        semestretxt.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        semestretxt.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--" }));
        semestretxt.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        semestretxt.setOpaque(false);
        semestretxt.setPreferredSize(new java.awt.Dimension(36, 21));

        carreratxt.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        carreratxt.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--" }));
        carreratxt.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        carreratxt.setOpaque(false);
        carreratxt.setPreferredSize(new java.awt.Dimension(36, 21));
        carreratxt.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                carreratxtActionPerformed(evt);
            }
        });

        lblCedula43.setBackground(new java.awt.Color( 255, 255, 255, 75 ));
        lblCedula43.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCedula43.setForeground(new java.awt.Color(255, 255, 255));
        lblCedula43.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCedula43.setText("Carrera");
        lblCedula43.setOpaque(true);

        lblCedula44.setBackground(new java.awt.Color( 255, 255, 255, 75 ));
        lblCedula44.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCedula44.setForeground(new java.awt.Color(255, 255, 255));
        lblCedula44.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCedula44.setText("Semestre");
        lblCedula44.setOpaque(true);

        lblCedula45.setBackground(new java.awt.Color( 255, 255, 255, 75 ));
        lblCedula45.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCedula45.setForeground(new java.awt.Color(255, 255, 255));
        lblCedula45.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCedula45.setText("Número");
        lblCedula45.setOpaque(true);

        idtxt.setModel(new javax.swing.SpinnerNumberModel(1, 1, 15, 1));

        lblCedula46.setBackground(new java.awt.Color( 255, 255, 255, 75 ));
        lblCedula46.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCedula46.setForeground(new java.awt.Color(255, 255, 255));
        lblCedula46.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCedula46.setText("Turno");
        lblCedula46.setOpaque(true);

        turnotxt.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        turnotxt.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "DIURNO" }));
        turnotxt.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        turnotxt.setOpaque(false);
        turnotxt.setPreferredSize(new java.awt.Dimension(36, 21));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCedula44, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCedula43, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCedula45, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCedula46, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(idtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(carreratxt, 0, 142, Short.MAX_VALUE)
                    .addComponent(turnotxt, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(semestretxt, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCedula43)
                    .addComponent(carreratxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCedula44)
                    .addComponent(semestretxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCedula46)
                    .addComponent(turnotxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCedula45)
                    .addComponent(idtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        lblCedula25.setBackground(new java.awt.Color( 255, 255, 255, 75 ));
        lblCedula25.setFont(new java.awt.Font("Segoe UI", 1, 26)); // NOI18N
        lblCedula25.setForeground(new java.awt.Color(255, 255, 255));
        lblCedula25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCedula25.setText("ACTUALIZACIÓN DE SECCIÓN");
        lblCedula25.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        lblCedula25.setOpaque(true);

        jPanel3.setBackground(new java.awt.Color( 255, 255, 255, 75 ));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        jPanel3.setDoubleBuffered(false);

        jScrollPane1.setBorder(null);
        jScrollPane1.setOpaque(false);

        horariotbl.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        horariotbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {
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
            new String []
            {
                "Hora", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"
            }
        )
        {
            Class[] types = new Class []
            {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean []
            {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex)
            {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex)
            {
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
        horariotbl.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                horariotblMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(horariotbl);

        delinfo.setBackground(new java.awt.Color( 255, 255, 255, 75 ));
        delinfo.setText("Haz Click en la celda donde se encuentra la asignatura a eliminar");
        delinfo.setOpaque(true);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(delinfo))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 557, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(delinfo)
                .addContainerGap())
        );

        nextmateriabtn.setBackground(new java.awt.Color( 255, 255, 255, 125 ));
        nextmateriabtn.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        nextmateriabtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Themes/Razor/next.png"))); // NOI18N
        nextmateriabtn.setText("Siguiente");
        nextmateriabtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        nextmateriabtn.setContentAreaFilled(false);
        nextmateriabtn.setOpaque(true);
        nextmateriabtn.setPreferredSize(new java.awt.Dimension(100, 25));
        nextmateriabtn.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseEntered(java.awt.event.MouseEvent evt)
            {
                nextmateriabtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt)
            {
                nextmateriabtnMouseExited(evt);
            }
        });
        nextmateriabtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                nextmateriabtnActionPerformed(evt);
            }
        });

        nextseccionbtn.setBackground(new java.awt.Color( 255, 255, 255, 125 ));
        nextseccionbtn.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        nextseccionbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Themes/Razor/next.png"))); // NOI18N
        nextseccionbtn.setText("Siguiente");
        nextseccionbtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        nextseccionbtn.setContentAreaFilled(false);
        nextseccionbtn.setOpaque(true);
        nextseccionbtn.setPreferredSize(new java.awt.Dimension(100, 25));
        nextseccionbtn.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseEntered(java.awt.event.MouseEvent evt)
            {
                nextseccionbtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt)
            {
                nextseccionbtnMouseExited(evt);
            }
        });
        nextseccionbtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                nextseccionbtnActionPerformed(evt);
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
        finalizar.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseEntered(java.awt.event.MouseEvent evt)
            {
                finalizarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt)
            {
                finalizarMouseExited(evt);
            }
        });
        finalizar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                finalizarActionPerformed(evt);
            }
        });

        limpiar.setBackground(new java.awt.Color( 255, 255, 255, 125 ));
        limpiar.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        limpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Themes/Razor/reload.png"))); // NOI18N
        limpiar.setText("Limpiar horario");
        limpiar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        limpiar.setContentAreaFilled(false);
        limpiar.setOpaque(true);
        limpiar.setPreferredSize(new java.awt.Dimension(100, 25));
        limpiar.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseEntered(java.awt.event.MouseEvent evt)
            {
                limpiarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt)
            {
                limpiarMouseExited(evt);
            }
        });
        limpiar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                limpiarActionPerformed(evt);
            }
        });

        previousseccionbtn.setBackground(new java.awt.Color( 255, 255, 255, 125 ));
        previousseccionbtn.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        previousseccionbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Themes/Razor/cancel.png"))); // NOI18N
        previousseccionbtn.setText("Cancelar");
        previousseccionbtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        previousseccionbtn.setContentAreaFilled(false);
        previousseccionbtn.setOpaque(true);
        previousseccionbtn.setPreferredSize(new java.awt.Dimension(100, 25));
        previousseccionbtn.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseEntered(java.awt.event.MouseEvent evt)
            {
                previousseccionbtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt)
            {
                previousseccionbtnMouseExited(evt);
            }
        });
        previousseccionbtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                previousseccionbtnActionPerformed(evt);
            }
        });

        previousmateriabtn.setBackground(new java.awt.Color( 255, 255, 255, 125 ));
        previousmateriabtn.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        previousmateriabtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Themes/Razor/previous.png"))); // NOI18N
        previousmateriabtn.setText("Volver");
        previousmateriabtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        previousmateriabtn.setContentAreaFilled(false);
        previousmateriabtn.setOpaque(true);
        previousmateriabtn.setPreferredSize(new java.awt.Dimension(100, 25));
        previousmateriabtn.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseEntered(java.awt.event.MouseEvent evt)
            {
                previousmateriabtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt)
            {
                previousmateriabtnMouseExited(evt);
            }
        });
        previousmateriabtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                previousmateriabtnActionPerformed(evt);
            }
        });

        addbtn.setBackground(new java.awt.Color( 255, 255, 255, 125 ));
        addbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Themes/Razor/add.png"))); // NOI18N
        addbtn.setText("Agregar Asignatura");
        addbtn.setToolTipText("Haz click para agregar una asignatura");
        addbtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        addbtn.setContentAreaFilled(false);
        addbtn.setOpaque(true);
        addbtn.setPreferredSize(new java.awt.Dimension(100, 25));
        addbtn.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseEntered(java.awt.event.MouseEvent evt)
            {
                addbtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt)
            {
                addbtnMouseExited(evt);
            }
        });
        addbtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                addbtnActionPerformed(evt);
            }
        });

        delbtn.setBackground(new java.awt.Color( 255, 255, 255, 125 ));
        delbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Themes/Razor/del.png"))); // NOI18N
        delbtn.setText("Eliminar Asignatura");
        delbtn.setToolTipText("Haz click para eliminar una asignatura");
        delbtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        delbtn.setContentAreaFilled(false);
        delbtn.setOpaque(true);
        delbtn.setPreferredSize(new java.awt.Dimension(100, 25));
        delbtn.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseEntered(java.awt.event.MouseEvent evt)
            {
                delbtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt)
            {
                delbtnMouseExited(evt);
            }
        });
        delbtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                delbtnActionPerformed(evt);
            }
        });

        aceptarbtn.setBackground(new java.awt.Color( 255, 255, 255, 125 ));
        aceptarbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Themes/Razor/complete.png"))); // NOI18N
        aceptarbtn.setText("Aceptar");
        aceptarbtn.setToolTipText("Haz click para agregar una asignatura");
        aceptarbtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        aceptarbtn.setContentAreaFilled(false);
        aceptarbtn.setOpaque(true);
        aceptarbtn.setPreferredSize(new java.awt.Dimension(100, 25));
        aceptarbtn.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseEntered(java.awt.event.MouseEvent evt)
            {
                aceptarbtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt)
            {
                aceptarbtnMouseExited(evt);
            }
        });
        aceptarbtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                aceptarbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(previousmateriabtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nextmateriabtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(delbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(limpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(finalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(previousseccionbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(nextseccionbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(aceptarbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(lblCedula25, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(lblCedula25, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(aceptarbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nextseccionbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(previousseccionbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nextmateriabtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(previousmateriabtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(delbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(limpiar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(finalizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void finalizarMouseEntered(java.awt.event.MouseEvent evt)//GEN-FIRST:event_finalizarMouseEntered
    {//GEN-HEADEREND:event_finalizarMouseEntered
        finalizar.setBackground( new java.awt.Color( 255, 255, 255, 175 ) );
    }//GEN-LAST:event_finalizarMouseEntered

    private void finalizarMouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_finalizarMouseExited
    {//GEN-HEADEREND:event_finalizarMouseExited
        finalizar.setBackground( new java.awt.Color( 255, 255, 255, 125 ) );
    }//GEN-LAST:event_finalizarMouseExited

    private void limpiarMouseEntered(java.awt.event.MouseEvent evt)//GEN-FIRST:event_limpiarMouseEntered
    {//GEN-HEADEREND:event_limpiarMouseEntered
        limpiar.setBackground( new java.awt.Color( 255, 255, 255, 175 ) );
    }//GEN-LAST:event_limpiarMouseEntered

    private void limpiarMouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_limpiarMouseExited
    {//GEN-HEADEREND:event_limpiarMouseExited
        limpiar.setBackground( new java.awt.Color( 255, 255, 255, 125 ) );
    }//GEN-LAST:event_limpiarMouseExited

    private void previousseccionbtnMouseEntered(java.awt.event.MouseEvent evt)//GEN-FIRST:event_previousseccionbtnMouseEntered
    {//GEN-HEADEREND:event_previousseccionbtnMouseEntered
        previousseccionbtn.setBackground( new java.awt.Color( 255, 255, 255, 175 ) );
    }//GEN-LAST:event_previousseccionbtnMouseEntered

    private void previousseccionbtnMouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_previousseccionbtnMouseExited
    {//GEN-HEADEREND:event_previousseccionbtnMouseExited
        previousseccionbtn.setBackground( new java.awt.Color( 255, 255, 255, 125 ) );
    }//GEN-LAST:event_previousseccionbtnMouseExited

    private void previousmateriabtnMouseEntered(java.awt.event.MouseEvent evt)//GEN-FIRST:event_previousmateriabtnMouseEntered
    {//GEN-HEADEREND:event_previousmateriabtnMouseEntered
        previousmateriabtn.setBackground( new java.awt.Color( 255, 255, 255, 175 ) );
    }//GEN-LAST:event_previousmateriabtnMouseEntered

    private void previousmateriabtnMouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_previousmateriabtnMouseExited
    {//GEN-HEADEREND:event_previousmateriabtnMouseExited
        previousmateriabtn.setBackground( new java.awt.Color( 255, 255, 255, 125 ) );
    }//GEN-LAST:event_previousmateriabtnMouseExited

    private void nextmateriabtnMouseEntered(java.awt.event.MouseEvent evt)//GEN-FIRST:event_nextmateriabtnMouseEntered
    {//GEN-HEADEREND:event_nextmateriabtnMouseEntered
        nextmateriabtn.setBackground( new java.awt.Color( 255, 255, 255, 175 ) );
    }//GEN-LAST:event_nextmateriabtnMouseEntered

    private void nextmateriabtnMouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_nextmateriabtnMouseExited
    {//GEN-HEADEREND:event_nextmateriabtnMouseExited
        nextmateriabtn.setBackground( new java.awt.Color( 255, 255, 255, 125 ) );
    }//GEN-LAST:event_nextmateriabtnMouseExited

    private void nextseccionbtnMouseEntered(java.awt.event.MouseEvent evt)//GEN-FIRST:event_nextseccionbtnMouseEntered
    {//GEN-HEADEREND:event_nextseccionbtnMouseEntered
        nextseccionbtn.setBackground( new java.awt.Color( 255, 255, 255, 175 ) );
        project.Controller.Application.repaintScreen();
    }//GEN-LAST:event_nextseccionbtnMouseEntered

    private void nextseccionbtnMouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_nextseccionbtnMouseExited
    {//GEN-HEADEREND:event_nextseccionbtnMouseExited
        nextseccionbtn.setBackground( new java.awt.Color( 255, 255, 255, 125 ) );
    }//GEN-LAST:event_nextseccionbtnMouseExited

    private void addbtnMouseEntered(java.awt.event.MouseEvent evt)//GEN-FIRST:event_addbtnMouseEntered
    {//GEN-HEADEREND:event_addbtnMouseEntered
        addbtn.setBackground( new java.awt.Color( 255, 255, 255, 200 ) );
    }//GEN-LAST:event_addbtnMouseEntered

    private void addbtnMouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_addbtnMouseExited
    {//GEN-HEADEREND:event_addbtnMouseExited
        addbtn.setBackground( new java.awt.Color( 255, 255, 255, 125 ) );
    }//GEN-LAST:event_addbtnMouseExited

    private void addbtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_addbtnActionPerformed
    {//GEN-HEADEREND:event_addbtnActionPerformed
        if( horario.isEmpty() )
            establecerModo( EDITION_MODE.AGREGAR_ASIGNATURA );
        else
            establecerModo( EDITION_MODE.AGREGAR_ASIGNATURA_2 );
    }//GEN-LAST:event_addbtnActionPerformed

    private void delbtnMouseEntered(java.awt.event.MouseEvent evt)//GEN-FIRST:event_delbtnMouseEntered
    {//GEN-HEADEREND:event_delbtnMouseEntered
        delbtn.setBackground( new java.awt.Color( 255, 255, 255, 200 ) );
    }//GEN-LAST:event_delbtnMouseEntered

    private void delbtnMouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_delbtnMouseExited
    {//GEN-HEADEREND:event_delbtnMouseExited
        delbtn.setBackground( new java.awt.Color( 255, 255, 255, 125 ) );
    }//GEN-LAST:event_delbtnMouseExited

    private void delbtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_delbtnActionPerformed
    {//GEN-HEADEREND:event_delbtnActionPerformed
        if( horario.size() > 0 )
            establecerModo( EDITION_MODE.ELIMINAR_ASIGNATURA );
    }//GEN-LAST:event_delbtnActionPerformed

    private void nextseccionbtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_nextseccionbtnActionPerformed
    {//GEN-HEADEREND:event_nextseccionbtnActionPerformed
        establecerModo( EDITION_MODE.AGREGAR_ASIGNATURA_2 );
    }//GEN-LAST:event_nextseccionbtnActionPerformed

    private void nextmateriabtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_nextmateriabtnActionPerformed
    {//GEN-HEADEREND:event_nextmateriabtnActionPerformed
        establecerModo( EDITION_MODE.AGREGAR_ASIGNATURA_3 );
    }//GEN-LAST:event_nextmateriabtnActionPerformed

    private void previousmateriabtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_previousmateriabtnActionPerformed
    {//GEN-HEADEREND:event_previousmateriabtnActionPerformed
        if( horario.isEmpty() )
            establecerModo( EDITION_MODE.AGREGAR_ASIGNATURA );
        else
            establecerModo( EDITION_MODE.NORMAL );
        
        actualizarTabla();
    }//GEN-LAST:event_previousmateriabtnActionPerformed

    private void previousseccionbtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_previousseccionbtnActionPerformed
    {//GEN-HEADEREND:event_previousseccionbtnActionPerformed
        establecerModo( EDITION_MODE.NORMAL );
    }//GEN-LAST:event_previousseccionbtnActionPerformed

    private void carreratxtActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_carreratxtActionPerformed
    {//GEN-HEADEREND:event_carreratxtActionPerformed
        cargarSemestres();
    }//GEN-LAST:event_carreratxtActionPerformed

    private void asignaturatxtActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_asignaturatxtActionPerformed
    {//GEN-HEADEREND:event_asignaturatxtActionPerformed
        cargarHoras();
        project.Controller.Application.repaintScreen();
    }//GEN-LAST:event_asignaturatxtActionPerformed

    private void horariotblMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_horariotblMouseClicked
    {//GEN-HEADEREND:event_horariotblMouseClicked
        int row = horariotbl.getSelectedRow();
        int col = horariotbl.getSelectedColumn();
        
        if( row >= 0 && col >= 1 )
        {
            // Agregar una materia a la tabla
            if( m_asignatura != null )
            {
                if( m_mode == EDITION_MODE.AGREGAR_ASIGNATURA_3 )
                { 
                    if( practicalbl.getText().equals("0") && teoricalbl.getText().equals("0") )
                        return;
                    
                    int res;
                    if( m_asignatura.getPracticas() > 0 )
                        res = project.Controller.Application.showMessageDialog("Agregar Asignatura", "", 2, new String[]{"Bloque teórico", "Bloque práctico"}, new String[] {"teoria", "lab"} );
                    else
                        res = 1;
                    
                    int duracion;
                    String value = m_asignatura.getNombre();
                    
                    if( res == 1 )
                    {
                        if( m_asignatura.getTeoricas() == asignaturaSeccion.getTeoricas() )
                        {
                            project.Controller.Application.showMessageDialog("Ha alcanzado el límite de bloques de teoría a registrar");
                            return;
                        }
                        duracion = m_asignatura.getDuracionTeoricas(); 
                    }
                    else if( res == 2 )
                    {
                        if( m_asignatura.getPracticas() == asignaturaSeccion.getPracticas() )
                        {
                            project.Controller.Application.showMessageDialog("Ha alcanzado el límite de bloques de practica a registrar");
                            return;
                        }
                        duracion = m_asignatura.getDuracionPracticas();
                        value += "-Laboratorio";
                    }
                    else
                        return;
                    
                    if( row + duracion >= horariotbl.getModel().getRowCount() )
                        return;
                    
                    String conflicto = "Unknown"; 
                    boolean isLibre = true;
                    for( int i = 0; i < duracion; ++i )
                    {
                        conflicto = ( String ) horariotbl.getModel().getValueAt(row+i, col);
                        if( conflicto != null && !conflicto.equals("") )
                            isLibre = false;
                    }
                    
                    if( isLibre )
                    {
                        for( int i = 0; i < duracion; ++i )
                            horariotbl.getModel().setValueAt( m_asignatura.getNombre(), row+i, col );
                    }
                    else
                    {
                        project.Controller.Application.showMessageDialog("Existe un conflicto de asignaturas",  conflicto + " - " + value, 1, new String[]{"Aceptar"}, new String[]{"Accept"});
                        return;
                    }
                    
                    asignaturaSeccion.agregarBloque( col, row, res );
                    if( res == 1 )
                        asignaturaSeccion.setTeoricas( asignaturaSeccion.getTeoricas() + 1 );
                    else 
                        asignaturaSeccion.setPracticas( asignaturaSeccion.getPracticas() + 1 );
                    
                    actualizarHoras();
                }
                // Eliminar una materia de la tabla
                else if( m_mode == EDITION_MODE.ELIMINAR_ASIGNATURA )
                {
                    String seleccion = ( String ) horariotbl.getModel().getValueAt(row, col);
                    if( !seleccion.equals("") )
                    {
                        String nombre;
                        if( seleccion.endsWith("-Laboratorio") )
                            nombre = seleccion.substring( 0, seleccion.indexOf('-') );
                        else
                            nombre = seleccion;
                        
                        for( project.Model.AsignaturaSeccion a : horario )
                            if( a.getNombre() != null && a.getNombre().equals(nombre) )
                            {
                                horario.remove(a);
                                break;
                            }
                        actualizarTabla();
                        
                        establecerModo( EDITION_MODE.NORMAL );
                    }
                    else
                        establecerModo( EDITION_MODE.NORMAL );
                }
            }
        }
        
        project.Controller.Application.repaintScreen();
    }//GEN-LAST:event_horariotblMouseClicked

    private void aceptarbtnMouseEntered(java.awt.event.MouseEvent evt)//GEN-FIRST:event_aceptarbtnMouseEntered
    {//GEN-HEADEREND:event_aceptarbtnMouseEntered
        project.Controller.Application.repaintScreen();
    }//GEN-LAST:event_aceptarbtnMouseEntered

    private void aceptarbtnMouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_aceptarbtnMouseExited
    {//GEN-HEADEREND:event_aceptarbtnMouseExited
        project.Controller.Application.repaintScreen();
    }//GEN-LAST:event_aceptarbtnMouseExited

    private void aceptarbtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_aceptarbtnActionPerformed
    {//GEN-HEADEREND:event_aceptarbtnActionPerformed
        if( teoricalbl.getText().equals("0") && practicalbl.getText().equals("0") )
        {
            horario.add(asignaturaSeccion);
            establecerModo( EDITION_MODE.NORMAL );
            
            actualizarTabla();
        }
        else
            project.Controller.Application.showMessageDialog("Existen bloques horarios por asignar");
    }//GEN-LAST:event_aceptarbtnActionPerformed

    private void limpiarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_limpiarActionPerformed
    {//GEN-HEADEREND:event_limpiarActionPerformed
        horario.clear();
        actualizarTabla();
    }//GEN-LAST:event_limpiarActionPerformed

    private void finalizarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_finalizarActionPerformed
    {//GEN-HEADEREND:event_finalizarActionPerformed
        project.Model.Seccion seccion = new project.Model.Seccion();
        seccion.setId(Integer.parseInt("" + idtxt.getValue()));
        seccion.setKeyCarrera(carreratxt.getSelectedIndex()+1);
        seccion.setKeySemestre(semestretxt.getSelectedIndex()+1);
        seccion.setHorario(horario);
        
        if( project.Controller.Application.onSeccionCreated(seccion) )
        {
            project.Controller.Application.showMessageDialog("Se ha registrado el horario éxitosamente");
            project.Controller.Application.callInicio();
        }
        else
            project.Controller.Application.showSqlErrorMessageDialog();
    }//GEN-LAST:event_finalizarActionPerformed

    @Override
    public void paintComponent( java.awt.Graphics g )
    {
        super.paintComponent(g);
        
        if( Egoist.Swing.Animator.isBeingAnimated(this) == false )
            repaint();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptarbtn;
    private javax.swing.JButton addbtn;
    private javax.swing.JComboBox asignaturatxt;
    private javax.swing.JComboBox carreratxt;
    private javax.swing.JButton delbtn;
    private javax.swing.JLabel delinfo;
    private javax.swing.JButton finalizar;
    private javax.swing.JTable horariotbl;
    private javax.swing.JSpinner idtxt;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCedula25;
    private javax.swing.JLabel lblCedula43;
    private javax.swing.JLabel lblCedula44;
    private javax.swing.JLabel lblCedula45;
    private javax.swing.JLabel lblCedula46;
    private javax.swing.JLabel lblCedula89;
    private javax.swing.JLabel lblCedula90;
    private javax.swing.JLabel lblCedula91;
    private javax.swing.JButton limpiar;
    private javax.swing.JButton nextmateriabtn;
    private javax.swing.JButton nextseccionbtn;
    private javax.swing.JLabel practicalbl;
    private javax.swing.JButton previousmateriabtn;
    private javax.swing.JButton previousseccionbtn;
    private javax.swing.JComboBox semestretxt;
    private javax.swing.JLabel teoricalbl;
    private javax.swing.JComboBox turnotxt;
    // End of variables declaration//GEN-END:variables
}
