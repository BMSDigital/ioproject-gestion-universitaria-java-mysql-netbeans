package project.Model;

import java.util.ArrayList;

public class Seccion
{
    java.util.ArrayList<AsignaturaSeccion> horario;
    int id;
    int keyCarrera;
    int keySemestre;

    public void setSqlRows( java.util.ArrayList rows )
    {
        id = Integer.parseInt(( String ) rows.get(0));
        keyCarrera= Integer.parseInt((String ) rows.get(1));
        keySemestre = Integer.parseInt(( String ) rows.get(2));
    }
    public String[] getSqlCols()
    {
        // Columnas
        String[] cols = { "id", "cod_carrera", "cod_semestre" };
        return(cols);
    }
    public String[] getSqlRows()
    {
        // Fila
        String[] rows = 
        {   
            "" + id,
            "" + keyCarrera,
            "" + keySemestre,
        };
        return(rows);
    }
    public String getSqlTable()
    {
        return("seccion");
    }
    
    public ArrayList<AsignaturaSeccion> getHorario()
    {
        return horario;
    }

    public void setHorario(ArrayList<AsignaturaSeccion> horario)
    {
        this.horario = horario;
        for( int i = 0; i < this.horario.size(); ++i )
        {
            for( Bloque b : this.horario.get(i).getBloques() )
                b.setKeySeccion(id);
        }
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getKeyCarrera()
    {
        return keyCarrera;
    }

    public void setKeyCarrera(int keyCarrera)
    {
        this.keyCarrera = keyCarrera;
    }

    public int getKeySemestre()
    {
        return keySemestre;
    }

    public void setKeySemestre(int keySemestre)
    {
        this.keySemestre = keySemestre;
    }
    
    
    
}