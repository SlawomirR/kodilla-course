package com.kodilla.good.patterns.challenges;

class ProductOrderDto {
    private User user;
    private String orderId;
    private boolean userWantAccount;
    private boolean userWantNotification;
    private boolean userExist;

    boolean getUserExist() {
        return userExist;
    }
    void setUserExist(boolean userExist) {
        this.userExist = userExist;
    }
    boolean getUserWantAccount() {
        return userWantAccount;
    }
    void setUserWantAccount(boolean userWantAccount) {
        this.userWantAccount = userWantAccount;
    }
    boolean getUserWantNotification() {
        return userWantNotification;
    }
    void setUserWantNotification(boolean userWantNotification) {
        this.userWantNotification = userWantNotification;
    }
    User getUser() {
        return user;
    }
    String getOrderId() {
        return orderId;
    }
    void setUser(User user) {
        this.user = user;
    }
    void setAutoOrderId() {
        this.orderId = "New_Auto_Generated_Id_Here_If_Not_Exist";
    }
}
