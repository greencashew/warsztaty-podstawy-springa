class DependencyInversionPrinciple {

    public static void main(String[] args) {
        final Driver driver = new Driver();
        driver.drive(new Tico());
        driver.drive(new Matiz());
    }
}

interface Car {
}

class Driver {
    void drive(Car car) {
        System.out.println("Driving " + car.getClass().getSimpleName());
    }
}

class Tico implements Car {
}

class Matiz implements Car {
}


