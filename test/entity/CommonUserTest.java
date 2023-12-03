package entity;

import org.junit.Assert;
import org.junit.Test;

public class CommonUserTest {

    @Test
    public void getName() {
        CommonUser user = new CommonUser("Name", "pwd");
        Assert.assertEquals(user.getName(), "Name");
    }

    @Test
    public void getPassword() {
        CommonUser user = new CommonUser("Name", "pwd");
        Assert.assertEquals(user.getPassword(), "pwd");
    }
}