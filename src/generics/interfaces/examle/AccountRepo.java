package generics.interfaces.examle;
//Accountun DB islemleri
public class AccountRepo implements Repo<Account> {

    @Override
    public void save(Account obj) {

    }

    @Override
    public Account find() {
        return null;
    }
}
