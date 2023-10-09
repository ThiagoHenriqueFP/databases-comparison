package br.edu.ufersa.dbcomparsion.cassandra;

import org.springframework.data.cassandra.repository.CassandraRepository;

public interface UserCassandraRepository extends CassandraRepository<UserCassandra, String> {
}
