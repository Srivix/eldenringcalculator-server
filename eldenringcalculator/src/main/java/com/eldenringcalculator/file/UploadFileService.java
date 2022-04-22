package com.eldenringcalculator.file;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface UploadFileService {
	
	public Resource charge(String photoName) throws MalformedURLException;
	public String copy(MultipartFile file) throws IOException;
	public Path getPath(String photoName);

}