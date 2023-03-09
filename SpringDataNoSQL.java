public interface CustomerRepository extends MongoRepository<Customer, String> {
  List<Customer> findByLastName(String lastName);
  List<Customer> findByAddress_City(String city);
}
