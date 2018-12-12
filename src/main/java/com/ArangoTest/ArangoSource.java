package com.ArangoTest;

import com.arangodb.ArangoCursor;
import com.arangodb.ArangoDB;
import com.arangodb.ArangoDBException;
import com.arangodb.entity.BaseDocument;
import com.arangodb.util.MapBuilder;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;
import java.util.function.BiConsumer;

import static com.ArangoTest.DataSourceConfig.Types.ARANGO;

public class ArangoSource implements ArangoTest {
    private String arangoHost;
    private Integer arangoPort;
    private String arangoUser;
    private String arangoDbName;
    private String arangoCollection;
    private UUID deviceId;


    public ArangoSource(String arangoHost, Integer arangoPort, String arangoUser,
                        String arangoDbName, String arangoCollection, UUID deviceId) {
        this.arangoHost = arangoHost;
        this.arangoPort = arangoPort;
        this.arangoUser = arangoUser;
        this.arangoDbName = arangoDbName;
        this.arangoCollection = arangoCollection;
        this.deviceId = deviceId;
    }

    @Override
    public List<String> getHeader() {
        List<String> header = new ArrayList<>();

        return null;
    }

    @Override
    public SampleFile getSample() {
        ArangoDB arangoDB = getNewConnection();

//        final BaseDocument doc = arangoDB.db().collection(arangoCollection).getDocument("device1", BaseDocument.class);


        final BaseDocument doc = arangoDB.db(arangoDbName).collection(arangoCollection).getDocument(deviceId.toString(), BaseDocument.class);
        Map<String, Object> properties = doc.getProperties();

        Map<String, String> strProperties = new HashMap<>();
        List<String> header = new ArrayList<>();

        properties.entrySet().forEach(entry -> {
            strProperties.put(entry.getKey(), entry.getValue().toString());
            header.add(entry.getKey());
        });

        List<Map<String, String>> dataList = new ArrayList<>();
        dataList.add(strProperties);

        Map<String, List<String>> headerMap = new HashMap<>();
        headerMap.put(ARANGO.toString().toLowerCase(), header);

        Map<String, List<Map<String, String>>> dataMap = new HashMap<>();
        dataMap.put(ARANGO.toString().toLowerCase(), dataList);

        System.out.println(headerMap);
        System.out.println(dataMap);

        SampleFile sampleFile = new SampleFile(headerMap, dataMap);
        return sampleFile;
    }

    @Override
    public void close() throws IOException {

    }

    public ArangoDB getNewConnection() {

        return new ArangoDB.Builder()
//                .host("206.189.34.199", 1027)
                .host(arangoHost, arangoPort)
                .user(arangoUser)
                .password("root")
                .build();
    }

}
