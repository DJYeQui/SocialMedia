package com.example.socialmedia.repository;

import com.example.socialmedia.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity,Long> {
List<UserEntity> findUserEntitiesByFirstName (String firstName);
UserEntity findByUserNameAndPassword (String userName, String password);
}
