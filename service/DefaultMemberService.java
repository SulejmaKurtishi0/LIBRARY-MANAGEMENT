package com.example.demo.service;

import com.example.demo.pojo.Member;
import com.example.demo.pojo.input.MemberInput;
import com.example.demo.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class DefaultMemberService implements MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    @Override
    public Member findMemberById(Integer id) {
        return memberRepository.findMemberById(id);
    }

    @Override
    public Member save(MemberInput memberInput) {


        String name = memberInput.getName();
        String surname = memberInput.getSurname();
        Integer nrbooks= memberInput.getNrbooks();

        Member member  = new Member();
        member.setName(name);
        member.setSurname(surname);
        member.setNrbooks(nrbooks);

        return memberRepository.save(member);
    }

    @Override
    public Member update(Integer id, MemberInput memberInput) {

        Member member= memberRepository.findMemberById(id);

        if (member == null) {
            return null;
        }
        String updatedName = memberInput.getName();
        String updatedSurname =  memberInput.getSurname();
        Integer updatedNrBooks = memberInput.getNrbooks();

        member.setName(updatedName);
        member.setSurname(updatedSurname);
        member.setNrbooks(updatedNrBooks);

        return memberRepository.save(member);
    }

    @Override
    public void delete(Integer id) {
        Member member= memberRepository.findMemberById(id);
        {
            if (member!= null) {
                memberRepository.delete(member);
            }
            memberRepository.delete(member);
        }


    }
}
