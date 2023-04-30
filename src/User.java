public class User {
    private String userName;
    private long phoneNumber;
    private String emailId;
    private double distanceFromWarehouse;

    public User(String userName, long phoneNumber, String emailId, double distanceFromWarehouse) {
        this.userName = userName;
        this.phoneNumber = phoneNumber;
        this.emailId = emailId;
        this.distanceFromWarehouse = distanceFromWarehouse;
    }
}
