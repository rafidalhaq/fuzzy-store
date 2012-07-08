package com.fuzzy.logic.algoritm.mongdb;

import java.net.UnknownHostException;
import java.util.Set;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import com.mongodb.MongoException;

public class DbAccesConnection {

	private static DB db_object;

	/**
	 * @param host
	 * @param port
	 * @param database
	 * @return
	 * @throws UnknownHostException
	 * @throws MongoException
	 */
	public DB setDbObject(final String host, final Integer port,
			final String database) throws UnknownHostException, MongoException {

		final Mongo mongo_db = this.getMongoObject(host, port);

		final DB db = mongo_db.getDB(database);
		if (db != null) {
			this.setDb_object(db);
		}

		return db;

	}

	/**
	 * @param host
	 * @param port
	 * @return
	 * @throws UnknownHostException
	 * @throws MongoException
	 */
	public Mongo getMongoObject(final String host, final Integer port)
			throws UnknownHostException, MongoException {

		Mongo mongo_db = null;
		if (port != null) {
			mongo_db = new Mongo(host, port);
		}
		return mongo_db;

	}

	/**
	 * @return un set cu numele colectiilor
	 */
	public Set<String> getCollectionNames() {
		Set<String> colls = this.db_object.getCollectionNames();

		for (String s : colls) {
			System.out.println(s);
		}
		return colls;

	}

	/**
	 * @return
	 */
	public DBCollection getCollection() {

		DBCollection coll = this.db_object.getCollection("test");
		return coll;

	}

	/**
	 * @return db_object
	 */
	public static DB getDb_object() {
		return db_object;
	}

	/**
	 * @param db_object
	 */
	private void setDb_object(DB db_object) {
		this.db_object = db_object;
	}

}
