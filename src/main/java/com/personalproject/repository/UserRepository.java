package com.personalproject.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.personalproject.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    @Autowired
    private DynamoDBMapper dynamoDBMapper;

    public User save(User user) {
        dynamoDBMapper.save(user);
        return user;
    }

    public User getUserById(String id) {
    return dynamoDBMapper.load(User.class, id);
    }

    public String deleteUserById(String id) {

    User deleteUser = dynamoDBMapper.load(User.class, id);

    dynamoDBMapper.delete(deleteUser);

    return "User deleted";
    }

    public String update(String userId, User user) {
        dynamoDBMapper.save(user, new DynamoDBSaveExpression()
                .withExpectedEntry("id" ,
                        new ExpectedAttributeValue(
                                new AttributeValue().withS(userId)
                        )));
        return userId;
    }
}
