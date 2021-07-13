package org.example;

public class PersonBuilder {
    private String name;
    private String surname;
    private int age;
    private int height;
    private int weight;

    public static class Builder {
        private PersonBuilder newPerson;

        public Builder() {
            newPerson = new PersonBuilder();
        }

        public Builder withName(String name) {
            newPerson.name = name;
            return this;
        }

        public Builder withSurname(String surname) {
            newPerson.surname = surname;
            return this;
        }

        public Builder withAge(int age) {
            newPerson.age = age;
            return this;
        }

        public Builder withHeight(int height) {
            newPerson.height = height;
            return this;
        }

        public Builder withWeight(int weight) {
            newPerson.weight = weight;
            return this;
        }

        public PersonBuilder build() {
            return newPerson;
        }

    }
}

