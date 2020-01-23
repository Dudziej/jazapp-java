package pl.edu.pjwstk.jaz.admin.section;

public class SectionEntity {
    private Long id;
    private String name;

    public SectionEntity(Long id, String name) {
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
