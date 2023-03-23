package com.sbs.IdH.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sbs.IdH.command.PageMaker;
import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dao.Co_AttachDAO;
import com.sbs.IdH.dao.CompanyruleDAO;
import com.sbs.IdH.dto.Co_AttachVO;
import com.sbs.IdH.dto.CompanyruleVO;


public class CompanyruleServiceImpl implements CompanyruleService {

   private CompanyruleDAO companyruleDAO;
   private Co_AttachDAO co_attachDAO;
   public void setCompanyruleDAO(CompanyruleDAO companyruleDAO) {
      this.companyruleDAO = companyruleDAO;
   }
   public void setCo_attachDAO(Co_AttachDAO co_attachDAO) {
      this.co_attachDAO = co_attachDAO;
   }

   @Override
   public Map<String, Object> selectCompanyruleList(SearchCriteria cri) throws SQLException {
      
      List<CompanyruleVO> companyruleList = companyruleDAO.selectCompanyruleCriteria(cri);
      if (companyruleList != null)
         for (CompanyruleVO companyrule : companyruleList)
          addAttachList(companyrule);

      PageMaker pageMaker = new PageMaker();
      pageMaker.setCri(cri);
      pageMaker.setTotalCount(companyruleDAO.selectCompanyruleCriteriaTotalCount(cri));

      Map<String, Object> dataMap = new HashMap<String, Object>();
      dataMap.put("companyruleList", companyruleList);
      dataMap.put("pageMaker", pageMaker);
      
      return dataMap;

   }

   @Override
   public void registCompanyrule(CompanyruleVO companyrule) throws SQLException {
      int companyrule_number = companyruleDAO.selectCompanySeqNextValue();
      companyrule.setCompanyrule_number(companyrule_number);
      companyruleDAO.insertCompanyrule(companyrule);
      if (companyrule.getAttachList() != null)
            for (Co_AttachVO attach :companyrule.getAttachList()) {
               attach.setCo_number(companyrule_number);
               attach.setCo_attach_attacher(companyrule.getCompanyrule_member_id());
               co_attachDAO.insertCo_Attach(attach);
            }

   }

   
   @Override
   public CompanyruleVO selectCompanyrule(int companyrule_number) throws SQLException {
      CompanyruleVO companyrule = companyruleDAO.selectCompanyrule(companyrule_number);

      return companyrule;
   }

   @Override
   public void modifyCompanyrule(CompanyruleVO companyrule_number) throws SQLException {
      
      companyruleDAO.updateCompanyrule(companyrule_number);
   }

   @Override
   public void removeCompanyrule(int companyrule_number) throws SQLException {
      companyruleDAO.deleteCompanyrule(companyrule_number);
   }
   
   private void addAttachList(CompanyruleVO companyrule) throws SQLException {

      if (companyrule == null)
         return;

      int companyrule_number = companyrule.getCompanyrule_number();
      List<Co_AttachVO> attachList = co_attachDAO.selectAttachesByCo_number(companyrule_number);

      companyrule.setCo_AttachList(attachList);
   
   }
   

   @Override
   public Co_AttachVO selectCo_AttachByAno(int ano) throws SQLException {
      Co_AttachVO co_attach = co_attachDAO.selectCo_AttachByAno(ano);

      return co_attach;

   }

   @Override
   public void removeCo_AttachByAno(int ano) throws SQLException {
      co_attachDAO.deleteCo_Attach(ano);

   }

}