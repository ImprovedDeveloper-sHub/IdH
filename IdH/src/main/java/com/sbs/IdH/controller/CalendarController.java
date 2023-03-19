package com.sbs.IdH.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dto.CalendarVO;
import com.sbs.IdH.dto.MemberVO;
import com.sbs.IdH.dto.ScheduleVO;
import com.sbs.IdH.service.ScheduleService;
import com.sbs.IdH.service.UnitworkService;

@Controller
@RequestMapping("/calendar")
public class CalendarController {

	@Resource(name = "scheduleService")
	ScheduleService scheduleService;
	
	@Resource(name = "unitworkService")
	UnitworkService unitworkService;

	@GetMapping("/main")
	public ModelAndView main(ModelAndView mnv, SearchCriteria cri) throws Exception {
		// model.addAllObjects();
		
		  CalendarVO cal = new CalendarVO(); Map<String,Object> dataMap = new
		  HashMap<String,Object>(); dataMap.put("eventData", cal);
		  dataMap.put("test","test"); mnv.addAllObjects(dataMap);
		 
		
		  List<CalendarVO> testList = new ArrayList<CalendarVO>(); CalendarVO cal1 =
		  new CalendarVO(); cal1.setTitle("일정1"); CalendarVO cal2 = new CalendarVO();
		  cal2.setTitle("일정2"); testList.add(cal1); testList.add(cal2);
		  mnv.addObject("cal1", cal1);
		 
		// mnv.addAllObjects(scheduleService.selectScheduleList(cri));
		// model.addAllAttributes(scheduleService.selectScheduleList(cri));
		return mnv;
	}
	
	
	@GetMapping("/test")
	public void test() {}

	@GetMapping("/getCalendar2")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> getCalendar() throws Exception {
		ResponseEntity<Map<String, Object>> entity = null;
		HttpStatus status;
		//Map<String, Object> dataMap = null;
		List<CalendarVO> testList = new ArrayList<CalendarVO>();
		CalendarVO cal1 = new CalendarVO();
		cal1.setTitle("일정1"); CalendarVO cal2 = new CalendarVO();
		cal2.setTitle("일정2"); 
		testList.add(cal1); testList.add(cal2);
		Map<String,Object> dataMap = new HashMap<String,Object>();
		dataMap.put("testList", testList);
		try {
			//SearchCriteria cri = new SearchCriteria();
			//dataMap = scheduleService.selectScheduleList(cri);
			status = HttpStatus.OK;
		} catch (Exception e) {
			status = HttpStatus.BAD_REQUEST;
		}
		entity = new ResponseEntity<Map<String, Object>>(dataMap, status);

		return entity;
	}


	/*
	 * @GetMapping("/getCalendar")
	 * 
	 * @ResponseBody public List<CalendarVO> getPlan(int business_number) throws
	 * Exception { ResponseEntity<List<CalendarVO>> entity = null; // new
	 * ResponseEntity<Map<String,Object>>() List<CalendarVO> testList = new
	 * ArrayList<CalendarVO>(); CalendarVO cal1 = new CalendarVO();
	 * cal1.setTitle("일정1"); CalendarVO cal2 = new CalendarVO();
	 * cal2.setTitle("일정2"); testList.add(cal1); testList.add(cal2);
	 * 
	 * return testList; }
	 */

	@PostMapping("/regist")
	@ResponseBody
	public void regist(Model model, @RequestBody ScheduleVO schedule, SearchCriteria cri) throws Exception {

		scheduleService.registSchedule(schedule);
		// model.addAllAttributes(scheduleService.selectScheduleList(cri));

	}

	@PostMapping("/update")
	@ResponseBody
	public void update(Model model, @RequestBody ScheduleVO schedule, SearchCriteria cri) throws Exception {

		scheduleService.modifySchedule(schedule);
		model.addAllAttributes(scheduleService.selectScheduleList(cri));
	}

	@PostMapping("/delete")
	@ResponseBody
	public void delete(Model model, int schedule_number, SearchCriteria cri) throws Exception {
		scheduleService.removeSchedule(schedule_number);
		model.addAllAttributes(scheduleService.selectScheduleList(cri));
	}

}
