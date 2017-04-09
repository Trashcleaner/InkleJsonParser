import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import model.Stitch;

import java.io.IOException;

/**
 * Created by obrusvit on 9.4.17.
 */
public class StitchTypeAdapter extends TypeAdapter<Stitch> {
    @Override
    public Stitch read(JsonReader jsonReader) throws IOException {
        final Stitch stitch = new Stitch();
        jsonReader.beginObject();
        String name = jsonReader.nextName();
        System.out.println(name);

        /*jsonReader.beginObject();
        String content = jsonReader.nextName();
        System.out.println(content);*/

        jsonReader.skipValue();
        /*jsonReader.beginArray();

        String text = jsonReader.nextString();
        System.out.println(text);

        System.out.println(jsonReader.peek());
        System.out.println(jsonReader.nextName());

        jsonReader.endArray();*/


        jsonReader.endObject();

        stitch.setName(name);
        //stitch.setText(text);

        return stitch;
    }


    @Override
    public void write(JsonWriter jsonWriter, Stitch o) throws IOException {


    }

}
