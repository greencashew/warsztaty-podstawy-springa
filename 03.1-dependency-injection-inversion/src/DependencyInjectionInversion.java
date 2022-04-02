import java.util.List;

class DependencyInjectionInversion {
    public static void main(String[] args) {
        Seller seller = new Seller("Maciej");
        Client client = new Client("Wojciech");

        var transactions = List.of(
                new GoldenTransaction(seller, client),
                new CryptoCurrencyTransaction(seller, client)
        );
        transactions.forEach(Transaction::complete);
    }

    interface Transaction {
        void complete();
    }

    record GoldenTransaction(Seller seller, Client client) implements Transaction {
        public void complete() {
            System.out.println("GoldenTransaction between " + client.name() + " and " + seller.name() + " completed!");
        }
    }

    record CryptoCurrencyTransaction(Seller seller, Client client) implements Transaction {
        public void complete() {
            System.out.println("CryptoCurrencyTransaction between " + client.name() + " and " + seller.name() + " completed!");
        }
    }

    record Seller(String name) {
    }

    record Client(String name) {
    }
}

