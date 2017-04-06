package prog.logic;

public class Document {
    private Integer docId;
    private String name;
    private String owner;
    private String docPath;
    private Integer parentId;
    private Boolean isDirectory;
    private Boolean isProtected;

    public Document(Integer docId, String name, String owner, String docPath, Integer parentId, Boolean isDirectory, Boolean isProtected) {
        this.docId = docId;
        this.name = name;
        this.owner = owner;
        this.docPath = docPath;
        this.parentId = parentId;
        this.isDirectory = isDirectory;
        this.isProtected = isProtected;
    }

    Integer getDocId() {
        return docId;
    }

    public String getName() {
        return name;
    }

    public String getOwner() {
        return owner;
    }

    public String getDocPath() {
        return docPath;
    }

    public Integer getParentId() {
        return parentId;
    }

    public Boolean getDirectory() {
        return isDirectory;
    }

    public Boolean getProtected() {
        return isProtected;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProtected(Boolean aProtected) {
        isProtected = aProtected;
    }
}
