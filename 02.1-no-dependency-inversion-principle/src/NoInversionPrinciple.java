class NoInversionPrinciple {

    public static void main(String[] args) {
        final Driver msciwojDriver = new Driver();
        msciwojDriver.drive(new Tico()); // Can't drive Matiz
    }
}

class Driver {
    void drive(Tico car) {
        System.out.println("Driving " + car.getClass().getSimpleName());
    }
}

class Tico {
}

class Matiz {
}
