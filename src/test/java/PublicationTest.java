
import com.polytech.config.AppConfig;
import com.polytech.services.Note;
import com.polytech.services.NoteService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.List;

public class PublicationTest {


    private NoteService noteService;


    @Before
    public void setUp() {
        AnnotationConfigApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class);
        noteService = container.getBean(NoteService.class);
    }

    @Test
    @Ignore
    public void should_post_story() {

        //GIVEN


        //WHEN


        //THEN


    }
}
