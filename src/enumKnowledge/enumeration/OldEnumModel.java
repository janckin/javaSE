package enumKnowledge.enumeration;

public abstract class OldEnumModel {
    protected String id;
    protected String name;

    protected OldEnumModel(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
