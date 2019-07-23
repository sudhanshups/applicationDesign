package stackOverFlow;

import lombok.Data;

@Data
public abstract class Account {
    private String id;
    private String password;
    private AccountStatus status;

    private String name;
    private String email;
    private String phone;

    boolean resetPassword() {
        return true;//should be implemented by different actors
    }

    AccountStatus getStatus(){
        return status;
    }
    void setStatus(AccountStatus s){
        status= s;
    }
}