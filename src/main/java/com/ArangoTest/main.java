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
import java.util.UUID;

public class main {
    public static <doc> void main(String[] args) {

        ArangoSource arangoSource = new ArangoSource("127.0.0.1",8529,"root","_system","device", UUID.fromString("7021476e-ec14-47bc-b5d7-19745fe17f88"));

        arangoSource.getSample();

    }
}
