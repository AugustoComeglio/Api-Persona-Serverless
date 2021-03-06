package com.api.entities;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@DynamoDBTable(tableName = "autor")
public class Autor  {

	@DynamoDBHashKey(attributeName = "autorId")
	private String autorId;

	@DynamoDBAttribute(attributeName = "nombre")
	private String nombre;

	@DynamoDBAttribute(attributeName = "apellido")
	private String apellido;

	@DynamoDBAttribute(attributeName = "biografia")
	private String biografia;
}
