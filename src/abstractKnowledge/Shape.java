package abstractKnowledge;


public abstract class Shape {
    /**
     * 获取面积
     *
     * @return
     */
    public abstract float getArea() throws Exception;

    /**
     * 获取周长
     *
     * @return
     */
    public abstract float getLength() throws Exception;

    //颜色
    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Shape(String color) {
        System.out.println("生成带参构造器！！");
        this.color = color;
    }

    public Shape() {
        System.out.println("生成无参构造器！！");
    }

    public void show() {
        System.out.println("show public word!!");
    }
}
