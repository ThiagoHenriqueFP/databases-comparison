package br.edu.ufersa.dbcomparsion.cassandra;

import org.springframework.data.repository.CrudRepository;

public interface UserCassandraRepository extends CrudRepository<UserCassandra, String> {
}
