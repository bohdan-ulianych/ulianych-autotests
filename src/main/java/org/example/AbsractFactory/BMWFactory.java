package org.example.AbsractFactory;

public class BMWFactory implements CarsFactory {
    @Override
    public Sedan createSedan() {
        return new  BMWSedan();
    }

    @Override
    public Coupe createCoupe() {
        return new BMWCoupe();
    }
}
