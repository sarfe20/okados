
package com.example.Okados.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class UploadController {


    @PostMapping("/upload")
    public ResponseEntity<?> upload(@RequestPart("file") MultipartFile file) {
        // TODO: Cloudinary java sdk use ho rha hai yaha pr
        return ResponseEntity.ok(Map.of("image", new Object[]{}));
    }


    @PostMapping("/deleteImage")
    public ResponseEntity<?> delete(@RequestBody Map<String,String> body) {
        String publicId = body.get("public_id");
        // TODO: Cloudinary destroy ho rha hai
        return ResponseEntity.ok(Map.of("success", true, "message", "Not implemented - add Cloudinary SDK"));
    }
}
