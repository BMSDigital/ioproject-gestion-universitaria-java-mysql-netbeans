package project.Model;

import java.util.ArrayList;

public class AsignaturaSeccion extends Asignatura
{
    private final ArrayList<Bloque> bloques = new ArrayList();
    
    public boolean agregarBloque( int dia, int entrada, int tipo /* 1 = Teorica | 2 = Practica */ )
    {
        Bloque n_bloque = new Bloque();
        n_bloque.setDia(dia);
        n_bloque.setEntrada(entrada);
        n_bloque.setDuracion( tipo == 1 ? duracionTeoricas : duracionPracticas );
        n_bloque.setKeyAsignatura(codigo);
        boolean done = isLibre(n_bloque);
        if(done)
            bloques.add(n_bloque);

        return(done);
    }
    public boolean agregarBloque( Bloque b )
    {
         boolean done = isLibre(b);
        if(done)
            bloques.add(b);
        
        return(true);
    }
    public ArrayList<Bloque> getBloques()
    {
        return(bloques);
    }
    public boolean isLibre( Bloque c_bloque )
    {
        for( int i = 0; i < bloques.size(); ++i )
            if( c_bloque.getDia() == bloques.get(i).getDia() )
            {
                if( (c_bloque.getEntrada() > bloques.get(i).getEntrada() && c_bloque.getEntrada() < bloques.get(i).getSalida()) ||
                    (c_bloque.getSalida() > bloques.get(i).getEntrada() && c_bloque.getSalida() < bloques.get(i).getSalida())  || 
                    (c_bloque.getEntrada() < bloques.get(i).getEntrada() && c_bloque.getSalida() > bloques.get(i).getSalida()) ) 
                    return(false);
            }
            
        return(true);
    }
    public boolean compare( AsignaturaSeccion c_materia )
    {
        ArrayList<Bloque> c_bloques = c_materia.getBloques();
        
        boolean done = true;
        for( int i = 0; i < c_bloques.size() && done; ++i )
            done = isLibre(c_bloques.get(i));
        
        return(done);
    }
}
