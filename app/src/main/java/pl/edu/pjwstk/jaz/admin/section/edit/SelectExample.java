package pl.edu.pjwstk.jaz.admin.section.edit;

public class SelectExample {
    private final Long id;
    private final String name;

    public SelectExample(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
