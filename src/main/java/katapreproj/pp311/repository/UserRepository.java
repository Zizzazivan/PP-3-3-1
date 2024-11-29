package katapreproj.pp311.repository;

import katapreproj.pp311.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
