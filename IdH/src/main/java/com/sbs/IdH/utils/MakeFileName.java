package com.sbs.IdH.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.sbs.IdH.dto.Issue_AttachVO;
import com.sbs.IdH.dto.Work_AttachVO;

public class MakeFileName {

	public static String toUUIDFileName(String fileName, String delimiter) {
		String uuid = UUID.randomUUID().toString().replace("-", "");
		return uuid + delimiter + fileName;
	}

	public static String parseFileNameFromUUID(String fileName, String delimiter) {
		String[] uuidFileName = fileName.split(delimiter);
		return uuidFileName[uuidFileName.length - 1];
	}

	public static List<Issue_AttachVO> parseFileNameFromIssue_Attaches(List<Issue_AttachVO> attachList, String delimiter) {

		List<Issue_AttachVO> renamedAttachList = new ArrayList<Issue_AttachVO>();

		if (attachList != null) {
			for (Issue_AttachVO attach : attachList) {
				String fileName = attach.getFileName(); // DB상의 fileName
				fileName = parseFileNameFromUUID(fileName, delimiter); // uuid가 제거된
				// fileName
				attach.setFileName(fileName);

				renamedAttachList.add(attach);
			}
		}
		return renamedAttachList;
	}

	public static List<Work_AttachVO> parseFileNameFromWork_Attaches(List<Work_AttachVO> attachList, String delimiter) {

		List<Work_AttachVO> renamedAttachList = new ArrayList<Work_AttachVO>();

		if (attachList != null) {
			for (Work_AttachVO attach : attachList) {
				String fileName = attach.getFileName(); // DB상의 fileName
				fileName = parseFileNameFromUUID(fileName, delimiter); // uuid가 제거된
// fileName
				attach.setFileName(fileName);

				renamedAttachList.add(attach);
			}
		}
		return renamedAttachList;
	}
}