import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import java.net.UnknownHostException;
import java.util.*;

public class MainClass {
	public static void main(String[] args) throws UnknownHostException{
		Scanner Key = new Scanner(System.in);
		InsertDocument insert = new InsertDocument();
		UpdateDocument update = new UpdateDocument();
		FindDocument find = new FindDocument();
		DeleteDocument delete = new DeleteDocument();
		
		MongoClient mongoClient = new MongoClient();
		mongoClient = new MongoClient("localhost", 27017);
		
		DB db = mongoClient.getDB("web");
		DBCollection dbCollection = db.getCollection("Info");
		boolean insertAPIX = true;
		boolean runAgain = true;		
		while(runAgain){
		System.out.println("What would you like to do (add, find, delete, or update)?");		
		String Do = Key.nextLine();
		if(Do.toUpperCase().equals("ADD")){
			System.out.println("What is the name of the WebAPI?");
			String WebAPI = Key.nextLine();
			System.out.println("What is the name of the JVM?");
			String JVM = Key.nextLine();
			System.out.println("What is the app name?");
			String AppName = Key.nextLine();
			System.out.println("Is it APIX?");
			String ReplyAPIX = Key.nextLine();
			while(insertAPIX = true){
			if(ReplyAPIX.toUpperCase().equals("YES")){
				String APIX = "true";
				insert.insertData(WebAPI, JVM, AppName, APIX);
				insertAPIX = false;
			}
			else if(ReplyAPIX.toUpperCase().equals("NO")){
				String APIX = "false";
				insert.insertData(WebAPI, JVM, AppName, APIX);
				insertAPIX = false;
			}
			else{
				System.out.println("Is it APIX? NOTE: This is a yes or no question.");
				ReplyAPIX = Key.nextLine();
			}
			}			
	        runAgain = false;
			}
		
		else if((Do.toUpperCase().equals("UPDATE"))){
			System.out.println("What would you like to update?");
	        String change = Key.nextLine();
	        if(change.toUpperCase().equals("APIX")){
	        	System.out.println("What is the Web API of the document you would like to change");
		        String currentWebAPI = Key.nextLine();
		        BasicDBObject query = new BasicDBObject("Web API", currentWebAPI);
		        DBCursor cursor = dbCollection.find(query);
		        BasicDBObject dbObject = (BasicDBObject)cursor.next();
		        String changeAPIX = dbObject.getString("APIX");		       
		        if(changeAPIX.equals("true")){
		        	System.out.println("Your document has been updated.");
		        	update.setFalse(currentWebAPI); 		       
		        }
		        else{
		        	System.out.println("Your document has been updated.");
		        	update.setTrue(currentWebAPI);    	
		        }
		        runAgain = false;
	        }
	        else{
	        System.out.println("What is the Web API of the document you would like to change");
	        String currentWebAPI = Key.nextLine();
	        System.out.println("What would you like to change " + change + " to?");
	        String updateDocument = Key.nextLine();
	        update.updateValues(change, currentWebAPI, updateDocument);
	        BasicDBObject query = new BasicDBObject(change, updateDocument);
	        DBCursor cursor = dbCollection.find(query);
	        System.out.println("Your document has been updated. The new values are as follows: ");
	        BasicDBObject dbObject = (BasicDBObject)cursor.next();
	        String webAPI = dbObject.getString("Web API");
	        String JVMName = dbObject.getString("JVM");
	        String appName = dbObject.getString("App Name");
	        boolean APIX = dbObject.getBoolean("APX");
	        System.out.println("Web Application API: " + webAPI);
	        System.out.println("JVM Name: " + JVMName);
	        System.out.println("App Name: " + appName);
	        System.out.println("APIX: " + APIX);
	        runAgain = false;
	        }	     
		}
		else if((Do.toUpperCase().equals("FIND"))){
			System.out.println("Enter the name of the Web API you are trying to find.");
			String API = Key.nextLine();
			find.findDocument(API);
			runAgain = false;
		}
		else if((Do.toUpperCase().equals("DELETE"))){
			System.out.println("What is the Web API of the document you would like to delete?");
			String webAPI = Key.nextLine();
			delete.deleteDocument(webAPI);
			runAgain = false;			
		}
		else{
			System.err.println("Not an Option!");
			runAgain = true;
		}	
		mongoClient.close();
	}
	}
}
