package com.sbs.IdH.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sbs.IdH.dto.MemberVO;
import com.sbs.IdH.exception.InvalidPasswordException;
import com.sbs.IdH.exception.NotFoundIdException;
import com.sbs.IdH.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {

	@Resource(name = "memberService")
	private MemberService memberService;
	
	@GetMapping("/registForm")
	public String registForm() {
		String url = "/member/regist";
		return url;
	}

	@GetMapping("/loginForm")
	public String loginForm() {
		String url = "/member/login";
		return url;
	}

	@GetMapping("/main")
	public void main() {}
	
	
	@PostMapping("/login")
	public String login(String member_id, String member_pwd, HttpSession session,RedirectAttributes rttr) throws Exception {
		String url = "redirect:/index";
		try {
			memberService.login(member_id, member_pwd);
			session.setAttribute("loginUser", memberService.selectMember(member_id));
		} catch (NotFoundIdException | InvalidPasswordException e) {
			url = "redirect:/loginForm";
			
			/*
			 * rttr.addFlashAttribute("message",e.getMessage());
			 * rttr.addFlashAttribute("member_id", member_id);
			 */
		} 
		return url;
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		String url = "redirect:/member/loginForm";
		session.invalidate();
		return url;
	}
	
	
	@PostMapping("/regist")
	public String regist(MemberVO member,HttpServletRequest request,
						 RedirectAttributes rttr) throws Exception {
		String url = "redirect:/member/login";
		
		String XSSname = (String)request.getAttribute("XSSname");
		if(XSSname !=null) member.setMember_name(XSSname);
		
		memberService.registMember(member);

		rttr.addFlashAttribute("member",member);
		rttr.addAttribute("from","regist");
		
		return url;
	}

	
//	@Resource(name = "picturePath")
//	private String picturePath;
//
//	public String savePicture(String oldPicture, MultipartFile multi) throws Exception {
//		/* 저장 파일명 */
//		String fileName = null;
//		/* 파일저장폴더설정 */
//		String uploadPath = this.picturePath;
//		/* 파일유무확인 */
//		if (!(multi == null || multi.isEmpty() || multi.getSize() > 1024 * 1024 * 1)) {
//			fileName = MakeFileName.toUUIDFileName(multi.getOriginalFilename(), "$$");
//			File storeFile = new File(uploadPath, fileName);
//
//			// 파일경로 생성
//			storeFile.mkdirs();
//
//			// local HDD 에 저장.
//			multi.transferTo(storeFile);
//		}
//
//		// 기존파일 삭제
//		if (oldPicture != null && !oldPicture.isEmpty()) {
//			File oldFile = new File(uploadPath, oldPicture);
//			if (oldFile.exists()) {
//				oldFile.delete();
//			}
//		}
//		return fileName;
//	}

//	@PostMapping(value = "/picture", produces = "text/plain;charset=utf-8")
//	@ResponseBody
//	public ResponseEntity<String> pictureUpload(@RequestParam("pictureFile") MultipartFile multi, String oldPicture)
//			throws Exception {
//
//		ResponseEntity<String> entity = null;
//		String result = "";
//		HttpStatus status = null;
//
//		/* 파일저장확인 */
//		if ((result = savePicture(oldPicture, multi)) == null) {
//			result = "파일이 없습니다.!";
//			status = HttpStatus.BAD_REQUEST;
//		} else {
//			status = HttpStatus.OK;
//
//		}
//
//		entity = new ResponseEntity<String>(result, status);
//		return entity;
//
//	}

	@GetMapping("/idCheck")
	@ResponseBody
	public ResponseEntity<String> idCheck(String member_id) throws Exception {
		ResponseEntity<String> entity = null;

		MemberVO member = memberService.selectMember(member_id);

		if (member != null) {
			entity = new ResponseEntity<String>("duplicated", HttpStatus.OK);
		} else {
			entity = new ResponseEntity<String>("", HttpStatus.OK);
		}

		return entity;
	}

//	@GetMapping("/getPicture")
//	public ResponseEntity<byte[]> getPicture(String member_id) throws Exception {
//
//		MemberVO member = memberService.selectMember(member_id);
//
//		if(member==null) return new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
//		
//		String picture = member.getMember_picture();
//		String imgPath = this.picturePath;
//
//		InputStream in = null;
//		ResponseEntity<byte[]> entity = null;
//
//		try {
//			in = new FileInputStream(new File(imgPath, picture));
//
//			// IOUtils.toByteArray() : <img src="">, style:background-url 만 사용...
//			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), HttpStatus.OK);
//		} finally {
//			if (in != null)
//				in.close();
//		}
//		return entity;
//	}

}
