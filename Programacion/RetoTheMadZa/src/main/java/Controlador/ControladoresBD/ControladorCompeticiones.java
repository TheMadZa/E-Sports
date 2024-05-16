package Controlador.ControladoresBD;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import Modelo.Competicion;

import javax.swing.*;
import java.util.List;

public class ControladorCompeticiones {
    private final EntityManager em;
    private final EntityTransaction transaction;
    private Competicion c;

    public ControladorCompeticiones(EntityManager em, EntityTransaction transaction)
    {
        this.em = em;
        this.transaction = transaction;

        System.out.println("Elementos creados de ControladorCompeticiones.");
    }

    public void insertarCompeticion(Competicion c) throws Exception
    {
        try
        {
            transaction.begin();
            em.persist(c);
            transaction.commit();
        }
        catch (Exception e)
        {
            if (transaction.isActive()){
                transaction.rollback();
            }
        }
    }

    public void borrarCompeticion() throws Exception
    {
        transaction.begin();
        em.remove(c);
        transaction.commit();
    }

    public Competicion buscarCompeticion(Integer id_competicion) throws Exception
    {
        transaction.begin();
        c = em.find(Competicion.class, id_competicion);
        if (c == null){
            JOptionPane.showMessageDialog(null,"No hay ninguna competición con ese ID.");
        }
        transaction.commit();
        return c;
    }

    public Competicion buscarCompeticionNombre(String nombre_com) throws Exception
    {
        transaction.begin();
        c = em.find(Competicion.class, nombre_com);
        if (c == null){
            JOptionPane.showMessageDialog(null,"No hay ninguna competición con ese nombre.");
        }
        transaction.commit();
        return c;
    }

    // TODO : EL PROBLEMÓN
    public List<Competicion> buscarTodasCompeticiones() throws Exception
    {
        transaction.begin();
        List<Competicion> lista = em.createQuery("select c from Competicion c",
                Competicion.class).getResultList();
        transaction.commit();
        return lista;
    }

    public void modificarCompeticion(Competicion competicion) throws Exception
    {
        transaction.begin();
        Competicion c = em.find(Competicion.class, competicion.getIdCompeticion());
        if (c != null){

            c.setNombreCom(competicion.getNombreCom());
            c.setFechaInicio(competicion.getFechaInicio());
            c.setFechaFin(competicion.getFechaFin());
            c.setEtapa(competicion.getEtapa());
            c.setJuegoByIdJuego(competicion.getJuegoByIdJuego());
            c.setEquipoByIdEquipoGanador(competicion.getEquipoByIdEquipoGanador());

            em.merge(c);
            transaction.commit();
        }
        else
        {
            throw new Exception("No se encontró ninguna competición con el ID provisto: "+
                    competicion.getIdCompeticion());
        }
    }
}
