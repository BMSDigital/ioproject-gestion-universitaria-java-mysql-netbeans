package project.View;

import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import project.Model.Profesor;

public class ListadoProfesor extends javax.swing.JPanel
{
    ArrayList<Profesor> listaBase = new ArrayList();
    ArrayList<Profesor> listaFiltro = new ArrayList();
    ArrayList<ArrayList<Profesor>> historial = new ArrayList();
    int index = 0;

    public ListadoProfesor()
    {
        initComponents();

        actualizarListado();
        cargarValores();
    }

    public String getProfesorValue(String key, Profesor p)
    {
        String valor;
        
        switch( key )
        {
            case "Cédula":
            {
                valor = p.getCedula();
            }
            break;
            case "Nombres":
            {
                valor = p.getNombre();
            }
            break;
            case "Apellidos":
            {
                valor = p.getApellido();
            }
            break;
            case "Sexo":
            {
                valor = p.getSexo();
            }
            break;
            case "Estado Civil":
            {
                valor = p.getEdoCivil();
            }
            break;
            case "Teléfono Célular":
            {
                valor = p.getCelular();
            }
            break;
            case "Teléfono Fijo":
            {
                valor = p.getFijo();
            }
            break;
            case "Profesión":
            {
                valor = p.getProfesion();
            }
            break;
            case "Títulos":
            {
                valor = p.getTitulos();
            }
            break;
            case "Especialidades":
            {
                valor = p.getEspecialidades();
            }
            break;
            case "Tipo de Contrato":
            {
                valor = p.getTipoContrato();
            }
            break;
            case "Status":
            {
                valor = p.getStatus() == 'a' ? "Activo" : "Inactivo";
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
        listaBase = project.Controller.Application.loadDbItems(new Profesor());
        listaFiltro = ( ArrayList<Profesor> ) listaBase.clone();
        
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
            Profesor p = listaFiltro.get(i);
            String valor = getProfesorValue(item, p);

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
        String[] columns = new String[listadotbl.getColumnCount()];
        for( int i = 0; i < columns.length; ++i )
            columns[i] = listadotbl.getColumnName(i);
        
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);

        for( Profesor p : listaFiltro )
        {
            String[] row = new String[12];
            row[0] = p.getCedula();
            row[1] = p.getNombre();
            row[2] = p.getApellido();
            row[3] = p.getSexo();
            row[4] = p.getEdoCivil();
            row[5] = p.getEspecialidades();
            row[6] = p.getTipoContrato();
            row[7] = p.getStatus() == 'a' ? "Activo" : "Inactivo";

            model.addRow(row);
        }

        listadotbl.setModel(model);
    }

    public void filtrar()
    {
        ArrayList<Profesor> nuevaLista = new ArrayList();
        
        String key = "" + atributostxt.getSelectedItem();
        String value = "" + valorestxt.getSelectedItem();

        for( Profesor p : listaFiltro )
        {
            if( value.equals(getProfesorValue(key, p)) )
                nuevaLista.add(p);
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
            System.out.println(index + " .... " + historial.size() + " ... " + listaFiltro.size());
        }
    }
    
    @SuppressWarnings( "unchecked" )
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listadotbl = new javax.swing.JTable();
        modificarbtn = new javax.swing.JButton();
        expandirbtn = new javax.swing.JButton();
        eliminarbtn = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        lblCedula47 = new javax.swing.JLabel();
        atributostxt = new javax.swing.JComboBox();
        valorestxt = new javax.swing.JComboBox();
        lblCedula48 = new javax.swing.JLabel();
        buscarbtn = new javax.swing.JButton();
        previous = new javax.swing.JButton();
        nextbtn = new javax.swing.JButton();
        actualizarbtn = new javax.swing.JButton();
        activarbtn = new javax.swing.JButton();
        jScrollBar1 = new javax.swing.JScrollBar();

        setMaximumSize(new java.awt.Dimension(1029, 616));
        setMinimumSize(new java.awt.Dimension(1029, 616));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(1029, 616));

        jPanel3.setBackground(new java.awt.Color( 255, 255, 255, 75 ));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true), "Listado de Profesores", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 24), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel3.setDoubleBuffered(false);

        jScrollPane1.setBorder(null);
        jScrollPane1.setMaximumSize(new java.awt.Dimension(450, 400));
        jScrollPane1.setMinimumSize(new java.awt.Dimension(450, 400));
        jScrollPane1.setOpaque(false);

        listadotbl.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        listadotbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cédula", "Nombres", "Apellidos", "Sexo", "Estado Civil", "Especialidades", "Tipo de Contrato", "Status"
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
        listadotbl.setGridColor(new java.awt.Color(204, 204, 204));
        listadotbl.setOpaque(false);
        listadotbl.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listadotbl.setUpdateSelectionOnSort(false);
        listadotbl.setVerifyInputWhenFocusTarget(false);
        listadotbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listadotblMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listadotbl);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 323, Short.MAX_VALUE)
                .addContainerGap())
        );

        modificarbtn.setBackground(new java.awt.Color( 255, 255, 255, 125 ));
        modificarbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Themes/Razor/finish.png"))); // NOI18N
        modificarbtn.setText("Modificar");
        modificarbtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        modificarbtn.setContentAreaFilled(false);
        modificarbtn.setOpaque(true);
        modificarbtn.setPreferredSize(new java.awt.Dimension(100, 25));
        modificarbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                modificarbtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                modificarbtnMouseExited(evt);
            }
        });

        expandirbtn.setBackground(new java.awt.Color( 255, 255, 255, 125 ));
        expandirbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Themes/Razor/finish.png"))); // NOI18N
        expandirbtn.setText("Expandir");
        expandirbtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        expandirbtn.setContentAreaFilled(false);
        expandirbtn.setOpaque(true);
        expandirbtn.setPreferredSize(new java.awt.Dimension(100, 25));
        expandirbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                expandirbtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                expandirbtnMouseExited(evt);
            }
        });

        eliminarbtn.setBackground(new java.awt.Color( 255, 255, 255, 125 ));
        eliminarbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Themes/Razor/finish.png"))); // NOI18N
        eliminarbtn.setText("Eliminar");
        eliminarbtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        eliminarbtn.setContentAreaFilled(false);
        eliminarbtn.setOpaque(true);
        eliminarbtn.setPreferredSize(new java.awt.Dimension(100, 25));
        eliminarbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                eliminarbtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                eliminarbtnMouseExited(evt);
            }
        });
        eliminarbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarbtnActionPerformed(evt);
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
        atributostxt.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cédula", "Nombres", "Apellidos", "Sexo", "Estado Civil", "Especialidades", "Tipo de Contrato", "Status" }));
        atributostxt.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        atributostxt.setDoubleBuffered(true);
        atributostxt.setOpaque(false);
        atributostxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
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
        buscarbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buscarbtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buscarbtnMouseExited(evt);
            }
        });
        buscarbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
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

        actualizarbtn.setBackground(new java.awt.Color( 255, 255, 255, 125 ));
        actualizarbtn.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        actualizarbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Themes/Razor/reload.png"))); // NOI18N
        actualizarbtn.setText("Actualizar");
        actualizarbtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        actualizarbtn.setContentAreaFilled(false);
        actualizarbtn.setOpaque(true);
        actualizarbtn.setPreferredSize(new java.awt.Dimension(100, 25));
        actualizarbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                actualizarbtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                actualizarbtnMouseExited(evt);
            }
        });
        actualizarbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
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

        activarbtn.setBackground(new java.awt.Color( 255, 255, 255, 125 ));
        activarbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Themes/Razor/finish.png"))); // NOI18N
        activarbtn.setText("Reactivar");
        activarbtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        activarbtn.setContentAreaFilled(false);
        activarbtn.setOpaque(true);
        activarbtn.setPreferredSize(new java.awt.Dimension(100, 25));
        activarbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                activarbtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                activarbtnMouseExited(evt);
            }
        });
        activarbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                activarbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(activarbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(eliminarbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(expandirbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(modificarbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 38, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(modificarbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(expandirbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(eliminarbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(activarbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(48, 48, 48))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void listadotblMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_listadotblMouseClicked
    {//GEN-HEADEREND:event_listadotblMouseClicked
        int row = listadotbl.getSelectedRow();
        int col = listadotbl.getSelectedColumn();
    }//GEN-LAST:event_listadotblMouseClicked

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
        project.Controller.Application.repaintScreen();
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
        project.Controller.Application.repaintScreen();
    }//GEN-LAST:event_nextbtnActionPerformed

    private void actualizarbtnMouseEntered(java.awt.event.MouseEvent evt)//GEN-FIRST:event_actualizarbtnMouseEntered
    {//GEN-HEADEREND:event_actualizarbtnMouseEntered
        actualizarbtn.setBackground(new java.awt.Color(255, 255, 255, 175));
        project.Controller.Application.repaintScreen();
    }//GEN-LAST:event_actualizarbtnMouseEntered

    private void actualizarbtnMouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_actualizarbtnMouseExited
    {//GEN-HEADEREND:event_actualizarbtnMouseExited
        actualizarbtn.setBackground(new java.awt.Color(255, 255, 255, 125));
        project.Controller.Application.repaintScreen();
    }//GEN-LAST:event_actualizarbtnMouseExited

    private void actualizarbtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_actualizarbtnActionPerformed
    {//GEN-HEADEREND:event_actualizarbtnActionPerformed
        actualizarListado();
        project.Controller.Application.repaintScreen();
    }//GEN-LAST:event_actualizarbtnActionPerformed

    private void atributostxtActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_atributostxtActionPerformed
    {//GEN-HEADEREND:event_atributostxtActionPerformed
        cargarValores();
        project.Controller.Application.repaintScreen();
    }//GEN-LAST:event_atributostxtActionPerformed

    private void buscarbtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_buscarbtnActionPerformed
    {//GEN-HEADEREND:event_buscarbtnActionPerformed
        filtrar();
        project.Controller.Application.repaintScreen();
    }//GEN-LAST:event_buscarbtnActionPerformed

    private void activarbtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_activarbtnActionPerformed
    {//GEN-HEADEREND:event_activarbtnActionPerformed
        if( listadotbl.getSelectedRow() >= 0 )
        {
            Profesor p = listaFiltro.get(listadotbl.getSelectedRow());
            if( p.getStatus() != 'a' )
                p.setStatus('a');

            if( project.Controller.Application.onProfesorStatusChanged(p))
                p.setStatus('a');
            else
                project.Controller.Application.showSqlErrorMessageDialog();

            cargarTabla();
        }
        project.Controller.Application.repaintScreen();
    }//GEN-LAST:event_activarbtnActionPerformed

    private void eliminarbtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_eliminarbtnActionPerformed
    {//GEN-HEADEREND:event_eliminarbtnActionPerformed
        if( listadotbl.getSelectedRow() >= 0 )
        {
            Profesor p = listaFiltro.get(listadotbl.getSelectedRow());

            if( p.getStatus() != 'e' )
                p.setStatus('e');

            if( project.Controller.Application.onProfesorStatusChanged(p))
                p.setStatus('e');
            else
                project.Controller.Application.showSqlErrorMessageDialog();

            cargarTabla();
        }
        project.Controller.Application.repaintScreen();
    }//GEN-LAST:event_eliminarbtnActionPerformed

    private void expandirbtnMouseEntered(java.awt.event.MouseEvent evt)//GEN-FIRST:event_expandirbtnMouseEntered
    {//GEN-HEADEREND:event_expandirbtnMouseEntered
        expandirbtn.setBackground(new java.awt.Color(255, 255, 255, 175));
        project.Controller.Application.repaintScreen();
    }//GEN-LAST:event_expandirbtnMouseEntered

    private void expandirbtnMouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_expandirbtnMouseExited
    {//GEN-HEADEREND:event_expandirbtnMouseExited
        expandirbtn.setBackground(new java.awt.Color(255, 255, 255, 125));
        project.Controller.Application.repaintScreen();
    }//GEN-LAST:event_expandirbtnMouseExited

    private void modificarbtnMouseEntered(java.awt.event.MouseEvent evt)//GEN-FIRST:event_modificarbtnMouseEntered
    {//GEN-HEADEREND:event_modificarbtnMouseEntered
        modificarbtn.setBackground(new java.awt.Color(255, 255, 255, 175));
        project.Controller.Application.repaintScreen();
    }//GEN-LAST:event_modificarbtnMouseEntered

    private void modificarbtnMouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_modificarbtnMouseExited
    {//GEN-HEADEREND:event_modificarbtnMouseExited
        modificarbtn.setBackground(new java.awt.Color(255, 255, 255, 125));
        project.Controller.Application.repaintScreen();
    }//GEN-LAST:event_modificarbtnMouseExited

    private void eliminarbtnMouseEntered(java.awt.event.MouseEvent evt)//GEN-FIRST:event_eliminarbtnMouseEntered
    {//GEN-HEADEREND:event_eliminarbtnMouseEntered
        eliminarbtn.setBackground(new java.awt.Color(255, 255, 255, 175));
        project.Controller.Application.repaintScreen();
    }//GEN-LAST:event_eliminarbtnMouseEntered

    private void eliminarbtnMouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_eliminarbtnMouseExited
    {//GEN-HEADEREND:event_eliminarbtnMouseExited
        eliminarbtn.setBackground(new java.awt.Color(255, 255, 255, 125));
        project.Controller.Application.repaintScreen();
    }//GEN-LAST:event_eliminarbtnMouseExited

    private void activarbtnMouseEntered(java.awt.event.MouseEvent evt)//GEN-FIRST:event_activarbtnMouseEntered
    {//GEN-HEADEREND:event_activarbtnMouseEntered
        activarbtn.setBackground(new java.awt.Color(255, 255, 255, 175));
        project.Controller.Application.repaintScreen();
    }//GEN-LAST:event_activarbtnMouseEntered

    private void activarbtnMouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_activarbtnMouseExited
    {//GEN-HEADEREND:event_activarbtnMouseExited
        activarbtn.setBackground(new java.awt.Color(255, 255, 255, 125));
        project.Controller.Application.repaintScreen();
    }//GEN-LAST:event_activarbtnMouseExited

    private void buscarbtnMouseEntered(java.awt.event.MouseEvent evt)//GEN-FIRST:event_buscarbtnMouseEntered
    {//GEN-HEADEREND:event_buscarbtnMouseEntered
        buscarbtn.setBackground(new java.awt.Color(255, 255, 255, 175));
        project.Controller.Application.repaintScreen();
    }//GEN-LAST:event_buscarbtnMouseEntered

    private void buscarbtnMouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_buscarbtnMouseExited
    {//GEN-HEADEREND:event_buscarbtnMouseExited
        buscarbtn.setBackground(new java.awt.Color(255, 255, 255, 125));
        project.Controller.Application.repaintScreen();
    }//GEN-LAST:event_buscarbtnMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton activarbtn;
    private javax.swing.JButton actualizarbtn;
    private javax.swing.JComboBox atributostxt;
    private javax.swing.JButton buscarbtn;
    private javax.swing.JButton eliminarbtn;
    private javax.swing.JButton expandirbtn;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCedula47;
    private javax.swing.JLabel lblCedula48;
    private javax.swing.JTable listadotbl;
    private javax.swing.JButton modificarbtn;
    private javax.swing.JButton nextbtn;
    private javax.swing.JButton previous;
    private javax.swing.JComboBox valorestxt;
    // End of variables declaration//GEN-END:variables
}
