package com.java.problem.comparatorAndComparableExample;

public class Employee implements Comparable{
    private int id;
    private String name;
    private int age;

    public Employee(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    /**
     * e1.compareTo(e2) if it returns +1 then e1>e2
     * e1.compareTo(e2) if it returns 0 then e1=e2
     * e1.compareTo(e2) if it returns -1 then e1<e2
     */
    @Override
    public int compareTo(Object o) {
        Employee e = (Employee) o;

        /**
         * if both the objects id are same
         * then consider them as equal  
         */
        if(this.getId()==e.getId()){
            return 0;
        } else if (this.getId()>e.getId()) {
            return 1;
        } else {
            return -1;
        }
    }
}
