package project.Model;

import java.awt.Image;
import java.io.InputStream;

public class Profesor 
{    
    String cedula;
    String nombre;
    String apellido;
    String sexo;
    String edoCivil;
    String fechaNacimiento;
    String nacionalidad;
    String sanguineo;
    String celular;
    String fijo;
    String correo;
    String cuentaBancaria;
    String entidadBancaria;
    
    Familiar[] familiares;
    
    String profesion;
    String titulos;
    String especialidades;
    String catedras;
    String tipoContrato;
    String fechaIngreso;
    
    String foto;
    
    char status = 0;
    // Getters And Setters

    public char getStatus()
    {
        return status;
    }

    public void setStatus(char status)
    {
        this.status = status;
    }

    public String getFoto()
    {
        return foto;
    }

    public void setFoto(String foto)
    {
        this.foto = foto;
    }

    public String getCedula()
    {
        return cedula;
    }

    public void setCedula(String cedula)
    {
        this.cedula = cedula;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public String getApellido()
    {
        return apellido;
    }

    public void setApellido(String apellido)
    {
        this.apellido = apellido;
    }

    public String getSexo()
    {
        return sexo;
    }

    public void setSexo(String sexo)
    {
        this.sexo = sexo;
    }

    public String getEdoCivil()
    {
        return edoCivil;
    }

    public void setEdoCivil(String edoCivil)
    {
        this.edoCivil = edoCivil;
    }

    public String getFechaNacimiento()
    {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento)
    {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNacionalidad()
    {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad)
    {
        this.nacionalidad = nacionalidad;
    }

    public String getSanguineo()
    {
        return sanguineo;
    }

    public void setSanguineo(String sanguineo)
    {
        this.sanguineo = sanguineo;
    }

    public String getCelular()
    {
        return celular;
    }

    public void setCelular(String celular)
    {
        this.celular = celular;
    }

    public String getFijo()
    {
        return fijo;
    }

    public void setFijo(String fijo)
    {
        this.fijo = fijo;
    }

    public String getCorreo()
    {
        return correo;
    }

    public void setCorreo(String correo)
    {
        this.correo = correo;
    }

    public String getCuentaBancaria()
    {
        return cuentaBancaria;
    }

    public void setCuentaBancaria(String cuentaBancaria)
    {
        this.cuentaBancaria = cuentaBancaria;
    }

    public String getEntidadBancaria()
    {
        return entidadBancaria;
    }

    public void setEntidadBancaria(String entidadBancaria)
    {
        this.entidadBancaria = entidadBancaria;
    }

    public Familiar[] getFamiliares()
    {
        return familiares;
    }

    public void setFamiliares(Familiar[] familiares)
    {
        this.familiares = familiares;
    }

    public String getProfesion()
    {
        return profesion;
    }

    public void setProfesion(String profesion)
    {
        this.profesion = profesion;
    }

    public String getTitulos()
    {
        return titulos;
    }

    public void setTitulos(String titulos)
    {
        this.titulos = titulos;
    }

    public String getEspecialidades()
    {
        return especialidades;
    }

    public void setEspecialidades(String especialidades)
    {
        this.especialidades = especialidades;
    }

    public String getCatedras()
    {
        return catedras;
    }

    public void setCatedras(String catedras)
    {
        this.catedras = catedras;
    }

    public String getTipoContrato()
    {
        return tipoContrato;
    }

    public void setTipoContrato(String tipoContrato)
    {
        this.tipoContrato = tipoContrato;
    }

    public String getFechaIngreso()
    {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso)
    {
        this.fechaIngreso = fechaIngreso;
    }
    
 
    // Funciones de MySql que requiere la libreria Egoist
    public void setSqlRows( java.util.ArrayList rows )
    {
        cedula = "" + rows.get(0);
        nombre = "" + rows.get(1);
        apellido = "" + rows.get(2);
        sexo = "" + rows.get(3);
        edoCivil = "" + rows.get(4);
        fechaNacimiento = "" + rows.get(5);
        nacionalidad = "" + rows.get(6);
        sanguineo = "" + rows.get(7);
        celular = "" + rows.get(8);
        fijo = "" + rows.get(9);
        correo = "" + rows.get(10);
        cuentaBancaria ="" + rows.get(11);
        entidadBancaria = "" + rows.get(12);
        profesion = "" + rows.get(13);
        titulos = "" + rows.get(14);
        especialidades ="" + rows.get(15);
        catedras = "" + rows.get(16);
        tipoContrato = "" + rows.get(17);
        fechaIngreso = "" + rows.get(18);
        status = ("" +rows.get(19)).charAt(0);
    }
    public String[] getSqlCols()
    {
        // Columnas
        String[] cols = { "cedula", "nombre", "apellido", "sexo", "edo_civil", "fecha_nac", "nacionalidad", "sanguineo", "celular", "fijo", "correo", "cta_bancaria", "ent_bancaria", "profesion", "titulos", "especialidades", "catedras", "tipo_contrato", "fecha_ingreso", "status" };
        return(cols);
    }
    public String[] getSqlRows()
    {
        // Fila
        String[] rows = 
        {   
            "'" + cedula + "'",
            "'" + nombre + "'",
            "'" + apellido + "'",
            "'" + sexo + "'",
            "'" + edoCivil + "'",
            "'" + fechaNacimiento + "'",
            "'" + nacionalidad + "'",
            "'" + sanguineo + "'",
            "'" + celular + "'",
            "'" + fijo + "'",
            "'" + correo + "'",
            "'" + cuentaBancaria + "'",
            "'" + entidadBancaria + "'",
            "'" + profesion + "'",
            "'" + titulos + "'",
            "'" + especialidades + "'",
            "'" + catedras + "'",
            "'" + tipoContrato + "'",
            "'" + fechaIngreso + "'",
            "'" + status + "'"
        };
       
        return(rows);
    }
    public String getSqlTable()
    {
        return("profesor");
    }
}