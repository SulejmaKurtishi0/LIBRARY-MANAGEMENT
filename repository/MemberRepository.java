package com.example.demo.repository;

import com.example.demo.pojo.Member;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends CrudRepository<Member, Integer> {
    List<Member> findAll();

    Member findMemberById(Integer id);
}