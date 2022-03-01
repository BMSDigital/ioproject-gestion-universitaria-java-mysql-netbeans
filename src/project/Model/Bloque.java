package project.Model;

public class Bloque
{
    int id;
    int keyAsignatura;
    int keySeccion;
    int entrada;
    int duracion;
    int dia;

    public void setSqlRows( java.util.ArrayList rows )
    {
        id = Integer.parseInt(( String ) rows.get(0));
        keyAsignatura = Integer.parseInt((String ) rows.get(1));
        keySeccion = Integer.parseInt((String ) rows.get(2));
        entrada = Integer.parseInt(( String ) rows.get(3));
        duracion = Integer.parseInt(( String ) rows.get(4));
        dia = Integer.parseInt(( String ) rows.get(5));
    }
    public String[] getSqlCols()
    {
        // Columnas
        String[] cols = { "id", "cod_asignatura", "cod_seccion", "entrada", "duracion", "dia" };
        return(cols);
    }
    public String[] getSqlRows()
    {
        // Fila
        String[] rows = 
        {   
            "" + 0,
            "" + keyAsignatura,
            "'" + keySeccion + "'",
            "" + entrada,
            "" + duracion,
            "" + dia,
        };
        return(rows);
    }
    public String getSqlTable()
    {
        return("asigxsecc");
    }
    
    public int getKeyAsignatura()
    {
        return keyAsignatura;
    }

    public void setKeyAsignatura(int keyAsignatura)
    {
        this.keyAsignatura = keyAsignatura;
    }

    public int getKeySeccion()
    {
        return keySeccion;
    }

    public void setKeySeccion(int keySeccion)
    {
        this.keySeccion = keySeccion;
    }

    public int getEntrada()
    {
        return entrada;
    }

    public void setEntrada(int entrada)
    {
        this.entrada = entrada;
    }

    public int getDuracion()
    {
        return duracion;
    }

    public void setDuracion(int duracion)
    {
        this.duracion = duracion;
    }

    public int getDia()
    {
        return dia;
    }

    public void setDia(int dia)
    {
        this.dia = dia;
    }  
    
    public int getSalida()
    {
        return(entrada + duracion);
    }
}
