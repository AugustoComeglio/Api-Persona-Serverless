package com.api.repositories;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.api.entities.Autor;
import com.api.entities.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class AutorRepositoryImpl implements AutorRepository{

    @Autowired
    private DynamoDBMapper dynamoDBMapper;

    @Override
    public Autor createAutor(Autor autor) {
        dynamoDBMapper.save(autor);
        return autor;
    }

    @Override
    public Autor getOneAutor(String autorId) {
        Autor autor = dynamoDBMapper.load(Autor.class,autorId);
        return autor;
    }

    @Override
    public Autor updateAutor(Autor autor) {
        Map<String, ExpectedAttributeValue> expectedAttributeValueMap = new HashMap<>();
        ExpectedAttributeValue expectedAttributeValue = new ExpectedAttributeValue(new AttributeValue().withS(autor.getAutorId()));
        expectedAttributeValueMap.put("autorId", expectedAttributeValue);
        DynamoDBSaveExpression saveExpression = new DynamoDBSaveExpression().withExpected(expectedAttributeValueMap);
        dynamoDBMapper.save(autor,saveExpression);
        return autor;
    }

    @Override
    public void deleteAutor (String autorId) {
        Autor autor = dynamoDBMapper.load(Autor.class,autorId);
        dynamoDBMapper.delete(autor);
    }

    @Override
    public List<Autor> getAllAutores() {
        final Map<String,AttributeValue> map = new HashMap<>();
        map.put("autorId", new AttributeValue("Autores:"));
        final DynamoDBQueryExpression<Autor> queryExpression = new DynamoDBQueryExpression<Autor>()
                .withKeyConditionExpression("autorId")
                .withExpressionAttributeValues(map);
        return dynamoDBMapper.query(Autor.class, queryExpression);

        /*
        List<Persona> personas = dynamoDBMapper.scan(Persona.class, new DynamoDBScanExpression());
        return personas;

         */
    }
}
