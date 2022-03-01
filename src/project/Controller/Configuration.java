package project.Controller;

import java.util.ArrayList;

public class Configuration
{
    private String sqlHost, sqlDB, sqlPort, sqlUser, sqlPassw, tblProfesor;
    private String cfgMax, cfgWidth, cfgHeight, cfgFirstuse;
    private String d_sqlHost = "localhost", d_sqlDB = "projectdb", d_sqlPort = "3306", d_sqlUser = "root", d_sqlPassw = "", d_tblProfesor = "proof";
    private String d_cfgMax = "false", d_cfgWidth = "1200", d_cfgHeight = "800", d_cfgFirstuse = "true";

    public boolean loadCfg()
    {
        Egoist.Util.IoStream io = new Egoist.Util.IoStream();
        if( !io.exists("cfg.xml") )
        {
            if(saveCfg())
                return(loadCfg());
            else
                return(false);
        }

        try
        {
            Egoist.Util.Xml xml = new Egoist.Util.Xml();
            if( !xml.read("cfg.xml") )
                throw new Exception();
        
            boolean done;
            ArrayList<org.w3c.dom.Element> elements;
            
            elements = xml.getElements(xml.getNode("user").item(0));
            cfgFirstuse = ((org.w3c.dom.Element)xml.getNode("user").item(0)).getAttribute("firstuse");

            done = true;
            for( int i = 0; i < elements.size() && done; ++i )
            {
                org.w3c.dom.Element e = elements.get(i);
                switch( e.getNodeName() )
                {
                    case "screen":
                    {
                        if( e.getAttributes().getLength() == 3 )
                        {
                            cfgWidth = e.getAttribute("width");
                            cfgHeight = e.getAttribute("height");
                            cfgMax = e.getAttribute("maximized");
                        }
                        else
                            done = false;
                    }break;
                    default:
                    {
                        done = false;
                    }break;
                }
            }
            
            elements = xml.getElements(xml.getNode("sql").item(0));
            done = true;
            for( int i = 0; i < elements.size() && done; ++i )
            {
                org.w3c.dom.Element e = elements.get(i);
                switch( e.getNodeName() )
                {
                    case "configuration":
                    {
                        if( e.getAttributes().getLength() == 5 )
                        {
                            sqlHost = e.getAttribute("host");
                            sqlDB = e.getAttribute("database");
                            sqlPort = e.getAttribute("port");
                            sqlUser = e.getAttribute("user");
                            sqlPassw = e.getAttribute("passw");
                        }
                        else
                            done = false;
                    }break;
                    case "tables":
                    {
                        if( e.getAttributes().getLength() == 1 )
                        {
                            tblProfesor = e.getAttribute("profesor");
                        }
                        else
                            done = false;
                    }break;
                    default:
                    {
                        done = false;
                    }break;
                }
            }
            
            if(!done)
                throw new Exception();
            
            System.out.println("NODE");
            
            return(true);
        }catch(Exception e)
        {
            return(false);
        }
    }
    public boolean saveCfg()
    {
        String xml = 
                "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n"
                + "<doc>\n"
                + "\t<user firstuse=\"" + d_cfgFirstuse + "\">\n"
                + "\t\t<screen width=\"" + d_cfgWidth + "\" height=\"" + d_cfgHeight + "\" maximized=\"" + d_cfgMax + "\"></screen>\n"
                + "\t</user>\n"
                + "\t<sql>\n"
                + "\t\t<configuration host=\"" + d_sqlHost + "\" database=\"" + d_sqlDB + "\" port=\"" + d_sqlPort + "\" user=\"" + d_sqlUser + "\" passw=\"" + d_sqlPassw + "\"></configuration>\n"
                + "\t\t<tables profesor=\"" + d_tblProfesor + "\"></tables>\n"
                + "\t</sql>\n"
                + "</doc>";
        
        Egoist.Util.IoStream io = new Egoist.Util.IoStream();
        if( !io.saveFile( "cfg.xml", xml ) )
        {
            return(false);
        }
        
        return(true);
    }
    public void useDefaultCfg()
    {
    }
    public boolean parseCfg()
    {
        return(true);
    }
    public String getSqlHost()
    {
        return(sqlHost);
    }
    public String getSqlDB()
    {
        return(sqlDB);
    }
    public String getSqlPort()
    {
        return(sqlPort);
    }
    public String getSqlUser()
    {
        return(sqlUser);
    }
    public String getSqlPassw()
    {
        return(sqlPassw);
    }
    public String getTblProfesor()
    {
        return(tblProfesor);
    }
    public String getCfgMaximized()
    {
        return(cfgMax);
    }
    public String getCfgWidth()
    {
        return(cfgWidth);
    }
    public String getCfgHeight()
    {
        return(cfgHeight);
    }
    public String getCfgFirstuse()
    {
        return(cfgFirstuse);
    }
    public void setSqlHost( String sqlHost )
    {
        this.sqlHost = sqlHost;
        this.d_sqlHost = sqlHost;
    }
    public void setSqlDB( String sqlDB )
    {
        this.sqlDB = sqlDB;
        this.d_sqlDB = sqlDB;
    }
    public void setSqlPort( String sqlPort )
    {
        this.sqlPort = sqlPort;
        this.d_sqlPort = sqlPort;
    }
    public void setSqlUser( String sqlUser )
    {
        this.sqlUser = sqlUser;
        this.d_sqlUser = sqlUser;
    }
    public void setSqlPassw( String sqlPassw )
    {
        this.sqlPassw = sqlPassw;
        this.d_sqlPassw = sqlPassw;
    }
    public void setTblProfesor( String tblProfesor )
    {
        this.tblProfesor = tblProfesor;
        this.d_tblProfesor = tblProfesor;
    }
    public void setCfgMaximized( String cfgMax )
    {
        this.cfgMax = cfgMax;
        this.d_cfgMax = cfgMax;
    }
    public void setCfgWidth( String cfgWidth )
    {
        this.cfgWidth = cfgWidth;
        this.d_cfgWidth = cfgWidth;
    }
    public void setCfgHeight( String cfgHeight )
    {
        this.cfgHeight = cfgHeight;
        this.d_cfgHeight = cfgHeight;
    }
    public void setCfgFirstuse( String cfgFirstuse )
    {
        this.cfgFirstuse = cfgFirstuse;
        this.d_cfgFirstuse = cfgFirstuse;
    }
}
