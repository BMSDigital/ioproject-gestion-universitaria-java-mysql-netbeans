package project.Model;

public class Bitacora
{
    String nombre;
    String hora;
    String fecha;
    String descripcion;
    String resultado;
    int id;

    // Funciones de MySql que requiere la libreria Egoist
    public void setSqlRows( java.util.ArrayList rows )
    {
        id = Integer.parseInt(( String ) rows.get(0));
        nombre = ( String ) rows.get(1);
        fecha = (String) rows.get(2);
        hora = (String) rows.get(3);
        descripcion = (String) rows.get(4);
        resultado = (String) rows.get(5);
    }
    public String[] getSqlCols()
    {
        // Columnas
        String[] cols = { "id", "nombre", "fecha", "hora", "descripcion", "resultado" };
        return(cols);
    }
    public String[] getSqlRows()
    {
        // Fila
        String[] rows = 
        {   
            "" + 0,
            "'" + nombre + "'", 
            "'" + fecha + "'",
            "'" + hora + "'",
            "'" + descripcion + "'",
            "'" + resultado + "'"
        };
        return(rows);
    }
    public String getSqlTable()
    {
        return("bitacora");
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

    public String getHora()
    {
        return hora;
    }

    public void setHora(String hora)
    {
        this.hora = hora;
    }

    public String getFecha()
    {
        return fecha;
    }

    public void setFecha(String fecha)
    {
        this.fecha = fecha;
    }

    public String getDescripcion()
    {
        return descripcion;
    }

    public void setDescripcion(String descripcion)
    {
        this.descripcion = descripcion;
    }


    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getResultado()
    {
        return resultado;
    }

    public void setResultado(String resultado)
    {
        this.resultado = resultado;
    }
}
