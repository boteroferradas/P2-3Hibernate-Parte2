package services;

import config.HibernateConfig;
import models.Adestrador;
import models.Pokedex;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class AdestradorService {
    Transaction transaction = null;

    public void crearAdestrador(String nome, Date nacemento){
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            Adestrador novoAdestrador = new Adestrador();
            novoAdestrador.setNome(nome);
            novoAdestrador.setNacemento(nacemento);

            session.persist(novoAdestrador);
            transaction.commit();
            System.out.println("Adestrador creado con éxito.");

        } catch (Exception e) {
            if (transaction != null && transaction.isActive()){
                transaction.rollback();
            }
            System.out.println("Erro ao crear a Adestrador: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public List<Adestrador> listarAdestradores(){
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            return session.createQuery("from Adestrador", Adestrador.class).getResultList();
        } catch (Exception e) {
            System.out.println("Erro ao listar os adestradores: " + e.getMessage());
            return null;
        }
    }

    public Adestrador lerAdestrador(String nome) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            return session.get(Adestrador.class, nome);
        } catch (Exception e) {
            System.out.println("Erro ao ler adestrador: " + e.getMessage());
            return null;
        }
    }


    public void actualizarAdestrador(Adestrador adestrador) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
                session.update(adestrador);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Erro ao actualizar a Pokedex: " + e.getMessage());
        }
    }
}
