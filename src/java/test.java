
import com.pfe.facade.ServiceService;
import com.pfe.facade.TransactionService;
import com.pfe.facade.UtilisateurService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author abdelmouhgit
 */
public class test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        ApplicationContext context=new ClassPathXmlApplicationContext("newSpringXMLConfig.xml");
        ServiceService ss= (ServiceService)context.getBean("serviceService");
        TransactionService tt= (TransactionService)context.getBean("transactionService");
        UtilisateurService user= (UtilisateurService)context.getBean("utilisateurService");
        System.out.println("daaaz");

    }
    
}
