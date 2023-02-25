package entity;

import java.util.Objects;

public class Grade {

    private int id;
    private int value;
    private Student student;
    private Term term;
    private Discipline discipline;

    public Grade() {
    }

    public Grade(int id, int value, Student student, Term term, Discipline discipline) {
        this.id = id;
        this.value = value;
        this.student = student;
        this.term = term;
        this.discipline = discipline;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Term getTerm() {
        return term;
    }

    public void setTerm(Term term) {
        this.term = term;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Grade grade = (Grade) o;
        return id == grade.id && value == grade.value && Objects.equals(student, grade.student) && Objects.equals(term, grade.term) && Objects.equals(discipline, grade.discipline);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, value, student, term, discipline);
    }

    @Override
    public String toString() {
        return "Grade{" +
                "id=" + id +
                ", value=" + value +
                ", student=" + student +
                ", term=" + term +
                ", discipline=" + discipline +
                '}';
    }
}
