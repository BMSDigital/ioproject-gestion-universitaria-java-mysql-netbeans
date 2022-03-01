package project.Model;

public class Carrera
{
    int id;
    String nombre;

    // Funciones de MySql que requiere la libreria Egoist
    public void setSqlRows( java.util.ArrayList rows )
    {
        id = Integer.parseInt(( String ) rows.get(0));
        nombre = ( String ) rows.get(1);
    }
    public String[] getSqlCols()
    {
        // Columnas
        String[] cols = { "id", "nombre" };
        return(cols);
    }
    public String[] getSqlRows()
    {
        // Fila
        String[] rows = 
        {   
            "" + 0,
            "'" + nombre + "'", 
        };
        return(rows);
    }
    public String getSqlTable()
    {
        return("carrera");
    }
    
    // Getters And Setters
    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }
    
    
}
