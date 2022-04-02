class NoDependencyInjection {
    public static void main(String[] args) {
        GoldenTransaction goldenTransaction = new GoldenTransaction();
        goldenTransaction.complete();

        CryptoCurrencyTransaction cryptoCurrencyTransaction = new CryptoCurrencyTransaction();
        cryptoCurrencyTransaction.complete();
    }
}

class GoldenTransaction {
    private final Seller seller = new Seller("Maciej");
    private final Client client = new Client("Wojciech");

    void complete() {
        System.out.println("GoldenTransaction between " + client.name() + " and " + seller.name() + " completed!");
    }
}

class CryptoCurrencyTransaction {
    private final Seller seller = new Seller("Maciej");
    private final Client client = new Client("Wojciech");

    void complete() {
        System.out.println("CryptoCurrencyTransaction between " + client.name() + " and " + seller.name() + " completed!");
    }
}

record Seller(String name) {
}

record Client(String name) {
}


