package com.sbs.IdH.dao;

import org.junit.Assert;
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
public class TestMemberDAO {

	@Autowired
	private MemberDAO memberDAO;

//	@Test
//	public void getMemberList() throws Exception {
//		SearchCriteria cri = new SearchCriteria(1, 100, "p", "0");
//
//		List<MemberVO> memberList = memberDAO.selectSearchMemberList(cri);
//
//		Assert.assertEquals(2, memberList.size());
//	}

//   @Test
//   public void testGetMember() throws Exception{
//	   String id = "abcabc";		
//		
//		MemberVO member = memberDAO.selectMember(id);
//		
//		Assert.assertEquals(id, member.getMember_id());
//   }
//   
//   @Test
//	public void testSelectMemberListCount() throws Exception{
//		SearchCriteria cri = new SearchCriteria();
//		int count = memberDAO.selectSearchMemberListCount(cri);
//		Assert.notNull(count);
//	}
// @Test
// public void testInsertMebmer() throws Exception {
//	 Calendar cal = Calendar.getInstance();
//	 MemberVO member = new MemberVO("aaa","1212","tt","absdfab","12341234",new Date(cal.getTimeInMillis()),1,1,"ssIdH");
//	 memberDAO.insertMember(member); 
//     MemberVO member2 = memberDAO.selectMember("aaa");
//           
//     Assert.assertEquals(member, member2);
// }
//
//	
	@Test
	public void testUpdateMember() throws Exception{
		String targetID = "abcabc";
		
		MemberVO targetMember = memberDAO.selectMember(targetID);
		targetMember.setMember_name("kakaka");
		targetMember.setMember_pwd("abdabd");
		
		memberDAO.updateMember(targetMember);
		MemberVO getMember = memberDAO.selectMember(targetID);
		
		Assert.assertEquals(targetMember.getMember_name(), getMember.getMember_name());		
		Assert.assertEquals(targetMember.getMember_pwd(), getMember.getMember_pwd());
	}

	
//
//	@Test
//	public void testDeleteMember() throws Exception{
//		String target = "asdf";
//		
//		MemberVO deleteMember = memberDAO.selectMember(target);		
//		Assert.assertNotNull(deleteMember);
//		
//		memberDAO.deleteMember(target);
//		
//		MemberVO getMember =memberDAO.selectMember(target);
//		Assert.assertNull(getMember);
//	}

}