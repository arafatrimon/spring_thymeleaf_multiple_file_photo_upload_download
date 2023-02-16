package com.example.spring_web_thymeleaf_file_management.repository;

import com.example.spring_web_thymeleaf_file_management.model.UserFiles;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface UserFileRepository extends CrudRepository<UserFiles,Long> {
    @Query("select f from UserFiles as f where f.id=:userId")
    List<UserFiles> findFilesByUserId(@Param("userId") Long userId);
    @Modifying
    @Transactional
    @Query("delete  from UserFiles  as f where f.id=?1 and f.modifiedFileName in (?2)")
    void deleteFilesByUserIdAndImageNames(Long id, List<String> removeImages);
@Modifying
@Transactional
@Query("delete from  UserFiles  f where f.id=:userId")
    void deleteFilesByUserId(@Param("userId")  Long userId);
}
