package com.sbs.IdH.Service;

public class TestProductService {}
	/*
	private ProductService productService;// = new MemberServiceImpl();
	{
		String beanConfigXml = "build/classes/com/jsp/context/application-context.xml";
		try {
			ApplicationContextLoader.build(beanConfigXml);
			Map<String,Object> container = ApplicationContext.getApplicationContext();			
			memberService=(MemberService)container.get("memberService");
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	@Test
	public void testGetMember()throws Exception{
		String id = "mimi";
		
		MemberVO member = memberService.getMember(id);
		
		Assert.assertEquals(id, member.getId());
	} 	
	
	@Test
	public void testMemberList()throws Exception{
		SearchCriteria cri = new SearchCriteria();
		Map<String,Object> dataMap = memberService.getMemberListForPage(cri);

		List<MemberVO> memberList = (List<MemberVO>)dataMap.get("memberList");
		
		Assert.assertEquals(cri.getPerPageNum(),memberList.size() );
	}
	
}






}
*/