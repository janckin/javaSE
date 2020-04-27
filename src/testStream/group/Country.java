package testStream.group;

public class Country {
    private int id;
    private String name;
    private Language language;

    public Country(int id, String name, Language language) {
        this.id = id;
        this.name = name;
        this.language = language;
    }

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Language getLanguage() {
        return language;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", language=" + language +
                '}';
    }
}
