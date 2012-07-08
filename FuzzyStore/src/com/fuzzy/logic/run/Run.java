package com.fuzzy.logic.run;

import java.net.UnknownHostException;

import com.fuzzy.logic.algoritm.mongdb.DbAccesConnection;
import com.mongodb.MongoException;

public class Run {

	public static void main(String[] args) throws UnknownHostException,
			MongoException {

		DbAccesConnection dbAcces = new DbAccesConnection();
		dbAcces.setDbObject("localhost", 27017, "test");
		System.out.print(dbAcces.getCollectionNames());

		System.out.print(dbAcces.getCollection().findOne());
	}
}
