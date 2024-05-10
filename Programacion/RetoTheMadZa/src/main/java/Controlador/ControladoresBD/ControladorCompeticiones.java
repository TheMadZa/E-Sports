package Controlador.ControladoresBD;

import Controlador.ControladoresBD.ControladorModelo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import Modelo.Competicion;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class ControladorCompeticiones {
    private ControladorModelo cm;
    private EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction transaction;
    private Competicion c;

    public ControladorCompeticiones(ControladorModelo cm)
    {
        this.cm = cm;

        emf = Persistence.createEntityManagerFactory("default");
        em = emf.createEntityManager();
        transaction = em.getTransaction();

        System.out.println("Elementos creados");
    }

    public void terminar() throws Exception{
        em.close();
        emf.close();
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
            JOptionPane.showMessageDialog(null,"No hay ninguna competición con ese id");
        }
        transaction.commit();
        return c;
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
