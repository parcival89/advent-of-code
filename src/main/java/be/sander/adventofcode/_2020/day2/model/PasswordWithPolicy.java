package be.sander.adventofcode._2020.day2.model;

public class PasswordWithPolicy {
    private final Policy policy;
    private final String password;

    public PasswordWithPolicy(Policy policy, String password) {
        this.policy = policy;
        this.password = password;
    }

    public boolean isCompliant() {
        return policy.applies(password);
    }
}