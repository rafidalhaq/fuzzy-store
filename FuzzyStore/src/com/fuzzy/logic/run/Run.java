package com.fuzzy.logic.run;

import java.net.UnknownHostException;

import com.fuzzy.logic.algoritm.mongdb.DbAccesConnection;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoException;

public class Run {

	public static void main(String[] args) throws UnknownHostException,
			MongoException {

		DbAccesConnection dbAcces = new DbAccesConnection();
		dbAcces.setDbObject("localhost", 27017, "test");
		System.out.print(dbAcces.getCollectionNames());

		DBCollection coll = dbAcces.getCollection();
		System.out.print(coll.find());
		
		DBCursor cur = coll.find();
		
		while(cur.hasNext()) {
			System.out.println(cur.next());
		}
		
		
		BasicDBObject query = new BasicDBObject();

        query.put("i", 71);

        cur = coll.find(query);

        while(cur.hasNext()) {
            System.out.println(cur.next());
        }
        
	}
}
