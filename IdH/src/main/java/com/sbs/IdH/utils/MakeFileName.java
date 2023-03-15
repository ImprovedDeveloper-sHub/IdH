package com.sbs.IdH.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.sbs.IdH.dto.Business_attachVO;
import com.sbs.IdH.dto.Co_AttachVO;
import com.sbs.IdH.dto.Notice_attachVO;
import com.sbs.IdH.dto.Product_AttachVO;
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

	public static List<Notice_attachVO> parseFileNameFromNoticeAttaches(List<Notice_attachVO> attachList,
			String delimiter) {

		List<Notice_attachVO> renamedAttachList = new ArrayList<Notice_attachVO>();

		if (attachList != null) {

			for (Notice_attachVO attach : attachList) {

				String fileName = attach.getFilename(); // DB상의 fileName
				fileName = parseFileNameFromUUID(fileName, delimiter); // uuid가 제거된

				// fileName
				attach.setFilename(fileName);

				renamedAttachList.add(attach);

			}

		}

		return renamedAttachList;

	}

	public static List<Business_attachVO> parseFileNameFromBusinessAttaches(List<Business_attachVO> attachList,
			String delimiter) {

		List<Business_attachVO> renamedAttachList = new ArrayList<Business_attachVO>();

		if (attachList != null) {

			for (Business_attachVO attach : attachList) {

				String fileName = attach.getFilename(); // DB상의 fileName
				fileName = parseFileNameFromUUID(fileName, delimiter); // uuid가 제거된

				// fileName
				attach.setFilename(fileName);

				renamedAttachList.add(attach);

			}

		}

		return renamedAttachList;

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

	public static List<Co_AttachVO> parseFileNameFromCoAttaches(List<Co_AttachVO> attachList, String delimiter) {

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

	public static List<Product_AttachVO> parseFileNameFromProductAttaches(List<Product_AttachVO> attachList,
			String delimiter) {

		List<Product_AttachVO> renamedAttachList = new ArrayList<Product_AttachVO>();

		if (attachList != null) {
			for (Product_AttachVO attach : attachList) {
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
