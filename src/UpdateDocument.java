import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

import java.net.UnknownHostException;
import java.util.*;


public class UpdateDocument  {
	private String change;
	private String update;
	private String currentValue;
	private String currentWebAPI;
	private String newAPIX;
	
	public void updateValues(String change, String currentWebAPI , String update) throws UnknownHostException{
	DB db = (new MongoClient("localhost", 27017)).getDB("Web");
	DBCollection dbCollection = db.getCollection("Info");
	
	this.update = update;
	this.change = change;	
	this.currentWebAPI = currentWebAPI;
	BasicDBObject query = new BasicDBObject();
	query.put("Web API", currentWebAPI);

	BasicDBObject newDocument = new BasicDBObject();
	newDocument.put(change, update);

	BasicDBObject updateObj = new BasicDBObject();
	updateObj.put("$set", newDocument);

	dbCollection.update(query, updateObj);
	
	
	}
	
	public void setFalse(String currentWebAPI) throws UnknownHostException{
		 String APIX = "false";
		 DB db = (new MongoClient("localhost", 27017)).getDB("Web");
			DBCollection dbCollection = db.getCollection("Info");
			
		 this.currentWebAPI = currentWebAPI;
		 BasicDBObject query = new BasicDBObject();
			query.put("Web API", currentWebAPI);

			BasicDBObject newDocument = new BasicDBObject();
			newDocument.put("APIX", APIX);

			BasicDBObject updateObj = new BasicDBObject();
			updateObj.put("$set", newDocument);

			dbCollection.update(query, updateObj);
			BasicDBObject Query = new BasicDBObject("Web API", currentWebAPI);
	        DBCursor Cursor = dbCollection.find(Query);
	        BasicDBObject dbObject = (BasicDBObject)Cursor.next();
	        String webAPI = dbObject.getString("Web API");
	        String JVMName = dbObject.getString("JVM");
	        String appName = dbObject.getString("App Name");
	        String APX = dbObject.getString("APIX");
	        System.out.println("Web Application API: " + webAPI);
	        System.out.println("JVM Name: " + JVMName);
	        System.out.println("App Name: " + appName);
	        System.out.println("APIX: " + APX);
	}
	public void setTrue(String currentWebAPI) throws UnknownHostException{
		 String APIX = "true";
		 DB db = (new MongoClient("localhost", 27017)).getDB("Web");
			DBCollection dbCollection = db.getCollection("Info");
			
		 this.currentWebAPI = currentWebAPI;
		 BasicDBObject query = new BasicDBObject();
			query.put("Web API", currentWebAPI);

			BasicDBObject newDocument = new BasicDBObject();
			newDocument.put("APIX", APIX);

			BasicDBObject updateObj = new BasicDBObject();
			updateObj.put("$set", newDocument);

			dbCollection.update(query, updateObj);
			BasicDBObject Query = new BasicDBObject("Web API", currentWebAPI);
	        DBCursor Cursor = dbCollection.find(Query);
	        BasicDBObject dbObject = (BasicDBObject)Cursor.next();
	        String webAPI = dbObject.getString("Web API");
	        String JVMName = dbObject.getString("JVM");
	        String appName = dbObject.getString("App Name");
	        String APX = dbObject.getString("APIX");
	        System.out.println("Web Application API: " + webAPI);
	        System.out.println("JVM Name: " + JVMName);
	        System.out.println("App Name: " + appName);
	        System.out.println("APIX: " + APX);
	}
}
