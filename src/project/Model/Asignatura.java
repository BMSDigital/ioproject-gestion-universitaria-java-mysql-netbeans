package project.Model;

public class Asignatura
{
    int codigo;
    String nombre;
    String descripcion;
    int teoricas;
    int duracionTeoricas;
    int practicas;
    int duracionPracticas;
    int semestre;
    int carrera;
    int creditos;

    // Funciones de MySql que requiere la libreria Egoist
    public void setSqlRows( java.util.ArrayList rows )
    {
        codigo = Integer.parseInt(( String ) rows.get(0));
        nombre = ( String ) rows.get(1);
        descripcion = ( String ) rows.get(2);
        teoricas = Integer.parseInt(( String ) rows.get(3));
        practicas = Integer.parseInt(( String ) rows.get(4));
        duracionTeoricas = Integer.parseInt(( String ) rows.get(5));
        duracionPracticas = Integer.parseInt(( String ) rows.get(6));
        creditos = Integer.parseInt(( String ) rows.get(7));
        semestre = Integer.parseInt(( String ) rows.get(8));
        carrera = Integer.parseInt(( String ) rows.get(9));
    }
    public String[] getSqlCols()
    {
        // Columnas
        String[] cols = { "id", "nombre", "descripcion", "h_teoricas", "h_practicas", "dur_teoricas", "dur_practicas", "uni_credito",  "cod_semestre", "cod_carrera" };
        return(cols);
    }
    public String[] getSqlRows()
    {
        // Fila
        String[] rows = 
        {   
            "" + 0,
            "'" + nombre + "'", 
            "'" + descripcion + "'", 
            "" + teoricas,
            "" + practicas,
            "" + duracionTeoricas,
            "" + duracionPracticas,
            "" + creditos,
            "" + semestre,
            "" + carrera,
        };
        return(rows);
    }
    public String getSqlTable()
    {
        return("asignatura");
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
    
    public int getCodigo()
    {
        return codigo;
    }

    public void setCodigo(int codigo)
    {
        this.codigo = codigo;
    }

    public String getDescripcion()
    {
        return descripcion;
    }

    public void setDescripcion(String descripcion)
    {
        this.descripcion = descripcion;
    }

    public int getTeoricas()
    {
        return teoricas;
    }

    public void setTeoricas(int teoricas)
    {
        this.teoricas = teoricas;
    }

    public int getPracticas()
    {
        return practicas;
    }

    public void setPracticas(int practicas)
    {
        this.practicas = practicas;
    }

    public int getSemestre()
    {
        return semestre;
    }

    public void setSemestre(int semestre)
    {
        this.semestre = semestre;
    }

    public int getCarrera()
    {
        return carrera;
    }

    public void setCarrera(int carrera)
    {
        this.carrera = carrera;
    }

    public int getCreditos()
    {
        return creditos;
    }

    public void setCreditos(int creditos)
    {
        this.creditos = creditos;
    }

    public int getDuracionTeoricas()
    {
        return duracionTeoricas;
    }

    public void setDuracionTeoricas(int duracionTeoricas)
    {
        this.duracionTeoricas = duracionTeoricas;
    }

    public int getDuracionPracticas()
    {
        return duracionPracticas;
    }

    public void setDuracionPracticas(int duracionPracticas)
    {
        this.duracionPracticas = duracionPracticas;
    }
}
