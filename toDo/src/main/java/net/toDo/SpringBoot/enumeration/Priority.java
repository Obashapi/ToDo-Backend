package net.toDo.SpringBoot.enumeration;

public enum Priority {
    HIGH("HIGH"),
    MEDIUM("MEDIUM"),
    LOW("LOW");

    private String name;

private Priority(String name){
    this.name=name;
}

    public String getName() {
        return this.name;
    }
}
