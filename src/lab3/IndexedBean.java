package lab3;

public class IndexedBean {

    private String[] subjects = new String[3];

    // Indexed getter
    public String getSubjects(int index) {
        return subjects[index];
    }

    // Indexed setter
    public void setSubjects(int index, String value) {
        subjects[index] = value;
    }

    // Normal getter
    public String[] getSubjects() {
        return subjects;
    }

    // Normal setter
    public void setSubjects(String[] subjects) {
        this.subjects = subjects;
    }
}

