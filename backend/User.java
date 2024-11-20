@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer user_id;

    @Column(unique = true, nullable = false)
    private String username;

    private String password;
    private String firstname;
    private String lastname;

    @Enumerated(EnumType.STRING)
    private Role role;

    // Getters and setters
}
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);
}