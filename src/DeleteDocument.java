import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

import java.net.UnknownHostException;
import java.util.*;
public class DeleteDocument {
	private String WebAPI;
	public void deleteDocument(String WebAPI)throws UnknownHostException{
		this.WebAPI = WebAPI;
		DB db = (new MongoClient("localhost", 27017)).getDB("Web");
		DBCollection dbCollection = db.getCollection("Info");
		BasicDBObject query = new BasicDBObject("Web API", WebAPI);

		DBCursor cursor = dbCollection.find(query);
		BasicDBObject dbObject = (BasicDBObject)cursor.next();
		dbCollection.remove(dbObject);
		System.out.println("Document deleted!");
		
	}

}
