package com.ArangoTest;

import com.arangodb.ArangoCollection;
import com.arangodb.ArangoCursor;
import com.arangodb.ArangoDB;
import com.arangodb.ArangoDBException;
import com.arangodb.entity.BaseDocument;
import com.arangodb.entity.CollectionEntity;
import com.arangodb.model.AqlQueryOptions;
import com.arangodb.util.MapBuilder;
import com.arangodb.velocypack.VPackSlice;
import com.arangodb.velocypack.exception.VPackException;
import com.sun.xml.internal.bind.v2.runtime.output.SAXOutput;

import java.util.Collection;

public class main {
    public static <doc> void main(String[] args) {
        ArangoDB arangoDB = new ArangoDB.Builder()
                .host("127.0.0.1", 8529)
                .user("root")
                .password("root")
                .build();

        Collection<CollectionEntity> cols = arangoDB.db().getCollections();
        System.out.println(cols.size());

        String collectionName = "firstCollection";
//        try {
//            CollectionEntity myArangoCollection = arangoDB.db("_system").createCollection(collectionName);
//            System.out.println("Collection created: " + myArangoCollection.getName());
//        } catch (ArangoDBException e) {
//            System.err.println("Failed to create collection: " + collectionName + "; " + e.getMessage());
//        }

//        BaseDocument myObject = new BaseDocument();
//        myObject.setKey("myKey");
//        myObject.addAttribute("a", "Foo");
//        myObject.addAttribute("b", 42);
//        try {
//            arangoDB.db("_system").collection(collectionName).insertDocument(myObject);
//            System.out.println("Document created");
//        } catch (ArangoDBException e) {
//            System.err.println("Failed to create document. " + e.getMessage());
//        }

        ArangoCollection vertex = arangoDB.db("_system").collection("devices");
//        System.out.println(vertex.getProperties());
        System.out.println(vertex.getDocument("device1",  BaseDocument.class));

        final BaseDocument doc = null;
//        final BaseDocument doc = arangoDB.db().collection("devices").getDocument("device1", BaseDocument.class);
        System.out.println(doc.getProperties());

//        try{
//            doc.getProperties().forEach(r -> {
//                System.out.println(r.toString());
//            });
//        }()
    }
}
