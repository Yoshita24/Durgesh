package com.jpa.example.course_jpa_example.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jpa.example.course_jpa_example.entities.*;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    //ReturnType findBy<Property>(Type value)
    Optional<User> findByEmail(String value);
    List<User> findByName(String name);
    List<User> findByNameAndEmail(String name,String email);
    List<User> findByNameOrEmail(String name,String email);
    int countByName(String name);


    boolean existsByEmail(String email);

    List<User> findByNameContaining(String nameKeyword);
    List<User> findByNameLike(String pattern);
    @Query(value="select * from jpa_users",nativeQuery = true)
    public List<User> getUsers();

    @NativeQuery(value = "select * from jpa_users where email =:email")
    public List<User> getUsersByEmail(@Param("email") String email);

    @NativeQuery(value = "select * from jpa_users where name =:name AND email =:email")
    public List<User> getUserByEmailAndName(@Param("name") String name,@Param("email") String email);

    //HQL/JPQL -- it works on entity field and not on table column

    @Query(value = "select u from User u where u.email =:email and u.name =:name")
    public List<User> getUser1(@Param("name") String name,@Param("email") String email);

    @Query(value = "select u from User u where u.address.city =:city")
    public List<User> getUsersByCity(@Param("city") String city);

}
