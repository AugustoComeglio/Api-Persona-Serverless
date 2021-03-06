package com.api.repositories;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.api.entities.Localidad;
import com.api.entities.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class LocalidadRepositoryImpl implements LocalidadRepository{

    @Autowired
    private DynamoDBMapper dynamoDBMapper;

    @Override
    public Localidad createLocalidad(Localidad localidad) {
        dynamoDBMapper.save(localidad);
        return localidad;
    }

    @Override
    public Localidad getOneLocalidad(String localidadId) {
        Localidad  localidad = dynamoDBMapper.load(Localidad.class,localidadId);
        return localidad;
    }

    @Override
    public Localidad updateLocalidad(Localidad localidad) {
        Map<String, ExpectedAttributeValue> expectedAttributeValueMap = new HashMap<>();
        ExpectedAttributeValue expectedAttributeValue = new ExpectedAttributeValue(new AttributeValue().withS(localidad.getLocalidadId()));
        expectedAttributeValueMap.put("localidadId", expectedAttributeValue);
        DynamoDBSaveExpression saveExpression = new DynamoDBSaveExpression().withExpected(expectedAttributeValueMap);
        dynamoDBMapper.save(localidad,saveExpression);
        return localidad;
    }

    @Override
    public void deleteLocalidad (String localidadId) {
        Localidad localidad = dynamoDBMapper.load(Localidad.class,localidadId);
        dynamoDBMapper.delete(localidad);
    }

    @Override
    public List<Localidad> getAllLocalidades() {
        final Map<String,AttributeValue> map = new HashMap<>();
        map.put("localidadId", new AttributeValue("Localidades:"));
        final DynamoDBQueryExpression<Localidad> queryExpression = new DynamoDBQueryExpression<Localidad>()
                .withKeyConditionExpression("localidadId")
                .withExpressionAttributeValues(map);
        return dynamoDBMapper.query(Localidad.class, queryExpression);

        /*
        List<Persona> personas = dynamoDBMapper.scan(Persona.class, new DynamoDBScanExpression());
        return personas;

         */
    }
}
