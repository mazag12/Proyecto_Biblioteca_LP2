package listener;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import dao.DAOFactory;
import beans.session;
import interfaces.LogSessionInterfaceDAO;

/**
 * Application Lifecycle Listener implementation class SessionListener
 *
 */
@WebListener
public class SessionListener implements HttpSessionListener {

    /**
     * Default constructor. 
     */
    public SessionListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent sessionEvent)  { 
         // TODO Auto-generated method stub
    	System.out.println("Session Created ID:" + sessionEvent.getSession().getId());
    	   
        long time = sessionEvent.getSession().getCreationTime();
        
        Calendar calendar = converterCalendar(time);
        
       	int year = calendar.get(Calendar.YEAR);
    	int month = calendar.get(Calendar.MONTH);
    	int day = calendar.get(Calendar.DAY_OF_MONTH);
    	int hour = calendar.get(Calendar.HOUR_OF_DAY);
    	int minute = calendar.get(Calendar.MINUTE);
    	int second = calendar.get(Calendar.SECOND);
    	
        System.out.println("Session Created zone:" + calendar.getTimeZone().getDisplayName());
        System.out.println("Session Created date:" + new SimpleDateFormat().format(sessionEvent.getSession().getCreationTime()));
        
        
    
        
        
        DAOFactory daoFactory = DAOFactory.getFactory(DAOFactory.MYSQL);
        LogSessionInterfaceDAO dao = daoFactory.getSession();
        
        session sessio = new session ();
        sessio.setTimeZoneSession(calendar.getTimeZone().getDisplayName());
        sessio.setDateSession(new SimpleDateFormat().format(sessionEvent.getSession().getCreationTime()));

        
        dao.createSession(sessio);
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent sessionEvent)  { 
    	System.out.println("Session Destroyed ID:" + sessionEvent.getSession().getId());
    	System.out.println("Session Created zone:" + sessionEvent.getSession().getLastAccessedTime());
    }
    
    private Calendar converterCalendar(long time) {
   	 Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);
   	return calendar;
   }
	
}
