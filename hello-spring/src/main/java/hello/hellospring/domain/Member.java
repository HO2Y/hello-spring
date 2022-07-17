package hello.hellospring.domain;

public class Member {

    private Long id; //System이 저장하는 Id
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
