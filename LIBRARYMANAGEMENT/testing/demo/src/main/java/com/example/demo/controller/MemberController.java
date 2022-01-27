package com.example.demo.controller;
import com.example.demo.pojo.Member;
import com.example.demo.pojo.input.MemberInput;
import com.example.demo.service.DefaultMemberService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class MemberController {
    @Autowired
    private DefaultMemberService memberService;

    @GetMapping("/member")
    public List<Member> getMember() {
        return memberService.findAll();
    }

    @GetMapping("/member/{id}")
    public Member getMemberById(@PathVariable Integer id) {
        return memberService.findMemberById(id);
    }

    @PostMapping("/member")
    public Member insertNewMember(@RequestBody MemberInput memberInput) {
        return memberService.save(memberInput);
    }

    @PutMapping("/member/{id}")
    public Member updateMember(@PathVariable Integer id,
                               @RequestBody MemberInput memberInput) {
        return memberService.update(id,memberInput);
    }

    @DeleteMapping("/member/{id}")
    public Boolean deleteMember(@PathVariable Integer id) {
        memberService.delete(id);
        return true;
    }
}
