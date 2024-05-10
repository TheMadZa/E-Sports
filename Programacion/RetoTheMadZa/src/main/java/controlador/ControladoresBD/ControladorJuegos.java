package Controlador.ControladoresBD;

import Controlador.ControladoresBD.ControladorModelo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import Modelo.Juego;

import javax.swing.*;

public class ControladorJuegos {
    private ControladorModelo cm;
    private EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction transaction;
    private Juego j;

    public ControladorJuegos(ControladorModelo cm)
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

    public void insertarJuego(Juego j) throws Exception
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

    public void borrarJuego() throws Exception
    {
        transaction.begin();
        em.remove(j);
        transaction.commit();
    }

    public Juego buscarJuego(Integer id_juego) throws Exception
    {
        transaction.begin();
        j = em.find(Juego.class, id_juego);
        if (j == null){
            JOptionPane.showMessageDialog(null,"No hay ningún juego con ese id");
        }
        transaction.commit();
        return j;
    }

    public void modificarJuego(Juego juego) throws Exception
    {
        transaction.begin();
        Juego j = em.find(Juego.class, juego.getIdJuego());
        if (j != null){

            j.setNombre(juego.getNombre());
            j.setEmpresa(juego.getEmpresa());
            j.setFechaLanzamiento(juego.getFechaLanzamiento());

            em.merge(j);
            transaction.commit();
        }
        else
        {
            throw new Exception("No se encontró ningún juego con el ID provisto: "+ juego.getIdJuego());
        }
    }
}
