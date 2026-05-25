package com.ricky.fileexplorerapi.util;

import com.ricky.fileexplorerapi.model.FileNode;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileScanner {

    public static FileNode scan(File file) {

        if (file.isFile()) {
            return new  FileNode(file.getName(), "file", null);
        }

        List<FileNode> children = new ArrayList<>();
        File[] files = file.listFiles();

        if (files != null) {
            for (File f : files) {
                children.add(scan(f));
            }
        }

        return new FileNode(file.getName(), "directory", children);

    }

}
