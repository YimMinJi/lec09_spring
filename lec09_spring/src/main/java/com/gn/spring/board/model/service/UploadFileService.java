package com.gn.spring.board.model.service;

import java.io.File;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadFileService {
	
	
	
	// 사진 등록하는 방법
	public String upload(MultipartFile file) {
		// UUID로 바꾼 언어를 리턴해줘야한다.
		String newFileName = "";
		try {
		// 2024-08-02 파일 저장 시작 11:05
		// 1. 파일을 저장
		String fileOriName = file.getOriginalFilename();
		// 파일 자른다(.을 기준으로 파일명과 확장자 자른다.)
		// 일단 자른다! (Api 수업때 햇대)
		String fileExtension = fileOriName.substring(fileOriName.lastIndexOf("."),fileOriName.length());
		// 파일 명칭 바꾸기 ==> UUID(버전4) -> 8자리를 기준으로 -이찍힌대, 특수문자는 안들어가는게 좋대
		UUID uuid = UUID.randomUUID();
		// 그래서 8자리 마다 포함되는 (-)하이픈을 제거할거야
		String uniqueName = uuid.toString().replace("-", "");
		// 새로운 파일명
		newFileName = uniqueName+fileExtension;
		//파일 저장 경로 설정해줄거야
		String uploadDir = "C:\\board\\upload";
		// 파일 생성 , io import 받아와 ==> 껍데기만 잇을예정이야
		File saveFile = new File(uploadDir + "\\" +uniqueName+fileExtension);
		
		// 만약에 껍데기가 이미 있다면, 경로를 재설정 해줘야할 수도 있어
		if(!saveFile.exists()) {
			saveFile.mkdirs();
		}
		// 파일 껍데기에 파일 정보를 복제해준다.
		file.transferTo(saveFile); // 얘를 보내줘요 어디에다? saveFile에다가, 
		// 문제가 생겼어요. try~catch문으로 감싸줄게요
		
	}catch(Exception e) {
		e.printStackTrace();
	}
		return newFileName;
	}
}