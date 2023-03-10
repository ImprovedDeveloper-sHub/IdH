package com.sbs.IdH.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.sbs.IdH.dto.Co_AttachVO;

public class MakeFileName {
	
		public static String toUUIDFileName(String fileName, String delimiter) {
			String uuid = UUID.randomUUID().toString().replace("-", "");
			return uuid + delimiter + fileName;
		}

		public static String parseFileNameFromUUID(String fileName, String delimiter) {
			String[] uuidFileName = fileName.split(delimiter);
			return uuidFileName[uuidFileName.length - 1];
		}

		public static List<Co_AttachVO> parseFileNameFromAttaches(List<Co_AttachVO> attachList,
																String delimiter) {

			List<Co_AttachVO> renamedAttachList = new ArrayList<Co_AttachVO>();

			if (attachList != null) {
				for (Co_AttachVO attach : attachList) {
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


