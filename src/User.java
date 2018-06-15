public abstract class User {
    private String name;
    private int id;
    private String occupation;

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getOccupation() {
        return occupation;
    }


    @Override
    public String toString() {
        return "\nID: '" +
                this.getId() +
                "'\nName: '" +
                this.getName() +
                "'\nOccupation: '" +
                this.getOccupation() +

                "'"
                ;
    }
}
