package br.edu.ufersa.dbcomparsion.postgres;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPostgresRepository extends JpaRepository<UserPostgres, String> {
}
