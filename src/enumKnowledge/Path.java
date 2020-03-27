package enumKnowledge;

public enum Path {
    PATH1("/home/acer/logs1"), PATH2("/home/acer/logs2"), PATH3("/home/acer/logs3"), PATH4("/home/acer/logs4");

    private String path;

    Path(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    //测试方法
    public static void main(String[] args) {
        System.out.println(Path.PATH1.getPath());
        System.out.println(Path.PATH2.getPath());
        System.out.println(Path.PATH3.getPath());
        System.out.println(Path.PATH4.getPath());
    }
}
