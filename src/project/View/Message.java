package project.View;

public class Message extends Egoist.Swing.JPanel
{
    private int noOfButtons;
    private int value;
    private int baseY;
    private final java.awt.Dimension bodySize = new java.awt.Dimension(360, 160);
    
    public Message( java.awt.Window screen )
    {
        initComponents();
        
        this.screen = screen;
        this.screen.dispose();
        this.screen.add(this, 0);
        this.screen.pack();
        
        javax.swing.JLabel close = new javax.swing.JLabel();
        close.setSize(32, 32);
        close.setLocation( bodySize.width - 32, 0 );
        java.awt.Image img = Egoist.Swing.Image.setAlpha( project.Controller.Application.getImage("close", 32, 32), 175);
        close.setIcon(new javax.swing.ImageIcon(img));
        close.setCursor( new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR) );
        
        close.addMouseListener(new java.awt.event.MouseAdapter()
        {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                setValue(-1);
            }
        });
        
        this.add(close, 0);
    }
    public void setMessage( String title, String message, String[] buttons, String[] buttonsUrl )
    {
        baseY = 0;
        if( title != null )
        {
            javax.swing.JLabel jtitle = new javax.swing.JLabel();
            jtitle.setFont(new java.awt.Font("Tahoma", java.awt.Font.BOLD, 18));
            jtitle.setForeground( java.awt.Color.white );
            jtitle.setText( "<html>" + title + "</html>");
            
            int titleWidth = jtitle.getFontMetrics( jtitle.getFont() ).stringWidth(title);
            int titleHeight = (int)((titleWidth/(bodySize.width-60)) + 1)* 30;
            
            jtitle.setSize( bodySize.width - 60, titleHeight );
            jtitle.setLocation( body.getLocation().x + 30, body.getLocation().y + 20 );
            
            this.add(jtitle, 1);

            bodySize.height += titleHeight;
            baseY += titleHeight;
        }
        baseY += 20;

        javax.swing.JLabel jmessage = new javax.swing.JLabel();
        jmessage.setFont(new java.awt.Font("Tahoma", java.awt.Font.BOLD, 14));
        jmessage.setForeground( java.awt.Color.white );
        jmessage.setText( "<html>" + message + "</html>" );
        
        int messageWidth = jmessage.getFontMetrics( jmessage.getFont() ).stringWidth(message);
        int messageHeight = (int)((messageWidth/(bodySize.width-60)) + 1)* 20;
        
        jmessage.setSize( bodySize.width-60, messageHeight );
        jmessage.setLocation( body.getLocation().x + 30, body.getLocation().y + baseY );
        
        bodySize.height += messageHeight;
        baseY += messageHeight + 20;
        
        body.setSize(bodySize);

        this.add(jmessage, 1);
        
        setOptions(buttons, buttonsUrl);
        
        java.awt.Image img = Egoist.Swing.Image.setAlpha( project.Controller.Application.getImage("redbox", body.getWidth(), body.getHeight()), 175);
        this.body.setIcon( new javax.swing.ImageIcon(img));
    }
    private void setOptions( String[] buttons, String[] buttonsUrl )
    {
        if( buttons == null || buttons.length == 0 )
        {
            buttons = new String[1];
            buttons[0] = "Aceptar";
        }
        
        final javax.swing.JLabel[] buttons_icon = new javax.swing.JLabel[buttons.length];
        javax.swing.JLabel[] buttons_title = new javax.swing.JLabel[buttons.length];
        
        noOfButtons = buttons.length;
        switch( noOfButtons )
        {
            case 2:
            {
                // Cancel button
                buttons_icon[0] = new javax.swing.JLabel();
                buttons_icon[0].setSize( (int)(this.body.getWidth()*0.2f), (int)(this.body.getWidth()* 0.2f) );
                buttons_icon[0].setLocation( (int)(this.body.getX() + this.body.getWidth()* 0.2f), this.body.getY() + baseY );  
            
                // Accept button
                buttons_icon[1] = new javax.swing.JLabel();
                buttons_icon[1].setSize( (int)(this.body.getWidth()*0.2f), (int)(this.body.getWidth()* 0.2f) );
                buttons_icon[1].setLocation( (int)(this.body.getX() + this.body.getWidth()* 0.6f), this.body.getY() + baseY );
            }break;
            default:
            {
                buttons_icon[0] = new javax.swing.JLabel();
                buttons_icon[0].setSize( (int)(this.body.getWidth()*0.2f), (int)(this.body.getWidth()* 0.2f) );
                buttons_icon[0].setLocation( (int)(this.body.getX() + this.body.getWidth()* 0.5f - buttons_icon[0].getWidth()* 0.5f), this.body.getY() + baseY );
            }break;
        }

        for( int i = 0; i < noOfButtons; ++i )
        {
            buttons_icon[i].setIcon( new javax.swing.ImageIcon( project.Controller.Application.getImage( buttonsUrl[i], buttons_icon[i].getWidth(), buttons_icon[i].getHeight()) ) );
            
            buttons_title[i] = new javax.swing.JLabel();
            buttons_title[i].setLocation( buttons_icon[i].getLocation().x, buttons_icon[i].getLocation().y + (int)(buttons_icon[i].getHeight()*0.5f) + 5 );
            buttons_title[i].setSize( buttons_icon[i].getWidth(), 100 );
            buttons_title[i].setFont(new java.awt.Font("Tahoma", java.awt.Font.BOLD, 12));
            buttons_title[i].setText( "<html><center>" + buttons[i] + "</center></html>" );
            buttons_title[i].setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            buttons_title[i].setForeground( java.awt.Color.white );

            final javax.swing.JLabel selected = new javax.swing.JLabel();
            selected.setLocation(buttons_icon[i].getLocation());
            selected.setSize(buttons_icon[i].getSize());
            selected.setCursor( new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR) );
            selected.setOpaque(true);
            selected.setVisible(false);
            
            this.add(buttons_title[i], 1);
            this.add(buttons_icon[i], 1);
            this.add(selected, 0);
            
            final int index = i+1;
            
            buttons_icon[i].addMouseListener( new java.awt.event.MouseAdapter()
            {
                Egoist.Swing.Animator animator;

                @Override
                public void mouseEntered( java.awt.event.MouseEvent evt )
                {
                    selected.setBackground( new java.awt.Color( 255, 255, 255, 0 ) );
                    selected.setVisible(true);
                    
                    if( animator != null )
                       animator.finish();
                    animator = Egoist.Swing.Animator.build(Egoist.Swing.Animator.ANIMATION.Fading).init( 150, 30, 500, Egoist.Swing.Animator.BEHAVIOUR.AccelDown, selected);
                    animator.start();
                }
                @Override
                public void mouseExited(java.awt.event.MouseEvent evt)
                {
                    selected.setVisible(false);
                    selected.setBackground( new java.awt.Color( 255, 255, 255, 150 ) );
                    
                    if( animator != null )
                        animator.finish();
                    animator = Egoist.Swing.Animator.build(Egoist.Swing.Animator.ANIMATION.Fading).init( -150, 30, 500, Egoist.Swing.Animator.BEHAVIOUR.AccelDown, selected );
                    animator.start();
                }
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt)
                {
                    setValue(index);
                }
            });
            
        }
    }
    private void setValue( int value )
    {
        this.value = value;
        screen.dispose();
    }
    public void showTime()
    {
        screen.dispose();
        screen.setSize(bodySize);
        screen.setLocationRelativeTo(project.Controller.Application.getScreen());
        screen.setVisible(true);
    }
    public int getValue()
    {
        return(value);
    }
    public java.awt.Dimension getBodySize()
    {
        return(bodySize);
    }
    @SuppressWarnings( "unchecked" )
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        body = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 102, 255));
        setLayout(null);

        body.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/redbox.png"))); // NOI18N
        body.setMaximumSize(new java.awt.Dimension(256, 198));
        body.setMinimumSize(new java.awt.Dimension(256, 198));
        body.setPreferredSize(new java.awt.Dimension(256, 198));
        add(body);
        body.setBounds(0, 0, 230, 170);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel body;
    // End of variables declaration//GEN-END:variables
}
