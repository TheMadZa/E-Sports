package controlador.ControladoresBD;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import Modelo.Jugador;

import javax.swing.*;

public class ControladorJugadores {
    private ControladorModelo cm;
    private EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction transaction;
    private Jugador j;

    public ControladorJugadores(ControladorModelo cm)
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

    public void insertarJugador(Jugador j) throws Exception
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

    public void borrarJugador() throws Exception
    {
        transaction.begin();
        em.remove(j);
        transaction.commit();
    }

    public Jugador buscarJugador(Integer id_jugador) throws Exception
    {
        transaction.begin();
        j = em.find(Jugador.class, id_jugador);
        if (j == null){
            JOptionPane.showMessageDialog(null,"No hay ningún jugador con ese id");
        }
        transaction.commit();
        return j;
    }

    public void modificarJugador(Jugador jugador) throws Exception
    {
        transaction.begin();
        Jugador j = em.find(Jugador.class, jugador.getIdJugador());
        if (j != null){

            j.setNombre(jugador.getNombre());
            j.setNickname(jugador.getNickname());
            j.setNacionalidad(jugador.getNacionalidad());
            j.setRol(jugador.getRol());
            j.setFechaNac(jugador.getFechaNac());
            j.setSueldo(jugador.getSueldo());
            j.setEquipoByIdEquipo(jugador.getEquipoByIdEquipo());

            em.merge(j);
            transaction.commit();
        }
        else
        {
            throw new Exception("No se encontró ningún jugador con el ID provisto: "+ jugador.getIdJugador());
        }
    }
}
