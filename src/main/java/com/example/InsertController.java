package com.example;

import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class InsertController {

    @Autowired
    private PersonRepository repo;

    private static final Faker faker = new Faker();

    @RequestMapping("/insert/{count}")
    public String insert(@PathVariable(value = "count") int count ) {

        if (count < 0) count = 1;

        StopWatch watch = new StopWatch();
        watch.start();
        for (int i=0; i<count; i++) {
            repo.save(new Person(faker.name().name()));
        }
        watch.stop();
        double duration = watch.getTotalTimeSeconds();

        return String.format("Insert of %d entries took %s seconds.", count, duration);

    }

}
