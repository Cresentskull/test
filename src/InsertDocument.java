import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

import java.net.UnknownHostException;
import java.util.*;

public class InsertDocument  {
	private String WebAPI;
	private String JVM;
	private String AppName;
	String stringAPIX;
	private String APIX;
	BasicDBObject Web = new BasicDBObject();
	
		public void insertData(String WebAPI, String JVM, String AppName, String APIX) throws UnknownHostException{
			this.WebAPI = WebAPI;
			this.JVM = JVM;
			this.AppName = AppName;
			this.APIX = APIX;
			 
			 DB db = (new MongoClient("localhost", 27017)).getDB("Web");
				DBCollection dbCollection = db.getCollection("Info");
				Web.put("Web API", WebAPI);
				Web.put("JVM", JVM);
				Web.put("App Name", AppName);
				Web.put("APIX", APIX);
				dbCollection.insert(new DBObject[]{Web});				
				BasicDBObject query = new BasicDBObject("Web API", WebAPI);
		        DBCursor cursor = dbCollection.find(query);		       
		        BasicDBObject dbObject = (BasicDBObject)cursor.next();
		        String webAPI = dbObject.getString("Web API");
		        String JVMName = dbObject.getString("JVM");
		        String appName = dbObject.getString("App Name");
		        APIX = dbObject.getString("APIX");
		        System.out.println("Web Application API: " + webAPI);
		        System.out.println("JVM Name: " + JVMName);
		        System.out.println("App Name: " + appName);
		        System.out.println("APIX: " + APIX);
		}
		
	
}
