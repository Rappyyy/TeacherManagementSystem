package com.personalproject.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DynamoDbConfiguration {

    @Bean
    public DynamoDBMapper dynamoDBMapper() {
        return new DynamoDBMapper(buildAmazonDynamoDB());
    }


    private AmazonDynamoDB buildAmazonDynamoDB() {
        return AmazonDynamoDBClientBuilder
                .standard()
                .withEndpointConfiguration(
                        new AwsClientBuilder.EndpointConfiguration(
                                "dynamodb.ap-southeast-1.amazonaws.com",
                                "ap-southeast-1"
                        )
                )
                .withCredentials(
                        new AWSStaticCredentialsProvider(
                                new BasicAWSCredentials(
                                "AKIAYVV7C3PV5O5KPOVJ",
                                "bG6jtb/vUE4A1DkZI0RXnLw+T9C4oYyPdD3xDgOs"
                        ))
                )
                .build();
    }


}
