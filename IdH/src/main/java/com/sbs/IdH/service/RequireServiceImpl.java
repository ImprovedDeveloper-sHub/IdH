package com.sbs.IdH.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sbs.IdH.command.PageMaker;
import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dao.RequireDAO;
import com.sbs.IdH.dao.Require_attachDAO;
import com.sbs.IdH.dto.RequireVO;
import com.sbs.IdH.dto.Require_attachVO;

public class RequireServiceImpl implements RequireService {

	private RequireDAO requireDAO;
	private Require_attachDAO require_attachDAO;
	public void setRequireDAO(RequireDAO requireDAO) {
		this.requireDAO = requireDAO;
	}

	public void setRequire_attachDAO(Require_attachDAO require_attachDAO) {
		this.require_attachDAO = require_attachDAO;
	}

	@Override
	public Map<String, Object> selectRequireList(SearchCriteria cri) throws SQLException {
		List<RequireVO> requireList = requireDAO.selectSearchRequireList(cri);

		if (requireList != null)
			for (RequireVO require : requireList)
				addAttachList(require);

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(requireDAO.selectSearchRequireListCount(cri));

		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("requireList", requireList);
		dataMap.put("pageMaker", pageMaker);

		return dataMap;
	}

	@Override
	public void registRequire(RequireVO require) throws SQLException {
		
		int require_number = requireDAO.selectRequireSeqNext();

		require.setRequire_number(require_number);
		requireDAO.insertRequire(require);

		if (require.getAttachList() != null)
			for (Require_attachVO attach : require.getAttachList()) {
				attach.setRequire_number(require_number);
				attach.setRequire_attach_attacher(require.getRequire_writer_id());
				require_attachDAO.insertRequire_attach(attach);
			}

		
	}

	@Override
	public RequireVO selectRequire(int require_number) throws SQLException {
		RequireVO require = requireDAO.selectRequire(require_number);
		addAttachList(require);

		return require;
	}

	@Override
	public void modifyRequire(RequireVO require) throws SQLException {
		
		requireDAO.updateRequire(require);
		require_attachDAO.deleteAllRequire_attach(require.getRequire_number());

		if (require.getAttachList() != null)
			for (Require_attachVO attach : require.getAttachList()) {
				attach.setRequire_number(require.getRequire_number());
				attach.setRequire_attach_attacher(require.getRequire_writer_id());
				require_attachDAO.insertRequire_attach(attach);

			}

	}
		
	

	@Override
	public void removeRequire(int require_number) throws SQLException {
		
		requireDAO.deleteRequire(require_number);
		
	}
	



	@Override
	public Require_attachVO getRequire_attachByAno(int ano) throws SQLException {
		
		Require_attachVO attach = require_attachDAO.selectAttachByAno(ano);

		return attach;
	}

	@Override
	public void removeRequire_attach_Ano(int ano) throws SQLException {

		require_attachDAO.deleteRequire_attach(ano);
		
	}
	
	private void addAttachList(RequireVO require) throws SQLException {
		
		if (require == null)
			return;
		
		int require_attach_number = require.getRequire_number();
		List<Require_attachVO> attachList = require_attachDAO.selectRequire_attachsByRequire_number(require_attach_number);
		
		require.setAttachList(attachList);
	}
	
}
