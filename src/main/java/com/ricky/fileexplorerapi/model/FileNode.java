package com.ricky.fileexplorerapi.model;

import java.util.List;

public class FileNode {

    private String name;
    private String type;
    private List<FileNode> children;
    private boolean truncated;
    private boolean skipped;

    public FileNode(String name, String type, List<FileNode> children, boolean truncated, boolean skipped) {
        this.name = name;
        this.type = type;
        this.children = children;
        this.truncated = truncated;
        this.skipped = skipped;
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

    public boolean isTruncated() {
        return truncated;
    }

    public boolean isSkipped() {
        return skipped;
    }

}
