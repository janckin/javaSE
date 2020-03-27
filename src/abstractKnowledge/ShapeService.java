package abstractKnowledge;

public interface ShapeService {
    /**
     * 获取面积
     *
     * @return
     */
    public float getArea() throws Exception;

    /**
     * 获取周长
     *
     * @return
     */
    public float getLength() throws Exception;

    /**
     * 获取周长
     *
     * @return
     */
    public abstract String getColor() throws Exception;
}
