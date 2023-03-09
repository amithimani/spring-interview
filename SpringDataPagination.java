public interface UserRepository extends PagingAndSortingRepository<User, Long> {
    Page<User> findAll(Pageable pageable);
}





@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    
    public Page<User> getUsers(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return userRepository.findAll(pageable);
    }
}
