package project.Model;

public class Usuario
{
    
    
    String nombre;
    String passwd;
    int tipo;
    int id;
    String nombres;
    String apellidos;
    String email;
    // Funciones de MySql que requiere la libreria Egoist
    public void setSqlRows( java.util.ArrayList rows )
    {
        id = Integer.parseInt( "" + rows.get(0));
        nombre = "" + rows.get(1);
        passwd = "" + rows.get(2);
        tipo = Integer.parseInt( "" + rows.get(3) );
    nombres = "" + rows.get(4);
    apellidos = "" + rows.get(5);
    email = "" + rows.get(6);
    }
    public String[] getSqlCols()
    {
        // Columnas
        String[] cols = { "id", "nombre", "passw", "tipo","nombres","apellidos","email" };
        return(cols);
    }
    public String[] getSqlRows()
    {
        // Fila
        String[] rows = 
        {   
            "" + id,
            "'" + nombre + "'",
            "'" + passwd + "'",
            "" + tipo ,
            "'" + nombres + "'",
            "'" + apellidos + "'", 
            "'" + email + "'"
        };
        return(rows);
    }
    public String getSqlTable()
    {
        return("usuario");
    }
    
    // Getters And Setters
    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public String getPasswd()
    {
        return passwd;
    }

    public void setPasswd(String passwd)
    {
        this.passwd = passwd;
    }

    public int getTipo()
    {
        return tipo;
    }

    public void setTipo( int tipo )
    {
        this.tipo= tipo;
    }
     public String getnombres()
    {
        return nombres;
    }

    public void setnombres(String nombres)
    {
        this.nombres = nombres;
    }
     public String getapellidos()
    {
        return apellidos;
    }

    public void setapellidos(String apellidos)
    {
        this.apellidos = apellidos;
    }
     public String getemail()
    {
        return email;
    }

    public void setemail(String email)
    {
        this.email = email;
    }
    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    } 
}
