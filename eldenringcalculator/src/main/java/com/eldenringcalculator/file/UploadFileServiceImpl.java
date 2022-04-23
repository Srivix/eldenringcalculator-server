package com.eldenringcalculator.file;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadFileServiceImpl implements UploadFileService{

	private final static String UPLOAD_DIRECTORY = "uploads";
	
	@Override
	public Resource charge(String photoName) throws MalformedURLException {
		
		Path filePath = getPath(photoName);
		
		Resource resource = new UrlResource(filePath.toUri());
		
		if(!resource.exists() && !resource.isReadable()) {
			filePath = Paths.get("src/main/resources/static/").resolve("notweapon.jpg").toAbsolutePath();
			
			resource = new UrlResource(filePath.toUri());
		}
		
		return resource;
	}

	@Override
	public String copy(MultipartFile file) throws IOException {
		String fileName = UUID.randomUUID().toString()+"_"+file.getOriginalFilename().replace(" ", "");
		
		Path filePath = getPath(fileName);
		
		Files.copy(file.getInputStream(), filePath);
		
		return fileName;
	}

	@Override
	public Path getPath(String photoName) {
		return Paths.get(UPLOAD_DIRECTORY).resolve(photoName).toAbsolutePath();
	}

	@Override
	public boolean delete(String photoName) {
		
		if(photoName !=null && photoName.length() >0) {
			
			Path oldPhotoPath = Paths.get("uploads").resolve(photoName).toAbsolutePath();
			
			File oldFilePhoto = oldPhotoPath.toFile();
			
			if(oldFilePhoto.exists() && oldFilePhoto.canRead()) {
				oldFilePhoto.delete();
				return true;
			}
		}
			
		return false;
		
	}

}
