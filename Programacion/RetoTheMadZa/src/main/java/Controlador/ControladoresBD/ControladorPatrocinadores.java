package Controlador.ControladoresBD;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import Modelo.Patrocinador;

import javax.swing.*;

public class ControladorPatrocinadores {
    private EntityManager em;
    private EntityTransaction transaction;
    private Patrocinador p;

    public ControladorPatrocinadores(EntityManager em, EntityTransaction transaction)
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

    public void insertarPatrocinador(Patrocinador p) throws Exception
    {
        try
        {
            transaction.begin();
            em.persist(p);
            transaction.commit();
        }
        catch (Exception ex)
        {
            if (transaction.isActive()){
                transaction.rollback();
            }
        }
    }

    public void borrarPatrocinador() throws Exception
    {
        transaction.begin();
        em.remove(p);
        transaction.commit();
    }

    public Patrocinador buscarPatrocinador(Integer id_patrocinador) throws Exception
    {
        transaction.begin();
        p = em.find(Patrocinador.class, id_patrocinador);
        if (p == null){
            JOptionPane.showMessageDialog(null,"No hay ningún patrocinador con ese id");
        }
        transaction.commit();
        return p;
    }

    public void modificarPatrocinador(Patrocinador patrocinador) throws Exception
    {
        transaction.begin();
        Patrocinador p = em.find(Patrocinador.class, patrocinador.getIdPatrocinador());
        if (p != null){

            p.setNombre(patrocinador.getNombre());

            em.merge(p);
            transaction.commit();
        }
        else
        {
            throw new Exception("No se encontró ningún patrocinador con el ID provisto: "+
                    patrocinador.getIdPatrocinador());
        }
    }
}
