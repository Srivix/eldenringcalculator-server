package com.eldenringcalculator.weapon;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadFileServiceImpl implements UploadFileService{

	private final Logger log = LoggerFactory.getLogger(UploadFileServiceImpl.class);
	private final static String DIRECTORIO_UPLOAD = "uploads";
	
	@Override
	public Resource charge(String photoName) throws MalformedURLException {
		Path filePath = getPath(photoName);
		log.info(filePath.toString());
		
		Resource resource = new UrlResource(filePath.toUri());
		
		if(!resource.exists() && !resource.isReadable()) {
			filePath = Paths.get("src/main/resources/static/images").resolve("notuser.png").toAbsolutePath();
			
			resource = new UrlResource(filePath.toUri());
			
			log.error("Error no se pudo cargar la imagen: "+photoName);
		}
		
		return resource;
	}

	@Override
	public String copy(MultipartFile file) throws IOException {
		String fileName = UUID.randomUUID().toString()+"_"+file.getOriginalFilename().replace(" ", "");
		
		Path filePath = getPath(fileName);
		log.info(filePath.toString());
		
		Files.copy(file.getInputStream(), filePath);
		
		return fileName;
	}

	@Override
	public Path getPath(String photoName) {
		return Paths.get(DIRECTORIO_UPLOAD).resolve(photoName).toAbsolutePath();
	}

}
