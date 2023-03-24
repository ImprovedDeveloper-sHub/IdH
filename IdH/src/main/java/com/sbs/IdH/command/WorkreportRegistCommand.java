package com.sbs.IdH.command;

import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.sbs.IdH.dto.WorkreportVO;

public class WorkreportRegistCommand {

   private int workreport_number;
   private int workreport_project_number;
   private String workreport_setter;// 보낸사람
   private int workreport_check;
   private Date workreport_regdate;
   private Date workreport_enddate;
   private String workreport_getter;// 받는사람
   private String workreport_title;
   private String workreport_content;
   private int workreport_memstatus;
   private List<MultipartFile> uploadFile;

   public int getWorkreport_number() {
      return workreport_number;
   }

   public void setWorkreport_number(int workreport_number) {
      this.workreport_number = workreport_number;
   }

   public int getWorkreport_project_number() {
      return workreport_project_number;
   }

   public void setWorkreport_project_number(int workreport_project_number) {
      this.workreport_project_number = workreport_project_number;
   }

   public int getWorkreport_check() {
      return workreport_check;
   }

   public void setWorkreport_check(int workreport_check) {
      this.workreport_check = workreport_check;
   }

   public Date getWorkreport_regdate() {
      return workreport_regdate;
   }

   public void setWorkreport_regdate(Date workreport_regdate) {
      this.workreport_regdate = workreport_regdate;
   }

   public Date getWorkreport_enddate() {
      return workreport_enddate;
   }

   public void setWorkreport_enddate(Date workreport_enddate) {
      this.workreport_enddate = workreport_enddate;
   }

   public int getWorkreport_memstatus() {
      return workreport_memstatus;
   }

   public void setWorkreport_memstatus(int workreport_memstatus) {
      this.workreport_memstatus = workreport_memstatus;
   }

   public String getWorkreport_setter() {
      return workreport_setter;
   }

   public void setWorkreport_setter(String workreport_setter) {
      this.workreport_setter = workreport_setter;
   }

   public String getWorkreport_getter() {
      return workreport_getter;
   }

   public void setWorkreport_getter(String workreport_getter) {
      this.workreport_getter = workreport_getter;
   }

   public String getWorkreport_title() {
      return workreport_title;
   }

   public void setWorkreport_title(String workreport_title) {
      this.workreport_title = workreport_title;
   }

   public String getWorkreport_content() {
      return workreport_content;
   }

   public void setWorkreport_content(String workreport_content) {
      this.workreport_content = workreport_content;
   }

   public List<MultipartFile> getUploadFile() {
      return uploadFile;
   }

   public void setUploadFile(List<MultipartFile> uploadFile) {
      this.uploadFile = uploadFile;
   }

   public WorkreportVO toWorkreportVO() {
      WorkreportVO workreport = new WorkreportVO();
      workreport.setWorkreport_title(workreport_title);
      workreport.setWorkreport_content(this.workreport_content);
      workreport.setWorkreport_setter(this.workreport_setter);
      workreport.setWorkreport_getter(this.workreport_getter);
      workreport.setWorkreport_memstatus(this.workreport_memstatus);
      workreport.setWorkreport_project_number(this.workreport_project_number);
      workreport.setWorkreport_check(this.workreport_check);

      return workreport;
   }
}