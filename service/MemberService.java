package com.example.demo.service;


import com.example.demo.pojo.Member;
import com.example.demo.pojo.input.MemberInput;

import java.util.List;

public interface MemberService {
    List<Member> findAll();
    Member findMemberById(Integer id);
    Member save(MemberInput memberInput);
    Member update(Integer id, MemberInput memberInput);
    void delete(Integer id);
}
