package org.example.AbsractFactory;

public class MercedesFactory implements CarsFactory{
    @Override
    public Sedan createSedan() {
        return new  MercedesSedan();
    }

    @Override
    public Coupe createCoupe() {
        return new MercedesCoupe();
    }

}
