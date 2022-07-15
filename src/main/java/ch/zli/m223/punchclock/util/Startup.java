package ch.zli.m223.punchclock.util;



import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.transaction.Transactional;
import ch.zli.m223.punchclock.domain.User;
import ch.zli.m223.punchclock.service.UserService;
import io.quarkus.runtime.StartupEvent;
 
 
@Singleton
public class Startup {
    @Inject
    UserService userService;
    
    @Transactional
    public void loadUsers(@Observes StartupEvent evt) {
        User user = new User();
        user.setUsername("admin");
        user.setPassword("admin");
        user.setRole("admin");
        userService.add(user);
        User user2 = new User();
        user2.setUsername("user");
        user2.setPassword("user");
        user2.setRole("user");
        userService.add(user2);
    }
}

