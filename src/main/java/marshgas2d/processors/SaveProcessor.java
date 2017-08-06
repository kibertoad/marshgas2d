package marshgas2d.processors;

import com.fasterxml.jackson.databind.ObjectMapper;
import marshgas2d.model.Screen;
import marshgas2d.model.ScreenModel;

import java.io.File;
import java.io.IOException;

public class SaveProcessor {

    private final ObjectMapper mapper = new ObjectMapper();

    public void saveScreen (Screen screen) throws IOException {
        mapper.writeValue(screen.getFile(), screen.getModel());
    }

    public Screen loadScreen (File file) throws IOException {
        Screen screen = mapper.readValue(file, Screen.class);
        screen.setFile(file);
        return screen;
    }


}
