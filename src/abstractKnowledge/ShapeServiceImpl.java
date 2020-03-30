package abstractKnowledge;

public class ShapeServiceImpl implements ShapeService {

    @Override
    public float getArea() throws Exception {
        return 6.33f;
    }

    @Override
    public float getLength() throws Exception {
        return 3.33f;
    }

    @Override
    public String getColor() throws Exception {
        return "default color";
    }

}
