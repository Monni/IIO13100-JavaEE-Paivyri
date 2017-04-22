package fi.agileo.javaee.api;

/**
 * Hello world!
 *
 */
import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        java.util.Date parsed = null;
		try {
			parsed = format.parse("20110210");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        java.sql.Date pvm = new java.sql.Date(parsed.getTime());
        
        // Kunhan saan jonkin kellonajan konstruktoriin
        java.sql.Time klo = new java.sql.Time(648466848);


        EntityManagerFactory tehdas = Persistence.createEntityManagerFactory("Ruokailu");
		EntityManager entityManageri = tehdas.createEntityManager(); 
		//EntityTransaction transaktio = entityManageri.getTransaction();
		//transaktio.begin(); 
        
        //Date pvm, Time klo, String nimi, String ruoannimi, int ruoanmaara, int kalorit, int hiilihydraatit, int proteiini, int rasva
       // Ruokailu ruokailu = new Ruokailu(pvm, klo, "Miika", "Persikkaa", 150, 200);
        
       // entityManageri.persist(ruokailu);
		//transaktio.commit();
		
       // System.out.println(ruokailu.toString());
    }
}