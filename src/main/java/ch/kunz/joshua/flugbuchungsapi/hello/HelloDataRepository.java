package ch.kunz.joshua.flugbuchungsapi.hello;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HelloDataRepository extends JpaRepository<HelloData, Long> {
}
