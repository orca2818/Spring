package ncs.r4a118.shop;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URI;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class PhotoControl {
	@PostMapping("/product/upload")
	private ResponseEntity<Void> upload(@RequestParam("upload") MultipartFile file){

		if (file.isEmpty() || file == null) {
			//err
		}

		//ファイルアップロード
		try {
			System.out.println(file.getOriginalFilename());
			File uploadFile = new File(ProductControl.PHOTO_DIR + "/" + file.getOriginalFilename());
			byte[] bytes = file.getBytes();
			//書き込み
			try(var stream = new BufferedOutputStream(new FileOutputStream(uploadFile))){
				stream.write(bytes);
			};
		} catch (Exception e) {}

		return ResponseEntity.status(HttpStatus.FOUND).location(URI.create("/LecSpring/product/photo")).build();
	}
}
