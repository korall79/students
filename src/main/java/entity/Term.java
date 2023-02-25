package entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Term {

    private int id;
    private String name;
    private String duration;
    private List<Discipline> disciplines = new ArrayList<>();

    public Term() {
    }

    public Term(int id, String name, String duration) {
        this.id = id;
        this.name = name;
        this.duration = duration;
    }

    public void addDiscipline(Discipline discipline) {
        disciplines.add(discipline);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Term term = (Term) o;
        return id == term.id && Objects.equals(name, term.name) && Objects.equals(duration, term.duration) && Objects.equals(disciplines, term.disciplines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, duration, disciplines);
    }

    @Override
    public String toString() {
        return "Term{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", duration='" + duration + '\'' +
                ", disciplines=" + disciplines +
                '}';
    }
}
