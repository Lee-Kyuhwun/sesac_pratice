package org.zerock.b01.controller;


import io.swagger.annotations.ApiOperation;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.b01.dto.upload.UploadFileDTO;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@RestController
@Log4j2
public class UpDownController {

    @Value("${org.zerock.upload.path}") // import 시에 springframework으로 싲가하는 Value
    private String uploadPath;




    @ApiOperation(value = "Upload POST", notes = "POST 방식으로 파일 등록")
    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String upload(UploadFileDTO uploadFileDTO){
        log.info(uploadFileDTO);

        if(uploadFileDTO.getFiles() != null){


            uploadFileDTO.getFiles().forEach(multipartFile -> {


                String originalName = multipartFile.getOriginalFilename();
                String uuid = UUID.randomUUID().toString();
                Path savePath = Paths.get(uploadPath, uuid + "_" + originalName);


                try{
                    multipartFile.transferTo(savePath);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                log.info(multipartFile.getOriginalFilename());
            });// end each
        }//end if


        return null;
    }

}



