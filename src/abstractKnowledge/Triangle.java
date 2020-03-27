package abstractKnowledge;

public class Triangle extends Shape {
    private float banner1;
    private float banner2;
    private float banner3;
    private float bottom;
    private float height;


    public Triangle(String color, float banner1, float banner2, float banner3) {
        super(color);
        this.banner1 = banner1;
        this.banner2 = banner2;
        this.banner3 = banner3;
    }

    public Triangle(String color, float bottom, float height) {
        super(color);
        this.bottom = bottom;
        this.height = height;
    }

    @Override
    public float getArea() throws Exception {
        float area = (float) (0.5 * bottom * height);
        return area;
    }

    @Override
    public float getLength() throws Exception {
        float length = banner1 + banner2 + banner3;
        return length;
    }


}
