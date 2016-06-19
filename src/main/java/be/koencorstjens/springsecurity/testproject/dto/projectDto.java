package be.koencorstjens.springsecurity.testproject.dto;

/**
 * Created by koencorstjens on 29/04/15.
 */
public class projectDto {
    Long id;
    String name;
    String manager;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }
}
