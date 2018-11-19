import org.hibernate.Session; 
import org.hibernate.SessionFactory; 
import org.hibernate.Transaction; 
import org.hibernate.boot.registry.StandardServiceRegistryBuilder; 
import org.hibernate.cfg.Configuration; 
import org.hibernate.service.ServiceRegistry; 
public class main { 
     public static void main(String[] args) { 
     //creating configuration object 
     Configuration cfg = new Configuration(); 
     cfg.configure("hibernate.cfg.xml");//populates the data of the configuration file 
     //creating seession factory object 
     ServiceRegistry serviceRegistry = new  
                StandardServiceRegistryBuilder().applySettings(cfg.getProperties()). build(); 
     SessionFactory factory=cfg.buildSessionFactory(serviceRegistry); 
     //creating session object 
     Session session=factory.openSession(); 
     //creating transaction object 
     Transaction t=session.beginTransaction(); 
     Employee e1=new Employee(); 
     e1.setId(1); 
     e1.setFirstName("myFirstName");
     e1.setLastName("mySecondName"); 
     session.persist(e1);//persisting the object 
     t.commit();//transaction is commited 
     session.close(); 
   } 
}
