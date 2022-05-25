package config;


import java.util.HashSet;
import java.util.Set;


@ApplicationPath("Vote")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> res = new HashSet<>();
        res.add(services.CandidateServices.class);
        return res;
    }
}