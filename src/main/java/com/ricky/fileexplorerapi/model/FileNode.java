package com.ricky.fileexplorerapi.model;

import java.util.List;

public class FileNode {

    private String name;
    private String type;
    private List<FileNode> children;

    public FileNode(String name, String type, List<FileNode> children) {
        this.name = name;
        this.type = type;
        this.children = children;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public List<FileNode> getChildren() {
        return children;
    }

}
