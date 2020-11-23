public class ContactItem {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String emailAddress;
    private int numberOfFilledFields;

    public ContactItem(String firstName, String lastName, String phoneNumber, String emailAddress) throws Exception{
        if(firstName.length() != 0){ numberOfFilledFields++; }
        if(lastName.length() != 0){ numberOfFilledFields++; }
        if(phoneNumber.length() != 0){ numberOfFilledFields++; }
        if(emailAddress.length() != 0){ numberOfFilledFields++; }

        if (numberOfFilledFields == 0){
            throw new Exception("Unable to create contact: All fields were left blank");
        } else {
            this.firstName = firstName;
            this.lastName = lastName;
            this.phoneNumber = phoneNumber;
            this.emailAddress = emailAddress;
        }

    }

    public String getFirstName() { return firstName; }

    public String getLastName() { return lastName; }

    public String getPhoneNumber() { return phoneNumber; }

    public String getEmailAddress() { return emailAddress; }

    public void editContactInformation(String firstName, String lastName, String phoneNumber, String emailAddress) throws Exception {
        numberOfFilledFields = 0;
        if(firstName.length() != 0){ numberOfFilledFields++; }
        if(lastName.length() != 0){ numberOfFilledFields++; }
        if(phoneNumber.length() != 0){ numberOfFilledFields++; }
        if(emailAddress.length() != 0){ numberOfFilledFields++; }

        if (numberOfFilledFields == 0){
            throw new Exception("Unable to edit contact: All fields were left blank");
        } else {
            this.firstName = firstName;
            this.lastName = lastName;
            this.phoneNumber = phoneNumber;
            this.emailAddress = emailAddress;
        }
    }

    @Override
    public String toString(){
        String finalToString = "";
        if(firstName.length() != 0){
            finalToString = "Name: " + getFirstName();
        }

        if(lastName.length() != 0 && firstName.length() != 0){
            finalToString = finalToString + " " + getLastName() + "\n";
        } else if (lastName.length() != 0 && firstName.length() == 0){
            finalToString = "Name: " + getLastName() + "\n";
        } else if (lastName.length() == 0 && firstName.length() != 0){
            finalToString = finalToString + "\n";
        }

        if(phoneNumber.length() != 0) {
            finalToString = finalToString + "Phone: " + getPhoneNumber() + "\n";
        }
        if (emailAddress.length() != 0) {
            finalToString = finalToString + "Email: " + getEmailAddress() + "\n";
        }

        return finalToString;
    }

}