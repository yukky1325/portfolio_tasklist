import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncode {
    public static void main(String[] args) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String rawPassword = "111";
        String encodedPassword = passwordEncoder.encode(rawPassword);
        System.out.println(encodedPassword);
    }
}

