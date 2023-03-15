package com.sbs.IdH.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.sbs.IdH.dto.MemberVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:com/sbs/IdH/context/root-context.xml")
@Transactional
public class TestMemberService {

	@Autowired
	private MemberService memberService;

//	@Test
//	public void selectMember() throws Exception {
//		
//		MemberVO member = memberService.selectMember("IdH");
//		System.out.println(member);
//	}

//	@Test
//	public void selectMemberList() throws Exception {
//		SearchCriteria cri = new SearchCriteria();
//		memberService.selectMemberList(cri);
//
//	}
//
//
//	@Test
//	public void registMember() throws Exception {
//
//		MemberVO member = new MemberVO("aa", "aa", "aa", "aaa", "111111111",
//				null, 2, 1, "aa");
//		memberService.registMember(member);
//		MemberVO member2 = memberService.selectMember("abcabc");
//
//	}
//
	@Test
	public void updateMember() throws Exception {

		MemberVO member1 = memberService.selectMember("abcabc");
		memberService.modifyMember(member1);
		member1 = memberService.selectMember("abcabc");
		memberService.modifyMember(member1);
		member1 = memberService.selectMember("abcabc");

	}
//
//	@Test
//	public void Deletemember() throws Exception {
//
//		MemberVO member1 = memberService.selectMember("abc");
//		memberService.removeMember("abc");
//		MemberVO member2 = memberService.selectMember("abc");
//
//	}

}