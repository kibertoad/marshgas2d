package marshgas2d.model;

import lombok.Getter;
import lombok.Setter;

import java.io.File;

public class Screen {

    @Getter
    @Setter
    private File file;

    @Getter
    @Setter
    private final ScreenModel model = new ScreenModel();

}
