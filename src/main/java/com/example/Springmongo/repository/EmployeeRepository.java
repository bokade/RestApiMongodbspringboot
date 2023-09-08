package com.example.Springmongo.repository;

import com.example.Springmongo.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, Long>
{

    List<Employee> findByName(String name);

    @Query(" { name: ?0 }")
    List<Employee> findByNameByQuery(String name);

    @Query(" { name: { $eq : ?0 } }")
    List<Employee> findByNameByQueryOperator(String name);

    @Query("{ salary: { $gt : ?0 } }")
    List<Employee> findEmployeeGreaterThan(Double salary);

    @Query("{ salary: { $lt : ?0 } }")
    List<Employee> findEmployeeLessThan(Double salary);

    @Query("{ $and: [ {salary : {$gt: ?0}},{salary: {$lt: ?1 } }]}")
    List<Employee> findEmployeeBetween(Double salary1,Double salary2);




}
