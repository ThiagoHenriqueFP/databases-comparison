package br.edu.ufersa.dbcomparsion.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserMongoRepository extends MongoRepository<UserMongo, String> {
}
