class DependencyInjection {
    public static void main(String[] args) {
        Seller seller = new Seller("Maciej");
        Client client = new Client("Wojciech");

        GoldenTransaction goldenTransaction = new GoldenTransaction(seller, client);
        goldenTransaction.complete();

        CryptoCurrencyTransaction cryptoCurrencyTransaction = new CryptoCurrencyTransaction(seller, client);
        cryptoCurrencyTransaction.complete();
    }
}

record GoldenTransaction(Seller seller, Client client) {
    void complete() {
        System.out.println("GoldenTransaction between " + client.name() + " and " + seller.name() + " completed!");
    }
}

record CryptoCurrencyTransaction(Seller seller, Client client) {
    void complete() {
        System.out.println("CryptoCurrencyTransaction between " + client.name() + " and " + seller.name() + " completed!");
    }
}

record Seller(String name) {
}

record Client(String name) {
}