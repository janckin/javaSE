package abstractKnowledge;


public class Circle extends Shape {
    private float radio;

    public float getRadio() {
        return radio;
    }

    @Override
    public float getArea() throws Exception {
        return (float) (radio * radio * Math.PI);
    }

    @Override
    public float getLength() throws Exception {
        return (float) (2 * radio * Math.PI);
    }
}
