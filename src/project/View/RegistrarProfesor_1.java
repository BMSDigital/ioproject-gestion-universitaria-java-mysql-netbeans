
package project.View;
   import java.awt.Toolkit;
   import java.awt.event.KeyEvent;
   import javax.swing.*;
import project.Model.Profesor;

public class RegistrarProfesor_1 extends javax.swing.JPanel
{
    // La variable profesor estará en todos las clases de registro
    // y guardará todo lo que escribamos.
    // Al pasar a la siguiente o a la anterior pantalla
    // se enviará esa variable.
    project.Model.Profesor profesor;
   
    public RegistrarProfesor_1()
    {
        initComponents();
    }

    @SuppressWarnings( "unchecked" )
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jComboBox6 = new javax.swing.JComboBox();
        civiltxt = new javax.swing.JComboBox();
        bancotxt = new javax.swing.JComboBox();
        nacionalidadtxt = new javax.swing.JComboBox();
        nombretxt = new javax.swing.JTextField();
        cedulatxt = new javax.swing.JTextField();
        apellidotxt = new javax.swing.JTextField();
        nacimientotxt = new javax.swing.JFormattedTextField();
        lblCedula50 = new javax.swing.JLabel();
        lblCedula51 = new javax.swing.JLabel();
        lblCedula52 = new javax.swing.JLabel();
        lblCedula53 = new javax.swing.JLabel();
        lblCedula54 = new javax.swing.JLabel();
        lblCedula55 = new javax.swing.JLabel();
        lblCedula56 = new javax.swing.JLabel();
        lblCedula57 = new javax.swing.JLabel();
        sexotxt = new javax.swing.JComboBox();
        sanguineotxt = new javax.swing.JComboBox();
        lblCedula58 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jComboBox9 = new javax.swing.JComboBox();
        jComboBox10 = new javax.swing.JComboBox();
        jComboBox11 = new javax.swing.JComboBox();
        jComboBox12 = new javax.swing.JComboBox();
        lblCedula43 = new javax.swing.JLabel();
        lblCedula44 = new javax.swing.JLabel();
        lblCedula45 = new javax.swing.JLabel();
        lblCedula46 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        celulartxt = new javax.swing.JTextField();
        correocombo = new javax.swing.JComboBox();
        correotxt = new javax.swing.JTextField();
        fijotxt = new javax.swing.JTextField();
        lblCedula47 = new javax.swing.JLabel();
        lblCedula48 = new javax.swing.JLabel();
        lblCedula49 = new javax.swing.JLabel();
        prefijotxt = new javax.swing.JComboBox();
        precelulartxt = new javax.swing.JComboBox();
        lblCedula24 = new javax.swing.JLabel();
        cancelbtn = new javax.swing.JButton();
        nextbtn = new javax.swing.JButton();

        setBackground(new java.awt.Color(51, 51, 51));
        setDoubleBuffered(false);
        setMaximumSize(new java.awt.Dimension(940, 520));
        setMinimumSize(new java.awt.Dimension(940, 520));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(940, 520));

        jPanel2.setBackground(new java.awt.Color( 255, 255, 255, 50 ));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true), "Datos básicos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 20), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel2.setDoubleBuffered(false);
        jPanel2.setPreferredSize(new java.awt.Dimension(359, 380));

        jComboBox6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "V-", "E-" }));
        jComboBox6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jComboBox6.setOpaque(false);
        jComboBox6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox6ActionPerformed(evt);
            }
        });

        civiltxt.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        civiltxt.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SOLTERO", "CASADO", "DIVORCIADO", "VIUDO" }));
        civiltxt.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        civiltxt.setOpaque(false);

        bancotxt.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        bancotxt.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "BANESCO", "MERCANTIL", "BICENTENARIO", "TESORO", "VENEZUELA", "CARIBE", "SOFITASA", "OTRA" }));
        bancotxt.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        bancotxt.setOpaque(false);

        nacionalidadtxt.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        nacionalidadtxt.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--" }));
        nacionalidadtxt.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        nacionalidadtxt.setDoubleBuffered(true);
        nacionalidadtxt.setOpaque(false);

        nombretxt.setToolTipText("");
        nombretxt.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        nombretxt.setFocusCycleRoot(true);
        nombretxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ValidarCtrAlt(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ValidarNombre(evt);
            }
        });

        cedulatxt.setToolTipText("");
        cedulatxt.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        cedulatxt.setFocusCycleRoot(true);
        cedulatxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ValidarCrtAltShip(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ValidarCedula(evt);
            }
        });

        apellidotxt.setToolTipText("");
        apellidotxt.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        apellidotxt.setFocusCycleRoot(true);
        apellidotxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ValidarCtr(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ValidarApellido(evt);
            }
        });

        nacimientotxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        nacimientotxt.setForeground(new java.awt.Color(204, 204, 204));
        nacimientotxt.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));
        nacimientotxt.setText(" Ejemplo: 08/08/1996");
        nacimientotxt.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        nacimientotxt.setMaximumSize(new java.awt.Dimension(6, 20));
        nacimientotxt.setName("nacimientohint"); // NOI18N
        nacimientotxt.setPreferredSize(new java.awt.Dimension(6, 20));
        nacimientotxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                nacimientotxtFocusLost(evt);
            }
        });
        nacimientotxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nacimientotxtMouseClicked(evt);
            }
        });
        nacimientotxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ValidarCrtShib(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ValidarFechaNacimiento(evt);
            }
        });

        lblCedula50.setBackground(new java.awt.Color( 255, 255, 255, 75 ));
        lblCedula50.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblCedula50.setForeground(new java.awt.Color(255, 255, 255));
        lblCedula50.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCedula50.setText("Cédula");
        lblCedula50.setOpaque(true);

        lblCedula51.setBackground(new java.awt.Color( 255, 255, 255, 75 ));
        lblCedula51.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCedula51.setForeground(new java.awt.Color(255, 255, 255));
        lblCedula51.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCedula51.setText("Nombres");
        lblCedula51.setOpaque(true);

        lblCedula52.setBackground(new java.awt.Color( 255, 255, 255, 75 ));
        lblCedula52.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCedula52.setForeground(new java.awt.Color(255, 255, 255));
        lblCedula52.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCedula52.setText("Apellidos");
        lblCedula52.setOpaque(true);

        lblCedula53.setBackground(new java.awt.Color( 255, 255, 255, 75 ));
        lblCedula53.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCedula53.setForeground(new java.awt.Color(255, 255, 255));
        lblCedula53.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCedula53.setText("Fecha de nacimiento");
        lblCedula53.setOpaque(true);

        lblCedula54.setBackground(new java.awt.Color( 255, 255, 255, 75 ));
        lblCedula54.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCedula54.setForeground(new java.awt.Color(255, 255, 255));
        lblCedula54.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCedula54.setText("Sexo");
        lblCedula54.setOpaque(true);

        lblCedula55.setBackground(new java.awt.Color( 255, 255, 255, 75 ));
        lblCedula55.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCedula55.setForeground(new java.awt.Color(255, 255, 255));
        lblCedula55.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCedula55.setText("Estado civil");
        lblCedula55.setOpaque(true);

        lblCedula56.setBackground(new java.awt.Color( 255, 255, 255, 75 ));
        lblCedula56.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCedula56.setForeground(new java.awt.Color(255, 255, 255));
        lblCedula56.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCedula56.setText("Nacionalidad");
        lblCedula56.setOpaque(true);

        lblCedula57.setBackground(new java.awt.Color( 255, 255, 255, 75 ));
        lblCedula57.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCedula57.setForeground(new java.awt.Color(255, 255, 255));
        lblCedula57.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCedula57.setText("Entidad bancaria");
        lblCedula57.setOpaque(true);

        sexotxt.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        sexotxt.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "MASCULINO", "FEMENINO" }));
        sexotxt.setToolTipText("");
        sexotxt.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        sexotxt.setOpaque(false);

        sanguineotxt.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--", "ORH+", "ORH-", "A+", "AB", "B-" }));
        sanguineotxt.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        sanguineotxt.setOpaque(false);
        sanguineotxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sanguineotxtActionPerformed(evt);
            }
        });

        lblCedula58.setBackground(new java.awt.Color( 255, 255, 255, 75 ));
        lblCedula58.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCedula58.setForeground(new java.awt.Color(255, 255, 255));
        lblCedula58.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCedula58.setText("Grupo Sanguíneo");
        lblCedula58.setOpaque(true);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblCedula57, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 204, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCedula54, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCedula56, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCedula55, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCedula50, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCedula58, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sanguineotxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nacionalidadtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(civiltxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(68, 68, 68))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(cedulatxt, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(bancotxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sexotxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(lblCedula51, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(nombretxt, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(lblCedula52, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(apellidotxt, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(lblCedula53, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(22, 22, 22)
                        .addComponent(nacimientotxt, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(bancotxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cedulatxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblCedula50)
                                .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCedula51)
                            .addComponent(nombretxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCedula52)
                            .addComponent(apellidotxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCedula53)
                            .addComponent(nacimientotxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCedula54)
                            .addComponent(sexotxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(civiltxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCedula55))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nacionalidadtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCedula56, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(sanguineotxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCedula58))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblCedula57)))
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color( 255, 255, 255, 50 ));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true), "Dirección", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 20), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel4.setDoubleBuffered(false);

        jComboBox9.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jComboBox9.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--", "Quebrada Honda de Guache", "Pio Tamayo", "Yacambú", "---", "Freitez", "Jose Maria Blanco", "---", "Anzoátegui", "Bolívar", "Guárico", "Hilario Luna y Luna", "Humocaro Bajo", "Humocaro Alto", "La Candelaria", "Morán", "---", "Cabudare", "Jose Gregorio", "Agua Viva", "---", "Buría", "Gustavo Vega", "Sarare", "---", "Altagracia", "Antonio Díaz", "Camacaro", "Castañeda", "Cecilio Zubillaga", "Chiquinquira", "El Blanco", "Espinoza de los MonterosHeriberto Arrollo", "Lara", "Las Mercedes", "Manuel Morillo", "Montaña Verde", "Montes de Oca", "Reyes de Vargas", "Torres", "Trinidad Samuel", "---", "Xaguas", "Siquisique", "San Miguel", "Moroturo", "---", "Aguedo Felipe Alvarado", "Buena Vista", "Catedral", "Concepción", "El Cují", "Juárez", "Juan de Villegas", "Santa Rosa", "Tamaca", "Unión" }));
        jComboBox9.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jComboBox9.setOpaque(false);
        jComboBox9.setPreferredSize(new java.awt.Dimension(36, 21));

        jComboBox10.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jComboBox10.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--", "Blanco", "Crespo", "Iribarren", "Jiménez", "Morán", "Palavecino", "Planas", "Torres", "Urdaneta" }));
        jComboBox10.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jComboBox10.setOpaque(false);
        jComboBox10.setPreferredSize(new java.awt.Dimension(36, 21));

        jComboBox11.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jComboBox11.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--", "Atarigua", "Barquisimeto", "Bobare", "Cabudare", "Carora", "Cubiro", "Duaca", "Guárico", "Humocaro Alto", "Humocaro Bajo", "Quíbor", "Río Claro", "Sanare", "Santa Inés", "Sarare", "Siquisique", "Tocuyo" }));
        jComboBox11.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jComboBox11.setOpaque(false);
        jComboBox11.setPreferredSize(new java.awt.Dimension(36, 21));
        jComboBox11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox11ActionPerformed(evt);
            }
        });

        jComboBox12.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jComboBox12.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--", "Amazonas", "Anzoategui", "Apure", "Aragua", "Barinas", "Bolivar", "Carabobo", "Cojedes", "Delta Amacuro", "Distrito Capital", "Falcón", "Guarico", "Lara", "Mérida", "Miranda", "Monagas", "Nueva Esparta", "Portuguesa", "Sucre", "Táchira", "Trujillo", "Vargas", "Yaracuy", "Zulia" }));
        jComboBox12.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jComboBox12.setOpaque(false);
        jComboBox12.setPreferredSize(new java.awt.Dimension(36, 21));

        lblCedula43.setBackground(new java.awt.Color( 255, 255, 255, 75 ));
        lblCedula43.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCedula43.setForeground(new java.awt.Color(255, 255, 255));
        lblCedula43.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCedula43.setText("Estado");
        lblCedula43.setOpaque(true);

        lblCedula44.setBackground(new java.awt.Color( 255, 255, 255, 75 ));
        lblCedula44.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCedula44.setForeground(new java.awt.Color(255, 255, 255));
        lblCedula44.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCedula44.setText("Municipio");
        lblCedula44.setOpaque(true);

        lblCedula45.setBackground(new java.awt.Color( 255, 255, 255, 75 ));
        lblCedula45.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCedula45.setForeground(new java.awt.Color(255, 255, 255));
        lblCedula45.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCedula45.setText("Ciudad");
        lblCedula45.setOpaque(true);

        lblCedula46.setBackground(new java.awt.Color( 255, 255, 255, 75 ));
        lblCedula46.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCedula46.setForeground(new java.awt.Color(255, 255, 255));
        lblCedula46.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCedula46.setText("Parroquia");
        lblCedula46.setOpaque(true);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(lblCedula46, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                        .addComponent(lblCedula44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(lblCedula43, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblCedula45, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jComboBox12, 0, 164, Short.MAX_VALUE))
                    .addComponent(jComboBox11, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox10, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox9, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCedula43)
                    .addComponent(jComboBox12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCedula45)
                    .addComponent(jComboBox11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCedula44)
                    .addComponent(jComboBox10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCedula46)
                    .addComponent(jComboBox9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color( 255, 255, 255, 50 ));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true), "Contacto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 20), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel3.setDoubleBuffered(false);

        celulartxt.setToolTipText("");
        celulartxt.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        celulartxt.setFocusCycleRoot(true);
        celulartxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ValidarCrtAltShi1(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ValidarTelefonoMovil(evt);
            }
        });

        correocombo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        correocombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "@HOTMAIL.COM", "@GMAIL.COM", "@YAHOO.COM", "@OUTLOOK.COM" }));
        correocombo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        correocombo.setOpaque(false);

        correotxt.setToolTipText("");
        correotxt.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        correotxt.setFocusCycleRoot(true);
        correotxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ValidarCrt3(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ValidarMail(evt);
            }
        });

        fijotxt.setToolTipText("");
        fijotxt.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        fijotxt.setFocusCycleRoot(true);
        fijotxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ValidarCrtAlt2(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ValidarTelefonoFijo(evt);
            }
        });

        lblCedula47.setBackground(new java.awt.Color( 255, 255, 255, 75 ));
        lblCedula47.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCedula47.setForeground(new java.awt.Color(255, 255, 255));
        lblCedula47.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCedula47.setText("Teléfono móvil");
        lblCedula47.setOpaque(true);

        lblCedula48.setBackground(new java.awt.Color( 255, 255, 255, 75 ));
        lblCedula48.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCedula48.setForeground(new java.awt.Color(255, 255, 255));
        lblCedula48.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCedula48.setText("Correo electrónico");
        lblCedula48.setOpaque(true);

        lblCedula49.setBackground(new java.awt.Color( 255, 255, 255, 75 ));
        lblCedula49.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCedula49.setForeground(new java.awt.Color(255, 255, 255));
        lblCedula49.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCedula49.setText("Teléfono fijo");
        lblCedula49.setOpaque(true);

        prefijotxt.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        prefijotxt.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0416", "0426", "0414", "0424", "0412" }));
        prefijotxt.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        prefijotxt.setDoubleBuffered(true);
        prefijotxt.setOpaque(false);

        precelulartxt.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        precelulartxt.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0251", "0212" }));
        precelulartxt.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        precelulartxt.setDoubleBuffered(true);
        precelulartxt.setOpaque(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCedula49, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCedula47, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCedula48, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(correotxt, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(correocombo, 0, 104, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(prefijotxt, 0, 60, Short.MAX_VALUE)
                            .addComponent(precelulartxt, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fijotxt)
                            .addComponent(celulartxt))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(celulartxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCedula47)
                    .addComponent(precelulartxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fijotxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCedula49)
                    .addComponent(prefijotxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(correocombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(correotxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCedula48))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        lblCedula24.setBackground(new java.awt.Color( 255, 255, 255, 75 ));
        lblCedula24.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblCedula24.setForeground(new java.awt.Color(255, 255, 255));
        lblCedula24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCedula24.setText("REGISTRO DE PROFESOR");
        lblCedula24.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        lblCedula24.setOpaque(true);

        cancelbtn.setBackground(new java.awt.Color( 255, 255, 255, 125 ));
        cancelbtn.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        cancelbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Themes/Razor/cancel.png"))); // NOI18N
        cancelbtn.setText("Cancelar");
        cancelbtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        cancelbtn.setContentAreaFilled(false);
        cancelbtn.setOpaque(true);
        cancelbtn.setPreferredSize(new java.awt.Dimension(100, 25));
        cancelbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cancelbtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cancelbtnMouseExited(evt);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCedula24, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(cancelbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(nextbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(131, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(lblCedula24, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)
                        .addGap(480, 480, 480))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nextbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cancelbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(50, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents
  
    //Metodo para comprobar que los datos esten completos a la hora de agregarlo
    public boolean validarDatos(){
       String msj = "";
       
       if(cedulatxt.getText().equals("")){//si el campo cedula esta vacio
          msj += "Por favor ingrese la cedula, el campo es obligatorio\n";
       }
       if(nombretxt.getText().equals("")){//si el campo nombre esta vacio
          msj += "Por favor ingrese el nombre, el campo es obligatorio\n";
       }
       if(apellidotxt.getText().equals("")){//si el campo apellido esta vacio
          msj += "Por favor ingrese el apellido, el campo es obligatorio\n";
       }
       if(nacimientotxt.getText().equals("")){// si el campo fecha de nacimiento esta vacio
          msj += "Por favor ingrese en la fecha nacimiento, el campo es obligatorio\n";
       }
       if(celulartxt.getText().equals("")){//si el campo de numero de telefono esta vacio
          msj += "Por favor ingrese  el numero de telefono, el campo es obligatorio\n";
       }
       if(fijotxt.getText().equals("")){// si el campo de numero de telefono fijo esta vacio
          msj += "Por favor ingrese el numero de telefono fijo, el campo es obligatorio\n";
       }
       if(correotxt.getText().equals("")){//si el campo de correo electronico esta vacio
          msj += "Por favor ingrese el correo eletronico, el campo es obligatorio\n";
       }
       if( msj.equals("") == false )
           return(false);
       
       return(true);
    }
    
    private void jComboBox6ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jComboBox6ActionPerformed
    {//GEN-HEADEREND:event_jComboBox6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox6ActionPerformed

    private void sanguineotxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sanguineotxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sanguineotxtActionPerformed

    private void ValidarCedula(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ValidarCedula
       int k = (int) evt.getKeyChar();
        char c = evt.getKeyChar();
        if((k >= 97 && k <= 122) || (k >= 65 && k <= 90)){
           evt.setKeyChar((char)KeyEvent.VK_CLEAR);
           JOptionPane.showMessageDialog(null, "No puede ingresar letras","Advertencia",JOptionPane.INFORMATION_MESSAGE);
        }
        
        if((k >= 32 && k <= 47) || (k >= 58 && k <= 64) || (k >= 91 && k <= 96) || (k >= 123 && k <= 126)){
           Toolkit.getDefaultToolkit().beep();
           evt.setKeyChar((char)KeyEvent.VK_CLEAR);
           JOptionPane.showMessageDialog(null, "No puede ingresar caracteres especiales","Advertencia",JOptionPane.INFORMATION_MESSAGE);
        }
        //para validar caracteres raros que no se puede validar normalmente
        if((c == '?')||(c == '¡') ||(c == 'ñ')||(c == 'Ñ') || (c == '´')||(c == 'ç') ||  (c == 'º')||(c == 'ª') || (c == '·')||(c == '☺')){
           Toolkit.getDefaultToolkit().beep();
           evt.setKeyChar((char)KeyEvent.VK_CLEAR);
           JOptionPane.showMessageDialog(null, "No puede ingresar caracteres especiales","Advertencia",JOptionPane.INFORMATION_MESSAGE);
        }
        
        if (k == 10) {//si se presiona enter
            //transfiere el foco
            cedulatxt.transferFocus();
        }
        
        if(cedulatxt.getText().length() >= 10){
           evt.setKeyChar((char)KeyEvent.VK_CLEAR);
           JOptionPane.showMessageDialog(null,"Ha excedido el numero maximo de caracter","Advertencia",JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_ValidarCedula

    private void ValidarCrtAltShip(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ValidarCrtAltShip
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
    }//GEN-LAST:event_ValidarCrtAltShip

    private void ValidarNombre(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ValidarNombre
       int k = (int) evt.getKeyChar();
        char c = evt.getKeyChar();
        if(k >= 48 && k <= 57){
           evt.setKeyChar((char)KeyEvent.VK_CLEAR);
           JOptionPane.showMessageDialog(null, "No puede ingresar digitos","Advertencia",JOptionPane.INFORMATION_MESSAGE);
        }
        
        if((k >= 33 && k <= 47) || (k >= 58 && k <= 64) || (k >= 91 && k <= 96) || (k >= 123 && k <= 126)){
           Toolkit.getDefaultToolkit().beep();
           evt.setKeyChar((char)KeyEvent.VK_CLEAR);
           JOptionPane.showMessageDialog(null, "No puede  ingresar caracteres especiales","Advertencia",JOptionPane.INFORMATION_MESSAGE);
        }
        //para validar caracteres raros que no se puede validar normalmente
        if((c == '?')||(c == '¡') || (c == '´')||(c == 'ç') ||  (c == 'º')||(c == 'ª') || (c == '·')||(c == '☺')){
           Toolkit.getDefaultToolkit().beep();
           evt.setKeyChar((char)KeyEvent.VK_CLEAR);
           JOptionPane.showMessageDialog(null, "No puede ingresar caracteres especiales","Advertencia",JOptionPane.INFORMATION_MESSAGE);
        }
        
        if (k == 10) {//si se presiona enter
            //transfiere el foco
            nombretxt.transferFocus();
        }
        
        if(nombretxt.getText().length() >= 20){
           evt.setKeyChar((char)KeyEvent.VK_CLEAR);
           JOptionPane.showMessageDialog(null,"Ha excedido el numero maximo de caracter","Advertencia",JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_ValidarNombre

    private void ValidarCtrAlt(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ValidarCtrAlt
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
    }//GEN-LAST:event_ValidarCtrAlt

    private void ValidarApellido(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ValidarApellido
       int k = (int) evt.getKeyChar();
        char c = evt.getKeyChar();
        if(k >= 48 && k <= 57){
           evt.setKeyChar((char)KeyEvent.VK_CLEAR);
           JOptionPane.showMessageDialog(null, "No puedes ingresar digitos","Advertencia",JOptionPane.INFORMATION_MESSAGE);
        }
        
        if((k >= 33 && k <= 47) || (k >= 58 && k <= 64) || (k >= 91 && k <= 96) || (k >= 123 && k <= 126)){
           Toolkit.getDefaultToolkit().beep();
           evt.setKeyChar((char)KeyEvent.VK_CLEAR);
           JOptionPane.showMessageDialog(null, "No puedes ingresar caracteres especiales","Advertencia",JOptionPane.INFORMATION_MESSAGE);
        }
        //para validar caracteres raros que no se puede validar normalmente
        if((c == '?')||(c == '¡') || (c == '´')||(c == 'ç') ||  (c == 'º')||(c == 'ª') || (c == '·')||(c == '☺')){
           Toolkit.getDefaultToolkit().beep();
           evt.setKeyChar((char)KeyEvent.VK_CLEAR);
           JOptionPane.showMessageDialog(null, "No puedes ingresar caracteres especiales","Advertencia",JOptionPane.INFORMATION_MESSAGE);
        }
        
        if (k == 10) {//si se presiona enter
            //transfiere el foco
            apellidotxt.transferFocus();
        }
        
        if(apellidotxt.getText().length() >= 20){
           evt.setKeyChar((char)KeyEvent.VK_CLEAR);
           JOptionPane.showMessageDialog(null,"Ha excedido el numero maximo de caracter","Advertencia",JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_ValidarApellido

    private void ValidarCtr(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ValidarCtr
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
    }//GEN-LAST:event_ValidarCtr

    private void ValidarFechaNacimiento(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ValidarFechaNacimiento
        // TODO add your handling code here:
         int k = (int) evt.getKeyChar();
        char c = evt.getKeyChar();
        if((k >= 97 && k <= 122) || (k >= 65 && k <= 90)){
           evt.setKeyChar((char)KeyEvent.VK_CLEAR);
           JOptionPane.showMessageDialog(null, "No puedes ingresar letras","Advertencia",JOptionPane.INFORMATION_MESSAGE);
        }
        
        if((k >= 32 && k <= 46) || (k >= 58 && k <= 64) || (k >= 91 && k <= 96) || (k >= 123 && k <= 126)){
           Toolkit.getDefaultToolkit().beep();
           evt.setKeyChar((char)KeyEvent.VK_CLEAR);
           JOptionPane.showMessageDialog(null, "No puedes ingresar caracteres especiales!!!","Advertencia",JOptionPane.INFORMATION_MESSAGE);
        }
        //para validar caracteres raros que no se puede validar normalmente
        if((c == '?')||(c == '¡') ||(c == 'ñ')||(c == 'Ñ') || (c == '´')||(c == 'ç') ||  (c == 'º')||(c == 'ª') || (c == '·')||(c == '☺')){
           Toolkit.getDefaultToolkit().beep();
           evt.setKeyChar((char)KeyEvent.VK_CLEAR);
           JOptionPane.showMessageDialog(null, "No puedes ingresar caracteres especiales","Advertencia",JOptionPane.INFORMATION_MESSAGE);
        }
        
        if (k == 10) {//si se presiona enter
            //transfiere el foco
            nacimientotxt.transferFocus();
        }
        
        if(nacimientotxt.getText().length() >= 10){
           evt.setKeyChar((char)KeyEvent.VK_CLEAR);
           JOptionPane.showMessageDialog(null,"Ha excedido el numero maximo de caracter","Advertencia",JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_ValidarFechaNacimiento

    private void ValidarCrtShib(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ValidarCrtShib
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
    }//GEN-LAST:event_ValidarCrtShib

    private void ValidarTelefonoMovil(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ValidarTelefonoMovil
        int k = (int) evt.getKeyChar();
        char c = evt.getKeyChar();
        if((k >= 97 && k <= 122) || (k >= 65 && k <= 90)){
           evt.setKeyChar((char)KeyEvent.VK_CLEAR);
           JOptionPane.showMessageDialog(null, "No puedes ingresar letras","Advertencia",JOptionPane.INFORMATION_MESSAGE);
        }
        
        if((k >= 32 && k <= 47) || (k >= 58 && k <= 64) || (k >= 91 && k <= 96) || (k >= 123 && k <= 126)){
           Toolkit.getDefaultToolkit().beep();
           evt.setKeyChar((char)KeyEvent.VK_CLEAR);
           JOptionPane.showMessageDialog(null, "No puedes ingresar caracteres especiales","Advertencia",JOptionPane.INFORMATION_MESSAGE);
        }
        //para validar caracteres raros que no se puede validar normalmente
        if((c == '?')||(c == '¡') ||(c == 'ñ')||(c == 'Ñ') || (c == '´')||(c == 'ç') ||  (c == 'º')||(c == 'ª') || (c == '·')||(c == '☺')){
           Toolkit.getDefaultToolkit().beep();
           evt.setKeyChar((char)KeyEvent.VK_CLEAR);
           JOptionPane.showMessageDialog(null, "No puedes ingresar caracteres especiales","Advertencia",JOptionPane.INFORMATION_MESSAGE);
        }
        
        if (k == 10) {//si se presiona enter
            //transfiere el foco
            celulartxt.transferFocus();
        }
        
        if(celulartxt.getText().length() >= 7){
           evt.setKeyChar((char)KeyEvent.VK_CLEAR);
           JOptionPane.showMessageDialog(null,"Ha excedido el numero maximo de caracter","Advertencia",JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_ValidarTelefonoMovil

    private void ValidarCrtAltShi1(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ValidarCrtAltShi1
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
    }//GEN-LAST:event_ValidarCrtAltShi1

    private void ValidarTelefonoFijo(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ValidarTelefonoFijo
         int k = (int) evt.getKeyChar();
        char c = evt.getKeyChar();
        if((k >= 97 && k <= 122) || (k >= 65 && k <= 90)){
           evt.setKeyChar((char)KeyEvent.VK_CLEAR);
           JOptionPane.showMessageDialog(null, "No puedes ingresar letras","Advertencia",JOptionPane.INFORMATION_MESSAGE);
        }
        
        if((k >= 32 && k <= 47) || (k >= 58 && k <= 64) || (k >= 91 && k <= 96) || (k >= 123 && k <= 126)){
           Toolkit.getDefaultToolkit().beep();
           evt.setKeyChar((char)KeyEvent.VK_CLEAR);
           JOptionPane.showMessageDialog(null, "No puedes ingresar caracteres especiales","Advertencia",JOptionPane.INFORMATION_MESSAGE);
        }
        //para validar caracteres raros que no se puede validar normalmente
        if((c == '?')||(c == '¡') ||(c == 'ñ')||(c == 'Ñ') || (c == '´')||(c == 'ç') ||  (c == 'º')||(c == 'ª') || (c == '·')||(c == '☺')){
           Toolkit.getDefaultToolkit().beep();
           evt.setKeyChar((char)KeyEvent.VK_CLEAR);
           JOptionPane.showMessageDialog(null, "No puedes ingresar caracteres especiales","Advertencia",JOptionPane.INFORMATION_MESSAGE);
        }
        
        if (k == 10) {//si se presiona enter
            //transfiere el foco
            fijotxt.transferFocus();
        }
        
        if(fijotxt.getText().length() >= 7){
           evt.setKeyChar((char)KeyEvent.VK_CLEAR);
           JOptionPane.showMessageDialog(null,"Ha excedido el numero maximo de caracter","Advertencia",JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_ValidarTelefonoFijo

    private void ValidarCrtAlt2(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ValidarCrtAlt2
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
    }//GEN-LAST:event_ValidarCrtAlt2

    private void ValidarMail(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ValidarMail
         // TODO add your handling code here:
        int k = (int) evt.getKeyChar();
        if (k == 10) {//si se presiona enter
            //transfiere el foco
            correotxt.transferFocus();
        }
        
        if(correotxt.getText().length() >= 20){
           evt.setKeyChar((char)KeyEvent.VK_CLEAR);
           JOptionPane.showMessageDialog(null,"Ha excedido el numero maximo de caracter","Advertencia",JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_ValidarMail

    private void ValidarCrt3(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ValidarCrt3
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
    }//GEN-LAST:event_ValidarCrt3

    private void cancelbtnMouseEntered(java.awt.event.MouseEvent evt)//GEN-FIRST:event_cancelbtnMouseEntered
    {//GEN-HEADEREND:event_cancelbtnMouseEntered
        cancelbtn.setBackground( new java.awt.Color( 255, 255, 255, 175 ) );
        project.Controller.Application.repaintScreen();
    }//GEN-LAST:event_cancelbtnMouseEntered

    private void cancelbtnMouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_cancelbtnMouseExited
    {//GEN-HEADEREND:event_cancelbtnMouseExited
        cancelbtn.setBackground( new java.awt.Color( 255, 255, 255, 125 ) );
        project.Controller.Application.repaintScreen();
    }//GEN-LAST:event_cancelbtnMouseExited

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
        if( validarDatos() == true )
        {
            profesor = new project.Model.Profesor();
            
            profesor.setNombre( nombretxt.getText() );
            profesor.setApellido( apellidotxt.getText() );
            profesor.setCedula( cedulatxt.getText() );
            profesor.setFechaNacimiento( nacimientotxt.getText() );
            profesor.setCelular( precelulartxt.getSelectedItem() + "-" + celulartxt.getText() );
            profesor.setFijo( prefijotxt.getSelectedItem() + "-" + fijotxt.getText() );
            profesor.setSexo((String)sexotxt.getSelectedItem());
            profesor.setEdoCivil( (String)civiltxt.getSelectedItem() );
            profesor.setNacionalidad( (String)nacionalidadtxt.getSelectedItem() );
            profesor.setSanguineo( (String)sanguineotxt.getSelectedItem() );
            profesor.setEntidadBancaria( (String)bancotxt.getSelectedItem() );
            profesor.setCorreo( correotxt.getText() + correocombo.getSelectedItem() );
            
            RegistrarProfesor_2 o = new RegistrarProfesor_2();
            o.setProfesor(profesor);
            
            project.Controller.Application.callMainOption(o);
        }   
    }//GEN-LAST:event_nextbtnActionPerformed

    private void nacimientotxtMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_nacimientotxtMouseClicked
    {//GEN-HEADEREND:event_nacimientotxtMouseClicked
        if( nacimientotxt.getName().equals("nacimientohint") )
        {
            nacimientotxt.setFont( new java.awt.Font( "Tahoma", java.awt.Font.PLAIN, 11) );
            nacimientotxt.setForeground( new java.awt.Color( 0, 0, 0 ) );
            nacimientotxt.setText("");
            nacimientotxt.setName("nacimientonohint");
        }
    }//GEN-LAST:event_nacimientotxtMouseClicked

    private void nacimientotxtFocusLost(java.awt.event.FocusEvent evt)//GEN-FIRST:event_nacimientotxtFocusLost
    {//GEN-HEADEREND:event_nacimientotxtFocusLost
        if( nacimientotxt.getText().length() == 0 )
        {
            nacimientotxt.setFont( new java.awt.Font( "Tahoma", java.awt.Font.ITALIC, 11) );
            nacimientotxt.setForeground( new java.awt.Color( 204,204,204 ) );
            nacimientotxt.setText("   Ejemplo: 08/08/1996");
            nacimientotxt.setName("nacimientohint");
        }
    }//GEN-LAST:event_nacimientotxtFocusLost

    private void jComboBox11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox11ActionPerformed

    public Profesor getProfesor()
    {
        return profesor;
    }
    public void setProfesor(Profesor profesor)
    {
        this.profesor = profesor;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField apellidotxt;
    private javax.swing.JComboBox bancotxt;
    private javax.swing.JButton cancelbtn;
    private javax.swing.JTextField cedulatxt;
    private javax.swing.JTextField celulartxt;
    private javax.swing.JComboBox civiltxt;
    private javax.swing.JComboBox correocombo;
    private javax.swing.JTextField correotxt;
    private javax.swing.JTextField fijotxt;
    private javax.swing.JComboBox jComboBox10;
    private javax.swing.JComboBox jComboBox11;
    private javax.swing.JComboBox jComboBox12;
    private javax.swing.JComboBox jComboBox6;
    private javax.swing.JComboBox jComboBox9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lblCedula24;
    private javax.swing.JLabel lblCedula43;
    private javax.swing.JLabel lblCedula44;
    private javax.swing.JLabel lblCedula45;
    private javax.swing.JLabel lblCedula46;
    private javax.swing.JLabel lblCedula47;
    private javax.swing.JLabel lblCedula48;
    private javax.swing.JLabel lblCedula49;
    private javax.swing.JLabel lblCedula50;
    private javax.swing.JLabel lblCedula51;
    private javax.swing.JLabel lblCedula52;
    private javax.swing.JLabel lblCedula53;
    private javax.swing.JLabel lblCedula54;
    private javax.swing.JLabel lblCedula55;
    private javax.swing.JLabel lblCedula56;
    private javax.swing.JLabel lblCedula57;
    private javax.swing.JLabel lblCedula58;
    private javax.swing.JFormattedTextField nacimientotxt;
    private javax.swing.JComboBox nacionalidadtxt;
    private javax.swing.JButton nextbtn;
    private javax.swing.JTextField nombretxt;
    private javax.swing.JComboBox precelulartxt;
    private javax.swing.JComboBox prefijotxt;
    private javax.swing.JComboBox sanguineotxt;
    private javax.swing.JComboBox sexotxt;
    // End of variables declaration//GEN-END:variables
}
