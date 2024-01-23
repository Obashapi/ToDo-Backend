package net.toDo.SpringBoot.enumeration;

public enum Status {
    PENDING("PENDING"),
    COMPLETED("COMPLETED"),
    INPROGRESS("INPROGRESS");

private String name;
    private Status(String name){
        this.name=name;
    }

    public String getName() {
        return this.name;
    }
}
