package com.ricky.fileexplorerapi.util;

import com.ricky.fileexplorerapi.model.FileNode;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class FileScanner {

    private static final Set<String> IGNORED_DIRECTORIES = Set.of(".git", "node_modules", "target");

    public static FileNode scan(File file, Integer currentDepth, Integer maxDepth) {

        if (file.isFile()) {
            return new  FileNode(file.getName(), "file", null, false, false);
        }

        if (maxDepth != null && currentDepth >= maxDepth) {
            return new FileNode(file.getName(), "directory", new ArrayList<>(), true, false);
        }

        if (file.isDirectory() && IGNORED_DIRECTORIES.contains(file.getName())) {
            return new FileNode(file.getName(), "directory", new ArrayList<>(), true, true);
        }

        List<FileNode> children = new ArrayList<>();
        File[] files = file.listFiles();

        if (files != null) {
            for (File f : files) {
                children.add(scan(f, currentDepth + 1, maxDepth));
            }
        }

        return new FileNode(file.getName(), "directory", children, false, false);

    }

}
