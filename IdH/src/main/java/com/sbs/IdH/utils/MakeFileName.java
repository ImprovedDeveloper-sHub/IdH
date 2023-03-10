package com.sbs.IdH.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.sbs.IdH.dto.Require_attachVO;

public class MakeFileName {

	public static String toUUIDFileName(String fileName, String delimiter) {
		String uuid = UUID.randomUUID().toString().replace("-", "");
		return uuid + delimiter + fileName;
	}

	public static String parseFileNameFromUUID(String fileName, String delimiter) {
		String[] uuidFileName = fileName.split(delimiter);
		return uuidFileName[uuidFileName.length - 1];
	}

	public static List<Require_attachVO> parseFileNameFromAttaches(List<Require_attachVO> attachList,
															String delimiter) {

		List<Require_attachVO> renamedAttachList = new ArrayList<Require_attachVO>();

		if (attachList != null) {
			for (Require_attachVO attach : attachList) {
				String fileName = attach.getFilename(); // DB상의 fileName
				fileName = parseFileNameFromUUID(fileName, delimiter); // uuid가 제거된
				// fileName
				attach.setFilename(fileName);

				renamedAttachList.add(attach);
			}
		}
		return renamedAttachList;
	}
}
