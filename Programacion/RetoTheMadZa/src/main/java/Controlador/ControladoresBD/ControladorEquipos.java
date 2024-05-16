package Controlador.ControladoresBD;

import Controlador.ControladoresBD.ControladorModelo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import Modelo.Equipo;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ControladorEquipos {
    private EntityManager em;
    private EntityTransaction transaction;
    private Equipo e;

    public ControladorEquipos(EntityManager em, EntityTransaction transaction)
    {
        this.em = em;
        this.transaction = transaction;

        System.out.println("Elementos creados");
    }

    /*
    public void terminar() throws Exception{
        em.close();
        emf.close();
    }
    */

    public void insertarEquipo(Equipo e) throws Exception
    {
        try
        {
            transaction.begin();
            em.persist(e);
            transaction.commit();
        }
        catch (Exception ex)
        {
            if (transaction.isActive()){
                transaction.rollback();
            }
        }
    }

    public void borrarEquipo() throws Exception
    {
        transaction.begin();
        em.remove(e);
        transaction.commit();
    }

    public Equipo buscarEquipo(Integer id_equipo) throws Exception
    {
        transaction.begin();
        e = em.find(Equipo.class, id_equipo);
        if (e == null){
            JOptionPane.showMessageDialog(null,"No hay ningún equipo con ese id");
        }
        transaction.commit();
        return e;
    }

    public void modificarEquipo(Equipo equipo) throws Exception
    {
        transaction.begin();
        Equipo e = em.find(Equipo.class, equipo.getIdEquipo());
        if (e != null){

            e.setNomEquipo(equipo.getNomEquipo());
            e.setFechaFundacion(equipo.getFechaFundacion());
            e.setLogo(equipo.getLogo());
            e.setColor(equipo.getColor());

            em.merge(e);
            transaction.commit();
        }
        else
        {
            throw new Exception("No se encontró ningún equipo con el ID provisto: "+ equipo.getIdEquipo());
        }
    }

}
