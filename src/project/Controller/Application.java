package project.Controller;

import Egoist.MySql.SqlDriver;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Application 
{
    static private Egoist.MySql.SqlDriver sqlDriver;
    
    
    static private Configuration configuration;
    
    static private Thread[] agents;
    
    static private project.View.MainForm screen;
    static private project.Model.Usuario usuario;
    
    /* Init */
    public static void start()
    {
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            @Override
            public void run() 
            {
                loadCfg();
                loadScreen();
                loadMySql();
                loadAgents();
            }
        });
    }
    private static void loadMySql()
    {
        sqlDriver = new Egoist.MySql.SqlDriver( configuration.getSqlHost(), configuration.getSqlDB(), configuration.getSqlPort(), configuration.getSqlUser(), configuration.getSqlPassw() );
    }
    private static void loadCfg()
    {
        configuration = new Configuration();
        if(!configuration.loadCfg())
        {
            int result = showMessageDialog( "La configuración no pudo ser cargada debido a un error en la lectura.", "¿Desea restablecer la configuración por defecto?", 1, new String[]{"Cancelar y salir", "Aceptar"}, new String[]{"cancel", "accept"} ); 
            if( result == 2 )
            {
                if(!configuration.saveCfg())
                {
                    result = showMessageDialog( "No se pudo escribir la configuración.", "¿Desea iniciar la aplicación sin cargar la configuración?", 1, new String[]{"Cancelar y salir", "Aceptar"}, new String[]{ "cancel", "accept" } );
                    if( result == 2 )
                    {
                        configuration.useDefaultCfg();
                    }
                    else
                    {
                        System.exit(0);
                    }
                }
            }
            else
            {
                System.exit(0);
            }
        }
    }
    private static void loadAgents()
    {
        agents = new Thread[1];
        // Sql Agent
        agents[0] = new Egoist.MySql.SqlConAgent( configuration.getSqlHost(), configuration.getSqlDB(), configuration.getSqlPort(), configuration.getSqlUser(), configuration.getSqlPassw() );
        ((Egoist.MySql.SqlConAgent)agents[0]).linkPostMethod(screen, "setSqlIconState", boolean.class);
        
        for( int i = 0; i < agents.length; ++i )
            agents[i].start();
    }
    private static void loadScreen()
    {
        screen = new project.View.MainForm();
        screen.setSize( Integer.parseInt(configuration.getCfgWidth()), Integer.parseInt(configuration.getCfgHeight()) );
        screen.setMenuVisible(false);
        screen.setVisible(true);
        
        callMainOption( new project.View.Login() );
    }
      
    /* Manejo de la pantalla */
    public static void callMainOption( javax.swing.JPanel n_content )
    {
        javax.swing.JPanel content = new javax.swing.JPanel()
        {
            private java.awt.Image backImage;
            
            @Override
            public void paintComponent( java.awt.Graphics g )
            {
                super.paintComponent(g);

                if( backImage != null )
                    g.drawImage(backImage, 0, 0, this);
                else
                    backImage = Egoist.Swing.Image.setAlpha(project.Controller.Application.getThemeItem("cfgpanel", getPreferredSize().width, getPreferredSize().height ), 200 );
            }
        };
        
        if(n_content != null)
        {
            content.setSize(n_content.getSize());
            content.setMaximumSize(n_content.getMaximumSize());
            content.setOpaque(false);
            content.setPreferredSize(n_content.getPreferredSize());
            content.add(n_content);
            screen.setContent(content);
        }
        else
            screen.setContent(null);
    }
    public static void callInicio()
    {
        callMainOption( new project.View.Welcome() );
    }
    public static void repaintScreen()
    {
        if(screen!=null)
            screen.repaint();
    }
    
    /* Eventos MySql que se registraran en la Bitácora */
    public static void onLoginEvent( project.Model.Usuario m_usuario )
    {
        usuario = m_usuario;
        screen.setMenuVisible(true);
        
        crearBitacora( "Inicio de sesión en el sistema", true );
    }
    public static void onLogoutEvent()
    {
    }
    public static boolean onusuario(project.Model.Usuario usuario){
     boolean res = sqlDriver.sqlInsert(usuario);
        
        crearBitacora( "Registro de usuario", res );
        
        return(res);   
    }
    public static boolean onRegisterProfesor( project.Model.Profesor profesor )
    {
        boolean res = sqlDriver.sqlInsert(profesor);
        
        crearBitacora( "Registro de profesor", res );
        
        return(res);
    }
    public static boolean onRegisterMateria( project.Model.Asignatura asignatura ) 
    {
        boolean res = sqlDriver.sqlInsert(asignatura);
        
        crearBitacora( "Registro de asignatura", res );
        
        return(res);
    }
    public static boolean onProfesorStatusChanged( project.Model.Profesor p )
    {
        boolean res = sqlDriver.sqlRefresh(p);
        
        crearBitacora( "Cambio de Status de profesor", res );
        
        return(res);
    }
    public static boolean onSeccionCreated( project.Model.Seccion seccion )
    {
        boolean res = sqlDriver.sqlRefresh(seccion);
        if( res )
        {
            java.util.ArrayList<project.Model.AsignaturaSeccion> asignaturas = seccion.getHorario();
        
            for( project.Model.AsignaturaSeccion a : asignaturas )
            {
                java.util.ArrayList<project.Model.Bloque> bloques = a.getBloques();
                for( project.Model.Bloque b : bloques )
                    res = sqlDriver.sqlRefresh(b);
            }
        }
        
        crearBitacora( "Actualización de sección", res );
        
        return(res);
    }
    
    /* Eventos menores MySql */
    public static java.util.ArrayList loadDbItems( Object o )
    {
        return(sqlDriver.sqlGetAll(o));
    }
    public static java.util.ArrayList loadDbItems( Object o, String key, String value )
    {
        return(sqlDriver.sqlGet(o, key, value));
    }
    public static java.util.ArrayList loadDbItems( Object o, String[] key, String[] value )
    {
        return(sqlDriver.sqlGet(o, key, value));
    }
    
    /*Bitácora*/
    public static void crearBitacora( String evento, boolean res )
    {
        project.Model.Bitacora bitacora = new project.Model.Bitacora();
        bitacora.setNombre(usuario.getNombre());
        bitacora.setFecha( getFecha() );
        bitacora.setHora( getHora() );
        bitacora.setDescripcion(evento);
        
        String resultado = res == false ? "Falló" + sqlDriver.getError() : "Éxito";
        bitacora.setResultado(resultado.length() > 60 ? resultado.substring( 0, 60 ) : resultado );
        
        sqlDriver.sqlInsert(bitacora);
    }
    
    /* Getters */
    public static String getFecha()
    {
        String fecha = "";
        Calendar c = new GregorianCalendar();
        fecha += c.get( Calendar.DAY_OF_MONTH );
        fecha += "/" + (c.get(Calendar.MONTH)+1);
        fecha += "/" + c.get(Calendar.YEAR);
        
        return(fecha);
    }
    public static String getHora()
    {
        String hora = "";
        Calendar c = new GregorianCalendar();
        hora += c.get(Calendar.HOUR_OF_DAY);
        hora += ":" + c.get(Calendar.MINUTE);
        hora += ":" + c.get(Calendar.SECOND);
        
        return(hora);
    }
    public static project.View.MainForm getScreen()
    {
        return((project.View.MainForm)screen);
    }
    public static  java.awt.Image getImage( String imagepath, int width, int height )
    {
        java.awt.Image image = new javax.swing.ImageIcon(Application.class.getResource( "/Recursos/" + imagepath + ".png" )).getImage();
        return( Egoist.Swing.Image.resize( image, width, height ) );
    }
    public static String getTheme()
    {
        return("Razor");
    }
    public static java.awt.Image getThemeItem( String item, int width, int height )
    {
        return(project.Controller.Application.getImage("Themes/" + project.Controller.Application.getTheme() + "/" + item, width, height));
    }
    public static SqlDriver getSqlDriver()
    {
        return sqlDriver;
    }
    
    /* Message Dialog */
    public static int showSqlErrorMessageDialog()
    {
        return(showMessageDialog( sqlDriver.getError() ));
    }
    public static int showMessageDialog( String msgTitle )
    {
        return(showMessageDialog( "", msgTitle, 1, new String[]{"Aceptar"}, new String[]{"accept"} ));
    }
    public static <T> int showMessageDialog( String msgTitle, String msgStr, int msgColor, String[] buttons, String[] buttonsUrl )
    {
        screen.setContentVisible(false);
        // Eligiendo el color de fondo
        java.awt.Color color;
        switch( msgColor )
        {
            default:
            {
                color = new java.awt.Color( 0, 0, 0, 0 );
            }break;
        }
        
        // Oscureciendo el fondo de la pantalla
        Egoist.Swing.JPanel backColor = new Egoist.Swing.JPanel()
        {
            @Override
            public void paintComponent( java.awt.Graphics g )
            {
                if( ((project.View.MainForm)screen).getBackImage() != null )
                    g.drawImage(((project.View.MainForm)screen).getBackImage(), 0, 0, this);
                
                super.paintComponent(g); 
            }  
        };
        backColor.setSize(screen.getSize());
        backColor.setBackground( new java.awt.Color( 0, 0, 0, 0 ) );
        backColor.setScreen(screen);
        backColor.setVisible(false);
        
        screen.getContentPane().add(backColor);
        screen.pack();
        
        Egoist.Swing.Animator animator = Egoist.Swing.Animator.build(Egoist.Swing.Animator.ANIMATION.Fading).init( 175, 30, 3000, Egoist.Swing.Animator.BEHAVIOUR.AccelDown, backColor);
        animator.start();

        // Creando el dialog y agregando el panel de opciones
        javax.swing.JDialog dialog = new javax.swing.JDialog( screen, "", true );
        
        dialog.dispose();
        dialog.setUndecorated(true);

        project.View.Message msg = new project.View.Message(dialog);
        
        // Estableciendo los valores del mensaje
        msg.setMessage( msgTitle, msgStr, buttons, buttonsUrl );
        
        backColor.setVisible(true);
        
        // Mostrando el mensaje
        msg.showTime();
        
        // Limpiando pantalla
        animator.finish();
        
        screen.getContentPane().remove(backColor);
        screen.pack();
        screen.setContentVisible(true);
        
        return(msg.getValue());
    }      
}
