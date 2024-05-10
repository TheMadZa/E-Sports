package Controlador.ControladoresBD;

import Controlador.ControladoresBD.ControladorModelo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import Modelo.Jornada;

import javax.swing.*;

public class ControladorJornadas {
    private ControladorModelo cm;
    private EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction transaction;
    private Jornada j;

    public ControladorJornadas(ControladorModelo cm)
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

    public void insertarJornada(Jornada j) throws Exception
    {
        try
        {
            transaction.begin();
            em.persist(j);
            transaction.commit();
        }
        catch (Exception ex)
        {
            if (transaction.isActive()){
                transaction.rollback();
            }
        }
    }

    public void borrarJornada() throws Exception
    {
        transaction.begin();
        em.remove(j);
        transaction.commit();
    }

    public Jornada buscarJornada(Integer id_jornada) throws Exception
    {
        transaction.begin();
        j = em.find(Jornada.class, id_jornada);
        if (j == null){
            JOptionPane.showMessageDialog(null,"No hay ninguna jornada con ese id");
        }
        transaction.commit();
        return j;
    }

    public void modificarJornada(Jornada jornada) throws Exception
    {
        transaction.begin();
        Jornada j = em.find(Jornada.class, jornada.getIdJornada());
        if (j != null){

            j.setNumJornada(jornada.getNumJornada());
            j.setFechaJornada(jornada.getFechaJornada());
            j.setCompeticionByIdCompeticion(jornada.getCompeticionByIdCompeticion());

            em.merge(j);
            transaction.commit();
        }
        else
        {
            throw new Exception("No se encontró ninguna jornada con el ID provisto: "+ jornada.getIdJornada());
        }
    }
}
