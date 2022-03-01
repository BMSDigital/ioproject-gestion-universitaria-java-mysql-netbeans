package project.View;

import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import project.Model.Bitacora;

public class ListadoBitacora extends javax.swing.JPanel
{
    ArrayList<Bitacora> listaBase = new ArrayList();
    ArrayList<Bitacora> listaFiltro = new ArrayList();
    ArrayList<ArrayList<Bitacora>> historial = new ArrayList();
    int index = 0;

    public ListadoBitacora()
    {
        initComponents();
        
        JPanel panel = new JPanel()
        {
            private java.awt.Image tableImage;
            
            @Override
            public void paintComponent( java.awt.Graphics g )
            {
                super.paintComponent(g);

                if( tableImage != null )
                    g.drawImage(tableImage, 0, 0, this);
                else
                    tableImage = Egoist.Swing.Image.setAlpha(project.Controller.Application.getThemeItem("tablepanel", getWidth(), getHeight()), 125 );
            }
        };
        panel.setOpaque(false);
        panel.setSize( 915, 322 );
        jScrollPane1.add(panel);
        
        actualizarListado();
        cargarValores();
        
        ((DefaultTableCellRenderer)bitacoratbl.getDefaultRenderer(Object.class)).setOpaque(false);
        jScrollPane1.getViewport().setOpaque(false);
    }
    
    public String getProfesorValue(String key, Bitacora b)
    {
        String valor;
        
        switch( key )
        {
            case "Usuario":
            {
                valor = b.getNombre();
            }
            break;
            case "Evento":
            {
                valor = b.getDescripcion();
            }
            break;
            case "Resultado":
            {
                valor = b.getResultado();
            }
            break;
            default:
            {
                valor ="Unknown";
            }break;
        }
        
        return(valor);
    }

    public void actualizarListado()
    {
        listaBase = project.Controller.Application.loadDbItems(new Bitacora());
        listaFiltro = ( ArrayList<Bitacora> ) listaBase.clone();
        
        historial = new ArrayList();
        historial.add(listaFiltro);
        index = 1;
        
        cargarTabla();
    }

    public void cargarValores()
    {
        String item = "" + atributostxt.getSelectedItem();
        DefaultComboBoxModel model = new DefaultComboBoxModel();

        for( int i = 0; i < listaFiltro.size(); ++i )
        {
            Bitacora b = listaFiltro.get(i);
            String valor = getProfesorValue(item, b);

            boolean exists = false;
            for( int j = 0; j < model.getSize(); ++j )
            {
                if( model.getElementAt(j).equals(valor) )
                {
                    exists = true;
                    break;
                }
            }

            if( !exists )
            {
                model.addElement(valor);
            }
        }

        valorestxt.setModel(model);
    }

    public void cargarTabla()
    {
        String[] columns = new String[bitacoratbl.getColumnCount()];
        for( int i = 0; i < columns.length; ++i )
            columns[i] = bitacoratbl.getColumnName(i);
        
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);

        for( Bitacora b : listaFiltro )
        {
            String[] row = new String[12];
            row[0] = b.getNombre();
            row[1] = b.getFecha();
            row[2] = b.getHora();
            row[3] = b.getDescripcion();
            row[4] = b.getResultado();

            model.addRow(row);
        }

        bitacoratbl.setModel(model);
    }

    public void filtrar()
    {
        ArrayList<Bitacora> nuevaLista = new ArrayList();
        
        String key = "" + atributostxt.getSelectedItem();
        String value = "" + valorestxt.getSelectedItem();

        for( Bitacora b : listaFiltro )
        {
            if( value.equals(getProfesorValue(key, b)) )
                nuevaLista.add(b);
        }

        if(nuevaLista.size() != listaFiltro.size())
        {
            if( historial.size() > 0 )
                for( int i = index; i < historial.size(); ++i )
                    historial.remove(i);
            historial.add(nuevaLista);
            setIndex(1);
        }
    }

    public void setIndex( int dir )
    {
        if( index + dir > 0 && index + dir <= historial.size() )
        {
            index += dir;
            listaFiltro = historial.get(index-1);
            cargarTabla();
        }
    }
    

    @SuppressWarnings( "unchecked" )
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        bitacoratbl = new javax.swing.JTable();
        exportar = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        lblCedula47 = new javax.swing.JLabel();
        atributostxt = new javax.swing.JComboBox();
        valorestxt = new javax.swing.JComboBox();
        lblCedula48 = new javax.swing.JLabel();
        buscarbtn = new javax.swing.JButton();
        previous = new javax.swing.JButton();
        nextbtn = new javax.swing.JButton();
        actualizarbtn = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(1029, 616));
        setMinimumSize(new java.awt.Dimension(1029, 616));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(1029, 616));

        jPanel3.setBackground(new java.awt.Color( 255, 255, 255, 75 ));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true), "Bitácora", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 24), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel3.setDoubleBuffered(false);

        jScrollPane1.setBorder(null);
        jScrollPane1.setOpaque(false);

        bitacoratbl.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        bitacoratbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {
                "Usuario", "Fecha de evento", "Hora de evento", "Descripción de evento", "Resultado"
            }
        )
        {
            Class[] types = new Class []
            {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean []
            {
                false, false, false, false, false
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
        bitacoratbl.setGridColor(new java.awt.Color(255, 255, 255));
        bitacoratbl.setOpaque(false);
        bitacoratbl.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        bitacoratbl.setUpdateSelectionOnSort(false);
        bitacoratbl.setVerifyInputWhenFocusTarget(false);
        bitacoratbl.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                bitacoratblMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(bitacoratbl);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
                .addContainerGap())
        );

        exportar.setBackground(new java.awt.Color( 255, 255, 255, 125 ));
        exportar.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        exportar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Themes/Razor/finish.png"))); // NOI18N
        exportar.setText("Exportar");
        exportar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        exportar.setContentAreaFilled(false);
        exportar.setOpaque(true);
        exportar.setPreferredSize(new java.awt.Dimension(100, 25));
        exportar.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseEntered(java.awt.event.MouseEvent evt)
            {
                exportarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt)
            {
                exportarMouseExited(evt);
            }
        });
        exportar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                exportarActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color( 255, 255, 255, 50 ));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true), "Gestor de consultas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 20), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel5.setDoubleBuffered(false);

        lblCedula47.setBackground(new java.awt.Color( 255, 255, 255, 75 ));
        lblCedula47.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCedula47.setForeground(new java.awt.Color(255, 255, 255));
        lblCedula47.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCedula47.setText("Atributo");
        lblCedula47.setOpaque(true);

        atributostxt.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        atributostxt.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Usuario", "Evento", "Resultado" }));
        atributostxt.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        atributostxt.setDoubleBuffered(true);
        atributostxt.setOpaque(false);
        atributostxt.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                atributostxtActionPerformed(evt);
            }
        });

        valorestxt.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        valorestxt.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        valorestxt.setDoubleBuffered(true);
        valorestxt.setOpaque(false);

        lblCedula48.setBackground(new java.awt.Color( 255, 255, 255, 75 ));
        lblCedula48.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCedula48.setForeground(new java.awt.Color(255, 255, 255));
        lblCedula48.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCedula48.setText("Valor");
        lblCedula48.setOpaque(true);

        buscarbtn.setBackground(new java.awt.Color( 255, 255, 255, 125 ));
        buscarbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Themes/Razor/finish.png"))); // NOI18N
        buscarbtn.setText("Buscar");
        buscarbtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        buscarbtn.setContentAreaFilled(false);
        buscarbtn.setOpaque(true);
        buscarbtn.setPreferredSize(new java.awt.Dimension(100, 25));
        buscarbtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                buscarbtnActionPerformed(evt);
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

        actualizarbtn.setBackground(new java.awt.Color( 255, 255, 255, 125 ));
        actualizarbtn.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        actualizarbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Themes/Razor/reload.png"))); // NOI18N
        actualizarbtn.setText("Actualizar");
        actualizarbtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        actualizarbtn.setContentAreaFilled(false);
        actualizarbtn.setOpaque(true);
        actualizarbtn.setPreferredSize(new java.awt.Dimension(100, 25));
        actualizarbtn.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseEntered(java.awt.event.MouseEvent evt)
            {
                actualizarbtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt)
            {
                actualizarbtnMouseExited(evt);
            }
        });
        actualizarbtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                actualizarbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(actualizarbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(previous, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nextbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(lblCedula47, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(atributostxt, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblCedula48, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(valorestxt, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buscarbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCedula47)
                    .addComponent(atributostxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(valorestxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCedula48)
                    .addComponent(buscarbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nextbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(previous, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(actualizarbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(exportar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 949, Short.MAX_VALUE))
                .addGap(40, 40, 40))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(exportar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bitacoratblMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_bitacoratblMouseClicked
    {//GEN-HEADEREND:event_bitacoratblMouseClicked
        int row = bitacoratbl.getSelectedRow();
        int col = bitacoratbl.getSelectedColumn();
    }//GEN-LAST:event_bitacoratblMouseClicked

    private void exportarMouseEntered(java.awt.event.MouseEvent evt)//GEN-FIRST:event_exportarMouseEntered
    {//GEN-HEADEREND:event_exportarMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_exportarMouseEntered

    private void exportarMouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_exportarMouseExited
    {//GEN-HEADEREND:event_exportarMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_exportarMouseExited

    private void atributostxtActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_atributostxtActionPerformed
    {//GEN-HEADEREND:event_atributostxtActionPerformed
        cargarValores();
    }//GEN-LAST:event_atributostxtActionPerformed

    private void buscarbtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_buscarbtnActionPerformed
    {//GEN-HEADEREND:event_buscarbtnActionPerformed
        filtrar();
    }//GEN-LAST:event_buscarbtnActionPerformed

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
        setIndex(-1);
    }//GEN-LAST:event_previousActionPerformed

    private void nextbtnMouseEntered(java.awt.event.MouseEvent evt)//GEN-FIRST:event_nextbtnMouseEntered
    {//GEN-HEADEREND:event_nextbtnMouseEntered
        nextbtn.setBackground(new java.awt.Color(255, 255, 255, 175));
        project.Controller.Application.repaintScreen();
    }//GEN-LAST:event_nextbtnMouseEntered

    private void nextbtnMouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_nextbtnMouseExited
    {//GEN-HEADEREND:event_nextbtnMouseExited
        nextbtn.setBackground(new java.awt.Color(255, 255, 255, 125));
        project.Controller.Application.repaintScreen();
    }//GEN-LAST:event_nextbtnMouseExited

    private void nextbtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_nextbtnActionPerformed
    {//GEN-HEADEREND:event_nextbtnActionPerformed
        setIndex(1);
    }//GEN-LAST:event_nextbtnActionPerformed

    private void actualizarbtnMouseEntered(java.awt.event.MouseEvent evt)//GEN-FIRST:event_actualizarbtnMouseEntered
    {//GEN-HEADEREND:event_actualizarbtnMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_actualizarbtnMouseEntered

    private void actualizarbtnMouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_actualizarbtnMouseExited
    {//GEN-HEADEREND:event_actualizarbtnMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_actualizarbtnMouseExited

    private void actualizarbtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_actualizarbtnActionPerformed
    {//GEN-HEADEREND:event_actualizarbtnActionPerformed
        actualizarListado();
    }//GEN-LAST:event_actualizarbtnActionPerformed

    private void exportarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_exportarActionPerformed
    {//GEN-HEADEREND:event_exportarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_exportarActionPerformed

    @Override
    public void paintComponent( java.awt.Graphics g )
    {
        super.paintComponent(g);
        
        if( Egoist.Swing.Animator.isBeingAnimated(this) == false )
            repaint();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton actualizarbtn;
    private javax.swing.JComboBox atributostxt;
    private javax.swing.JTable bitacoratbl;
    private javax.swing.JButton buscarbtn;
    private javax.swing.JButton exportar;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCedula47;
    private javax.swing.JLabel lblCedula48;
    private javax.swing.JButton nextbtn;
    private javax.swing.JButton previous;
    private javax.swing.JComboBox valorestxt;
    // End of variables declaration//GEN-END:variables
}
