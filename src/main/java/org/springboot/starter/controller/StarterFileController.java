package org.springboot.starter.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springboot.starter.model.UploadFileResponseModel;
import org.springboot.starter.service.impl.StorageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/filehandler")
public class StarterFileController {

	public static final Logger LOGGER = LoggerFactory.getLogger(StarterFileController.class);
	@Value("{$file.upload.dir}")
	String uploaddireactory;

	@Autowired
	private StorageServiceImpl storageService;


	@PostMapping("/uploadMultipleFiles")
	public List<UploadFileResponseModel> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
		return Arrays.asList(files).stream().map(file -> {
			try {
				return uploadFile(file);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}).collect(Collectors.toList());
	}

	@PostMapping("/uploadFile")
	public UploadFileResponseModel uploadFile(@RequestParam("file") MultipartFile file) throws Exception {
		String fileName = storageService.storeFile(file);
		LOGGER.info("Upload file name: " + fileName);
		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/downloadFile/")
				.path(fileName).toUriString();
		LOGGER.info("File upload path: " + fileDownloadUri);
		UploadFileResponseModel fileResponseModel = new UploadFileResponseModel();
		fileResponseModel.setFileName(fileName);
		fileResponseModel.setFileDownloadUri(fileDownloadUri);
		fileResponseModel.setFileType(file.getContentType());
		fileResponseModel.setSize(file.getSize());
		LOGGER.info("File upload has been completed..: ");
		return fileResponseModel;
	}
}
