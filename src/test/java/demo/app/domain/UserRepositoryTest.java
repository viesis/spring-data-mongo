package demo.app.domain;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import demo.app.config.MongoConfig;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static com.google.common.collect.Lists.newArrayList;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MongoConfig.class)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Before
    public void dropUserCollection() {
        userRepository.deleteAll();
    }

    @Test
    public void userSavingWorks() {
        userRepository.save(newArrayList(new User("admin"), new User("bob"), new User("Carl")));

        Assert.assertThat(userRepository.findAll(), Matchers.hasSize(3));
    }
}
