package ec.gob.educacion.uploadfiles.service.impl;

import java.io.IOException;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import ec.gob.educacion.uploadfiles.entity.UploadFiles;
import ec.gob.educacion.uploadfiles.repository.UploadFilesRepository;
import ec.gob.educacion.uploadfiles.service.UploadFilesService;

public class UploadFilesServiceImpl implements UploadFilesService{

	  @Autowired
	  private UploadFilesRepository uploadfilesRepository;

	  public UploadFiles store(MultipartFile file) throws IOException  {
	    String fileName = StringUtils.cleanPath(file.getOriginalFilename());
	    UploadFiles files = new UploadFiles(fileName, file.getContentType(), file.getBytes());

	    return uploadfilesRepository.save(files);
	  }

	  public UploadFiles getFile(Integer id) {
	    return uploadfilesRepository.findById(id).get();
	  }
	  
	  public Stream<UploadFiles> getAllFiles() {
	    return uploadfilesRepository.findAll().stream();
	  }

}
