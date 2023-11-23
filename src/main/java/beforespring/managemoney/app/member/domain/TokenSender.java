package beforespring.managemoney.app.member.domain;

public interface TokenSender {
    void sendEmail(String email, String token);

    String generateToken();
}
