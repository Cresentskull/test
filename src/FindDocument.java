import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

import java.net.UnknownHostException;
import java.util.*;
public class FindDocument {
	String WebAPI;
	public void findDocument(String WebAPI)throws UnknownHostException{
		DB db = (new MongoClient("localhost", 27017)).getDB("Web");
		DBCollection dbCollection = db.getCollection("Info");
		this.WebAPI = WebAPI;
	BasicDBObject query = new BasicDBObject("Web API", WebAPI);

	DBCursor cursor = dbCollection.find(query);

	System.out.println("Document found!");
	
	BasicDBObject dbObject = (BasicDBObject)cursor.next();
	String webAPI = dbObject.getString("Web API");
	String JVMName = dbObject.getString("JVM");
	String AppName = dbObject.getString("App Name");
	boolean APIX = dbObject.getBoolean("APX");
	
	System.out.println("Web Application API: " + webAPI) ;
	System.out.println("JVM Name: " + JVMName) ;
	System.out.println("App Name: " + AppName);
	System.out.println("APIX: " + APIX);
	}
}
