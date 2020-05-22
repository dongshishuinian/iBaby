package com.example.parentalassistant;

public class UserInformation {
    private UserInformation(){}
    private static class UserInformationInstance{
        private static final UserInformation instance =new UserInformation();
    }
    public static UserInformation getInstance_UserInformation(){
        return UserInformationInstance.instance;
    }
    public String username;
    public String userkey;
}
