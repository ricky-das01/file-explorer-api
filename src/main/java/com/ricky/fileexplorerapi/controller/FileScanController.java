package com.ricky.fileexplorerapi.controller;

import com.ricky.fileexplorerapi.model.ErrorResponse;
import com.ricky.fileexplorerapi.model.FileNode;
import com.ricky.fileexplorerapi.util.FileScanner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

@RestController
public class FileScanController {

    @GetMapping("/scan")
    public ResponseEntity<?> scan(@RequestParam String path) {

        File file = new File(path);

        if (!file.exists()) {
            ErrorResponse error = new ErrorResponse(
                    "Path does not exist",
                    path,
                    "Please provide a valid file or directory path"
            );
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
        }

        FileNode result = FileScanner.scan(file);

        return ResponseEntity.ok(result);
    }

}
