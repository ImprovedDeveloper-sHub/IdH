package com.sbs.IdH.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sbs.IdH.command.PageMaker;
import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dao.RequireDAO;
import com.sbs.IdH.dto.RequireVO;

public class RequireServiceImpl implements RequireService {

	private RequireDAO requireDAO;
	public void setRequireDAO(RequireDAO requireDAO) {
		this.requireDAO = requireDAO;
	}

//	private Require_attachDAO require_attachDAO;
	
	@Override
	public Map<String, Object> selectRequireList(SearchCriteria cri) throws SQLException {
		List<RequireVO> requireList = requireDAO.selectSearchRequireList(cri);

//		if (requireList != null)
//			for (RequireVO require : requireList)
//				addAttachList(require);

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

//		if (require.getAttachList() != null)
//			for (Require_attachVO attach : require.getRequire_attachList()) {
//				attach.setRequire_number(require_number);
//				attach.setRequire_writer_id(require.getRequire_writer_id());
//				require_attachDAO.insertAttach(attach);
//			}

		
	}

	@Override
	public RequireVO selectRequire(int require_number) throws SQLException {
		RequireVO require = requireDAO.selectRequire(require_number);
//		addRequre_attachList(require);

		return require;
	}

	@Override
	public void modifyRequire(RequireVO require) throws SQLException {
		
		requireDAO.updateRequire(require);
		// attachDAO.deleteAllAttach(pds.getPno());

//		if (require.getAttachList() != null)
//			for (Require_attachVO attach : require.getAttachList()) {
//				attach.setRequire_number(require.getRequire_number());
//				attach.setAttacher(require.getRequire_writer_id());
//				require_attachDAO.insertAttach(attach);
//
//			}

	}
		
	

	@Override
	public void removeRequire(int require_number) throws SQLException {
		
		requireDAO.deleteRequire(require_number);
		
	}

	
	
}
