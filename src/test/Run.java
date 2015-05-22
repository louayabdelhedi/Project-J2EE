package test;

import jeeproject.bean.*;
import jeeproject.hibernate.dao.HibernateSessionManager;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class Run {

/**
 * @param args
 */
 public static void main(String[] args) {
 Session session = HibernateSessionManager.getSessionFactory().openSession();

 session.beginTransaction();
 Client client = new Client();

 client.setNomClient("louay");
 client.setTelClient(222222);
 client.setVilleClient("sfax");
 client.setAdresseClient("route de gremda");

 session.save(client);
 Query req = session.createQuery("from Client");
// req.setInteger(0, 7);
 List<Client> list = (List<Client>)req.list();
 for (Client clients : list) {
	System.out.println(clients.getNomClient());
}
 session.getTransaction().commit();
HibernateSessionManager.shutdown();
}

}
