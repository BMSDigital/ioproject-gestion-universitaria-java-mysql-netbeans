/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.View;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTree;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

/**
 *
 * @author Oku
 */
public class Preferencias extends javax.swing.JPanel
{
    public Preferencias()
    {
        initComponents();

        tree.getSelectionModel().setSelectionMode( TreeSelectionModel.SINGLE_TREE_SELECTION);
        
        javax.swing.tree.TreeCellRenderer renderer = new javax.swing.tree.DefaultTreeCellRenderer() 
        {
             @Override
            public java.awt.Color getBackgroundNonSelectionColor() {
                return (null);
            }

            @Override
            public java.awt.Color getBackgroundSelectionColor() {
                return ( new java.awt.Color( 130, 130, 130, 150 ) );
            }

            @Override
            public java.awt.Color getBackground() {
                return (null);
            }
            
            @Override
            public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) 
            {
                super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
                if(leaf) 
                    setIcon(null);
                else 
                    setIcon( new javax.swing.ImageIcon(project.Controller.Application.getThemeItem("configuration", 16, 16)) );

                return this;
            }
        };
        
        tree.setCellRenderer(renderer);
        tree.addMouseListener( new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent mouse)
            {
                TreePath path = tree.getPathForLocation(mouse.getX(), mouse.getY());
                if( path != null )
                    showPopUp(path); 
            }
        });
        
        showPopUp(null);
    }
    private void showPopUp( TreePath path )
    {
        javax.swing.JPanel newPopup = null;
        
        if( path != null && path.getPathCount() > 0 )
        {
            switch( path.getPathComponent(1).toString() )
            {
                case "Entorno":
                {
                    if( path.getPathCount() > 2 )
                    {
                        switch( path.getPathComponent(2).toString() )
                        {
                            case "Inicio":
                            {
                                newPopup = new Preferencias_Entorno_Inicio();
                            }break;
                            case "Diseño":
                            {

                            }break;
                            default:
                            {
                                newPopup = new Preferencias_Entorno_General();
                            }break;
                        }
                    }
                    else
                        newPopup = new Preferencias_Entorno_General();
                }break;
                case "Base de datos":
                {
                    if( path.getPathCount() > 2 )
                    {
                        switch( path.getPathComponent(2).toString() )
                        {
                            case "Tablas":
                            {
                                newPopup = new Preferencias_BD_Tablas();
                            }break;
                            default:
                            {
                                newPopup = new Preferencias_BD_General();
                            } break;
                        }
                    }
                }break;
            }
            
        }
        else
            newPopup = new Preferencias_Entorno_General();
            
        if( newPopup != null )
        {
            newPopup.setName( "mainpopup" );
            newPopup.setSize(popup.getSize());

            for( int i = 0; i < popup.getComponentCount(); ++i )
                if( popup.getComponent(i).getName() != null && popup.getComponent(i).getName().equals("mainpopup") )
                    popup.remove(i);
            
            popup.add(newPopup, 0);
            popup.setViewportView(newPopup);
            popup.getViewport().setOpaque(false);
        }
        
        revalidate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings( "unchecked" )
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jScrollPane1 = new javax.swing.JScrollPane();
        tree = new javax.swing.JTree();
        cancel = new javax.swing.JButton();
        ok = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        popup = new javax.swing.JScrollPane();

        setMaximumSize(new java.awt.Dimension(520, 324));
        setMinimumSize(new java.awt.Dimension(520, 324));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(520, 324));
        setLayout(null);

        jScrollPane1.setBackground(new java.awt.Color( 0, 0, 0, 0 ));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        tree.setBackground(new java.awt.Color( 0, 0, 0, 0 ));
        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        javax.swing.tree.DefaultMutableTreeNode treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Entorno");
        javax.swing.tree.DefaultMutableTreeNode treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("General");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Inicio");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Base de datos");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("General");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Tablas");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Transferencias SQL");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Bitácora");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("General");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        tree.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        tree.setDoubleBuffered(true);
        tree.setRootVisible(false);
        tree.setToggleClickCount(1);
        jScrollPane1.setViewportView(tree);

        add(jScrollPane1);
        jScrollPane1.setBounds(20, 28, 100, 256);

        cancel.setText("Cancelar");
        cancel.setOpaque(false);
        add(cancel);
        cancel.setBounds(355, 290, 75, 23);

        ok.setText("Aceptar");
        ok.setOpaque(false);
        add(ok);
        ok.setBounds(435, 290, 71, 23);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Configuración");
        jLabel1.setToolTipText("");
        add(jLabel1);
        jLabel1.setBounds(-6, 7, 530, 20);

        popup.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        popup.setViewportBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        popup.setDoubleBuffered(true);
        popup.setMaximumSize(new java.awt.Dimension(380, 256));
        popup.setMinimumSize(new java.awt.Dimension(380, 256));
        popup.setOpaque(false);
        popup.setPreferredSize(new java.awt.Dimension(380, 256));
        add(popup);
        popup.setBounds(124, 28, 380, 256);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton ok;
    private javax.swing.JScrollPane popup;
    private javax.swing.JTree tree;
    // End of variables declaration//GEN-END:variables
}