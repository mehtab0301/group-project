package entity;

import org.junit.Assert;
import org.junit.Test;

public class CommonUserFactoryTest {
    @Test
    public void create() {
        String name = "Name";
        String password = "pwd";
        User user = new CommonUserFactory().create(name, password);
        Assert.assertEquals("Name", user.getName());
        Assert.assertEquals("pwd", user.getPassword());
    }
}