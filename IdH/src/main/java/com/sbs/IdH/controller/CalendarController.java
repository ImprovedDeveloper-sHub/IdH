package com.sbs.IdH.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

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
import com.sbs.IdH.dto.ScheduleVO;
import com.sbs.IdH.service.ScheduleService;

@Controller
@RequestMapping("/calendar")
public class CalendarController {

	
	@Resource(name="scheduleService")
	ScheduleService scheduleService;
	
	@GetMapping("/main")
	public ModelAndView main(ModelAndView mnv, SearchCriteria cri) throws Exception {
		//model.addAllObjects();
		CalendarVO cal = new CalendarVO();
	    Map<String,Object> dataMap = new HashMap<String,Object>();
	    dataMap.put("eventData", cal);
	    dataMap.put("test","test");
	    mnv.addAllObjects(dataMap);
	    mnv.addObject("test2", "test2");
		//model.addAllAttributes(scheduleService.selectScheduleList(cri));
		return mnv;
	}
	
	@PostMapping("/regist")
	@ResponseBody
	public void regist(Model model, @RequestBody ScheduleVO schedule, SearchCriteria cri) throws Exception {
	    
	    scheduleService.registSchedule(schedule);
	    //model.addAllAttributes(scheduleService.selectScheduleList(cri));
	    
	   
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
