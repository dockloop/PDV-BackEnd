package backend.pdv.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import backend.pdv.entities.User;


public interface UserRepository extends JpaRepository<User, Long>{
    

    User findByLogin(String subject);
}
